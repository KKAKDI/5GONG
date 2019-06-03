package tkl.product.model;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import java.sql.*;
import java.util.*;

class ProductDAO {
	private DataSource ds;

	ProductDAO(){
		try {
			Context initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:/comp/env");
			ds = (DataSource) envContext.lookup("jdbc/myoracle");
		}catch(NamingException ne) {}
	}
	
	ArrayList<ProductDTO> select(){
		ArrayList<ProductDTO> list = new ArrayList<ProductDTO>();
		Connection con = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(ProductSQL.sqlList);
			while(rs.next()) {
				int pd_no = rs.getInt("pd_no");
				String pd_nick = rs.getString("pd_nick");
				String pd_status = rs.getString("pd_status");
				String pd_subject = rs.getString("pd_subject");
				java.sql.Date pd_regdate = rs.getDate("pd_regdate");
				ProductDTO dto = new ProductDTO();
				dto.setPd_no(pd_no);
				dto.setPd_nick(pd_nick);
				dto.setPd_status(pd_status);
				dto.setPd_subject(pd_subject);
				dto.setPd_regdate(pd_regdate);
				list.add(dto);
			}
			return list;
		}catch(SQLException se) {
			return null;
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) rs.close();
				if(con != null) con.close();
			}catch(SQLException se) {}
		}
	}
}

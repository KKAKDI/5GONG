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
				if(stmt != null) stmt.close();
				if(con != null) con.close();
			}catch(SQLException se) {}
		}
	}
	
	void reg(ProductDTO dto) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(ProductSQL.sqlReg);
			pstmt.setString(1, dto.getPd_nick());
			pstmt.setString(2, dto.getPd_status());
			pstmt.setString(3, dto.getPd_name());
			pstmt.setString(4, dto.getPd_class());
			pstmt.setInt(5, dto.getPd_price());
			pstmt.setString(6, dto.getPd_subject());
			pstmt.setString(7, dto.getPd_content());
			pstmt.setString(8, dto.getPd_img());
			pstmt.setString(9, dto.getPd_img_copy());
			pstmt.executeUpdate();
		}catch(SQLException se) {
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(SQLException se) {}
		}
	}
	
	ProductDTO content(int pd_no) {
		Connection  con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(ProductSQL.sqlContent);
			pstmt.setInt(1, pd_no);
			rs = pstmt.executeQuery();
			rs.next();
			int pd_no1 = rs.getInt("pd_no");
			String pd_name = rs.getString("pd_name");
			String pd_class = rs.getString("pd_class");
			int pd_price = rs.getInt("pd_price");
			int pd_view = rs.getInt("pd_view");
			String pd_img_copy = rs.getString("pd_img_copy");
			java.sql.Date pd_regdate = rs.getDate("pd_regdate");
			ProductDTO dto = new ProductDTO();
			dto.setPd_no(pd_no1);
			dto.setPd_name(pd_name);
			dto.setPd_class(pd_class);
			dto.setPd_price(pd_price);
			dto.setPd_view(pd_view);
			dto.setPd_img_copy(pd_img_copy);
			dto.setPd_regdate(pd_regdate);
			return dto;
		} catch (SQLException se) {
			return null;
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch (SQLException se) {}
		}
	}
	
	void delete(int pd_no) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(ProductSQL.sqlDelete);
			pstmt.setInt(1, pd_no);
			pstmt.executeUpdate();
		}catch(SQLException se) {
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(SQLException se) {}
		}
	}
	
	void update(ProductDTO dto) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(ProductSQL.sqlUpdate);
			pstmt.setString(1, dto.getPd_name());
			pstmt.setString(2, dto.getPd_class());
			pstmt.setInt(3, dto.getPd_price());
			pstmt.setString(4, dto.getPd_img_copy());
			pstmt.setInt(5, dto.getPd_no());
			pstmt.executeUpdate();
		}catch(SQLException se) {
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(SQLException se) {}
		}
	}
}

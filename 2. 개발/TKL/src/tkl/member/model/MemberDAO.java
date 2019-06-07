package tkl.member.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

class MemberDAO {
	private DataSource ds;
	
	MemberDAO(){
		try {
			Context initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:/comp/env");
			ds = (DataSource) envContext.lookup("jdbc/myoracle");
		}catch(NamingException ne) {}
	}
	
	void insert(MamberDTO dto) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(MemberSQL.SQL_IN);
			pstmt.setString(1,dto.getEmail());
			pstmt.setString(2, dto.getNick());
			pstmt.setString(3,dto.getPwd());
			pstmt.setString(4,dto.getName());
			pstmt.setString(5, dto.getBank());
			pstmt.setInt(6, dto.getActNum());
			pstmt.setInt(7, dto.getPhone());
			pstmt.executeQuery();
		} catch (SQLException se) {
			System.out.println(se);
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(SQLException se) {}
		}
	}
}

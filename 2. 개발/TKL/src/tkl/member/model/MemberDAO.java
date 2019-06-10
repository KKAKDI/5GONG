package tkl.member.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


public class MemberDAO {
	private DataSource ds;
	
	public MemberDAO(){
		try {
			Context initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:/comp/env");
			ds = (DataSource) envContext.lookup("jdbc/myoracle");
		}catch(NamingException ne) {}
	}
	
	public MemberDTO getMem(MemberDTO mem) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MemberDTO outMem = null;
		try {
			con = ds.getConnection();			
			pstmt = con.prepareStatement(MemberSQL.SQL_SEL);
			pstmt.setString(1, mem.getEmail());
			pstmt.setString(2, mem.getPwd());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				System.out.println("1");
				outMem = new MemberDTO();
				System.out.println(rs.getString("M_EMAIL")+"/"+rs.getString("M_NICK"));
				outMem.setEmail(rs.getString("M_EMAIL"));
				outMem.setNick(rs.getString("M_NICK"));
				outMem.setGrant(rs.getString("M_GRANT"));
				outMem.setPwd(null);				
			}			
		} catch (SQLException se) {
			System.out.println(se);
		} finally {
			try {
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(con!=null)con.close();
			} catch (SQLException se) {}			
		}
		return outMem;
	}
	
	void insert(MemberDTO dto) {
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

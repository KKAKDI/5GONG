package tkl.preply.model;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import java.util.*;
import java.sql.*;

class PreplyDAO {
	private DataSource ds;
	
	PreplyDAO(){
		try {
			Context initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:/comp/env");
			ds = (DataSource) envContext.lookup("jdbc/myoracle");
		}catch(NamingException ne) {}
	}
	
	ArrayList<PreplyDTO> select(int pd_no){
		ArrayList<PreplyDTO> list = new ArrayList<PreplyDTO>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(PreplySQL.sqlList);
			pstmt.setInt(1, pd_no);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int pd_no1 = rs.getInt("pd_no");
				int pr_no = rs.getInt("pr_no");
				String pd_nick = rs.getString("pd_nick");
				String pr_comment = rs.getString("pr_comment");
				java.sql.Date pr_writedate = rs.getDate("pr_writedate");
				PreplyDTO dto = new PreplyDTO();
				dto.setPd_no(pd_no1);
				dto.setPr_no(pr_no);
				dto.setPd_nick(pd_nick);
				dto.setPr_comment(pr_comment);
				dto.setPr_writedate(pr_writedate);
				list.add(dto);
			}
			return list;
		}catch(SQLException se) {
			return null;
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(SQLException se) {}
		}
	}
	
	void reply_reg(PreplyDTO dto) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(PreplySQL.sqlReg);
			pstmt.setInt(1, dto.getPd_no());
			pstmt.setString(2, "aaa@naver.com");
			pstmt.setString(3, "닉네임1");
			pstmt.setString(4, dto.getPr_comment());
			pstmt.executeUpdate();
		}catch(SQLException se) {
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(SQLException se) {}
		}
	}
	
	void reply_delete(int pr_no) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(PreplySQL.sqlDelete);
			pstmt.setInt(1, pr_no);
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

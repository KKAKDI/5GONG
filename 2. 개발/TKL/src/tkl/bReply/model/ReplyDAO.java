package tkl.bReply.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.*;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ReplyDAO {
	private DataSource ds;
	ReplyDAO(){
		try {
			Context initContext = new InitialContext();
			Context envContext  = (Context)initContext.lookup("java:/comp/env");
			ds = (DataSource)envContext.lookup("jdbc/myoracle");	
		}catch(NamingException ne) {	
		}
	}
	void replyIn(int bNo, String brContent) {
		System.out.println("replyIn()");
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(ReplySQL.sqlI);
			pstmt.setInt(1, bNo);
			pstmt.setString(2, brContent);
			pstmt.executeUpdate();
		}catch(SQLException se) {
			System.out.println("replyIn : "+se);
		}finally {
			try {
				if(pstmt != null)pstmt.close();
				if(con != null)con.close();
				
			}catch(SQLException se ) {}
		}
	}
	ArrayList<ReplyDTO> replyList(int bNo) {
		System.out.println("replyList()");
		ArrayList<ReplyDTO> list = new ArrayList<ReplyDTO>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(ReplySQL.sqlS);
			pstmt.setInt(1, bNo);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int brNo = rs.getInt("BR_NO");
				String mNick = rs.getString("M_NICK");
				String brContent = rs.getString("BR_CONTENT");
				Date brWriteDate = rs.getDate("BR_WRITEDATE");
				int brLike = rs.getInt("BR_LIKE");
				int brDisLike = rs.getInt("BR_DISLIKE");
				ReplyDTO dto = new ReplyDTO(brNo, bNo, null, mNick, brContent, brWriteDate, null, null, brLike, brDisLike);
				list.add(dto);
			} 
			return list;
		}catch(SQLException se) {
			System.out.println("replyList se : "+se);
		}finally {
			try {
				if(pstmt != null)pstmt.close();
				if(con !=null)con.close();
			}catch(SQLException se) {}
		}
		return null;
	}
	boolean replySecretCheck(int idx, int replyIdx, String pwd) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			//pstmt = con.prepareStatement(ReplySQL.sqlReplyRS);
			pstmt.setInt(1, replyIdx);
			rs = pstmt.executeQuery();
			rs.next();
			String rPwd = rs.getString(3);
			
			if(rPwd.equals(pwd)) {
				//pstmt = con.prepareStatement(ReplySQL.sqlReplyD);
				pstmt.setInt(1, replyIdx);
				pstmt.executeUpdate();
				return true;
			}
			return false;
		}catch(SQLException se) {
			System.out.println("ReplyDAO : "+se);
		}finally {
			try {
				if(rs != null)rs.close();
				if(pstmt != null)pstmt.close();
				if(con !=null)con.close();
			}catch(SQLException se) {}
		}	
		return false;
	}
	void replyDelete(int brNo) {
		System.out.println("replyDelete");
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con= ds.getConnection();
			pstmt = con.prepareStatement(ReplySQL.sqlD);
			pstmt.setInt(1, brNo);
			pstmt.executeUpdate();
		}catch(SQLException se) {
			System.out.println("replyDelete se : "+se );
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(SQLException se) {
				
			}
		}
	}
}

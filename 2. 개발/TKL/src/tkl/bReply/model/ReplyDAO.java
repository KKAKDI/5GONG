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
	void replyIn(ReplyDTO dto) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(ReplySQL.sqlRS);
			int brNo = 
			String replyWriter = dto.getReplyWriter();
			String replyPwd = dto.getReplyPwd();
			String replyContent = dto.getReplyContent();
			String replyId = dto.getReplyId();
			int replyIdx = dto.getReplyIdx();
			pstmt.setString(1, replyWriter);
			pstmt.setString(2, replyPwd);
			pstmt.setString(3, replyContent);
			pstmt.setString(4, replyId);
			pstmt.setInt(5, replyIdx);

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
	ArrayList<ReplyDTO> replyList(int replyIdxFk) {
		ArrayList<ReplyDTO> list = new ArrayList<ReplyDTO>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			//pstmt = con.prepareStatement(ReplySQL.sqlReplyS);
			pstmt.setInt(1, replyIdxFk);
			rs =pstmt.executeQuery();
			while(rs.next()) {
				int idx = rs.getInt(1);
				String replyWriter = rs.getString(2);
				String replyPwd = rs.getString(3);
				String replyContent = rs.getString(4);
				Date replyDate = rs.getDate(5);
				String replyId = rs.getString(6);
				int replyIdx = rs.getInt(7);
				//ReplyDTO dto = new ReplyDTO(idx, replyWriter, replyPwd, replyContent, replyDate, replyId, replyIdx);
				//list.add(dto);
			} 
			return list;
		}catch(SQLException se) {
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
	  
}

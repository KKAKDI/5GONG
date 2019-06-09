package tkl.report.model;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import tkl.report.model.ReportDTO;
import tkl.report.model.ReportSQL;

public class ReportDAO {
	private DataSource ds;
	ReportDAO(){
		try {
		Context initContext = new InitialContext();
		Context envContext  = (Context)initContext.lookup("java:/comp/env");
		 ds = (DataSource)envContext.lookup("jdbc/myoracle");
		}catch(NamingException ne) {		
		}
	}
	ArrayList<ReportDTO> select(String searchKey, int i, int k, int begin,int end){
		ArrayList<ReportDTO> list = new ArrayList<>();
		Connection con = null;
		PreparedStatement pstmt, pstmtPage = null;
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			//pstmt = con.prepareStatement(ReportSQL.sqlS);
			if(searchKey == null) {
				pstmtPage = con.prepareStatement(ReportSQL.sqlS);
				
				pstmtPage.setInt(1, i);
				pstmtPage.setInt(2, k);
				pstmtPage.setInt(3, begin);
				pstmtPage.setInt(4, end);
			} else if(searchKey.equals("listR")) {
				pstmtPage = con.prepareStatement(ReportSQL.SQL_SR);
				pstmtPage.setInt(1, i);
				pstmtPage.setInt(2, k);
			} else if(searchKey.equals("listC")) {
				pstmtPage = con.prepareStatement(ReportSQL.SQL_SR);
				pstmtPage.setInt(1, i);
				pstmtPage.setInt(2, k);
			} else {
				pstmtPage = con.prepareStatement(ReportSQL.sqlS);
				
				pstmtPage.setInt(1, i);
				pstmtPage.setInt(2, k);
				pstmtPage.setInt(3, begin);
				pstmtPage.setInt(4, end);
			}
			//rs = pstmt.executeQuery();
			rs = pstmtPage.executeQuery();
			System.out.println("sql : select R_NO, R_SUBJECT, R_CONTENT, R_FILE, R_FILE_COPY, R_EMAIL, R_NICK, R_WRITEDATE, R_STATE from REPORT where (R_STATE="+ i + " or R_STATE=" + k + ") and (ROWNUM>=" + begin +" AND ROWNUM<=" + end + ") order by R_NO desc");
			while(rs.next()) {
				int rNO = rs.getInt("R_NO");
				String rSubject = rs.getString("R_SUBJECT");
				String rContent = rs.getString("R_CONTENT");
				String rFile = rs.getString("R_FILE");
				String rFileCopy = rs.getString("R_FILE_COPY");
				String rEmail = rs.getString("R_EMAIL");
				String rNick = rs.getString("R_NICK");
				java.sql.Date rWriteDate = rs.getDate("R_WRITEDATE");
				String rState = rs.getString("R_STATE");
				String rReply = rs.getString("R_REPLY");
				//System.out.println("sql : select " + rNO + rSubject + rContent + rFile + rFileCopy + rEmail + rNick + rWriteDate + rState + " from REPORT where R_STATE=" + i + " or R_STATE=" + k + " and ROWNUM>=" + begin + " AND ROWNUM<=" + end + " order by " + rNO + " desc");
				ReportDTO dto = new ReportDTO(rNO, rSubject, rContent, rFile, rFileCopy, rEmail, rNick, rWriteDate, rState, rReply);
				list.add(dto);
			}
			return list;
		}catch(SQLException se) {
			System.out.println("sql¿À·ù1 : " + se);
			return null;
		}finally {
			try {
				if(rs != null) rs.close();
				//if(pstmt != null) pstmt.close();
				if(pstmtPage != null) pstmtPage.close();
				if(con != null) con.close();
			}catch(SQLException se) {
			}
		}
	}
	void insert(ReportDTO dto) {
		Connection con = null;
		PreparedStatement pstmt = null; 
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(ReportSQL.sqlI);
			pstmt.setString(1, dto.getrSubject());
			System.out.println(dto.getrSubject());
			pstmt.setString(2, dto.getrContent());
			System.out.println(dto.getrContent());
			pstmt.setString(3, dto.getrFile());
			System.out.println(dto.getrFile());
			pstmt.setString(4, dto.getrFileCopy());
			System.out.println(dto.getrFileCopy());
			pstmt.setString(5, dto.getrNick());
			System.out.println(dto.getrNick());
			pstmt.setString(6, dto.getrReply());
			System.out.println(dto.getrReply());
			pstmt.executeUpdate();
		}catch(SQLException se) {
			System.out.println("insert() se: " + se);
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(SQLException se) {
			}
		}
	}
	void delete(int rNO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		File file = null;
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(ReportSQL.sqlD);
			pstmt.setInt(1, rNO);
			pstmt.executeUpdate();
		}catch(SQLException se) {
			
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(SQLException se) {
			}
		}
	}
	public ReportDTO content(int rNO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(ReportSQL.sqlC);
			pstmt.setInt(1, rNO);
			rs = pstmt.executeQuery();
			ReportDTO dtoContent = null; 
			while(rs.next()) {
				String rSubject = rs.getString("R_SUBJECT");
				String rContent = rs.getString("R_CONTENT");
				String rFile = rs.getString("R_FILE");
				String rFileCopy = rs.getString("R_FILE_COPY");
				String rEmail = rs.getString("R_EMAIL");
				String rNick = rs.getString("R_NICK");
				java.sql.Date rWriteDate = rs.getDate("R_WRITEDATE");
				String rState = rs.getString("R_STATE");
				String rReply = rs.getString("R_REPLY");
				dtoContent = new ReportDTO(rNO, rSubject, rContent, rFile, rFileCopy, rEmail, rNick, rWriteDate, rState, rReply);
			}
			return dtoContent;
		}catch(SQLException se) {
			return null;
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(SQLException se) {
			}
		}
	}
	void update(ReportDTO dto) {
		Connection con = null;
		PreparedStatement pstmt = null; 
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(ReportSQL.sqlU);
			pstmt.setString(1, dto.getrReply());
			System.out.println("dto.getrReply : " + dto.getrReply());
			pstmt.setInt(2, dto.getrNO());
			System.out.println("dto.getrNO : " + dto.getrNO());
			pstmt.executeUpdate();
		}catch(SQLException se) {
			System.out.println("update() se: " + se);
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(SQLException se) {
			}
		}
	}
	
	int getTotal(int i, int k) {
		int cnt = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(ReportSQL.sql_TOTAL);
			pstmt.setInt(1, i);
			pstmt.setInt(2, k);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				cnt = rs.getInt(1);
			}
			return cnt;
		} catch (SQLException se) {		
			return cnt;
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException se) {
			}
		} 		
	}
}

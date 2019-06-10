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
import javax.servlet.http.HttpSession;
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
	ArrayList<ReportDTO> select(String sessionNick, String sessionGrant, String searchKey, int begin,int end){
		ArrayList<ReportDTO> list = new ArrayList<>();
		Connection con = null;
		PreparedStatement pstmt, pstmtPage = null;
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			//pstmt = con.prepareStatement(ReportSQL.sqlS);
			System.out.println("sessionGrant11 : " + sessionGrant);
			if(sessionGrant.equals("0 ")) {
				if(searchKey == null) {
					pstmtPage = con.prepareStatement(ReportSQL.sqlSAll);
					pstmtPage.setString(1, "贸府吝");
					pstmtPage.setString(2, "贸府肯丰");
					pstmtPage.setInt(3, begin);
					pstmtPage.setInt(4, end);
				} else if(searchKey.equals("listR")) {
					pstmtPage = con.prepareStatement(ReportSQL.SQL_SRAll);
					pstmtPage.setString(1, "贸府吝");
				} else if(searchKey.equals("listC")) {
					pstmtPage = con.prepareStatement(ReportSQL.SQL_SRAll);
					pstmtPage.setString(1, "贸府肯丰");
				}
			}
			if(sessionGrant.equals("1 ")) {
				if(searchKey == null) {
					pstmtPage = con.prepareStatement(ReportSQL.sqlS);
					pstmtPage.setString(1, sessionNick);
					pstmtPage.setString(2, "贸府吝");
					pstmtPage.setString(3, "贸府肯丰");
					pstmtPage.setInt(4, begin);
					pstmtPage.setInt(5, end);
				} else if(searchKey.equals("listR")) {
					pstmtPage = con.prepareStatement(ReportSQL.SQL_SR);
					pstmtPage.setString(1, sessionNick);
					pstmtPage.setString(2, "贸府吝");
				} else if(searchKey.equals("listC")) {
					pstmtPage = con.prepareStatement(ReportSQL.SQL_SR);
					pstmtPage.setString(1, sessionNick);
					pstmtPage.setString(2, "贸府肯丰");
				} else {
					pstmtPage = con.prepareStatement(ReportSQL.sqlS);
					pstmtPage.setString(1, sessionNick);
					pstmtPage.setString(2, "贸府吝");
					pstmtPage.setString(3, "贸府肯丰");
					pstmtPage.setInt(4, begin);
					pstmtPage.setInt(5, end);	
				}
			}
			//rs = pstmt.executeQuery();
			rs = pstmtPage.executeQuery();
			//System.out.println("sql : select R_NO, R_SUBJECT, R_CONTENT, R_FILE, R_FILE_COPY, R_EMAIL, R_NICK, R_WRITEDATE, R_STATE from REPORT where (R_STATE="+ i + " or R_STATE=" + k + ") and (ROWNUM>=" + begin +" AND ROWNUM<=" + end + ") order by R_NO desc");
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
				String rClass = rs.getString("R_CLASS");
				//System.out.println("sql : select " + rNO + rSubject + rContent + rFile + rFileCopy + rEmail + rNick + rWriteDate + rState + " from REPORT where R_STATE=" + i + " or R_STATE=" + k + " and ROWNUM>=" + begin + " AND ROWNUM<=" + end + " order by " + rNO + " desc");
				ReportDTO dto = new ReportDTO(rNO, rSubject, rContent, rFile, rFileCopy, rEmail, rNick, rWriteDate, rState, rReply, rClass);
				list.add(dto);
			}
			return list;
		}catch(SQLException se) {
			System.out.println("sql坷幅1 : " + se);
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
			pstmt.setString(7, dto.getrClass());
			System.out.println(dto.getrClass());
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
				String rClass = rs.getString("R_Class");
				dtoContent = new ReportDTO(rNO, rSubject, rContent, rFile, rFileCopy, rEmail, rNick, rWriteDate, rState, rReply, rClass);
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
	
	int getTotal(String sessionNick, int i, int k) {
		int cnt = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = ds.getConnection();
			if(i+k == 1) {
				pstmt = con.prepareStatement(ReportSQL.sql_TOTALAll);
				pstmt.setInt(1, i);
				pstmt.setInt(2, k);
			} else {
				pstmt = con.prepareStatement(ReportSQL.sql_TOTAL);
				pstmt.setString(1, sessionNick);
				pstmt.setInt(2, i);
				pstmt.setInt(3, k);
			}
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

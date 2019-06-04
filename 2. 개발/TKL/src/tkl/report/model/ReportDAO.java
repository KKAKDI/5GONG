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
	ArrayList<ReportDTO> select(){
		ArrayList<ReportDTO> list = new ArrayList<>();
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(ReportSQL.sqlS);
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
				ReportDTO dto = new ReportDTO(rNO, rSubject, rContent, rFile, rFileCopy, rEmail, rNick, rWriteDate, rState);
				list.add(dto);
			}
			return list;
		}catch(SQLException se) {
			System.out.println(se);
			return null;
		}finally {
			try {
				if(stmt != null) stmt.close();
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
				dtoContent = new ReportDTO(rNO, rSubject, rContent, rFile, rFileCopy, rEmail, rNick, rWriteDate, rState);
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
}

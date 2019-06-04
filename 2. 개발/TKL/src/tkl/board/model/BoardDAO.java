package tkl.board.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.*;
import javax.sql.*;

import tkl.board.model.BoardDTO;
import tkl.board.model.BoardSQL;

public class BoardDAO {
	private DataSource ds;

	BoardDAO() {
		try {
			Context initContext = new InitialContext();
			Context envContext  = (Context)initContext.lookup("java:/comp/env");
			ds = (DataSource)envContext.lookup("jdbc/myoracle");	
		} catch (NamingException ne) {
			System.out.println("BoardDAO : " + ne);
		}
	}
	ArrayList<BoardDTO> boardList(){
		ArrayList<BoardDTO> list = new ArrayList<BoardDTO>();
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(BoardSQL.sqlS);
			while(rs.next()) {
				int bNo = rs.getInt("B_NO");
				String mEmail = rs.getString("M_EMAIL");
				String mNick = rs.getString("M_NICK");
				String bSubject = rs.getString("B_SUBJECT");
				String bContent = rs.getString("B_CONTENT");
				String bImg = rs.getString("B_IMG");
				String bImgCopy = rs.getString("B_IMG_COPY");
				int bView = rs.getInt("B_VIEW");
				int bLike = rs.getInt("B_LIKE");
				java.sql.Date bWriteDate = rs.getDate("B_WRITEDATE");
				
				BoardDTO dto = new BoardDTO(bNo, mEmail, mNick, bSubject, bContent, bImg, bImgCopy, bView, bLike, bWriteDate);
				list.add(dto);

			}
			return list;
		}catch(SQLException se) {
			System.out.println(" ¿©±ä°¡? se: " + se);
			return null;
		}finally {
			try {
				if(rs != null)rs.close();
				if(stmt !=null)stmt.close();
				if(con !=null)con.close();
			}catch(SQLException se) {}
			
		}
	}
	int tableRowNum() {
		Statement stmt = null;
		Connection con = null;
		try {
			con = ds.getConnection();
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(BoardSQL.sqlA);
			rs.next();
			int num = rs.getInt(1);
			return num;
			
			
		}catch(SQLException se) {
			System.out.println("tableRowNum se : "+se);
			return -1;
		}finally {
			try {
				if(stmt !=null)stmt.close();
				if(con !=null)con.close();
			}catch(SQLException se) {}
		}	
	}
	void insert(BoardDTO dto) {
		System.out.println("insert()");
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(BoardSQL.sqlI);
			pstmt.setString(1, dto.getmNick());
			pstmt.setString(2, dto.getbSubject());
			pstmt.setString(3, dto.getbContent());
			pstmt.setString(4, dto.getbImg());
			pstmt.setString(5, dto.getbImgCopy());
			pstmt.executeUpdate();
		} catch (SQLException se) {
			System.out.println("insert() se : "+se);
		}finally {
			try {
				if(pstmt !=null)pstmt.close();
				if(con !=null)con.close();
			}catch(SQLException se) {}
			
		}
		
	}
	
}

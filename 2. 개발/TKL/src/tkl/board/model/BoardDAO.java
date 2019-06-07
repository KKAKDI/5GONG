package tkl.board.model;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.*;
import javax.servlet.ServletException;
import javax.sql.*;

import tkl.board.model.BoardDTO;
import tkl.board.model.BoardSQL;

public class BoardDAO {
	private DataSource ds;

	BoardDAO() {
		try {
			Context initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:/comp/env");
			ds = (DataSource) envContext.lookup("jdbc/myoracle");
		} catch (NamingException ne) {
			System.out.println("BoardDAO : " + ne);
		}
	}

	ArrayList<BoardDTO> boardList(String sk, String sv) {
		System.out.println("boardList");
		ArrayList<BoardDTO> list = new ArrayList<BoardDTO>();
		Connection con = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		PreparedStatement pstmt3 = null;
		ResultSet rs = null;
		ResultSet rs1 = null;
		System.out.println("boardList sk : "+sk);
		System.out.println("boardList sv : "+sv);
		try {
			con = ds.getConnection();
			stmt = con.createStatement();
			pstmt1 = con.prepareStatement(BoardSQL.sqlSN);
			pstmt2 = con.prepareStatement(BoardSQL.sqlSS);
			pstmt3 = con.prepareStatement(BoardSQL.sqlSC);
			if((sk==null||sv==null)||(sk=="")) {
				rs = stmt.executeQuery(BoardSQL.sqlS);
			}else {
				if(sk.equals("M_NICK")) {
					sv = sv.trim();
					pstmt1.setString(1, sv);
					rs = pstmt1.executeQuery();
				}else if (sk.equals("B_SUBJECT")) {
					sv = sv.trim();
					pstmt2.setString(1, sv);
					rs = pstmt2.executeQuery();
				}else if(sk.equals("B_CONTENT")) {
					sv = sv.trim();
					pstmt3.setString(1, sv);
					rs = pstmt3.executeQuery();
				}
			}
			while (rs.next()) {
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
				pstmt = con.prepareStatement(BoardSQL.sqlACNT, ResultSet.TYPE_SCROLL_INSENSITIVE,
						ResultSet.CONCUR_UPDATABLE);
				pstmt.setInt(1, bNo);
				rs1 = pstmt.executeQuery();
				rs1.next();
				int CNT = rs1.getInt("COUNT(*)");
				rs1.relative(-1);
				pstmt = con.prepareStatement(BoardSQL.sqlUCNT);
				pstmt.setInt(1, CNT);
				pstmt.setInt(2, bNo);
				BoardDTO dto = new BoardDTO(bNo, mEmail, mNick, bSubject, bContent, bImg, bImgCopy, bView, bLike,
						bWriteDate, CNT);
				list.add(dto);

			}
			return list;
		} catch (SQLException se) {
			System.out.println(" boardList se: " + se);
			return null;
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (pstmt != null)
					pstmt.close();
				if (pstmt1 != null)
					pstmt1.close();
				if (pstmt2 != null)
					pstmt2.close();
				if (pstmt3 != null)
					pstmt3.close();
				if (con != null)
					con.close();
			} catch (SQLException se) {
			}

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

		} catch (SQLException se) {
			System.out.println("tableRowNum se : " + se);
			return -1;
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (con != null)
					con.close();
			} catch (SQLException se) {
			}
		}
	}

	void boardView(int bNo) {
		System.out.println("BoardView()");
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(BoardSQL.sqlV);
			pstmt.setInt(1, bNo);
			pstmt.executeUpdate();
		} catch (SQLException se) {
			System.out.println("BoardView se : " + se);
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException se) {
			}
		}
	}

	void boardLike(int bNo) {
		System.out.println("BoardLike()");
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(BoardSQL.sqlL);
			pstmt.setInt(1, bNo);
			pstmt.executeUpdate();
		} catch (SQLException se) {
			System.out.println("BoardLike se : " + se);
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException se) {
			}
		}
	}

	void insert(BoardDTO dto) {
		System.out.println("insert()");
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(BoardSQL.sqlI);

			pstmt.setString(2, dto.getbSubject());
			pstmt.setString(3, dto.getbContent());
			pstmt.setString(4, dto.getbImg());
			pstmt.setString(5, dto.getbImgCopy());
			pstmt.executeUpdate();
		} catch (SQLException se) {
			System.out.println("insert() se : " + se);
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException se) {
			}
		}
	}

	BoardDTO boardContent(int bNo) throws ServletException, IOException {
		System.out.println("content()");
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(BoardSQL.sqlC);
			pstmt.setInt(1, bNo);

			rs = pstmt.executeQuery();
			rs.next();
			String bSubject = rs.getString("B_SUBJECT");
			String bContent = rs.getString("B_CONTENT");
			String mNick = rs.getString("M_NICK");
			String bImg = rs.getString("B_IMG");
			String bImgCopy = rs.getString("B_IMG_COPY");
			System.out.println();
			int bView = rs.getInt("B_VIEW");
			int bLike = rs.getInt("B_LIKE");
			BoardDTO dto = new BoardDTO(bNo, null, mNick, bSubject, bContent, bImg, bImgCopy, bView, bLike, null, -1);
			return dto;
		} catch (SQLException se) {
			System.out.println("se: " + se);
			return null;
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

	void boardDelete(int bNo) {
		System.out.println("boardDelte");
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();

			pstmt = con.prepareStatement(BoardSQL.sqlD);
			pstmt.setInt(1, bNo);
			pstmt.executeQuery();
		} catch (SQLException se) {
			System.out.println("boardDelete se : " + se);
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException se) {

			}
		}
	}

	void boardUpdate(int bNo, String bSubject, String bContent, String bImg, String bImgCopy) {
		System.out.println("boardUpdate");
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(BoardSQL.sqlU);
			pstmt.setString(1, bSubject);
			System.out.println("bSubject : " + bSubject);
			pstmt.setString(2, bContent);
			pstmt.setString(3, bImg);
			System.out.println("bImg : " + bImg);
			pstmt.setString(4, bImgCopy);
			pstmt.setInt(5, bNo);

			pstmt.executeQuery();
		} catch (SQLException se) {
			System.out.println("boardUpdate se : " + se);
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException se) {

			}
		}
	}

}

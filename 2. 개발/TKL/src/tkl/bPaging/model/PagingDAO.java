package tkl.bPaging.model;

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

public class PagingDAO {
	private DataSource ds;

	PagingDAO() {
		try {
			Context initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:/comp/env");
			ds = (DataSource) envContext.lookup("jdbc/myoracle");
		} catch (NamingException ne) {
		}
	}

	PagingDTO Paging(PagingDTO rDto) {
		return rDto;

	}

	int PagingRowNum(int i, String sv) {
		PreparedStatement pstmt = null;
		Connection con = null;
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			if (i == 0) {
				pstmt = con.prepareStatement(PagingSQL.sqlA);
				rs = pstmt.executeQuery();
				rs.next();
				return rs.getInt("COUNT(*)");
			} else if (i == 1) {
				pstmt = con.prepareStatement(PagingSQL.sqlSN);
				pstmt.setString(1, sv);
				rs = pstmt.executeQuery();
				rs.next();
				return rs.getInt("COUNT(*)");

			} else if (i == 2) {
				pstmt = con.prepareStatement(PagingSQL.sqlSS);
				pstmt.setString(1, sv);
				rs = pstmt.executeQuery();
				rs.next();
				return rs.getInt("COUNT(*)");

			} else if (i == 3) {
				pstmt = con.prepareStatement(PagingSQL.sqlSC);
				pstmt.setString(1, sv);
				rs = pstmt.executeQuery();
				rs.next();
				return rs.getInt("COUNT(*)");

			} else
				return -1;

		} catch (SQLException se) {
			System.out.println("PagingRowNum se : " + se);
			return -1;
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

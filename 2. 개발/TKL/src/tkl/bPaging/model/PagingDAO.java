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
	PagingDAO(){
		try {
			Context initContext = new InitialContext();
			Context envContext  = (Context)initContext.lookup("java:/comp/env");
			ds = (DataSource)envContext.lookup("jdbc/myoracle");	
		}catch(NamingException ne) {	
		}
	}
	
	
	PagingDTO Paging(PagingDTO rDto) {
		return rDto;
		
	}
	int PagingRowNum() {
		Statement stmt = null;
		Connection con = null;
		try {
			con = ds.getConnection();
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(PagingSQL.sqlA);
			rs.next();
			int num = rs.getInt("COUNT(*)");
			return num;
			
			
		}catch(SQLException se) {
			System.out.println("PagingRowNum se : "+se);
			return -1;
		}finally {
			try {
				if(stmt !=null)stmt.close();
				if(con !=null)con.close();
			}catch(SQLException se) {}
		}
	}
}

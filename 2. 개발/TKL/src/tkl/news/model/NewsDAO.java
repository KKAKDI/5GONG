package tkl.news.model;

import java.sql.*;
import java.sql.Date;
import java.util.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class NewsDAO {
	private DataSource ds;

	NewsDAO(){
		try {
			Context initContext = new InitialContext();
			Context envContext  = (Context)initContext.lookup("java:/comp/env");
			ds = (DataSource)envContext.lookup("jdbc/myoracle");
		} catch (NamingException ne) {}
	}
	ArrayList<NewsDTO> select(){
		ArrayList<NewsDTO> list = new ArrayList<NewsDTO>();
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(NewsSQL.sqlS);
			while(rs.next()) {
				int n_no =rs.getInt("n_no");
				String n_nick = rs.getString("n_nick");
				String n_subject = rs.getString("n_subject");
				String n_content = rs.getString("n_content");
				int n_view = rs.getInt("n_view");
				Date n_writedate = rs.getDate("n_writedate");
				String n_division = rs.getString("n_division");

				NewsDTO dto = new NewsDTO();
				dto.setN_no(n_no);
				dto.setN_nick(n_nick);
				dto.setN_subject(n_subject);
				dto.setN_content(n_content);
				dto.setN_writedate(n_writedate);
				dto.setN_view(n_view);
				dto.setN_division(n_division);
				list.add(dto);
			}
			return list;
		} catch (SQLException se) {
			System.out.println("select SQL Error :" +se);
			return null;
		}finally {
			try {
				if(rs != null) rs.close();
				if(stmt != null) rs.close();
				if(con != null) con.close();

			} catch (SQLException se) {
				System.out.println("select finally error : " + se);
			}
		}	
	}

	void insert(NewsDTO dto) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(NewsSQL.sqlI);
			//pstmt.setString(1, dto.getN_email());
			pstmt.setString(1, dto.getN_nick());
			pstmt.setString(2, dto.getN_subject());
			pstmt.setString(3, dto.getN_content());
			pstmt.setString(4, dto.getN_division());
			pstmt.executeUpdate();
		} catch (SQLException se) {
			System.out.println("Insert SQL error: "+se);
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch (SQLException se) {	
				System.out.println("insert Finally SQL error: " +se);
			}
		}	
	}
	NewsDTO content(int n_no) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(NewsSQL.sqlC);
			pstmt.setInt(1, n_no);
			rs = pstmt.executeQuery();
			rs.next();
			String n_nick = rs.getString("n_nick");
			String n_subject = rs.getString("n_subject");
			String n_content = rs.getString("n_content");
			String n_division = rs.getString("n_division");

			NewsDTO dto = new NewsDTO();
			dto.setN_no(n_no);
			dto.setN_nick(n_nick);
			dto.setN_subject(n_subject);
			dto.setN_content(n_content);
			dto.setN_division(n_division);

			return dto;
		} catch (SQLException se) {
			System.out.println("Content SQL error :" + se);
			return null;
		}finally{
			try {
				if( rs != null) rs.close();
				if( pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch (SQLException se) {
				System.out.println("Content Finally error :" + se);
			}
		}
	}
	public void delete(int n_no) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(NewsSQL.sqlD);
			pstmt.setInt(1, n_no);
			pstmt.executeUpdate();
		} catch (SQLException se) {
			System.out.println("Delete SQL error: " +se);
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(SQLException se){	
			}
		}
	}
	public NewsDTO updateview(NewsDTO dto) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			pstmt= con.prepareStatement(NewsSQL.sqlUV);
			pstmt.setInt(1, dto.getN_no());
			rs = pstmt.executeQuery();
			rs.next();
			int n_no = rs.getInt("n_no");
			String n_nick = rs.getString("n_nick");
			String n_subject =rs.getString("n_subject");
			String n_content = rs.getString("n_content");
			String n_division = rs.getString("n_division");
			
			NewsDTO dtoo = new NewsDTO();
			dtoo.setN_no(n_no);
			dtoo.setN_nick(n_nick);
			dtoo.setN_subject(n_subject);
			dtoo.setN_content(n_content);
			dtoo.setN_division(n_division);
			return dtoo;
			
		} catch (SQLException se) {
			return dto;
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(rs != null) rs.close();
				if(con != null) con.close();
			} catch (SQLException se) {
				
			}
		}
	}
	void update(NewsDTO dto) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(NewsSQL.sqlU);
			pstmt.setString(1, dto.getN_subject());
			pstmt.setString(2, dto.getN_content());
			pstmt.setInt(3, dto.getN_no());
			pstmt.executeUpdate();
		} catch (SQLException se) {
			System.out.println("update SQL error:" +se);
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch (SQLException se) {
				
			}
		
		}
	}
	public void view(int n_no) {
	      Connection con = null;
	      PreparedStatement pstmt = null;
	      try {
	         con = ds.getConnection();
	         pstmt = con.prepareStatement(NewsSQL.sqlView);
	         pstmt.setInt(1, n_no);
	         pstmt.executeUpdate();
	      } catch (SQLException se) {
	         System.out.println("content view error : " +se);
	      }finally {
	         try {
	            if(pstmt != null) pstmt.close();
	            if(con != null) con.close();
	         } catch (SQLException se) {
	            System.out.println("content view finally error : " +se);
	         }
	      }
	   }
	public ArrayList<NewsDTO> selectnotice() {
		ArrayList<NewsDTO> list = new ArrayList<NewsDTO>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			pstmt= con.prepareStatement(NewsSQL.sqlnotice);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int n_no = rs.getInt("n_no");
				String n_nick = rs.getString("n_nick");
				String n_subject = rs.getString("n_subject");
				String n_content = rs.getString("n_content");
				int n_view = rs.getInt("n_view");
				Date n_writedate = rs.getDate("n_writedate");
				String n_division = rs.getString("n_division");
				
				NewsDTO dto = new NewsDTO();
				dto.setN_no(n_no);
				dto.setN_nick(n_nick);
				dto.setN_subject(n_subject);
				dto.setN_content(n_content);
				dto.setN_view(n_view);
				dto.setN_writedate(n_writedate);
				dto.setN_division(n_division);
				list.add(dto);
				
			}
			return list;
		} catch (SQLException se) {
			return null;
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(SQLException se) {}
		}
			
	}
	public ArrayList<NewsDTO> selectevent() {
		ArrayList<NewsDTO> list = new ArrayList<NewsDTO>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			pstmt= con.prepareStatement(NewsSQL.sqlevent);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int n_no = rs.getInt("n_no");
				String n_nick = rs.getString("n_nick");
				String n_subject = rs.getString("n_subject");
				String n_content = rs.getString("n_content");
				int n_view = rs.getInt("n_view");
				Date n_writedate = rs.getDate("n_writedate");
				String n_division = rs.getString("n_division");
				
				NewsDTO dto = new NewsDTO();
				dto.setN_no(n_no);
				dto.setN_nick(n_nick);
				dto.setN_subject(n_subject);
				dto.setN_content(n_content);
				dto.setN_view(n_view);
				dto.setN_writedate(n_writedate);
				dto.setN_division(n_division);
				list.add(dto);
				
			}
			return list;
		} catch (SQLException se) {
			return null;
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(SQLException se) {}
		}
	}
	int PagingRowNum() {
		Statement stmt = null;
		Connection con = null;
		try {
			con = ds.getConnection();
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(NewsSQL.sqlPaging);
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


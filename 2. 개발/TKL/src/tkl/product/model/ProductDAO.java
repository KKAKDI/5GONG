package tkl.product.model;

import java.sql.*;
import java.sql.Date;
import java.util.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import tkl.product.model.*;

public class ProductDAO {

	private DataSource ds;

	ProductDAO(){
		try {
			Context initContext = new InitialContext();
			Context envContext  = (Context)initContext.lookup("java:/comp/env");
			ds = (DataSource)envContext.lookup("jdbc/myoracle");
		} catch (NamingException ne) {
			System.out.println("오라클 오류야 : " +ne);
		}
	}
	ArrayList<ProductDTO> select(){
		ArrayList<ProductDTO> list = new ArrayList<ProductDTO>();
		Connection con = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(ProductSQL.sqlList);
			while(rs.next()) {
				int pd_no = rs.getInt("pd_no");
				String pd_nick = rs.getString("pd_nick");
				String pd_status = rs.getString("pd_status");
				String pd_subject = rs.getString("pd_subject");
				java.sql.Date pd_regdate = rs.getDate("pd_regdate");
				ProductDTO dto = new ProductDTO();
				dto.setPd_no(pd_no);
				dto.setPd_nick(pd_nick);
				dto.setPd_status(pd_status);
				dto.setPd_subject(pd_subject);
				dto.setPd_regdate(pd_regdate);
				list.add(dto);
			}
			return list;
		}catch(SQLException se) {
			return null;
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) rs.close();
				if(con != null) con.close();
			}catch(SQLException se) {}
		}
	}
	ProductDTO content(int pd_no) {
		Connection  con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(ProductSQL.sqlContent);
			pstmt.setInt(1, pd_no);
			rs = pstmt.executeQuery();
			rs.next();
			String pd_email = rs.getString("pd_email");
			String pd_nick = rs.getString("pd_nick");
			String pd_status =  rs.getString("pd_status");
			String pd_buyer = rs.getString("pd_buyer");
			String pd_name = rs.getString("pd_name");
			int pd_price = rs.getInt("pd_price");
			String pd_subject = rs.getString("pd_subject");
			String pd_content = rs.getString("pd_content");
			String pd_img = rs.getString("pd_img");
			String pd_img_copy = rs.getString("pd_img_copy");
			java.sql.Date pd_regdate = rs.getDate("pd_regdate");
			ProductDTO dto = new ProductDTO(pd_no, null, null, null, null, pd_name, pd_price, null, null, pd_img,null, pd_regdate);
			
			return dto;
			
		} catch (SQLException se) {
			System.out.println("Content error : " +se);
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch (SQLException se) {
				System.out.println("Content finally : " +se);
			}
		}
		return null;

	}
	

}

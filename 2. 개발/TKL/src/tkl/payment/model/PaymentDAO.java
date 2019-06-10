package tkl.payment.model;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import java.util.*;
import java.sql.*;

class PaymentDAO {
	private DataSource ds;
	
	PaymentDAO(){
		try {
			Context initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:/comp/env");
			ds = (DataSource) envContext.lookup("jdbc/myoracle");
		}catch(NamingException ne) {}
	}
	
	PaymentDTO select(int pd_no){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(PaymentSQL.sqlList);
			pstmt.setInt(1, pd_no);
			rs = pstmt.executeQuery();
			rs.next();
			int pm_no = rs.getInt("pm_no");
			System.out.println("pm_no : " + pm_no);
			pd_no = rs.getInt("pd_no");
			String pm_buyer = rs.getString("pm_buyer");
			System.out.println("pm_buyer : " + pm_buyer);
			String pm_b_bank = rs.getString("pm_b_bank");
			System.out.println("pm_b_bank : " + pm_b_bank);
			long pm_b_account = rs.getLong("pm_b_account");
			System.out.println("pm_b_account : " + pm_b_account);
			long pm_b_amount = rs.getLong("pm_b_amount");
			System.out.println("pm_b_amount : " + pm_b_amount);
			java.sql.Date pm_regdate = rs.getDate("pm_regdate");
			System.out.println("pm_regdate : " + pm_regdate);
			String pm_addr = rs.getString("pm_addr");
			PaymentDTO dto = new PaymentDTO();
			dto.setPm_no(pm_no);
			dto.setPd_no(pd_no);
			dto.setPm_buyer(pm_buyer);
			dto.setPm_b_bank(pm_b_bank);
			dto.setPm_b_account(pm_b_account);
			dto.setPm_b_amount(pm_b_amount);
			dto.setPm_regdate(pm_regdate);
			dto.setPm_addr(pm_addr);
			return dto;
		}catch(SQLException se) {
			System.out.println("오류 : " + se);
			return null;
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(SQLException se) {}
		}
	}
	
	
}

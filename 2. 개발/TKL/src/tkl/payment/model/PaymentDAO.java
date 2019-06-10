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
			//pd_no = rs.getInt("pd_no");
			String pm_seller = rs.getString("pm_seller");
			System.out.println("pm_seller : " + pm_seller);
			String pm_s_bank = rs.getString("pm_s_bank");
			System.out.println("pm_s_bank : " + pm_s_bank);
			int pm_s_account = rs.getInt("pm_s_account");
			System.out.println("pm_s_account : " + pm_s_account);
			int pm_s_amount = rs.getInt("pm_s_amount");
			System.out.println("pm_s_amount : " + pm_s_amount);
			java.sql.Date pm_regdate = rs.getDate("pm_regdate");
			System.out.println("pm_regdate : " + pm_regdate);
			String pm_addr = rs.getString("pm_addr");
			System.out.println("pm_addr : " + pm_addr);
			PaymentDTO dto = new PaymentDTO();
			dto.setPm_no(pm_no);
			//dto.setPd_no(pd_no);
			dto.setPm_seller(pm_seller);
			dto.setPm_s_bank(pm_s_bank);
			dto.setPm_s_account(pm_s_account);
			dto.setPm_s_amount(pm_s_amount);
			dto.setPm_regdate(pm_regdate);
			dto.setPm_addr(pm_addr);
			return dto;
		}catch(SQLException se) {
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

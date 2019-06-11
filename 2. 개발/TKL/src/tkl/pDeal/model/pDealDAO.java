package tkl.pDeal.model;

import java.sql.*;
import java.sql.Date;
import java.util.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import tkl.board.model.BoardDTO;
import tkl.board.model.BoardSQL;

public class pDealDAO {
	private DataSource ds;

	pDealDAO() {
		try {
			Context initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:/comp/env");
			ds = (DataSource) envContext.lookup("jdbc/myoracle");
		} catch (NamingException ne) {
		}
	}

	pDealDTO pDeal_list(String m_email, int pdNo, int pay_pm_no) {
		System.out.println("pDeal_list");
		System.out.println("1");
		Connection con = null;
		System.out.println("2");
		PreparedStatement pstmtM, pstmtP, pstmtPM = null;
		System.out.println("3");
		ResultSet rs = null;
		try {
			System.out.println("4");
			con = ds.getConnection();
			System.out.println("4");
			pstmtM = con.prepareStatement(pDealSQL.sqlM);
			pstmtM.setString(1, m_email);
			pstmtP = con.prepareStatement(pDealSQL.sqlP);
			pstmtP.setInt(1, pdNo);
			pstmtPM = con.prepareStatement(pDealSQL.sqlPM);
			pstmtPM.setInt(1, pay_pm_no);
			rs = pstmtM.executeQuery();
			System.out.println("6");
			rs.next();
			System.out.println("7");
			String m_nick = rs.getString("M_NICK");
			System.out.println("7-1");
			System.out.println("m_nick : "+m_nick);
			String m_name = rs.getString("M_NAME");
			String m_bank = rs.getString("M_BANK");
			int m_phone = rs.getInt("M_PHONE");
			long m_account = rs.getLong("M_ACCOUNT");
			int m_amount = rs.getInt("M_AMOUNT");
			int m_trust = rs.getInt("M_TRUST");
			Date m_regdate = rs.getDate("M_REGDATE");
			rs = pstmtP.executeQuery();
			System.out.println("8");
			rs.next();
			System.out.println("9");
			int pd_no = rs.getInt("PD_NO");
			System.out.println("PD_NO : "+pd_no);
			String pd_email = rs.getString("PD_EMAIL");
			String pd_nick = rs.getString("PD_NICK");
			String pd_status = rs.getString("PD_STATUS");
			String pd_buyer = rs.getString("PD_BUYER");
			String pd_name = rs.getString("PD_NAME");
			String pd_class = rs.getString("PD_CLASS");
			int pd_price = rs.getInt("PD_PRICE");
			Date pd_regdate = rs.getDate("PD_REGDATE");
			rs = pstmtPM.executeQuery();
			System.out.println("10");
			rs.next();
			System.out.println("11");
			int pay_pd_no = rs.getInt("PD_NO");
			System.out.println("pay_pd_no : "+pay_pd_no);
			String pm_seller = rs.getString("PM_SELLER");
			String pm_s_bank = rs.getString("PM_S_BANK");
			long pm_s_account = rs.getLong("PM_S_ACCOUNT");
			String pm_buyer = rs.getString("PM_BUYER");
			String pm_b_bank = rs.getString("PM_B_BANK");
			long pm_b_account = rs.getLong("PM_B_ACCOUNT");
			int pm_s_amount = rs.getInt("PM_S_AMOUNT");
			Date pm_regdate = rs.getDate("PM_REGDATE");
			String pm_addr = rs.getString("PM_ADDR");
			String pm_schek = rs.getString("PM_SCHEK");

			pDealDTO dto = new pDealDTO(m_email, m_nick, m_name, m_bank, m_phone, m_account, m_amount, m_trust,
					m_regdate, pd_no, pd_email, pd_nick, pd_status, pd_buyer, pd_name, pd_class, pd_price, pd_regdate,
					pay_pm_no, pay_pd_no, pm_seller, pm_s_bank, pm_s_account, pm_buyer, pm_b_bank, pm_b_account,
					pm_s_amount, pm_regdate, pm_addr, pm_schek);

			return dto;
		} catch (SQLException se) {
			System.out.println(" pDeal_list se: " + se);
			return null;
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmtPM != null)
					pstmtPM.close();
				if (con != null)
					con.close();
			} catch (SQLException se) {
			}

		}
	}
}

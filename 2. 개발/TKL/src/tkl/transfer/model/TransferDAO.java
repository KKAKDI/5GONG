package tkl.transfer.model;

import java.sql.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


public class TransferDAO implements Transfer{
	private DataSource ds;
	Connection con;
	
	public TransferDAO() {
		try {
			Context initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:/comp/env");
			ds = (DataSource) envContext.lookup("jdbc/myoracle");
			con = ds.getConnection();
			con.setAutoCommit(false);
		}catch(NamingException ne) {
		}catch(SQLException se) {			
		}		
	}
	
	TransferDTO select(int pd_no){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(TransferSQL.SQL_LIST);
			pstmt.setInt(1, pd_no);
			rs = pstmt.executeQuery();
			rs.next();
			int pm_no = rs.getInt("pm_no");
			pd_no = rs.getInt("pd_no");
			String pm_seller = rs.getString("pm_seller");
			String pm_s_bank = rs.getString("pm_s_bank");
			long pm_s_account = rs.getLong("pm_s_account");
			String pm_buyer = rs.getString("pm_buyer");
			String pm_b_bank = rs.getString("pm_b_bank");
			long pm_b_account = rs.getLong("pm_b_account");
			long pm_s_amount = rs.getLong("pm_s_amount");
			long pm_b_amount = rs.getLong("pm_b_amount");
			java.sql.Date pm_regdate = rs.getDate("pm_regdate");
			String pm_addr = rs.getString("pm_addr");
			String pm_bchek = rs.getString("pm_bchek");
			String pm_schek = rs.getString("pm_schek");
			TransferDTO dto = new TransferDTO();
			dto.setPm_no(pm_no);
			dto.setPd_no(pd_no);
			dto.setPm_seller(pm_seller);
			dto.setPm_s_bank(pm_s_bank);
			dto.setPm_s_account(pm_s_account);
			dto.setPm_buyer(pm_buyer);
			dto.setPm_b_bank(pm_b_bank);
			dto.setPm_b_account(pm_b_account);
			dto.setPm_s_amount(pm_s_amount);
			dto.setPm_b_amount(pm_b_amount);
			dto.setPm_regdate(pm_regdate);
			dto.setPm_addr(pm_addr);
			dto.setPm_bchek(pm_bchek);
			dto.setPm_schek(pm_schek);
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
	
	public void createPayment(TransferDTO dto) {
		PreparedStatement pstmt= null;
		try {
			pstmt = con.prepareStatement(TransferSQL.SQL_INPAY);
			pstmt.setInt(1, dto.getPd_no());
			pstmt.setString(2, dto.getPm_seller());
			pstmt.setString(3, dto.getPm_s_bank());
			pstmt.setLong(4, dto.getPm_s_account());
			pstmt.setString(5, dto.getPm_buyer());
			pstmt.setString(6, dto.getPm_b_bank());
			pstmt.setLong(7, dto.getPm_b_account());
			pstmt.setLong(8, dto.getPm_s_amount());
			pstmt.setLong(9, dto.getPm_b_amount());
			pstmt.setString(10, dto.getPm_addr());
			pstmt.executeQuery();
			con.commit();
		} catch (SQLException se) {
			System.out.println(se);			
		}		
	}
	//구매자 , 판매자 EMAIL 확인
	public boolean isMember(String email) { 
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = con.prepareStatement(TransferSQL.SQL_SELMEM);
			pstmt.setString(1,email);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return true;
			}else {
				return false;
			}
		} catch (SQLException se) {
			System.out.println(se);
			return false;
		}		
	}
	//구매자 잔액확인
	public boolean checkBalance(String seller, long amount) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = con.prepareStatement(TransferSQL.SQL_SELBAL);
			pstmt.setString(1, seller);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				long mAmount= rs.getLong(1);
				if(mAmount>=amount) {
					return true;
				}else {
					System.out.println("잔액부족");
					return false;
				}
			}else {
				return false;
			}
		} catch (SQLException se) {			
			System.out.println(se);
			return false;
		}	
	}
	//구매신청시 구매자 차감
	public boolean minus(String seller, long amount) {
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(TransferSQL.SQL_UPM);
			pstmt.setString(1, seller);
			pstmt.setLong(2, amount);
			pstmt.setString(3, seller);
			int flag = pstmt.executeUpdate();
			con.commit();
			if(flag>0) {
				return true;
			}else {
				return false;
			}
		} catch (SQLException se) {
			System.out.println(se);
			return false;
		}		
	}
	//최종 확인시 판매자 입금
	public boolean plus(String buyer, long amount) {
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(TransferSQL.SQL_UPP);
			pstmt.setString(1, buyer);
			pstmt.setLong(2, amount);
			pstmt.setString(3, buyer);
			int flag = pstmt.executeUpdate();
			if(flag>0) {
				return true;
			}else {
				return false;
			}
		} catch (SQLException se) {
			System.out.println(se);
			return false;
		}	
	}
	
	//거래일 업데이트 x => PAYMENT 테이블 접근 필요
	//차감 트렌젝션 필요?

	
	//HISTORY 작성
	public boolean log(TransferDTO dto) {
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(TransferSQL.SQL_INHIS);
			pstmt.setString(1, dto.getPm_seller());
			pstmt.setLong(4, dto.getPm_s_account());
			pstmt.setString(3, dto.getPm_buyer());
			pstmt.setLong(4, dto.getPm_b_account());
			pstmt.setLong(5, dto.getPm_s_amount());
			pstmt.executeQuery();
			return true;
		} catch (SQLException se) {
			System.out.println(se);
			return false;
		}		
	}
	//결과창 리턴
	public TransferDTO showResult(String seller, String buyer) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = con.prepareStatement(TransferSQL.SQL_RESULT);
			pstmt.setString(1, seller);
			pstmt.setString(2, buyer);
			rs = pstmt.executeQuery();
			String hSeller = null;
			String hBuyer = null;
			int amount=0;
			Date dDate = null;
			if(rs.next()) {
				 hSeller = rs.getString("H_SELLER");
				 hBuyer = rs.getString("H_BUYER");
				 amount = rs.getInt("H_DEAL_AMOUNT");
				 dDate = rs.getDate("H_DEALDATE");		
			}		
			TransferDTO dto = new TransferDTO();
			dto.setPm_seller(hSeller);
			dto.setPm_buyer(hBuyer);
			dto.setPm_s_amount(amount);
			dto.setPm_regdate(dDate);
			return dto;
		} catch (SQLException se) {
			System.out.println(se);
			return null;
		}
	}
	//최종확인시 돌아갈 트렌젝션
	public boolean transfer(TransferDTO dto) {
		String seller = dto.getPm_seller();
		String buyer = dto.getPm_buyer();
		long amount = dto.getPm_s_amount();
		try {
			if(isMember(seller)&&isMember(buyer)&&plus(seller,amount)&&log(dto)) {				
				con.commit();
				return true;
			}else {
				con.rollback();
				return false;
			}
		} catch (SQLException se) {
			System.out.println(se);
			return false;
		}		
	}
}

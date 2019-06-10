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
	
	public void createPayment(TransferDTO dto) {
		PreparedStatement pstmt= null;
		try {
			pstmt = con.prepareStatement(TransferSQL.SQL_INPAY);
			pstmt.setInt(1, dto.getPdNo());
			pstmt.setString(2, dto.getSeller());
			pstmt.setString(3, dto.getsBank());
			pstmt.setInt(4, dto.getsAccount());
			pstmt.setString(5, dto.getBuyer());
			pstmt.setString(6, dto.getbBank());
			pstmt.setInt(7, dto.getbAccount());
			pstmt.setInt(8, dto.getsAmount());
			pstmt.setInt(9, dto.getbAmount());
			pstmt.setString(10, dto.getbAddr());
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
			pstmt.setString(1, dto.getSeller());
			pstmt.setInt(4, dto.getsAccount());
			pstmt.setString(3, dto.getBuyer());
			pstmt.setInt(4, dto.getbAccount());
			pstmt.setInt(5, dto.getsAmount());
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
			dto.setSeller(hSeller);
			dto.setBuyer(hBuyer);
			dto.setsAmount(amount);
			dto.setRegDate(dDate);
			return dto;
		} catch (SQLException se) {
			System.out.println(se);
			return null;
		}
	}
	//최종확인시 돌아갈 트렌젝션
	public boolean transfer(TransferDTO dto) {
		String seller = dto.getSeller();
		String buyer = dto.getBuyer();
		int amount = dto.getsAmount();
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

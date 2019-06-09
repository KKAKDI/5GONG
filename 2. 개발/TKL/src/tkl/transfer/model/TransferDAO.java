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
	public boolean checkBalance(String sender, long amount) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = con.prepareStatement(TransferSQL.SQL_SELBAL);
			pstmt.setString(1, sender);
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
	public boolean minus(String sender, long amount) {
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(TransferSQL.SQL_UPM);
			pstmt.setString(1, sender);
			pstmt.setLong(2, amount);
			pstmt.setString(3, sender);
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
	//최종 확인시 판매자 입금
	public boolean plus(String receiver, long amount) {
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(TransferSQL.SQL_UPP);
			pstmt.setString(1, receiver);
			pstmt.setLong(2, amount);
			pstmt.setString(3, receiver);
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
	public boolean update(String sender, String receiver) {
		PreparedStatement pstmt = null;
		try {	
			pstmt = con.prepareStatement(TransferSQL.SQL_UPP);
		} catch (SQLException se) {
			System.out.println(se);
		}
		return false;
	}
	
	//HISTORY 작성
	public boolean log(String sender, String receiver, long amount) {
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(TransferSQL.SQL_UPP);
		} catch (SQLException se) {
			System.out.println(se);
		}
		return false;
	}
	//결과창 리턴
	public void showResult(String sender, String receiver) {
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(TransferSQL.SQL_UPP);
		} catch (SQLException se) {
			System.out.println(se);
		}
		
	}
	public void closeAll() {
		
	}
	//최종확인시 돌아갈 트렌젝션
	public boolean transfer(String sender, String receiver, long amount) {
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(TransferSQL.SQL_UPP);
		} catch (SQLException se) {
			System.out.println(se);
		}
		return false;
	}
}

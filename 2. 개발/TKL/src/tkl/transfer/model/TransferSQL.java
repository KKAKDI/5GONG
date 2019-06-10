package tkl.transfer.model;

class TransferSQL {
	public static final String SQL_SELMEM = "select M_EMAIL from MEMBER where M_EMAIL=?";
	public static final String SQL_SELBAL = "select M_AMOUNT from MEMBER where M_EMAIL=?";
	public static final String SQL_UPM = "update MEMBER set M_AMOUNT =((select M_AMOUNT from MEMBER M_EMAIL=?)-?) where M_EMAIL=?";
	public static final String SQL_UPP = "update MEMBER set M_AMOUNT =((select M_AMOUNT from MEMBER M_EMAIL=?)+?) where M_EMAIL=?";
	public static final String SQL_INPAY = "insert into PAYMENT(PM_NO,PD_NO,PM_SELLER,PM_S_BANK,PM_S_ACCOUNT,PM_BUYER,PM_B_BANK,PM_B_ACCOUNT,PM_S_AMOUNT,PM_B_AMOUNT,PM_REGDATE,PM_ADDR,PM_BCHEK,PM_SCHEK)"
			+ "values (PAYMENT_PM_NO.nextval,?,?,?,?,?,?,?,?,?,SYSDATE,?,0,0)";
	public static final String SQL_INHIS = "insert into HISTORY(H_NO,H_SELLER,H_S_ACCOUNT,H_BUYER,H_B_ACCOUNT,H_DEAL_AMOUNT,H_DEALDATE) "
			+ "valuse(HISTORY_H_NO.nextval,?,?,?,?,?,SYSDATE)";
	public static final String SQL_RESULT = "select H_SELLER,H_BUYER,H_DEAL_AMOUNT,H_DEALDATE from HISTORY where H_SELLER=? and H_BUYER=?";
}

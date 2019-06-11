package tkl.pDeal.model;


public class pDealSQL {
	static final String sqlM ="select M_EMAIL, M_NICK, M_NAME, M_BANK, M_PHONE, M_ACCOUNT, M_AMOUNT, M_TRUST, M_REGDATE from MEMBER where M_EMAIL = ?";
	static final String sqlP ="select PD_NO, PD_EMAIL, PD_NICK, PD_STATUS, PD_BUYER, PD_NAME, PD_CLASS, PD_PRICE, PD_REGDATE from PRODUCT where PD_NO = ?";
	static final String sqlPM ="select PM_NO, PD_NO, PM_SELLER, PM_S_BANK, PM_S_ACCOUNT, PM_BUYER, PM_B_BANK, PM_B_ACCOUNT, PM_S_AMOUNT, PM_REGDATE, PM_ADDR, PM_SCHEK from payment where PM_NO = ?";
}

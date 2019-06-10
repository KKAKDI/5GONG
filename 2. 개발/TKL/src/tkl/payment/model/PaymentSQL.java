package tkl.payment.model;

class PaymentSQL {
	static final String sqlList = "select PM_NO, PD_NO, PM_SELLER, PM_S_BANK, PM_S_ACCOUNT, PM_BUYER, PM_B_BANK, PM_B_ACCOUNT, PM_S_AMOUNT, PM_B_AMOUNT, PM_REGDATE, PM_ADDR, PM_BCHEK, PM_SCHEK from PAYMENT where PM_NO=?";
}

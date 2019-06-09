package tkl.transfer.model;

class TransferSQL {
	public static final String SQL_SELMEM = "select M_EMAIL from MEMBER where M_EMAIL=?";
	public static final String SQL_SELBAL = "select M_AMOUNT from MEMBER where M_EMAIL=?";
	public static final String SQL_UPM = "update MEMBER set M_AMOUNT =((select M_AMOUNT from MEMBER M_EMAIL=?)-?) where M_EMAIL=?";
	public static final String SQL_UPP = "update MEMBER set M_AMOUNT =((select M_AMOUNT from MEMBER M_EMAIL=?)+?) where M_EMAIL=?";
}

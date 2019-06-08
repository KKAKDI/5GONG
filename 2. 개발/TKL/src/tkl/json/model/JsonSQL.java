package tkl.json.model;

public class JsonSQL {
	static final String SQL_MEM = "select M_EMAIL,M_NICK,M_PHONE,M_NAME,M_ACCOUNT,M_BANK,M_PASSWORD from MEMBER";
	static final String SQL_REF = "select PHONE,NAME,BANK,ACT_NUMBER,ACT_HOLDER from MONEY_MEMBER";
}

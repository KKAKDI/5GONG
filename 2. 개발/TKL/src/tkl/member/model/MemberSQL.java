package tkl.member.model;

class MemberSQL {
	static final String SQL_IN = 
			"insert into MEMBER(M_EMAIL,M_NICK,M_GRANT,M_PASSWORD,M_NAME,M_BANK,M_ACCOUNT,M_PHONE,M_AMOUNT,M_TRUST,M_REGDATE) "
			+ "values(?,?,1,?,?,?,?,?,0,50,SYSDATE)";
	static final String SQL_SEL = "select M_EMAIL,M_PASSWORD,M_NICK,M_GRANT from MEMBER where M_EMAIL=? and M_PASSWORD=?"; 
}

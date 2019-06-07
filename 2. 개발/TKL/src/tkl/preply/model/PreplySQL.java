package tkl.preply.model;

class PreplySQL {
	static final String sqlList = "select PD_NO, PR_NO, M_NICK, PR_COMMENT, PR_WRITEDATE from P_REPLY where PD_NO=? order by PR_NO desc";
	static final String sqlReg = "insert into P_REPLY(PR_NO, PD_NO, M_NICK, PR_COMMENT, PR_WRITEDATE) values(P_REPLY_PR_NO.nextval, ?, 'aaa', ?, SYSDATE)";
	static final String sqlDelete = "delete from P_REPLY where PR_NO=?";
}

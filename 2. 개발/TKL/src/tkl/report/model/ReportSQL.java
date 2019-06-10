package tkl.report.model;

public class ReportSQL {
	//static final String sqlS = "select R_NO, R_SUBJECT, R_CONTENT, R_FILE, R_FILE_COPY, R_EMAIL, R_NICK, R_WRITEDATE, R_STATE from REPORT where (R_STATE=? or R_STATE=?) and (ROWNUM>=? AND ROWNUM<=?) order by R_NO desc";
	static final String sqlS = "select B.R_NO, B.R_SUBJECT, B.R_CONTENT, B.R_FILE, B.R_FILE_COPY, B.R_EMAIL, B.R_NICK, B.R_WRITEDATE, B.R_STATE, B.R_REPLY, B.R_CLASS from (select ROWNUM AS rn, A.R_NO, A.R_SUBJECT, A.R_CONTENT, A.R_FILE, A.R_FILE_COPY, A.R_EMAIL, A.R_NICK, A.R_WRITEDATE, A.R_STATE, A.R_REPLY, A.R_CLASS from (select R_NO, R_SUBJECT, R_CONTENT, R_FILE, R_FILE_COPY, R_EMAIL, R_NICK, R_WRITEDATE, R_STATE, R_REPLY, R_CLASS from REPORT order by R_NO desc)A)B where R_NICK=? and (R_STATE=? or R_STATE=?) and (RN>=? AND RN<=?) order by R_NO desc";
	static final String sqlSAll = "select B.R_NO, B.R_SUBJECT, B.R_CONTENT, B.R_FILE, B.R_FILE_COPY, B.R_EMAIL, B.R_NICK, B.R_WRITEDATE, B.R_STATE, B.R_REPLY, B.R_CLASS from (select ROWNUM AS rn, A.R_NO, A.R_SUBJECT, A.R_CONTENT, A.R_FILE, A.R_FILE_COPY, A.R_EMAIL, A.R_NICK, A.R_WRITEDATE, A.R_STATE, A.R_REPLY, A.R_CLASS from (select R_NO, R_SUBJECT, R_CONTENT, R_FILE, R_FILE_COPY, R_EMAIL, R_NICK, R_WRITEDATE, R_STATE, R_REPLY, R_CLASS from REPORT order by R_NO desc)A)B where (R_STATE=? or R_STATE=?) and (RN>=? AND RN<=?) order by R_NO desc";
	static final String sqlC = "select R_NO, R_SUBJECT, R_CONTENT, R_FILE, R_FILE_COPY, R_EMAIL, R_NICK, R_WRITEDATE, R_STATE, R_REPLY, R_CLASS from REPORT where R_NO=? order by R_NO desc";
	static final String sqlI = "insert into REPORT(R_NO, R_SUBJECT, R_CONTENT, R_FILE, R_FILE_COPY, R_NICK, R_WRITEDATE, R_STATE, R_REPLY, R_CLASS) values(REPORT_R_NO.nextval, ?, ?, ?, ?, ?, SYSDATE, '贸府吝', ?, ?)";
	static final String sqlD = "delete from Report where R_NO=?";
	static final String sql_TOTAL = "select count(*) from REPORT where R_NICK=? and R_STATE=?";
	static final String sql_TOTALAll = "select count(*) from REPORT where R_STATE=? or R_STATE=?";
	static final String sqlU = "update REPORT set R_STATE='贸府肯丰', R_REPLY=? where R_NO=?";
	static final String SQL_SRAll = "select R_NO, R_SUBJECT, R_CONTENT, R_FILE, R_FILE_COPY, R_EMAIL, R_NICK, R_WRITEDATE, R_STATE, R_REPLY, R_CLASS from REPORT where R_STATE=? order by R_NO desc";
	static final String SQL_SR = "select R_NO, R_SUBJECT, R_CONTENT, R_FILE, R_FILE_COPY, R_EMAIL, R_NICK, R_WRITEDATE, R_STATE, R_REPLY, R_CLASS from REPORT where R_NICK=? and R_STATE=? order by R_NO desc";
}

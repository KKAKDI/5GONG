package tkl.report.model;

public class ReportSQL {
	//static final String sqlS = "select R_NO, R_SUBJECT, R_CONTENT, R_FILE, R_FILE_COPY, R_EMAIL, R_NICK, R_WRITEDATE, R_STATE from REPORT where (R_STATE=? or R_STATE=?) and (ROWNUM>=? AND ROWNUM<=?) order by R_NO desc";
	static final String sqlS = "select B.R_NO, B.R_SUBJECT, B.R_CONTENT, B.R_FILE, B.R_FILE_COPY, B.R_EMAIL, B.R_NICK, B.R_WRITEDATE, B.R_STATE, B.R_REPLY from (select ROWNUM AS rn, A.R_NO, A.R_SUBJECT, A.R_CONTENT, A.R_FILE, A.R_FILE_COPY, A.R_EMAIL, A.R_NICK, A.R_WRITEDATE, A.R_STATE, A.R_REPLY from (select R_NO, R_SUBJECT, R_CONTENT, R_FILE, R_FILE_COPY, R_EMAIL, R_NICK, R_WRITEDATE, R_STATE, R_REPLY from REPORT order by R_NO desc)A)B where (R_STATE=? or R_STATE=?) and (RN>=? AND RN<=?) order by R_NO desc";
	static final String sqlC = "select R_NO, R_SUBJECT, R_CONTENT, R_FILE, R_FILE_COPY, R_EMAIL, R_NICK, R_WRITEDATE, R_STATE, R_REPLY from REPORT where R_NO=? order by R_NO desc";
	static final String sqlI = "insert into REPORT(R_NO, R_SUBJECT, R_CONTENT, R_FILE, R_FILE_COPY, R_NICK, R_WRITEDATE, R_STATE, R_REPLY) values(REPORT_R_NO.nextval, ?, ?, ?, ?, ?, SYSDATE, 0, ?)";
	static final String sqlD = "delete from Report where R_NO=?";
	static final String sql_TOTAL = "select count(*) from REPORT where R_STATE=? or R_STATE=?";
	static final String sqlU = "update REPORT set R_STATE=1, R_REPLY=? where R_NO=?";
	static final String SQL_SR = "select R_NO, R_SUBJECT, R_CONTENT, R_FILE, R_FILE_COPY, R_EMAIL, R_NICK, R_WRITEDATE, R_STATE, R_REPLY from REPORT where R_STATE=? or R_STATE=?";
	
	
	static final String sqlRS = "Select max(sunbun) from BOARD2 where refer = ? and lev+1 = ?";
	static final String sqlRU = "UPDATE BOARD2 set sunbun = sunbun +1 where refer = ? and lev > ?";
	static final String sqlRI = "insert into BOARD2(idx ,subject, content, writer, email, homepage, pwd, writedate, filename, ofilename, refer, lev, sunbun) values(BOARD2_IDX.nextval, ?, ?, ?, ?, ?, ?, SYSDATE, ?, ?, REPLY_IDX_REPLY, 0, 0)";
}

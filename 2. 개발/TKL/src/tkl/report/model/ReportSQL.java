package tkl.report.model;

public class ReportSQL {
	static final String sqlS = "select R_NO, R_SUBJECT, R_CONTENT, R_FILE, R_FILE_COPY, R_EMAIL, R_NICK, R_WRITEDATE, R_STATE from REPORT order by R_NO";
	static final String sqlC = "select R_NO, R_SUBJECT, R_CONTENT, R_FILE, R_FILE_COPY, R_EMAIL, R_NICK, R_WRITEDATE, R_STATE from REPORT where R_NO=? order by R_NO desc";
	static final String sqlI = "insert into REPORT(R_NO, R_SUBJECT, R_CONTENT, R_FILE, R_FILE_COPY, R_NICK, R_WRITEDATE, R_STATE) values(REPORT_R_NO.nextval, ?, ?, ?, ?, ?, SYSDATE, 0)";
	static final String sqlD = "delete from Report where R_NO=?";
	static final String sqlU = "update BOARD2 set WRITER=?, EMAIL=?, SUBJECT=?, CONTENT=? where IDX=?";
	
	static final String sqlRS = "Select max(sunbun) from BOARD2 where refer = ? and lev+1 = ?";
	static final String sqlRU = "UPDATE BOARD2 set sunbun = sunbun +1 where refer = ? and lev > ?";
	static final String sqlRI = "insert into BOARD2(idx ,subject, content, writer, email, homepage, pwd, writedate, filename, ofilename, refer, lev, sunbun) values(BOARD2_IDX.nextval, ?, ?, ?, ?, ?, ?, SYSDATE, ?, ?, REPLY_IDX_REPLY, 0, 0)";
}

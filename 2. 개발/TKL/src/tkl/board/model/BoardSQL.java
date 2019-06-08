package tkl.board.model;

public class BoardSQL {
	static final String sqlS = "select B_NO, M_EMAIL, M_NICK, B_SUBJECT, B_CONTENT, B_IMG, B_IMG_COPY, B_VIEW, B_LIKE, B_WRITEDATE, CNT from BOARD order by B_NO desc";
	static final String sqlA= "select count(*) from BOARD ";
	static final String sqlACNT = "select count(*) from B_REPLY where B_NO = ?";
	static final String sqlUCNT = "update BOARD set CNT = ? where B_NO =?";
	static final String sqlI= "insert into BOARD(B_NO, M_EMAIL, M_NICK, B_SUBJECT, B_CONTENT, B_IMG, B_IMG_COPY, B_VIEW, B_LIKE, B_WRITEDATE,CNT) values(BOARD_B_NO.nextval, ?,?,?,?,?,?,0,0,SYSDATE,0)";
	static final String sqlC= "select M_NICK, B_SUBJECT, B_CONTENT, B_IMG, B_IMG_COPY,  B_VIEW, B_LIKE, B_WRITEDATE from BOARD where B_NO = ?";
	static final String sqlD= "delete from BOARD where B_NO = ?";
	static final String sqlU= "update BOARD set B_SUBJECT = ?, B_CONTENT= ?, B_IMG =?, B_IMG_COPY= ? where B_NO = ?";
	static final String sqlV= "update BOARD set B_VIEW = B_VIEW+1 where B_NO = ?";
	static final String sqlL= "update BOARD set B_LIKE = B_LIKE+1 where B_NO = ?";
	static final String sqlSN = "select * from BOARD where M_NICK LIKE '%' || ? || '%' order by B_NO desc";
	static final String sqlSS = "select * from BOARD where B_SUBJECT LIKE '%' || ? || '%' order by B_NO desc";
	static final String sqlSC = "select * from BOARD where B_CONTENT LIKE '%' || ? || '%' order by B_NO desc";
}
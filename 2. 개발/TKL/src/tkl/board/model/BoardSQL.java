package tkl.board.model;

public class BoardSQL {
	static final String sqlS = "select * from BOARD order by B_NO desc";
	static final String sqlA= "select count(*) from BOARD ";
	static final String sqlI= "insert into BOARD values(BOARD_B_NO.nextval, null,?,?,?,?,?,0,0,SYSDATE)";
	static final String sqlC= "select M_NICK, B_SUBJECT, B_CONTENT, B_IMG, B_IMG_COPY,  B_VIEW, B_LIKE from BOARD where B_NO = ?";
	static final String sqlD= "delete from BOARD where B_NO = ?";
	static final String sqlU= "update BOARD set B_SUBJECT = ?, B_CONTENT= ?, B_IMG =?, B_IMG_COPY= ? where B_NO = ?";
	static final String sqlV= "update BOARD set B_VIEW = B_VIEW+1 where B_NO = ?";
}
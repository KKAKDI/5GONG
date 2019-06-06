package tkl.bReply.model;

public class ReplySQL {
	static final String sqlS = "select * from BOARD order by B_NO desc";
	static final String sqlA= "select count(*) from BOARD ";
	static final String sqlI= "insert into BOARD values(BOARD_B_NO.nextval, null,?,?,?,?,?,0,0,SYSDATE)";
	static final String sqlC= "select M_NICK, B_SUBJECT, B_CONTENT, B_IMG, B_IMG_COPY,  B_VIEW, B_LIKE from BOARD where B_NO = ?";
	static final String sqlD= "delete from BOARD where B_NO = ?";
	static final String sqlU= "update BOARD set B_SUBJECT = ?, B_CONTENT= ?, B_IMG =?, B_IMG_COPY= ? where B_NO = ?";
	static final String sqlRS= "select BR_NO, B_NO, M_NICK, BR_CONTENT, BR_WRITEDATE, BR_LIKE, BR_DISLIKE from B_REPLY where B_NO = ?";
}
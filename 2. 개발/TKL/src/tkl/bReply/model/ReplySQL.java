package tkl.bReply.model;

public class ReplySQL {
	static String sqlI = "insert into B_REPLY(BR_NO, B_NO, M_EMAIL, M_NICK, BR_CONTENT, BR_WRITEDATE, BR_LIKE, BR_DISLIKE) values(B_REPLY_BR_NO.NEXTVAL, ?, 'ccc@daum.net', '´Ð³×ÀÓ3', ?, SYSDATE, 0, 0)";
	static String sqlS = "select BR_NO, B_NO, M_NICK, BR_CONTENT, BR_WRITEDATE, BR_LIKE, BR_DISLIKE from B_REPLY where B_NO = ? order by BR_NO desc";
	static String sqlD = "delete from B_REPLY where BR_NO = ?";
	static String sqlA = "select count(*) from B_REPLY where B_NO = ?";
}
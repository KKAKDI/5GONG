package tkl.board.model;

public class BoardSQL {
	static final String sqlS = "select * from BOARD order by B_NO desc";
	static final String sqlA= "select count(*) from BOARD ";
	static final String sqlI= "insert into BOARD values(BOARD_B_NO.nextval, null,?,?,?,?,?,0,0,SYSDATE)";
}
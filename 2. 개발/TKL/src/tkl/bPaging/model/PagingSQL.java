package tkl.bPaging.model;

public class PagingSQL {
	static final String sqlA= "select count(*) from BOARD ";
	static final String sqlSN = "select count(*) from BOARD where M_NICK LIKE '%' || ? || '%'";
	static final String sqlSS = "select count(*) from BOARD where B_SUBJECT LIKE '%' || ? || '%'";
	static final String sqlSC = "select count(*) from BOARD where B_CONTENT LIKE '%' || ? || '%'";
}
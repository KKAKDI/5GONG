package tkl.news.model;


public class NewsSQL {
	static final String sqlS = "select n_no, n_nick, n_subject, n_content, n_view, n_writedate, n_division from NEWS order by N_NO desc";
	static final String sqlI = "insert into NEWS(n_no, n_email,n_nick, n_subject, n_content, n_view, n_writedate,n_division) "
										+ "values(NEWS_n_no.nextval,?,?,?,?,0,SYSDATE,?)";
	static final String sqlC = "select n_no, n_email, n_nick, n_subject, n_division, n_content from NEWS where n_no=?";
	static final String sqlD = "delete from NEWS where n_no=?";
	static final String sqlUV = "select n_no, n_nick,n_email, n_subject, n_content , n_division from NEWS where n_no=?";
	static final String sqlU = "update NEWS set n_subject=?, n_content=? where n_no=?";
	static final String sqlView = "update News set n_view = n_view+1 where n_no = ?";
	static final String sqlnotice = "select n_no, n_nick, n_subject, n_content, n_view, n_writedate, n_division from NEWS "
												+ "where n_division='공지사항' ORDER BY n_no DESC";
	static final String sqlevent = "select n_no, n_nick, n_subject, n_content, n_view, n_writedate, n_division from NEWS "
												+ "where n_division='이벤트' order by n_no desc";
	static final String sqlPaging = "select COUNT(*) from NEWS";
}

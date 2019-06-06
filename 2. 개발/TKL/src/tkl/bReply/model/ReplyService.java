package tkl.bReply.model;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;

public class ReplyService {
	private ReplyDAO dao;
	private static ReplyService instance = new ReplyService();
	private ReplyService() {
		dao = new ReplyDAO();
	}
	public static ReplyService getInstance() {
		return instance;
	}
	public void replyInS(int bNo, String bContent) {
		dao.replyIn(bNo, bContent);
	}
}

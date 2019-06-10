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
	public void replyInS(int bNo, String brContent, String mEmail, String mNick) {
		dao.replyIn(bNo, brContent, mEmail, mNick);
	}
	public ArrayList<ReplyDTO> replyListS(int bNo) {
		return dao.replyList(bNo);
	}
	public void replyDeleteS(int brNo) {
		dao.replyDelete(brNo);
	}
	public ArrayList<String> replyLikeListS(int bNo) {
		return dao.replyLikeList(bNo);
	}
	public ReplyDTO replyNickS(int brNo) {
		return  dao.replyNick(brNo);
	}
	public void replyLikeInS(int bNo, String email, String nick) {
		dao.replyLikeIn(bNo, email, nick);
	}
}

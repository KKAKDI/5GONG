package tkl.preply.model;

import java.util.*;

public class PreplyService {
	private PreplyDAO dao;
	private static PreplyService instance = new PreplyService();
	private PreplyService() {
		dao = new PreplyDAO();
	}
	public static PreplyService getInstance() {
		return instance;
	}
	public ArrayList<PreplyDTO> selectS(int pd_no){
		return dao.select(pd_no);
	}
	public void regS(PreplyDTO dto) {
		dao.reply_reg(dto);
	}
	public void deleteS(int pr_no) {
		dao.reply_delete(pr_no);
	}
}

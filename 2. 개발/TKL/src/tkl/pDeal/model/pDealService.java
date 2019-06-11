package tkl.pDeal.model;

import java.util.*;

import tkl.board.model.BoardService;

public class pDealService {
	private pDealDAO dao;
	private static pDealService instance = new pDealService();
	private pDealService() {
		dao = new pDealDAO();
	}
	public static pDealService getInstance() {
		return instance;
	}

	public pDealDTO pDeal_listS(String m_email,int pdNo, int pay_pm_no){
		return dao.pDeal_list(m_email, pdNo, pay_pm_no);
	}
	
}

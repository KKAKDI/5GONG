package tkl.report.model;

import java.util.*;

public class ReportService {
	private ReportDAO dao;
	private static ReportService instance = new ReportService();
	public ReportService() {
		dao = new ReportDAO();
	}
	public static ReportService getInstance() {
		return instance;
	}
	public ArrayList<ReportDTO> selectS(String sessionNick, String sessionGrant, String searchKey, int begin, int end){
		return dao.select(sessionNick, sessionGrant, searchKey, begin, end);
	}
	public void insertS(ReportDTO dto) {
		dao.insert(dto);
	}
	public void deleteS(int rNO) {
		dao.delete(rNO);
	}
	public ReportDTO contentS(int rNO) {
		return dao.content(rNO);
	}
	public int getTotalS(String sessionNick, int i, int k) {
		return dao.getTotal(sessionNick, i, k);
	}
	public void updateS(ReportDTO dto) {
		System.out.println("³Ñ¾Æ?");
		dao.update(dto);
	}
}

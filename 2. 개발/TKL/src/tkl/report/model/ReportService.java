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
	public ArrayList<ReportDTO> selectS(String searchKey, int i, int k, int begin, int end){
		return dao.select(searchKey, i, k, begin, end);
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
	public int getTotalS(int i, int k) {
		return dao.getTotal(i, k);
	}
	public void updateS(ReportDTO dto) {
		System.out.println("³Ñ¾Æ?");
		dao.update(dto);
	}
}

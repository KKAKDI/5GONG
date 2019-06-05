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
	public ArrayList<ReportDTO> selectS(int i, int k){
		return dao.select(i, k);
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
}

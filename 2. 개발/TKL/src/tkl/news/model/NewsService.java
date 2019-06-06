package tkl.news.model;

import java.util.*;

public class NewsService {
	private NewsDAO dao;
	private static NewsService instance = new NewsService();
	private NewsService() {
		dao = new NewsDAO();
	}
	public static NewsService getInstance() {
		return instance;
	}
	public ArrayList<NewsDTO> selectS(){
		return dao.select();
	}
	public void inserts(NewsDTO dto) {
		dao.insert(dto);
	}
	public NewsDTO contentS(int n_no) {
		return dao.content(n_no);
	}
	public void deleteD(int n_no) {
		dao.delete(n_no);
	}
	public NewsDTO viewU(NewsDTO dto) {
		return dao.view(dto);
	}
	public void updateU(NewsDTO dto) {
		dao.update(dto);
	}
}

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
	public NewsDTO updateviewU(NewsDTO dto) {
		return dao.updateview(dto);
	}
	public void updateU(NewsDTO dto) {
		dao.update(dto);
	}
	public void viewU(int n_no) {
	      dao.view(n_no);
	   }
	public ArrayList<NewsDTO> selectnoticeS() {
		return dao.selectnotice();
	}
	public ArrayList<NewsDTO> selecteventS() {
		return dao.selectevent();
	}
	public int PagingRowNumS() {
		return dao.PagingRowNum();
	}

	
}

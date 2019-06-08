package tkl.bPaging.model;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;

public class PagingService {
	private PagingDAO dao;
	private static PagingService instance = new PagingService();
	private PagingService() {
		dao = new PagingDAO();
	}
	public static PagingService getInstance() {
		return instance;
	}
	public PagingDTO PagingS(PagingDTO rDto) {
		return dao.Paging(rDto);
	}
	public int PagingRowNumS(int i, String sv) {
		return dao.PagingRowNum(i, sv);
	}
}

package tkl.json.model;

public class JsonService {

	private JsonDAO dao;
	private static JsonService instance = new JsonService();
	
	private JsonService() {
		dao = new JsonDAO();
	}	
	public static JsonService getInstance() {
		return instance;
	}
	public String jsonList() {
		return dao.list();
	}
}

package tkl.product.model;

import java.util.*;

public class ProductService {
	private ProductDAO dao;
	private static ProductService instance = new ProductService();
	private ProductService() {
		dao = new ProductDAO();
	}
	public static ProductService getInstance() {
		return instance;
	}
	public ArrayList<ProductDTO> selectS(){
		return dao.select();
	}
}

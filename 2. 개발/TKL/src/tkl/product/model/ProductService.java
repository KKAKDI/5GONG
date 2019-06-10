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
	public void reg(ProductDTO dto) {
		dao.reg(dto);
	}
	public ProductDTO contentS(int pd_no) {
		return dao.content(pd_no);
	}
	public void viewS(int pd_no) {
		dao.view(pd_no);
	}
	public void deleteS(int pd_no) {
		dao.delete(pd_no);
	}
	public void updateS(ProductDTO dto) {
		dao.update(dto);
	}
	public ArrayList<ProductDTO> select2(String pd_class){
		return dao.select2(pd_class);
	}
	public void buyCompleteS(ProductDTO dto) {
		dao.buyComplete(dto);
	}
	public int PagingRowNumS() {
		return dao.PagingRowNum();
	}
}

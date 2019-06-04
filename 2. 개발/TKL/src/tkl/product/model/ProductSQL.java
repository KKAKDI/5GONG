package tkl.product.model;

public class ProductSQL {
	static final String sqlList = "select pd_no, pd_nick, pd_status, pd_subject, pd_regdate from PRODUCT";
	
	static final String sqlContent = "select pd_no, pd_email, pd_nick, pd_status, pd_buyer, pd_name, pd_price, pd_subject, pd_content,"
			+ " pd_img, pd_img_copy, pd_regdate, pd_class, pd_view from PRODUCT where PD_NO=?";
}

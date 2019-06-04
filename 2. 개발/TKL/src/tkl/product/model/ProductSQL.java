package tkl.product.model;

import java.sql.Date;

class ProductSQL {
	static final String sqlList = "select pd_no, pd_nick, pd_status, pd_subject, pd_regdate from PRODUCT";
	static final String sqlReg = "insert into PRODUCT(pd_no, pd_nick, pd_status, pd_name, pd_class, pd_price, pd_subject, pd_content, pd_view, pd_img, pd_img_copy, pd_regdate) values(PRODUCT_PD_NO.nextval, ?, ?, ?, ?, ?, ?, ?, 0, ?, ?, SYSDATE)";
	//static final String sqlContent = "select pd_no, pd_email, pd_nick, pd_status, pd_buyer, pd_name, pd_price, pd_subject, pd_content,"
	//		+ " pd_img, pd_img_copy, pd_regdate, pd_class, pd_view from PRODUCT where PD_NO=?";
	static final String sqlContent = "select pd_no, pd_name, pd_class, pd_price, pd_view, pd_img_copy, pd_regdate from PRODUCT where PD_NO=?";
}

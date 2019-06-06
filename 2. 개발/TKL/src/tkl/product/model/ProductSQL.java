package tkl.product.model;

class ProductSQL {
	static final String sqlList = "select PD_NO, PD_NICK, PD_STATUS, PD_SUBJECT, PD_REGDATE from PRODUCT";
	static final String sqlReg = "insert into PRODUCT(PD_NO, PD_NICK, PD_STATUS, PD_NAME, PD_CLASS, PD_PRICE, PD_SUBJECT, PD_CONTENT, PD_VIEW, PD_IMG, PD_IMG_COPY, PD_REGDATE) values(PRODUCT_PD_NO.nextval, ?, ?, ?, ?, ?, ?, ?, 0, ?, ?, SYSDATE)";
	static final String sqlContent = "select PD_NO, PD_NAME, PD_CLASS, PD_PRICE, PD_VIEW, PD_IMG_COPY, PD_REGDATE from PRODUCT where PD_NO=?";
	static final String sqlDelete = "delete from PRODUCT where PD_NO=?";
	static final String sqlUpdate = "update PRODUCT set PD_NAME=?, PD_CLASS=?, PD_PRICE=?, PD_IMG_COPY=? where PD_NO=?";
}
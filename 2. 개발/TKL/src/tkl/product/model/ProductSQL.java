package tkl.product.model;

class ProductSQL {
	//static final String sqlList = "select PD_NO, PD_NICK, PD_STATUS, PD_SUBJECT, PD_REGDATE, PD_VIEW from PRODUCT order by PD_NO desc";
	static final String sqlList = "select PD_NO, PD_NICK, PD_STATUS, PD_CLASS, PD_SUBJECT, PD_REGDATE, PD_VIEW, (select COUNT(*) from P_REPLY R where R.PD_NO = P.PD_NO) AS CNT from PRODUCT P ORDER BY PD_NO DESC";
	static final String sqlReg = "insert into PRODUCT(PD_NO, PD_EMAIL, PD_NICK, PD_STATUS, PD_NAME, PD_CLASS, PD_PRICE, PD_SUBJECT, PD_CONTENT, PD_VIEW, PD_IMG, PD_IMG_COPY, PD_REGDATE) values(PRODUCT_PD_NO.nextval, ?, ?, ?, ?, ?, ?, ?, ?, 0, ?, ?, SYSDATE)";
	static final String sqlContent = "select PD_NO, PD_STATUS, PD_NAME, PD_CLASS, PD_PRICE, PD_VIEW, PD_IMG_COPY, PD_REGDATE from PRODUCT where PD_NO=?";
	static final String sqlDelete = "delete from PRODUCT where PD_NO=?";
	static final String sqlUpdate = "update PRODUCT set PD_NAME=?, PD_CLASS=?, PD_PRICE=?, PD_IMG_COPY=? where PD_NO=?";
	static final String sqlUpView = "update PRODUCT set PD_VIEW=PD_VIEW+1 where PD_NO=?";
	static final String sqlListSel = "select PD_NO, PD_NICK, PD_STATUS, PD_CLASS, PD_SUBJECT, PD_REGDATE, PD_VIEW, (select COUNT(*) from P_REPLY R where R.PD_NO = P.PD_NO) AS CNT from PRODUCT P where PD_CLASS='팝니다' ORDER BY PD_NO DESC";
	static final String sqlListBuy = "select PD_NO, PD_NICK, PD_STATUS, PD_CLASS, PD_SUBJECT, PD_REGDATE, PD_VIEW, (select COUNT(*) from P_REPLY R where R.PD_NO = P.PD_NO) AS CNT from PRODUCT P where PD_CLASS='삽니다' ORDER BY PD_NO DESC";
	static final String sqlBuyComplete = "update PRODUCT set PD_STATUS=? where PD_NO=?";
	static final String sqlPaging = "select COUNT(*) from PRODUCT";
}
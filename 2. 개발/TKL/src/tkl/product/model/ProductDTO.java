package tkl.product.model;

import java.sql.*;

public class ProductDTO {
	private int pd_no;
	private String pd_email;
	private String pd_nick;
	private String pd_status;
	private String pd_buyer;
	private String pd_name;
	private String pd_class;
	private int pd_price;
	private String pd_subject;
	private String pd_content;
	private int pd_view;
	private String pd_img;
	private String pd_img_copy;
	private Date pd_regdate;
	private int cnt;
	
	public ProductDTO(){}

	public ProductDTO(int pd_no, String pd_email, String pd_nick, String pd_status, String pd_buyer, String pd_name,
			String pd_class, int pd_price, String pd_subject, String pd_content, int pd_view, String pd_img,
			String pd_img_copy, Date pd_regdate, int cnt) {
		this.pd_no = pd_no;
		this.pd_email = pd_email;
		this.pd_nick = pd_nick;
		this.pd_status = pd_status;
		this.pd_buyer = pd_buyer;
		this.pd_name = pd_name;
		this.pd_class = pd_class;
		this.pd_price = pd_price;
		this.pd_subject = pd_subject;
		this.pd_content = pd_content;
		this.pd_view = pd_view;
		this.pd_img = pd_img;
		this.pd_img_copy = pd_img_copy;
		this.pd_regdate = pd_regdate;
		this.cnt = cnt;
	}

	public int getPd_no() {
		return pd_no;
	}

	public void setPd_no(int pd_no) {
		this.pd_no = pd_no;
	}

	public String getPd_email() {
		return pd_email;
	}

	public void setPd_email(String pd_email) {
		this.pd_email = pd_email;
	}

	public String getPd_nick() {
		return pd_nick;
	}

	public void setPd_nick(String pd_nick) {
		this.pd_nick = pd_nick;
	}

	public String getPd_status() {
		return pd_status;
	}

	public void setPd_status(String pd_status) {
		this.pd_status = pd_status;
	}

	public String getPd_buyer() {
		return pd_buyer;
	}

	public void setPd_buyer(String pd_buyer) {
		this.pd_buyer = pd_buyer;
	}

	public String getPd_name() {
		return pd_name;
	}

	public void setPd_name(String pd_name) {
		this.pd_name = pd_name;
	}

	public String getPd_class() {
		return pd_class;
	}

	public void setPd_class(String pd_class) {
		this.pd_class = pd_class;
	}

	public int getPd_price() {
		return pd_price;
	}

	public void setPd_price(int pd_price) {
		this.pd_price = pd_price;
	}

	public String getPd_subject() {
		return pd_subject;
	}

	public void setPd_subject(String pd_subject) {
		this.pd_subject = pd_subject;
	}

	public String getPd_content() {
		return pd_content;
	}

	public void setPd_content(String pd_content) {
		this.pd_content = pd_content;
	}

	public int getPd_view() {
		return pd_view;
	}

	public void setPd_view(int pd_view) {
		this.pd_view = pd_view;
	}

	public String getPd_img() {
		return pd_img;
	}

	public void setPd_img(String pd_img) {
		this.pd_img = pd_img;
	}

	public String getPd_img_copy() {
		return pd_img_copy;
	}

	public void setPd_img_copy(String pd_img_copy) {
		this.pd_img_copy = pd_img_copy;
	}

	public Date getPd_regdate() {
		return pd_regdate;
	}

	public void setPd_regdate(Date pd_regdate) {
		this.pd_regdate = pd_regdate;
	}
	
	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
}

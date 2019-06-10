package tkl.payment.model;

import java.sql.*;

public class PaymentDTO {
	private int pm_no;
	private int pd_no;
	private String pm_seller;
	private String pm_s_bank;
	private int pm_s_account;
	private String pm_buyer;
	private String pm_b_bank;
	private int pm_b_account;
	private int pm_s_amount;
	private int pm_b_amount;
	private Date pm_regdate;
	private String pm_addr;
	private String pm_bchek;
	private String pm_schek;
	
	public PaymentDTO() {}
	
	public PaymentDTO(int pm_no, int pd_no, String pm_seller, String pm_s_bank, int pm_s_account, String pm_buyer,
			String pm_b_bank, int pm_b_account, int pm_s_amount, int pm_b_amount, Date pm_regdate, String pm_addr,
			String pm_bchek, String pm_schek) {
		this.pm_no = pm_no;
		this.pd_no = pd_no;
		this.pm_seller = pm_seller;
		this.pm_s_bank = pm_s_bank;
		this.pm_s_account = pm_s_account;
		this.pm_buyer = pm_buyer;
		this.pm_b_bank = pm_b_bank;
		this.pm_b_account = pm_b_account;
		this.pm_s_amount = pm_s_amount;
		this.pm_b_amount = pm_b_amount;
		this.pm_regdate = pm_regdate;
		this.pm_addr = pm_addr;
		this.pm_bchek = pm_bchek;
		this.pm_schek = pm_schek;
	}
	public int getPm_no() {
		return pm_no;
	}
	public void setPm_no(int pm_no) {
		this.pm_no = pm_no;
	}
	public int getPd_no() {
		return pd_no;
	}
	public void setPd_no(int pd_no) {
		this.pd_no = pd_no;
	}
	public String getPm_seller() {
		return pm_seller;
	}
	public void setPm_seller(String pm_seller) {
		this.pm_seller = pm_seller;
	}
	public String getPm_s_bank() {
		return pm_s_bank;
	}
	public void setPm_s_bank(String pm_s_bank) {
		this.pm_s_bank = pm_s_bank;
	}
	public int getPm_s_account() {
		return pm_s_account;
	}
	public void setPm_s_account(int pm_s_account) {
		this.pm_s_account = pm_s_account;
	}
	public String getPm_buyer() {
		return pm_buyer;
	}
	public void setPm_buyer(String pm_buyer) {
		this.pm_buyer = pm_buyer;
	}
	public String getPm_b_bank() {
		return pm_b_bank;
	}
	public void setPm_b_bank(String pm_b_bank) {
		this.pm_b_bank = pm_b_bank;
	}
	public int getPm_b_account() {
		return pm_b_account;
	}
	public void setPm_b_account(int pm_b_account) {
		this.pm_b_account = pm_b_account;
	}
	public int getPm_s_amount() {
		return pm_s_amount;
	}
	public void setPm_s_amount(int pm_s_amount) {
		this.pm_s_amount = pm_s_amount;
	}
	public int getPm_b_amount() {
		return pm_b_amount;
	}
	public void setPm_b_amount(int pm_b_amount) {
		this.pm_b_amount = pm_b_amount;
	}
	public Date getPm_regdate() {
		return pm_regdate;
	}
	public void setPm_regdate(Date pm_regdate) {
		this.pm_regdate = pm_regdate;
	}
	public String getPm_addr() {
		return pm_addr;
	}
	public void setPm_addr(String pm_addr) {
		this.pm_addr = pm_addr;
	}
	public String getPm_bchek() {
		return pm_bchek;
	}
	public void setPm_bchek(String pm_bchek) {
		this.pm_bchek = pm_bchek;
	}
	public String getPm_schek() {
		return pm_schek;
	}
	public void setPm_schek(String pm_schek) {
		this.pm_schek = pm_schek;
	}
}

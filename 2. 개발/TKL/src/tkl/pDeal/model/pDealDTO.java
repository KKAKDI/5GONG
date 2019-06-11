package tkl.pDeal.model;

import java.sql.Date;

public class pDealDTO {
	////////////////////////////// 회원 테이블
	private String m_email; // 회원 이메일
	private String m_nick; // 회원 닉네임
	private String m_name; // 회원 이름
	private String m_bank; // 회원 주거래은행
	private int n_phone; // 회원 핸드폰번호
	private long m_account; // 회원 보유금액
	private int m_amount; // 회원 보유금액
	private int m_trust; // 회원 신뢰도
	private Date m_regdate; // 회원 등록 날짜
	////////////////////////////// 여기서부터는 상품테이블
	private int pd_no; // 상품 거래 번호
	private String pd_email; // 상품 이메일
	private String pd_nick; // 상품 닉네임
	private String pd_status; // 상품 진행상태
	private String pd_buyer; // 상품 구매자
	private String pd_name; // 상품 상품명
	private String pd_class; // 상품 유형
	private int pd_price; // 상품 가격
	private Date pd_regdate; // 상품 등록날짜
	////////////////////////////// 여기서부터는 결제 테이블
	private int pay_pm_no; // 결제번호
	private int pay_pd_no; // 거래번호
	private String pm_seller; // 판매자
	private String pm_s_bank; // 판매자 은행
	private long pm_s_account; // 판매자 계좌
	private String pm_buyer; // 구매자
	private String pm_b_bank; // 구매자 은행
	private long pm_b_account; // 구매자 계좌
	private int pm_s_amount; // 판매 금액
	private Date pm_regdate; // 결제 등록 날짜
	private String pm_addr; // 배송 주소
	private String pm_schek; // 판매 확인

	public pDealDTO() {
	}

	public pDealDTO(String m_email, String m_nick, String m_name, String m_bank, int n_phone, long m_account,
			int m_amount, int m_trust, Date m_regdate, int pd_no, String pd_email, String pd_nick, String pd_status,
			String pd_buyer, String pd_name, String pd_class, int pd_price, Date pd_regdate, int pay_pm_no,
			int pay_pd_no, String pm_seller, String pm_s_bank, long pm_s_account, String pm_buyer, String pm_b_bank,
			long pm_b_account, int pm_s_amount, Date pm_regdate, String pm_addr, String pm_schek) {
		super();
		this.m_email = m_email;
		this.m_nick = m_nick;
		this.m_name = m_name;
		this.m_bank = m_bank;
		this.n_phone = n_phone;
		this.m_account = m_account;
		this.m_amount = m_amount;
		this.m_trust = m_trust;
		this.m_regdate = m_regdate;
		this.pd_no = pd_no;
		this.pd_email = pd_email;
		this.pd_nick = pd_nick;
		this.pd_status = pd_status;
		this.pd_buyer = pd_buyer;
		this.pd_name = pd_name;
		this.pd_class = pd_class;
		this.pd_price = pd_price;
		this.pd_regdate = pd_regdate;
		this.pay_pm_no = pay_pm_no;
		this.pay_pd_no = pay_pd_no;
		this.pm_seller = pm_seller;
		this.pm_s_bank = pm_s_bank;
		this.pm_s_account = pm_s_account;
		this.pm_buyer = pm_buyer;
		this.pm_b_bank = pm_b_bank;
		this.pm_b_account = pm_b_account;
		this.pm_s_amount = pm_s_amount;
		this.pm_regdate = pm_regdate;
		this.pm_addr = pm_addr;
		this.pm_schek = pm_schek;
	}

	public String getM_email() {
		return m_email;
	}

	public void setM_email(String m_email) {
		this.m_email = m_email;
	}

	public String getM_nick() {
		return m_nick;
	}

	public void setM_nick(String m_nick) {
		this.m_nick = m_nick;
	}

	public String getM_name() {
		return m_name;
	}

	public void setM_name(String m_name) {
		this.m_name = m_name;
	}

	public String getM_bank() {
		return m_bank;
	}

	public void setM_bank(String m_bank) {
		this.m_bank = m_bank;
	}

	public int getN_phone() {
		return n_phone;
	}

	public void setN_phone(int n_phone) {
		this.n_phone = n_phone;
	}

	public long getM_account() {
		return m_account;
	}

	public void setM_account(long m_account) {
		this.m_account = m_account;
	}

	public int getM_amount() {
		return m_amount;
	}

	public void setM_amount(int m_amount) {
		this.m_amount = m_amount;
	}

	public int getM_trust() {
		return m_trust;
	}

	public void setM_trust(int m_trust) {
		this.m_trust = m_trust;
	}

	public Date getM_regdate() {
		return m_regdate;
	}

	public void setM_regdate(Date m_regdate) {
		this.m_regdate = m_regdate;
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

	public Date getPd_regdate() {
		return pd_regdate;
	}

	public void setPd_regdate(Date pd_regdate) {
		this.pd_regdate = pd_regdate;
	}

	public int getPay_pm_no() {
		return pay_pm_no;
	}

	public void setPay_pm_no(int pay_pm_no) {
		this.pay_pm_no = pay_pm_no;
	}

	public int getPay_pd_no() {
		return pay_pd_no;
	}

	public void setPay_pd_no(int pay_pd_no) {
		this.pay_pd_no = pay_pd_no;
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

	public long getPm_s_account() {
		return pm_s_account;
	}

	public void setPm_s_account(long pm_s_account) {
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

	public long getPm_b_account() {
		return pm_b_account;
	}

	public void setPm_b_account(long pm_b_account) {
		this.pm_b_account = pm_b_account;
	}

	public int getPm_s_amount() {
		return pm_s_amount;
	}

	public void setPm_s_amount(int pm_s_amount) {
		this.pm_s_amount = pm_s_amount;
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

	public String getPm_schek() {
		return pm_schek;
	}

	public void setPm_schek(String pm_schek) {
		this.pm_schek = pm_schek;
	}

	

}
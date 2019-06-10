package tkl.member.model;

import java.sql.Date;

public class MamberDTO {
	private String email;
	private String nick;
	private String grant;
	private String pwd;
	private String name;
	private String bank;
	private int actNum;
	private int phone;
	private int amount;
	private int trust;
	private Date regdate;
	
	public MamberDTO(){}
	
	public MamberDTO(String email, String nick, String grant,String pwd, String name, String bank, int actNum, int phone,
			int amount, int trust, Date regdate) {
		super();
		this.email = email;
		this.nick = nick;
		this.grant = grant;
		this.pwd = pwd;
		this.name = name;
		this.bank = bank;
		this.actNum = actNum;
		this.phone = phone;
		this.amount = amount;
		this.trust = trust;
		this.regdate = regdate;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}	
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public String getGrant() {
		return grant;
	}
	public void setGrant(String grant) {
		this.grant = grant;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBank() {
		return bank;
	}
	public void setBank(String bank) {
		this.bank = bank;
	}
	public int getActNum() {
		return actNum;
	}
	public void setActNum(int actNum) {
		this.actNum = actNum;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getTrust() {
		return trust;
	}
	public void setTrust(int trust) {
		this.trust = trust;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
}

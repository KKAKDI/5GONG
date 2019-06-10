package tkl.transfer.model;

import java.sql.Date;

public class TransferDTO {
	private int pmNo;
	private int pdNo;
	private String seller;
	private String sBank;
	private	int sAccount;
	private String buyer;
	private String bBank;
	private int bAccount;
	private int sAmount;
	private int bAmount;;
	private Date regDate;
	private String bAddr;
	private String bcheck;
	private String scheck;
	
	public TransferDTO() {}
	
	public TransferDTO(int pmNo, int pdNo, String seller, String sBank, int sAccount, String buyer, String bBank,
			int bAccount, int sAmount, int bAmount, Date regDate, String bAddr, String bcheck, String scheck) {
		super();
		this.pmNo = pmNo;
		this.pdNo = pdNo;
		this.seller = seller;
		this.sBank = sBank;
		this.sAccount = sAccount;
		this.buyer = buyer;
		this.bBank = bBank;
		this.bAccount = bAccount;
		this.sAmount = sAmount;
		this.bAmount = bAmount;
		this.regDate = regDate;
		this.bAddr = bAddr;
		this.bcheck = bcheck;
		this.scheck = scheck;
	}
	
	public int getPmNo() {
		return pmNo;
	}
	public void setPmNo(int pmNo) {
		this.pmNo = pmNo;
	}
	public int getPdNo() {
		return pdNo;
	}
	public void setPdNo(int pdNo) {
		this.pdNo = pdNo;
	}
	public String getSeller() {
		return seller;
	}
	public void setSeller(String seller) {
		this.seller = seller;
	}
	public String getsBank() {
		return sBank;
	}
	public void setsBank(String sBank) {
		this.sBank = sBank;
	}
	public int getsAccount() {
		return sAccount;
	}
	public void setsAccount(int sAccount) {
		this.sAccount = sAccount;
	}
	public String getBuyer() {
		return buyer;
	}
	public void setBuyer(String buyer) {
		this.buyer = buyer;
	}
	public String getbBank() {
		return bBank;
	}
	public void setbBank(String bBank) {
		this.bBank = bBank;
	}
	public int getbAccount() {
		return bAccount;
	}
	public void setbAccount(int bAccount) {
		this.bAccount = bAccount;
	}
	public int getsAmount() {
		return sAmount;
	}
	public void setsAmount(int sAmount) {
		this.sAmount = sAmount;
	}
	public int getbAmount() {
		return bAmount;
	}
	public void setbAmount(int bAmount) {
		this.bAmount = bAmount;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public String getbAddr() {
		return bAddr;
	}
	public void setbAddr(String bAddr) {
		this.bAddr = bAddr;
	}
	public String getBcheck() {
		return bcheck;
	}
	public void setBcheck(String bcheck) {
		this.bcheck = bcheck;
	}
	public String getScheck() {
		return scheck;
	}
	public void setScheck(String scheck) {
		this.scheck = scheck;
	}
	
	
}

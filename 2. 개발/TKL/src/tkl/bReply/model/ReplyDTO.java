package tkl.bReply.model;

import java.sql.Date;

public class ReplyDTO {
	private int brNo;
	private int bNo;
	private String mEmail;
	private String mNick;
	private String brContent;
	private Date brWriteDate;
	private String brImg;
	private String brImgCopy;  
	private int brLike;
	private int brDisLike;
	public ReplyDTO(int brNo, int bNo, String mEmail, String mNick, String brContent, Date brWriteDate, String brImg,
			String brImgCopy, int brLike, int brDisLike) {
		super();
		this.brNo = brNo;
		this.bNo = bNo;
		this.mEmail = mEmail;
		this.mNick = mNick;
		this.brContent = brContent;
		this.brWriteDate = brWriteDate;
		this.brImg = brImg;
		this.brImgCopy = brImgCopy;
		this.brLike = brLike;
		this.brDisLike = brDisLike; 
	}
	public int getBrNo() {
		return brNo;
	}  
	public void setBrNo(int brNo) { 
		this.brNo = brNo;
	}
	public int getbNo() {
		return bNo;
	}
	public void setbNo(int bNo) {
		this.bNo = bNo;
	}   
	public String getmEmail() {
		return mEmail;
	}
	public void setmEmail(String mEmail) {
		this.mEmail = mEmail;       
	}
	public String getmNick() {
		return mNick;
	}
	public void setmNick(String mNick) {
		this.mNick = mNick;
	}
	public String getBrContent() {   
		return brContent;
	}
	public void setBrContent(String brContent) {
		this.brContent = brContent;
	}
	public Date getBrWriteDate() {
		return brWriteDate;
	}
	public void setBrWriteDate(Date brWriteDate) {
		this.brWriteDate = brWriteDate;
	}
	public String getBrImg() {
		return brImg;
	}
	public void setBrImg(String brImg) {
		this.brImg = brImg;
	}
	public String getBrImgCopy() {
		return brImgCopy;
	}
	public void setBrImgCopy(String brImgCopy) {
		this.brImgCopy = brImgCopy;
	}
	public int getBrLike() {
		return brLike;
	}
	public void setBrLike(int brLike) {
		this.brLike = brLike;
	}
	public int getBrDisLike() {
		return brDisLike;
	}
	public void setBrDisLike(int brDisLike) {
		this.brDisLike = brDisLike;
	}
	
}
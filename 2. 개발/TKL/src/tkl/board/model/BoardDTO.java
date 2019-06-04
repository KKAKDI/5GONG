package tkl.board.model;

import java.sql.*;

public class BoardDTO {
	private int bNo;
	private String mEmail;
	private String mNick;
	private String bSubject;
	private String bContent;
	private String bImg;
	private String bImgCopy;
	private int bView;
	private int bLike;
	private Date bWriteDate;
	public BoardDTO() {}
	public BoardDTO(int bNO, String mEmail, String mNick, String bSubject, String bContent, String bImg,
			String bImgCopy, int bView, int bLike, Date bWriteDate) {
		super();
		this.bNo = bNo;
		this.mEmail = mEmail;
		this.mNick = mNick;
		this.bSubject = bSubject;
		this.bContent = bContent;
		this.bImg = bImg;
		this.bImgCopy = bImgCopy;
		this.bView = bView;
		this.bLike = bLike;
		this.bWriteDate = bWriteDate;
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
	public String getbSubject() {
		return bSubject;
	}
	public void setbSubject(String bSubject) {
		this.bSubject = bSubject;
	}
	public String getbContent() {
		return bContent;
	}
	public void setbContent(String bContent) {
		this.bContent = bContent;
	}
	public String getbImg() {
		return bImg;
	}
	public void setbImg(String bImg) {
		this.bImg = bImg;
	}
	public String getbImgCopy() {
		return bImgCopy;
	}
	public void setbImgCopy(String bImgCopy) {
		this.bImgCopy = bImgCopy;
	}
	public int getbView() {
		return bView;
	}
	public void setbView(int bView) {
		this.bView = bView;
	}
	public int getbLike() {
		return bLike;
	}
	public void setbLike(int bLike) {
		this.bLike = bLike;
	}
	public Date getbWriteDate() {
		return bWriteDate;
	}
	public void setbWriteDate(Date bWriteDate) {
		this.bWriteDate = bWriteDate;
	}
	
	
	
}

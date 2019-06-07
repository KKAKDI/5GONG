package tkl.preply.model;

import java.sql.*;

public class PreplyDTO {
	private int pr_no;
	private int pd_no;
	private String m_email;
	private String m_nick;
	private String pr_comment;
	private String pr_img;
	private String pr_img_copy;
	private Date pr_writedate;
	
	public PreplyDTO() {}

	public PreplyDTO(int pr_no, int pd_no, String m_email, String m_nick, String pr_comment, String pr_img,
			String pr_img_copy, Date pr_writedate) {
		super();
		this.pr_no = pr_no;
		this.pd_no = pd_no;
		this.m_email = m_email;
		this.m_nick = m_nick;
		this.pr_comment = pr_comment;
		this.pr_img = pr_img;
		this.pr_img_copy = pr_img_copy;
		this.pr_writedate = pr_writedate;
	}

	public int getPr_no() {
		return pr_no;
	}

	public void setPr_no(int pr_no) {
		this.pr_no = pr_no;
	}

	public int getPd_no() {
		return pd_no;
	}

	public void setPd_no(int pd_no) {
		this.pd_no = pd_no;
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

	public String getPr_comment() {
		return pr_comment;
	}

	public void setPr_comment(String pr_comment) {
		this.pr_comment = pr_comment;
	}

	public String getPr_img() {
		return pr_img;
	}

	public void setPr_img(String pr_img) {
		this.pr_img = pr_img;
	}

	public String getPr_img_copy() {
		return pr_img_copy;
	}

	public void setPr_img_copy(String pr_img_copy) {
		this.pr_img_copy = pr_img_copy;
	}

	public Date getPr_writedate() {
		return pr_writedate;
	}

	public void setPr_writedate(Date pr_writedate) {
		this.pr_writedate = pr_writedate;
	}
}

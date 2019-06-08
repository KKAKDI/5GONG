package tkl.news.model;

import java.sql.Date;

public class NewsDTO {
	private int n_no;
	private String n_email;
	private String n_nick;
	private String n_subject;
	private String n_content;
	private int n_view;
	private Date n_writedate;
	private String n_division;
	
	
	public NewsDTO() {}

	public NewsDTO(int n_no, String n_email, String n_nick, String n_subject, String n_content, int n_view,
			Date n_writedate, String n_division) {
		super();
		this.n_no = n_no;
		this.n_email = n_email;
		this.n_nick = n_nick;
		this.n_subject = n_subject;
		this.n_content = n_content;
		this.n_view = n_view;
		this.n_writedate = n_writedate;
		this.n_division = n_division;
	}
	
	

	public int getN_no() {
		return n_no;
	}

	public void setN_no(int n_no) {
		this.n_no = n_no;
	}

	public String getN_email() {
		return n_email;
	}

	public void setN_email(String n_email) {
		this.n_email = n_email;
	}

	public String getN_nick() {
		return n_nick;
	}

	public void setN_nick(String n_nick) {
		this.n_nick = n_nick;
	}

	public String getN_subject() {
		return n_subject;
	}

	public void setN_subject(String n_subject) {
		this.n_subject = n_subject;
	}

	public String getN_content() {
		return n_content;
	}

	public void setN_content(String n_content) {
		this.n_content = n_content;
	}

	public int getN_view() {
		return n_view;
	}

	public void setN_view(int n_view) {
		this.n_view = n_view;
	}

	public Date getN_writedate() {
		return n_writedate;
	}

	public void setN_writedate(Date n_writedate) {
		this.n_writedate = n_writedate;
	}

	public String getN_division() {
		return n_division;
	}

	public void setN_division(String n_division) {
		this.n_division = n_division;
	}

	


}
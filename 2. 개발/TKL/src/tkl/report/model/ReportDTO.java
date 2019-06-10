package tkl.report.model;

import java.sql.Date;

public class ReportDTO {
	private int rNO;
	private String rSubject;
	private String rContent;
	private String rFile;
	private String rFileCopy;
	private String rEmail;
	private String rNick;
	private Date rWriteDate;
	private String rState;
	private String rReply;
	private String rClass;
	public ReportDTO(){}
	public ReportDTO(int rNO, String rSubject, String rContent, String rFile, String rFileCopy, String rEmail,
			String rNick, Date rWriteDate, String rState, String rReply, String rClass) {
		super();
		this.rNO = rNO;
		this.rSubject = rSubject;
		this.rContent = rContent;
		this.rFile = rFile;
		this.rFileCopy = rFileCopy;
		this.rEmail = rEmail;
		this.rNick = rNick;
		this.rWriteDate = rWriteDate;
		this.rState = rState;
		this.rReply = rReply;
		this.rClass = rClass;
	}
	public int getrNO() {
		return rNO;
	}
	public void setrNO(int rNO) {
		this.rNO = rNO;
	}
	public String getrSubject() {
		return rSubject;
	}
	public void setrSubject(String rSubject) {
		this.rSubject = rSubject;
	}
	public String getrContent() {
		return rContent;
	}
	public void setrContent(String rContent) {
		this.rContent = rContent;
	}
	public String getrFile() {
		return rFile;
	}
	public void setrFile(String rFile) {
		this.rFile = rFile;
	}
	public String getrFileCopy() {
		return rFileCopy;
	}
	public void setrFileCopy(String rFileCopy) {
		this.rFileCopy = rFileCopy;
	}
	public String getrEmail() {
		return rEmail;
	}
	public void setrEmail(String rEmail) {
		this.rEmail = rEmail;
	}
	public String getrNick() {
		return rNick;
	}
	public void setrNick(String rNick) {
		this.rNick = rNick;
	}
	public Date getrWriteDate() {
		return rWriteDate;
	}
	public void setrWriteDate(Date rWriteDate) {
		this.rWriteDate = rWriteDate;
	}
	public String getrState() {
		return rState;
	}
	public void setrState(String rState) {
		this.rState = rState;
	}
	public String getrReply() {
		return rReply;
	}
	public void setrReply(String rReply) {
		this.rReply = rReply;
	}
	public String getrClass() {
		return rClass;
	}
	public void setrClass(String rClass) {
		this.rClass = rClass;
	}
	
}
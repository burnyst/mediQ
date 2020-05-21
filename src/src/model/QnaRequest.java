package model;

import java.util.Date;
import java.util.Map;

public class QnaRequest {
//변수
	private User user;
	private int sn;
	private String title;
	private String category;
	private int qpublic;  //0은 공개 1은 비공개
	private int vcount;
	private String mid;
	private Date rdate;
	private String question;
	private String answer;
	private String image;
	private  int qstate; //0은 답변없음 1은 답변있음
	
	//anaupdatecontroller 연계
	public QnaRequest(User user,String title, String category, int qpublic,  String question, String image) {
		this.user =user;
		this.title =title;
		this.category = category;
		this.qpublic = qpublic;
		this.mid=user.getMid();
		this.question = question;
		this.image = image;
	}
	public QnaRequest(String title, String category, int qpublic,  String question, String image) {
		this.title =title;
		this.category = category;
		this.qpublic = qpublic;
		this.question = question;
		this.image = image;
	}
	
	public QnaRequest(int sn, String answer) {
		this.sn = sn;
		this.answer = answer;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getSn() {
		return sn;
	}
	public void setSn(int sn) {
		this.sn = sn;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getQpublic() {
		return qpublic;
	}
	public void setQpublic(int qpublic) {
		this.qpublic = qpublic;
	}
	public int getVcount() {
		return vcount;
	}
	public void setVcount(int vcount) {
		this.vcount = vcount;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public Date getRdate() {
		return rdate;
	}
	public void setRdate(Date rdate) {
		this.rdate = rdate;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public int getQstate() {
		return qstate;
	}
	public void setQstate(int qstate) {
		this.qstate = qstate;
	}
	
	//title이 null인지에대한 체크=>유효성검사
	public void validate(Map<String, Boolean> errors) {
		if( title==null || title.trim().isEmpty() ) {
			errors.put("title",Boolean.TRUE);
		}
	}
	@Override
	public String toString() {
		return "QnaRequest [user=" + user + ", sn=" + sn + ", title=" + title + ", category=" + category + ", qpublic="
				+ qpublic + ", vcount=" + vcount + ", mid=" + mid + ", rdate=" + rdate + ", question=" + question
				+ ", answer=" + answer + ", image=" + image + ", qstate=" + qstate + "]";
	}

}



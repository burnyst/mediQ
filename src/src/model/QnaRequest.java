package model;

import java.util.Date;
import java.util.Map;

public class QnaRequest {
//변수
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
	public QnaRequest(String title, String category, int qpublic,  String question, String image) {
		this.title =title;
		this.category = category;
		this.qpublic = qpublic;
		this.question = question;
		this.image = image;
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

/*	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	
public boolean isPasswordEqualToConfirm() {
	return password != null && password.equals(confirmPassword);
}*/
	
/*public void vaildate(Map<String, Boolean> errors) {
	checkEmpty(errors, id, "id");
	checkEmpty(errors, name,"name");
	checkEmpty(errors,password,"password");
	checkEmpty(errors,confirmPassword,"confirmPassword");
	if (!errors.containsKey("confirmPassword")) {
		if(!isPasswordEqualToConfirm()) {
			errors.put("notMatch", Boolean.TRUE);
		}
	}
}
private void checkEmpty(Map<String,Boolean> errors,
				String value, String fieldName) {
					if(value == null || value.isEmpty()) {
						errors.put(fieldName,Boolean.TRUE);
					}
				}*/
}



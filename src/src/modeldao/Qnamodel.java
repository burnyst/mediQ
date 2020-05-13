package cs.qna.modeldao;
import java.sql.Connection;
import java.util.Date;

public class Qnamodel {
	
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
	
public Qnamodel() {}
public Qnamodel(int  sn,String title,String category,int qpublic,int vcount,
		String mid,Date rdate,String question,String answer,String image,int qstate) {
	this.sn =sn;
	this.title =title;
	this.category = category;
	this.qpublic = qpublic;
	this.vcount =  vcount;
	this.mid = mid;
	this.rdate= rdate;
	this.question =question;
	 this.answer=answer;
	this.image=image;
	this.qstate=qstate;	
}
public Qnamodel(int sn,String title,String category,int qpublic,int vcount,
		String mid,Date rdate,String answer,int qstate,String image) {
	this.sn =sn;
	this.title =title;
	this.category = category;
	this.qpublic = qpublic;
	this.vcount =  vcount;
	this.mid = mid;
	this.rdate= rdate;
	 this.answer=answer;
	this.image=image;
	this.qstate=qstate;	
}
public Qnamodel(int sn,String title,String category,int qpublic,int vcount,
		String mid,Date rdate,String question,String image,int qstate) {
	this.sn =sn;
	this.title =title;
	this.category = category;
	this.qpublic = qpublic;
	this.vcount =  vcount;
	this.mid = mid;
	this.rdate= rdate;
	this.question=question;
	this.image=image;
	this.qstate=qstate;	
}

public Qnamodel(int sn,String title,String category,int qpublic,int vcount,
		String mid,Date rdate,int qstate) {
	this.sn =sn;
	this.title =title;
	this.category = category;
	this.qpublic = qpublic;
	this.vcount =  vcount;
	this.mid = mid;
	this.rdate= rdate;
	this.qstate=qstate;	
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

@Override
public String toString() {
	return "Qnamodel [sn=" + sn + ", title=" + title + ", category=" + category + ", qpublic=" + qpublic + ", vcount="
			+ vcount + ", mid=" + mid + ", rdate=" + rdate + ", question=" + question + ", answer=" + answer
			+ ", image=" + image + ", qstate=" + qstate + "]";
}
//id 일치여부 체크, 관리자 등급 체크 여부
public boolean matchId(String id) {
	return  this.mid.equals(id);
}

}

package controller;

import java.util.Date;
import java.util.Map;

import model.User;


//p637
//글입력에 필요한 데이터를 제공
/*
insert into article(writer_id,writer_name,title,regdate,moddate,read_cnt)
values(writer_id?,writer_name?,title?,regdate?,moddate?,0);

insert into article_content(article_no,content)
values(article_no?,content?);
 */
public class WriteRequest {
	
	/*
	private String id;  	//writer_id 컬럼용
	private String name; 	//writer_name 컬럼용
	위의 2속성에 해당하는 부분을
	Wrtier클래스 변수로 코드를 교재에서 작성하였다  p637 9*/
	private int sn;
	private	User user;
	private String mid;
	private String title;
	private String press;
	private String summary;
	private Date rdate;
	private	String nimage;		
	
	
	 WriteRequest(User user, String title, String press, String summary, String nimage) {
		
		this.user = user;
		this.title = title;
		this.press = press;
		this.summary = summary;
		this.nimage = nimage;
	}
	
	
	 public int getSn() {
		 return sn;
	 }
	 
	 
	 
	 public void setSn(int sn) {
		 this.sn = sn;
	 }


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public String getMid() {
		return mid;
	}


	public void setMid(String mid) {
		this.mid = mid;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getPress() {
		return press;
	}


	public void setPress(String press) {
		this.press = press;
	}


	public String getSummary() {
		return summary;
	}


	public void setSummary(String summary) {
		this.summary = summary;
	}


	public Date getRdate() {
		return rdate;
	}


	public void setRdate(Date rdate) {
		this.rdate = rdate;
	}


	public String getNimage() {
		return nimage;
	}


	public void setNimage(String nimage) {
		this.nimage = nimage;
	}

	

	






	@Override
	public String toString() {
		return "WriteRequest [sn=" + sn + ", user=" + user + ", mid=" + mid + ", title=" + title + ", press=" + press
				+ ", summary=" + summary + ", rdate=" + rdate + ", nimage=" + nimage + "]";
	}


	//p638 31
	//title이 null인지에대한 체크=>유효성검사
	public void validate(Map<String, Boolean> errors) {
		if( title==null || title.trim().isEmpty() ) {
			errors.put("title",Boolean.TRUE);
		}
	}
}








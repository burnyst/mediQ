package model;

import java.util.Date;
import java.util.Map;

public class Faq {
	
	private int sn;
	private String title;
	private String mid;
	private Date rdate;
	private int vcount;
	private String contents;
	private String category;
	
	public Faq() {}
	
	public Faq(int sn, String title, String mid, Date rdate,
			 String category,int vcount,String contents) {
		this.sn = sn;
		this.title = title;
		this.mid = mid;
		this.rdate = rdate;
		this.vcount = vcount;
		this.category = category;
		this.contents = contents;
		
	}
	public Faq(Integer sn, String title, Date rdate, String category, int vcount) {
		this.sn=sn;
		this.title=title;
		this.rdate=rdate;
		this.category=category;
		this.vcount=vcount;
	}
	public Faq(String category, String title, String contents) {
		this.category=category;
		this.title=title;
		this.contents=contents;
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
	public int getVcount() {
		return vcount;
	}
	public void setVcount(int vcount) {
		this.vcount = vcount;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	@Override
	public String toString() {
		return "FaqDAO [sn=" + sn + ", title=" + title + ", mid=" + mid + ", rdate=" + rdate
				+ ", vcount=" + vcount + ", contents=" + contents + ", category=" + category + "]";
	}

	public void validate(Map<String, Boolean> errors) {
		if(title == null || title.trim().isEmpty()) {		//trim 좌우공백제거
			errors.put("title",Boolean.TRUE);   //map에 대이터 넣을때 put
		}
	
	
	}
	
	
}

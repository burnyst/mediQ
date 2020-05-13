package faq.model;

import java.util.Date;

public class Faq {
	
	private int sn;
	private String title;
	private String writer;
	private String mid;
	private Date rdate;
	private int vcount;
	private String contents;
	private String category;
	
	
	public Faq(int sn, String title, String writer, String mid, Date rdate,
			int vcount, String contents,String category) {
		this.sn = sn;
		this.title = title;
		this.writer = writer;
		this.mid = mid;
		this.rdate = rdate;
		this.vcount = vcount;
		this.contents = contents;
		this.category = category;
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
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
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
		return "FaqDAO [sn=" + sn + ", title=" + title + ", writer=" + writer + ", mid=" + mid + ", rdate=" + rdate
				+ ", vcount=" + vcount + ", contents=" + contents + ", category=" + category + "]";
	}

	
	
	
	
	
	
}

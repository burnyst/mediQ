package model;

import java.util.Map;

public class FaqRequest {
	private String mid;
	private int sn;
	private String category;
	private String title;
	private String contents;
	
	public FaqRequest(String mid, String category, String title, String contents) {
		this.mid=mid;
		this.category=category;
		this.title=title;
		this.contents=contents;
	}
	
	public FaqRequest(int sn, String category,String title, String contents, String mid) {
		this.sn=sn;
		this.category=category;
		this.title=title;
		this.contents=contents;
		this.mid=mid;
		
	}

	public FaqRequest(String category, String title, String contents) {
		this.category=category;
		this.title=title;
		this.contents=contents;
	}


	


	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public int getSn() {
		return sn;
	}

	public void setSn(int sn) {
		this.sn = sn;
	}


	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public void validate(Map<String,Boolean>errors) {
		if(title == null || title.trim().isEmpty()) {
			errors.put("title", Boolean.TRUE);
		}
		
	}

	@Override
	public String toString() {
		return "FaqRequest [mid=" + mid + ", sn=" + sn + ", category=" + category + ", title=" + title + ", contents="
				+ contents + "]";
	}


	
	
	
	
}

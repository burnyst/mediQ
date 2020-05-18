package controller;

import java.util.Map;

//p666 
//게시글 수정시 필요한 수정할 게시글 sn,title,press,summary가 필요한데 
//위의 내용을 담는 클래스
public class ModifyRequest {

	private int sn;//게시글번호
	private String title;//제목
	private String summary;//요약정보
	
	public ModifyRequest(int sn,String title,String summary) {
		this.sn=sn;
		this.title=title;
		this.summary=summary;		
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
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public void validate(Map<String,Boolean> errors) {
		if( title==null || title.trim().isEmpty()) {
			errors.put("title",Boolean.TRUE);
		}
	}
	@Override
	public String toString() {
		return "ModifyRequest [sn=" + sn + ", title=" + title + ", summary=" + summary + "]";
	}
}

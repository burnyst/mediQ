package model;

//p604
//LoginService에서 로그인성공시
//로그인한 회원의  정보를 담기위한 클래스
public class User {
	
	private String mid;		//memberid
	private String mname;	//회원명
	
	public User(String mid, String mname) {
		this.mid   = mid;
		this.mname = mname;
	}

	public String getMid() {
		return mid;
	}
	
	public String getMname() {
		return mname;
	}
	

	@Override
	public String toString() {
		return "User [mid=" + mid + ", mname=" + mname + "]";
	}

	
}

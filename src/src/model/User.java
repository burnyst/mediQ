package model;

//p604
//LoginService에서 로그인성공시
//로그인한 회원의  정보를 담기위한 클래스
public class User {
	
	private String mid;		//memberid
	private String mname;	//회원명
	private int mlevel;
	
	public User(String mid, String mname, int mlevel) {
		this.mid   = mid;
		this.mname = mname;
		this.mlevel = mlevel;
	}

	public User(String mid) {
		this.mid   = mid;
	}

	public User(String mid, int mlevel) {
		this.mid   = mid;
		this.mlevel = mlevel;
	}
	
	//회원탈퇴를 위한 기본생성자
	public User() {
	}

	public String getMid() {
		return mid;
	}
	
	public String getMname() {
		return mname;
	}
	
	public int getMlevel() {
		return mlevel;
	}

	@Override
	public String toString() {
		return "User [mid=" + mid + ", mname=" + mname + ", mlevel=" + mlevel + "]";
	}


	
}

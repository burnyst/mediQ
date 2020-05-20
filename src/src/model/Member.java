package model;


public class Member {
	
	private String	mid;
	private String	mname;
	private String	mpwd;
	private String	memail;
	private String	mhp;
	private String	mbd;
	private int		mlevel;
	private char	xmember;
	private String	xreason;
	
	//생성자
	public Member(String mid, String mname, String mpwd, String memail,String mhp,
			String mbd, int mlevel, char xmember, String xreason) {
		this.mid	=	mid;
		this.mname	=	mname;
		this.mpwd	=	mpwd;
		this.memail	=	memail;
		this.mhp	=	mhp;
		this.mbd	=	mbd;
		this.mlevel	=	mlevel;
		this.xmember=	xmember;
		this.xreason=	xreason;
	}
	
	public Member(String mid, String mname, String mpwd, String memail, String mhp, String mbd, int mlevel) {
		this.mid	=	mid;
		this.mname	=	mname;
		this.mpwd	=	mpwd;
		this.memail	=	memail;
		this.mhp	=	mhp;
		this.mbd	=	mbd;
		this.mlevel	=	mlevel;
	}

	//MyinfoService용
	public Member(String mid, String mname, String mbd, String memail, String mhp) {
		this.mid	=	mid;
		this.mname	=	mname;
		this.memail	=	memail;
		this.mhp	=	mhp;
		this.mbd	=	mbd;
	}

	//getters&setters
	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public String getMpwd() {
		return mpwd;
	}

	public void setMpwd(String mpwd) {
		this.mpwd = mpwd;
	}

	public String getMemail() {
		return memail;
	}

	public void setMemail(String memail) {
		this.memail = memail;
	}

	public String getMhp() {
		return mhp;
	}

	public void setMhp(String mhp) {
		this.mhp = mhp;
	}

	public String getMbd() {
		return mbd;
	}

	public void setMbd(String mbd) {
		this.mbd = mbd;
	}

	public int getMlevel() {
		return mlevel;
	}

	public void setMlevel(int mlevel) {
		this.mlevel = mlevel;
	}

	public char getXmember() {
		return xmember;
	}

	public void setXmember(char xmember) {
		this.xmember = xmember;
	}

	public String getXreason() {
		return xreason;
	}

	public void setXreason(String xreason) {
		this.xreason = xreason;
	}
	
	//비밀번호 일치여부를 체크 (from LoginService.java)
	public boolean matchPassword(String mpwd2) {
		return mpwd.contentEquals(mpwd2);
	}
	
	public void changePwd(String newPwd) {
		this.mpwd = newPwd;
	}

}
package model;


public class Memberlist {
	
	private String	mid;
	private String	mname;
	private String	mpwd;
	private String	mpwd2;
	private String	memail;
	private String	mhp;
	private String	mhp2;
	private String	mbd;
	private int		mlevel;
	private int	   xmember;
	private String	xreason;
	private String e_domain;
	
	//생성자
	public Memberlist() {
		
	}
	
	public Memberlist(String mid, String mname, String mpwd, String memail,String mhp,
			String mbd, int mlevel, int xmember, String xreason) {
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
	public Memberlist(String mid, String mname, String memail,String mhp,
			String mbd, int mlevel, int xmember, String xreason) {
		this.mid	=	mid;
		this.mname	=	mname;
		this.memail	=	memail;
		this.mhp	=	mhp;
		this.mbd	=	mbd;
		this.mlevel	=	mlevel;
		this.xmember=	xmember;
		this.xreason=	xreason;
	}
	public Memberlist(String mid, String mname, String mpwd, String memail, String mhp, String mbd, int mlevel) {
		this.mid	=	mid;
		this.mname	=	mname;
		this.mpwd	=	mpwd;
		this.memail	=	memail;
		this.mhp	=	mhp;
		this.mbd	=	mbd;
		this.mlevel = mlevel;
	}

	public Memberlist(String mid, String mpwd) {
		this.mid	=	mid;
		this.mpwd	=	mpwd;
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

	

	public int getXmember() {
		return xmember;
	}

	public void setXmember(int xmember) {
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

	public String getE_domain() {
		return e_domain;
	}

	public void setE_domain(String e_domain) {
		this.e_domain = e_domain;
	}

	public String getMpwd2() {
		return mpwd2;
	}

	public void setMpwd2(String mpwd2) {
		this.mpwd2 = mpwd2;
	}

	public String getMhp2() {
		return mhp2;
	}

	public void setMhp2(String mhp2) {
		this.mhp2 = mhp2;
	}
}

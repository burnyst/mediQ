package model;

import java.util.Map;

public class MemberRequest {
	private String	mid;
	private String	mname;
	private String	mpwd;
	private String	memail;
	private String	mhp;
	private String	mbd;
	private int		mlevel;
	private char	xmember;
	private String	xreason;
	private String	confirmPwd;
	
	//생성자
	public MemberRequest() {
		
	}
	
	public MemberRequest(String mid, String mname, String mpwd, String memail,String mhp,
			String mbd, int mlevel, char xmember, String xreason, String confirmPwd) {
		this.mid		=	mid;
		this.mname		=	mname;
		this.mpwd		=	mpwd;
		this.memail		=	memail;
		this.mhp		=	mhp;
		this.mbd		=	mbd;
		this.mlevel		=	mlevel;
		this.xmember	=	xmember;
		this.xreason	=	xreason;
		this.confirmPwd	=	confirmPwd;
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
	
	public String getConfirmPwd() {
		return confirmPwd;
	}

	public void setConfirmPwd(String confirmPwd) {
		this.confirmPwd = confirmPwd;
	}

	public boolean isPwdEqualToConfirm() {
		return mpwd != null && mpwd.contentEquals(confirmPwd);
	}
	
	public void validate(Map<String, Boolean> errors) {
		checkEmpty(errors, mid, "mid");
		checkEmpty(errors, mname, "mname");
		checkEmpty(errors, mpwd, "mpwd");
		checkEmpty(errors, confirmPwd, "confirmPwd");
		if (!errors.containsKey("confirmPwd")) {
			if(!isPwdEqualToConfirm()) {
				errors.put("notMatch", Boolean.TRUE);
			}
		}
		
	}
	
	private void checkEmpty(Map<String, Boolean> errors,
			String value, String fieldName) {
		if(value == null || value.isEmpty())
			errors.put(fieldName,  Boolean.TRUE);
	}
}


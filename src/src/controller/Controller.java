package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;

public abstract class Controller {
	public int getParameterInt(HttpServletRequest req, String name, int defVal) {
		int rst = defVal;
		String val = req.getParameter(name);
		if (val != null && !val.isEmpty()) {
			try {
				rst = Integer.parseInt(val);
			} catch (NumberFormatException e) {
			}
		}
		return rst;
	}
	public static User getAuthUser(HttpServletRequest req) {
		User rst = null;
		Object userObj = req.getSession(false).getAttribute("AUTHUSER");
		if (userObj != null && userObj instanceof User) {
			rst = (User)userObj;
			return rst;
		} else {
			throw new NotLoginException();
		}
	}
	public abstract String doPost(HttpServletRequest req, HttpServletResponse res) throws Exception;
	public abstract String doGet(HttpServletRequest req, HttpServletResponse res) throws Exception;
}

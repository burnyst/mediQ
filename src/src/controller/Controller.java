package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	public abstract String doPost(HttpServletRequest req, HttpServletResponse res) throws Exception;
	public abstract String doGet(HttpServletRequest req, HttpServletResponse res) throws Exception;
}

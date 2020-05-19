package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MailController extends Controller {
	private MailService service = new MailService();
	@Override
	public String doPost(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		String fromEmail = "mediqmaster@gmail.com";
		String toEmail = req.getParameter("email");
		service.sendMail(title, content, fromEmail, toEmail);
		req.setAttribute("sendMail", true);
		return "/view/member/join.jsp";
	}

	@Override
	public String doGet(HttpServletRequest req, HttpServletResponse res) throws Exception {
		res.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
		return null;
	}

}

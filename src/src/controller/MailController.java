package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MailController extends Controller {
	private MailService service = new MailService();
	@Override
	public String doPost(HttpServletRequest req, HttpServletResponse res) throws Exception {
		//"mail.do?title=메디큐이메일인증"+"&content="+content.value+"&email="+email.value+"@"+email2.value+"&authCode="+code;
		
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		String email = req.getParameter("email");
		service.sendMail(title, content, email);
		req.setAttribute("sendMail", true);
		return null;
	}

	@Override
	public String doGet(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		System.out.println("doGet옴");
		doPost(req,res);
		
		return null;
	}

}

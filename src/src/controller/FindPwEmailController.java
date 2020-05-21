package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FindPwEmailController extends Controller {
	private MailService service = new MailService();
	@Override
	public String doPost(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String id = req.getParameter("mid");
		res.sendRedirect(req.getContextPath()+"/findPwResult.do?mid="+id);
		return null;
	}

	@Override
	public String doGet(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String id = req.getParameter("mid");
		String email = req.getParameter("memail");
		String authCode = req.getParameter("authCode");
		String title = req.getParameter("title");
		req.setAttribute("mid", id);
		req.setAttribute("memail", email);
		req.setAttribute("authCode", authCode);
		req.setAttribute("title", title);
		if(id != null && !id.isEmpty() && email != null && !email.isEmpty() && authCode != null && !authCode.isEmpty() && title != null && !title.isEmpty()) {
			service.sendMail(title, authCode, email);
			System.out.println("메일 전송");
		}
		return "/view/member/findPwEmail.jsp";
	}

}

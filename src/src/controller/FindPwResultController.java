package controller;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDAO;
import dbcp.JdbcUtil;

public class FindPwResultController extends Controller {

	@Override
	public String doPost(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String rst = null;
		String id = req.getParameter("mid");
		String pw = req.getParameter("mpw1");
		System.out.println(id);
		System.out.println(pw);
		if (id != null && !id.isEmpty() && pw != null && !pw.isEmpty()) {
			Connection con = JdbcUtil.getConnection();
			MemberDAO.changePw(con, id, pw);
			JdbcUtil.close(con);
			rst = "/view/member/findPwSuccess.jsp";
		} else {
			req.setAttribute("fail", "비밀번호 갱신이 실패했습니다.");
			res.sendRedirect(req.getContextPath()+"/findPwResult.do");
		}
		return rst;
	}

	@Override
	public String doGet(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String id = req.getParameter("mid");
		req.setAttribute("mid", id);
		return "/view/member/findPwResult.jsp";
	}

}

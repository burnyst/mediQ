package controller;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDAO;
import dbcp.JdbcUtil;

public class FindPwController extends Controller {
	@Override
	public String doPost(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String rst = null;
		String findId = null;
		String id = req.getParameter("mid");
		String email = req.getParameter("memail");
		if (id != null && !id.isEmpty() && email != null && !email.isEmpty()) {
			Connection con = JdbcUtil.getConnection();
			findId = MemberDAO.findPw(con, id, email);
			JdbcUtil.close(con);
		}
		if (findId != null && !findId.isEmpty()) {
			res.sendRedirect(req.getContextPath()+"/findPwEmail.do?mid="+id+"&memail="+email);
		} else {
			req.setAttribute("fail", "일치하는 회원 정보가 없습니다.");
			rst = "/view/member/findPw.jsp";
		}
		return rst;
	}

	@Override
	public String doGet(HttpServletRequest req, HttpServletResponse res) throws Exception {
		return "/view/member/findPw.jsp";
	}

}

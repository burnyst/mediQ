package controller;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDAO;
import dbcp.JdbcUtil;

public class FindIdController extends Controller {

	@Override
	public String doPost(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String id = null;
		String name = req.getParameter("mname");
		String email = req.getParameter("memail");
		if (name != null && !name.isEmpty() && email != null && !email.isEmpty()) {
			Connection con = JdbcUtil.getConnection();
			id = MemberDAO.findId(con, name, email);
			JdbcUtil.close(con);
		}
		System.out.println(id);
		req.setAttribute("findId", id);
		return "/view/member/findIdResult.jsp";
	}

	@Override
	public String doGet(HttpServletRequest req, HttpServletResponse res) throws Exception {
		return "/view/member/findId.jsp";
	}

}

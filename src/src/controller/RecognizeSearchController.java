package controller;

import java.sql.Connection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.RecognizeDAO;
import dbcp.JdbcUtil;
import page.RecognizePage;

public class RecognizeSearchController  extends Controller {

	@Override
	public String doPost(HttpServletRequest req, HttpServletResponse res) throws Exception {
		System.out.println("1진입성공");

		res.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
		return null;
	}

	@Override
	public String doGet(HttpServletRequest req, HttpServletResponse res) throws Exception {
		RecognizePage page = null;
		System.out.println("2진입성공");
		String itemname = req.getParameter("itemname");
		if (itemname != null && !itemname.isEmpty()) {
			int pageNo = getParameterInt(req, "pageNo", 1);
			int numOfRows = getParameterInt(req, "numOfRows", 10);
			Connection con = JdbcUtil.getConnection();
			Integer count = RecognizeDAO.getCount(con, itemname);
			page = new RecognizePage(count, pageNo, numOfRows, RecognizeDAO.getList(con, itemname, pageNo, numOfRows));
			JdbcUtil.close(con);
			System.out.println("3진입성공");
		}
		req.setAttribute("page", page);
		req.setAttribute("itemname", itemname);
		return "/view/product/Recognizelist.jsp";
		}

	}


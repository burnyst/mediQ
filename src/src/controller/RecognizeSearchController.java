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
		res.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
		return null;
	}

	@Override
	public String doGet(HttpServletRequest req, HttpServletResponse res) throws Exception {
		RecognizePage page = null;
		String productname = req.getParameter("productname");
		if (productname != null && !productname.isEmpty()) {
			int pageNo = getParameterInt(req, "pageNo", 1);
			int numOfRows = getParameterInt(req, "numOfRows", 10);
			Connection con = JdbcUtil.getConnection();
			Integer count = RecognizeDAO.getCount(con, productname);
			page = new RecognizePage(count, pageNo, numOfRows, RecognizeDAO.getList(con, productname, pageNo, numOfRows));
			JdbcUtil.close(con);
		}
		req.setAttribute("page", page);
		req.setAttribute("productname", productname);
		return "/view/product/Recognizelist.jsp";
		}

	}


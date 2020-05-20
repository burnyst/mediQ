package controller;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.InfoDAO;
import dbcp.JdbcUtil;
import page.InfoPage;


public class InfoSearchController extends Controller {
	
	@Override
	public String doPost(HttpServletRequest req, HttpServletResponse res) throws Exception {
		res.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
		return null;
	}

	@Override
	public String doGet(HttpServletRequest req, HttpServletResponse res) throws Exception {
		InfoPage page = null;
		String indexWord = req.getParameter("indexWord");
		if (indexWord != null && !indexWord.isEmpty()) {
			int pageNo = getParameterInt(req, "pageNo", 1);
			int numOfRows = getParameterInt(req, "numOfRows", 10);
			Connection con = JdbcUtil.getConnection();
			Integer count = InfoDAO.getCount(con, indexWord);
			page = new InfoPage(count, pageNo, numOfRows, InfoDAO.getList(con, indexWord, pageNo, numOfRows));
			JdbcUtil.close(con);
		}
		req.setAttribute("page", page);
		req.setAttribute("searchWord", indexWord);
		return "/infolist.jsp";
	}

}

package controller;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.HistoryDao;
import dbcp.JdbcUtil;
import model.User;
import page.HistoryPage;

public class HistoryController extends Controller {
	@Override
	public String doPost(HttpServletRequest req, HttpServletResponse res) throws Exception {
		try {
			User user = getAuthUser(req);
			String mid = user.getMid();
			String[] itemsSeq = req.getParameterValues("itemSeq");
			if (itemsSeq != null && itemsSeq.length > 0) {
				Connection con = null;
				try {
					con = JdbcUtil.getConnection();
					for (String i : itemsSeq) {
						HistoryDao.Delete(con, mid, i);
					}
				} finally {
					JdbcUtil.close(con);
				}
			}
			res.sendRedirect(req.getContextPath()+"/history.do");
			return null;
		} catch (NotLoginException e) {
			res.sendRedirect(req.getContextPath()+"/login.do");
			return null;
		}
	}

	@Override
	public String doGet(HttpServletRequest req, HttpServletResponse res) throws Exception {
		try {
			User user = getAuthUser(req);
			String mid = user.getMid();
			int pageNo = getParameterInt(req, "pageNo", 1);
			int numOfRows = getParameterInt(req, "numOfRows", 10);
			Connection con = null;
			try {
				con = JdbcUtil.getConnection();
				Integer count = HistoryDao.getCount(con, mid);
				HistoryPage page = new HistoryPage(count, pageNo, numOfRows, HistoryDao.getList(con, mid, pageNo, numOfRows));
				req.setAttribute("page", page);
			} finally {
				JdbcUtil.close(con);
			}
			return "/view/history/history.jsp";
		} catch (NotLoginException e) {
			res.sendRedirect(req.getContextPath()+"/login.do");
			return null;
		}
	}

}

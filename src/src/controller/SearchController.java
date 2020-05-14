package controller;

import java.sql.Connection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductDao;
import dbcp.JdbcUtil;
import page.ProductPage;

public class SearchController extends Controller {

	@Override
	public String doPost(HttpServletRequest req, HttpServletResponse res) throws Exception {
		res.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
		return null;
	}

	@Override
	public String doGet(HttpServletRequest req, HttpServletResponse res) throws Exception {
		ProductPage page = null;
		String productName = req.getParameter("productName");
		if (productName != null && !productName.isEmpty()) {
			int pageNo = getParameterInt(req, "pageNo", 1);
			int numOfRows = getParameterInt(req, "numOfRows", 10);
			Connection con = JdbcUtil.getConnection();
			Integer count = ProductDao.getCount(con, productName);
			JdbcUtil.close(con);
			con = JdbcUtil.getConnection();
			if (count > 0) {
				page = new ProductPage(count, pageNo, numOfRows, ProductDao.getList(con, productName, pageNo, numOfRows));
				
			}
			JdbcUtil.close(con);
		}
		req.setAttribute("page", page);
		req.setAttribute("productName", productName);
		return "/index.jsp";
	}

}
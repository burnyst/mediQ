package controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import dao.NewsDAO;
import dbcp.JdbcUtil;
import model.News;
import page.NewsSearchPage;

public class NewsSearchService {
	private NewsDAO newsDao = new NewsDAO();
	
	public NewsSearchPage getKeywordt(String keyword1) {
		System.out.println("Newssearchservice getKeywordt호출성공");
		try {
			Connection conn  =
				JdbcUtil.getConnection();
			
			int total = NewsDAO.selectCountt(conn,keyword1);
			
			//특정키워드 article조회
			List<News> search= 
					 newsDao.selectByIdT(conn,keyword1);
			
			return new NewsSearchPage(total,search,keyword1);
			
	}catch(SQLException e) {
		throw new RuntimeException(e);
	}
}

}

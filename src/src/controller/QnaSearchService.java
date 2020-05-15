package controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import dao.QnaDAO;
import dbcp.JdbcUtil;
import model.Qnamodel;
import page.QnaSearchPage;

public class QnaSearchService {
	private QnaDAO qnaDao = new QnaDAO();
	
	public QnaSearchPage getKeywordt(String keyword1,String keyword2,String keyword3,String keyword4) {
		System.out.println("Qnasearchservice getKeywordt호출성공");
		try {
			Connection conn  =
				JdbcUtil.getConnection();
			
			int total = QnaDAO.selectCountt(conn,keyword1,keyword2,keyword3,keyword4);
			
			//특정키워드 article조회
			List<Qnamodel> search= 
					 qnaDao.selectByIdT(conn,keyword1,keyword2,keyword3,keyword4);
			
			return new QnaSearchPage(total,search,keyword1,keyword2,keyword3,keyword4);
			
	}catch(SQLException e) {
		throw new RuntimeException(e);
	}
}

}

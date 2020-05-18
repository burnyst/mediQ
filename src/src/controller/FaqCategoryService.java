package controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import dao.FaqDAO;
import dbcp.JdbcUtil;
import model.Faq;
import page.FaqCategoryPage;

public class FaqCategoryService {
	
	private FaqDAO faqDAO = new FaqDAO();
	private int size = 10;		//한페이지당 출력할 게시글 수

	public FaqCategoryPage getFaqPage(int pageNo , String category) {
		System.out.println("getFaqPage호출");
		System.out.println("pageNo="+pageNo);
		
		try {
			Connection conn= JdbcUtil.getConnection();
			
			
			//카테고리 게시글수 조회
			int categorytotal = faqDAO.selectCountC(conn, category);
			System.out.println("total"+categorytotal);
			System.out.println("category="+category);
			//category별 리스트 조회
			List<Faq> contentC = faqDAO.selectC(conn, category , (pageNo-1)*size, size);
			System.out.println("contentC호출 성공");
			System.out.println("pageNo"+pageNo);
			System.out.println("size"+size);
			System.out.println("category"+category);
			
			//페이지정보가 포함된 내용을 리턴을 해줘야 한다
			return new FaqCategoryPage(categorytotal, contentC, pageNo, size, category );
			
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}

	}

}

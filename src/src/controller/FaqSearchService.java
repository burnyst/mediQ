package controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import dao.FaqDAO;
import dbcp.JdbcUtil;
import model.Faq;
import page.FaqSearchPage;

public class FaqSearchService {
	
	private FaqDAO faqDAO = new FaqDAO();
	private int size = 10;
	
	public FaqSearchPage getFaqPAge(int pageNo, String search) {
		System.out.println("getFaqPage호출");
		System.out.println("pageNo="+pageNo);
		System.out.println("search="+search);
		
		try {
			Connection conn = JdbcUtil.getConnection();
			
			//search 게시글수 조회
			int searchtotal = faqDAO.selectContS(conn,search);
			System.out.println("total="+searchtotal);
			System.out.println("search="+search);
			
			List<Faq> contentS = faqDAO.selectS(conn, search, (pageNo-1)*size, size);
			System.out.println("contentS 호출 성공");
			System.out.println("pageNo"+pageNo);
			System.out.println("size="+size);
			System.out.println("search="+search);
			
			//페이지정보가 포함된 내용을 리턴
			return new FaqSearchPage(searchtotal, contentS, pageNo, size, search);
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	

}

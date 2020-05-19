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
	
	public FaqSearchPage getFaqPage(int pageNo, String search, String category) {
		System.out.println("getFaqPage호출");
		System.out.println("pageNo="+pageNo);
		System.out.println("search="+search);
		
		try {
			Connection conn = JdbcUtil.getConnection();
			
			
			
			
			if(category==null) {	
				//search 게시글수 조회
				int searchtotal = faqDAO.selectCountS(conn,category,search);
				List<Faq> contentSA = faqDAO.selectSA(conn, search, (pageNo-1)*size, size);
				System.out.println("search="+search+"/category="+category+"/searchtotal="+searchtotal);
				return new FaqSearchPage(searchtotal, contentSA, pageNo, size, search,category);
				
			}else {
				//search 게시글수 조회	
				int searchtotal = faqDAO.selectCountSC(conn,category,search);
				System.out.println("searchtotal="+searchtotal);
				List<Faq> contentSC =faqDAO.selectSC(conn, category, search,(pageNo-1)*size, size);
				System.out.println("search="+search+"/category="+category);
				return new FaqSearchPage(searchtotal, contentSC, pageNo, size, search,category);
			}
			
			
			//페이지정보가 포함된 내용을 리턴
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	

}

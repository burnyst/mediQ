package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import page.NewsSearchPage;

public class NewsSearchController implements controller.CommandHandler {
	private NewsSearchService newssearchservice = new NewsSearchService();

	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("newssearchController 진입성공");
		//1.파라미터받기 -검색한 키워드
		String keyword1= request.getParameter("keyword1"); 	
			
		System.out.println("keyword==>"+keyword1);
		
		//2.비즈니스로직(<->Service<->DAO<->DB) 
		NewsSearchPage newsSearchPage = 
				newssearchservice.getKeywordt(keyword1);
		
		//3.Model
		request.setAttribute("newsSearchPAGE", newsSearchPage);
				
		//4.View
		return  "/view/notice/news/newsMain.jsp";
		
	}
}

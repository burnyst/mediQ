package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import page.FaqSearchPage;

public class FaqSearchController  implements CommandHandler{

	//Service
	private FaqSearchService searchService = new FaqSearchService();

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("FaqListController의 process()진입");
		//파라미터받기
		String pageNoVal = request.getParameter("pageNo");//보고싶은페이지
		String search = request.getParameter("search");
		int pageNo=1;
		if(pageNoVal!=null) {		//보고싶은페이지가 넘어오면 
			pageNo=Integer.parseInt(pageNoVal);
		}
		
		//비즈니스로직 수행
		FaqSearchPage faqSearchPage = searchService.getFaqPAge(pageNo,search);
		
		//Model
		request.setAttribute("faqSearchPage", faqSearchPage);
		
		//View
		return "view/cs/faq/faqsearch.jsp";
	}
	
	
}

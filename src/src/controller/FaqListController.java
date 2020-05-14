package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.CommandHandler;

import page.FaqPage;

//전체목록보기 요청 담당 컨트롤러
//p652
public class FaqListController implements CommandHandler {

	//Service
	private FaqListService listService = new FaqListService();
	
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("FaqListController의 process()진입");
		//할일
		//1.파라미터 받기
		String pageNoVal = request.getParameter("pageNo");//보고싶은페이지
		int pageNo=1;
		if(pageNoVal!=null) {		//보고싶은페이지가 넘어오면 
			pageNo=Integer.parseInt(pageNoVal);
		}
		//2.비즈니스로직 수행(<->Service<->DAO<->DB)(p652-22)
		FaqPage faqPage = listService.getFaqPage(pageNo);
		
		//3.Model
		request.setAttribute("faqPage", faqPage);
		//4.View
		
		return "/view/cs/faq/faqlist.jsp";
	}

}

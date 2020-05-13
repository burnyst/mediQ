package faq.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import faq.service.FaqPage;
import faq.service.ListFaqService;
import mvc.command.CommandHandler;

//전체목록보기 요청 담당 컨트롤러
//p652
public class ListFaqHandler implements CommandHandler {

	//Service
	private ListFaqService listService = new ListFaqService();
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//할일
		//1.파라미터 받기
		String pageNoVal = request.getParameter("pageNo");//보고싶은페이지
		int pageNo=1;
		if(pageNoVal!=null) {		//보고싶은페이지가 넘어오면 
			pageNo=Integer.parseInt(pageNoVal);
		}
		//2.비즈니스로직 수행(<->Service<->DAO<->DB)(p652-22)
		FaqPage faqPage = listService.getArticlePage(pageNo);
		
		//3.Model
		request.setAttribute("faqPage", faqPage);
		//4.View
		
		return "/view/cs/faq/faqList.jsp";
	}

}

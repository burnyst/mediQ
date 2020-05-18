package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import page.FaqCategoryPage;

public class FaqCategoryController  implements CommandHandler{

	private FaqCategoryService categoryService = new FaqCategoryService();
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("FaqCategoryController의 process()진입");
		
		//파라미터받기
		String pageNoVal = request.getParameter("pageNo");//보고싶은페이지
		String category = request.getParameter("category");
		System.out.println("pageNo="+pageNoVal+"/category="+category);
		int pageNo=1;
		if(pageNoVal!=null) {		//보고싶은페이지가 넘어오면 
			pageNo=Integer.parseInt(pageNoVal);
		}
		//2.비즈니스로직 수행(<->Service<->DAO<->DB)(p652-22)
		FaqCategoryPage faqCategoryPage = categoryService.getFaqPage(pageNo, category);
		
		//Model
		request.setAttribute("faqCategoryPage",faqCategoryPage);
		
		//View
		return "view/cs/faq/faqcategory.jsp";
	}

}

package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Faq;

public class FaqCcountController implements CommandHandler{
	
	//View
	private static final String FORM_VIEW="/faqcategory.do";
	
	//service
	private FaqCountService vcountService = new FaqCountService();

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("FaqCountController의 process()진입");
		
		//파라미터받기
		int sn = Integer.parseInt(request.getParameter("sn"));
		String category = request.getParameter("category");
		System.out.println("sn="+sn+"/category="+category);
		try {
			//조회수 증가
			Faq faqVcount = vcountService.getVcount(sn,true);
		
			//Model
			request.setAttribute("faqVcount", faqVcount);
			System.out.println("sn="+sn+"/category="+category);
			//View
			return FORM_VIEW;
			
		}catch(FaqNotFoundException e) {
			request.getServletContext().log("no faq",e);
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
		}
		return null;
	}
}
	
	
	
	
	
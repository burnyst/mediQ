package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import page.FaqPage;

public class FaqDeleteController implements CommandHandler{
	
	//View
	private static final String FORM_VIEW = "/faqlist.do";
	
	//Service
	private FaqDeleteService deleteService = new FaqDeleteService();

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("FaqDeleteController의 process()진입");
		
		//1.파라미터 받기
		int sn = Integer.parseInt(request.getParameter("sn"));
		System.out.println("sn="+sn);
		
		try {
			deleteService.delete(sn);
			return FORM_VIEW;
		}catch(FaqNotFoundException e) {
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			return null;
		}catch(PermissionDeniedException e) {
			response.sendError(HttpServletResponse.SC_FORBIDDEN);
			return null;
		}
		
	}

}
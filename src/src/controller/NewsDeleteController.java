package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.CommandHandler;



public class NewsDeleteController implements CommandHandler {

	//View
	private static final String FORM_VIEW = "/newslist.do";
	
	//Service
	private NewsDeleteService deleteService = new NewsDeleteService();

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("NewsDeleteController의 process()진입");
		
		//1.파라미터 받기
		
		int sn = Integer.parseInt(request.getParameter("sn"));
		System.out.println("sn="+sn);
		
		try {
			deleteService.delete(sn);
			return FORM_VIEW;
		}catch(Exception e) {
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			return null;
		}
		
	}

}
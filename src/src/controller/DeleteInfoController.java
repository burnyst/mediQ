package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteInfoController implements CommandHandler{
	//View
	private static final String FORM_VIEW = "/infolist.do";
	
	//Service
	private DeleteInfoService deleteService = new DeleteInfoService();


	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("InfoDeleteController의 process()진입");
		
		//1.파라미터 받기
		String ITEM_NAME = request.getParameter("itemName");
		System.out.println("ITEM_NAME="+ITEM_NAME);
		
		try {
			deleteService.delete(ITEM_NAME);
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
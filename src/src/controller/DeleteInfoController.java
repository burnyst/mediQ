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
		System.out.println("infoDeleteController의 process()진입");
		
		//1.파라미터 받기
		String itemname = request.getParameter("itemname");
		System.out.println("itemname="+itemname);
		
		try {
			deleteService.delete(itemname);
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
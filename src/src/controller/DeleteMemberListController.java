package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.CommandHandler;
import model.Memberlist;



public class DeleteMemberListController implements CommandHandler {

	//View
	private static final String FORM_VIEW = "memberlist.do";
	
	//Service
	private DeleteMemberListService deleteMemberListService = new DeleteMemberListService();

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("DeleteMemberListController의 process()진입");
		
		//1.파라미터 받기
		
//		String mid = request.getParameter("mid");
//		System.out.println("mid="+mid);
		String[] members = request.getParameterValues("mid");
		for (Object i : members) {
			System.out.println(((Memberlist)i).getMname());
		}
		
		try {
			//deleteMemberListService.delete(mid);
			return FORM_VIEW;
		}catch(Exception e) {
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			return null;
		}
		
	}

}
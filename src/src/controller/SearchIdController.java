package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SearchIdController implements CommandHandler {

	private static final String FORM_VIEW = "/view/member/join.jsp";
	private JoinService joinService = new JoinService();
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {

		System.out.println("SearchIdController 진입성공");
		
		//1.파라미터받기
		String mid=req.getParameter("mid"); //user가 입력한 id.. 기존id존재여부체크 하기 위한 id
		
		//2.비즈니스로직(Serivce->dao->db)
		String result=joinService.searchId(mid);
		System.out.println("SearchIdController리턴result="+result);
		//3.Model
		req.setAttribute("RESULT", result);
		
		//4.View
		return FORM_VIEW;
	}

}

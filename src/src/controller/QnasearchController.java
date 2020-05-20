package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.User;
import page.QnaSearchPage;

public class QnasearchController implements CommandHandler{
	private QnaSearchService qnasearchservice = new QnaSearchService();

	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("qnasearchController 진입성공");
		//1.파라미터받기 -검색한 키워드
		String keyword1= request.getParameter("keyword1"); 	
		String keyword2= request.getParameter("keyword2"); 	
		String keyword3= request.getParameter("keyword3"); 	
		String keyword4 = request.getParameter("keyword4"); 	
		System.out.println("keyword==>"+keyword1 +keyword2 +keyword3+keyword4);
		
		//2.비즈니스로직(<->Service<->DAO<->DB) 
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("AUTHUSER");
		QnaSearchPage qnaSearchPage = 
				qnasearchservice.getKeywordt(keyword1, keyword2, keyword3, keyword4);
		
		//3.Model
		request.setAttribute("qnaSearchPAGE", qnaSearchPage);
		request.setAttribute("user", user);		
				
		//4.View
		return  "/view/cs/qna/qnalist.jsp";
		
	}
}

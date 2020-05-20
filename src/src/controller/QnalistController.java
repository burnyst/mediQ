package controller;


import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.QnaRequest;
import model.User;
import page.QnaPage;

public class QnalistController implements CommandHandler {

	private QnaListService listService =
			new QnaListService();
	
	@Override
	public String process(HttpServletRequest request, 
						  HttpServletResponse response) throws Exception {
		System.out.println("qnalistcontroller진입성공");
		
		//할일
				//1.파라미터 받기
				String pageNoVal = request.getParameter("pageNo");//보고싶은페이지
				int pageNo = 1;
				if( pageNoVal!=null ) { //보고싶은페이지가 넘어오면
					pageNo = Integer.parseInt(pageNoVal);
				}
				//2.비즈니스로직(<->Service<->DAO<->DB) p652 22
				HttpSession session = request.getSession();
				User user = (User)session.getAttribute("AUTHUSER");
				
				QnaPage qnaPage = 
						listService.getQnaPage(pageNo);
				
				//3.Model
				request.setAttribute("qnaPAGE", qnaPage);
				request.setAttribute("user", user);		
				//4.View
				return  "/view/cs/qna/qnalist.jsp";
	}


}


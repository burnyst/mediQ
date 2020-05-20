package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.User;
import model.Member;

public class MyinfoUpdateController implements CommandHandler {
	
	private static final String FORM_VIEW = "/view/member/myinfoUpdate.jsp";
	private MyinfoUpdateService myinfoUpdateService = new MyinfoUpdateService();
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("MyinfoUpdateController 진입성공");
		
		//GET방식으로  요청이 들어오면
		if(request.getMethod().equalsIgnoreCase("GET")) {
			System.out.println("myinfoUpdate.jsp의 method방식="+request.getMethod());
			return processForm(request,response);
		}else if(request.getMethod().equalsIgnoreCase("POST")) {//post방식으로 요청이 들어오면
			System.out.println("myinfoUpdate.jsp의 method방식="+request.getMethod());
			return processSubmit(request,response);
		}else {
			//405에러
			response.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			return null;
		}
	}
	
	//GET방식으로 요청이 들어오면  폼(/view/member/join.jsp)을 보여주기
	private String processForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("MyinfoUpdateController의 processForm()호출");
		//할일
		//1.파라미터받기
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("AUTHUSER");
		String mid = user.getMid();
		System.out.println("세션에서 받은 mid = "+mid);
				
		//2.비즈니스로직(<->Service<->DAO<->DB)
		try {
			Member member = MyinfoUpdateService.myinfo(mid);
			System.out.println("MypageHandler-process(member)="+member);
			
			//3.Model
			request.setAttribute("member",member);
			
			//4.View
			return "/view_member/myinfoUpdateForm.jsp";
		}catch(Exception e) {
			request.getServletContext().log("no article", e);
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			return null;
		}
	}
	
		//POST방식으로 요청이 들어오면 회원정보수정 요청을 진행
		private String processSubmit(HttpServletRequest request, HttpServletResponse response) throws SQLException {
			System.out.println("MyinfoController의 processSubmit()호출");
//			//할일
//			//1. 요청파라미터 받기
//			//MyinfoController는 유저가 입력한 폼의 내용을 객체로 묶어서 처리
//			Member mem = new Member();
//			
//			mem.setMid(request.getParameter("mid"));
//			mem.setMname(request.getParameter("mname"));
//			mem.setMemail(request.getParameter("memail"));
//			mem.setMhp(request.getParameter("mhp"));
//			mem.setMbd(request.getParameter("mbd"));
//			
//			//p.598 line 42~49까지 다 쓰기
//			//2.비즈니스로직수행(<->Service<->DAO<->DB)
//			MyinfoUpdateService.myinfo(mem);
//			
//			//3.Model
//			//4.View지정
			return "/view/member/myinfoUpdateSuccess.jsp";
//			return null;
		}
}


package controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MemberRequest;

public class MyinfoController implements CommandHandler {
	
	private static final String FORM_VIEW = "/view/member/myinfo.jsp";
	private MyinfoService myinfoService = new MyinfoService();
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("MyinfoController 진입성공");
		
		//GET방식으로  요청이 들어오면
		if(request.getMethod().equalsIgnoreCase("GET")) {
			System.out.println("myinfo.jsp의 method방식="+request.getMethod());
			return processForm(request,response);
		}else if(request.getMethod().equalsIgnoreCase("POST")) {//post방식으로 요청이 들어오면
			System.out.println("myinfo.jsp의 method방식="+request.getMethod());
			return processSubmit(request,response);
		}else {
			//405에러
			response.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			return null;
		}
	}
	
	//GET방식으로 요청이 들어오면  폼(/view/member/join.jsp)을 보여주기
	private String processForm(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("JoinController의 processFrom()호출");
		return FORM_VIEW;
	}
	
	//POST방식으로 요청이 들어오면 회원정보수정 요청을 진행
		private String processSubmit(HttpServletRequest request, HttpServletResponse response) throws SQLException {
			System.out.println("MyinfoController의 processSubmit()호출");
			//할일
			//1. 요청파라미터 받기
			//MyinfoController는 유저가 입력한 폼의 내용을 객체로 묶어서 처리
			MemberRequest memberReq = new MemberRequest();
			
			memberReq.setMid(request.getParameter("mid"));
			memberReq.setMname(request.getParameter("mname"));
			memberReq.setMemail(request.getParameter("memail"));
			memberReq.setMhp(request.getParameter("mhp"));
			memberReq.setMbd(request.getParameter("mbd"));
			
			//p.598 line 42~49까지 다 쓰기
			//2.비즈니스로직수행(<->Service<->DAO<->DB)
			myinfoService.update(memberReq);
			
			//3.Model
			//4.View지정
			return "/view/member/myinfoUpdateSuccess.jsp";
			
		}
}

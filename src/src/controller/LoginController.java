package controller;

import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.LoginFailException;
import model.User;
import dao.MemberDAO;
import controller.CommandHandler;
import model.MemberRequest;

public class LoginController implements CommandHandler {
	
	private static final String FORM_VIEW = "/view/member/loginSuccess.jsp";
	private LoginService loginService = new LoginService();
	
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("LoginController 진입성공");
		
		//GET방식으로  요청이 들어오면
		if(request.getMethod().equalsIgnoreCase("GET")) {
			System.out.println("login.jsp의 method방식="+request.getMethod());
			return processForm(request,response);
		}else if(request.getMethod().equalsIgnoreCase("POST")) {//post방식으로 요청이 들어오면
			System.out.println("login.jsp의 method방식="+request.getMethod());
			return processSubmit(request,response);
		}else {
			//405에러
			response.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			return null;
		}
	}
	
	//GET방식으로 요청이 들어오면  폼(/view/member/login.jsp)을 보여주기
	private String processForm(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("LoginController의 processFrom()호출");
		return FORM_VIEW;
	}
	
	//POST방식으로 요청이 들어오면 로그인 요청을 진행
	private String processSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("LoginController의 processSubmit()호출");
		//1. 요청파라미터 받기
		//LoginController는 유저가 입력한 폼의 내용을 객체로 묶어서 처리
		MemberRequest memberReq = new MemberRequest();
		
		String mid	= trim(request.getParameter("mid"));
		String mpwd = request.getParameter("mpwd"); //비번
		System.out.println("processSubmit() id/password="+mid+"/"+mpwd);
		
		//p.598 line 42~49까지 다 쓰기
		//2.비즈니스로직수행(<->Service<->DAO<->DB)
		Map<String,Boolean> errors = new HashMap<>();
		
			//3.Model
			request.setAttribute("errors",errors); //View에 Model로 전달
			
			if(mid==null||mid.isEmpty()) 
				errors.put("mid",Boolean.TRUE);
			
			if(mpwd==null||mpwd.isEmpty()) 
				errors.put("mpwd",Boolean.TRUE);
			
			//에러가 발생되면
			if(!errors.isEmpty()) {
				return FORM_VIEW; //로그인폼으로 이동
			}
			
			//회원으로 존재하면 회원정보가 User객체로 리턴
			try {
				User user = loginService.login(mid,mpwd);
				
				//로그인한 회원의 정보를 세션에 저장
				//형식> session.setAttribute(String name,Object value);
				HttpSession session = request.getSession();
				session.setAttribute("AUTHUSER", user);
				/*
				session.setAttribute("AUTHUSER_ID", user.getId());
				session.setAttribute("AUTHUSER_NAME", user.getName());
				*/
				
				//4.View
				//로그인성공시   index.jsp문서로 sendRedirect를 이용하여 강제이동
				response.sendRedirect(request.getContextPath()+"/index.jsp");
				return null;
			} catch (LoginFailException e) {//로그인 실패시
				errors.put("idOrPwNotMatch", Boolean.TRUE);
				e.printStackTrace(); //에러관련내용 콘솔출력
				return FORM_VIEW;    //  /view/member/loginForm.jsp를  View지정 
			}
		}
		
		private String trim(String str) {
			//조건? 참: 거짓;
			return  str==null? null: str.trim();		
		}
	}
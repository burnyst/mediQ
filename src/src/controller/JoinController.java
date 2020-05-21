package controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.JoinService;
import dao.MemberDAO;
import dbcp.JdbcUtil;
import model.Member;
import controller.CommandHandler;

public class JoinController implements CommandHandler {

	//View지정(p.598 line16)
	private static final String FORM_VIEW = "/view/member/join.jsp";
	private JoinService joinService = new JoinService();
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("JoinController 진입성공");
		
		//GET방식으로  요청이 들어오면
		if(request.getMethod().equalsIgnoreCase("GET")) {
			System.out.println("join.jsp의 method방식="+request.getMethod());
			return processForm(request,response);
		}else if(request.getMethod().equalsIgnoreCase("POST")) {//post방식으로 요청이 들어오면
			System.out.println("join.jsp의 method방식="+request.getMethod());
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
	
	//POST방식으로 요청이 들어오면 회원가입 요청을 진행(p.598 line35)
	private String processSubmit(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("JoinController의 processSubmit()호출");
		//할일
		//1. 요청파라미터 받기
		//JoinController는 유저가 입력한 폼의 내용을 객체로 묶어서 처리
		String reqMethod = request.getParameter("reqMethod");
		String mid = request.getParameter("mid");
		System.out.println("duplicatedId:" + reqMethod + ", mid:" + mid);
//		if (reqMethod != null && !reqMethod.isEmpty()) {
//			try {
//				boolean rst = MemberDAO.checkDuplicate(JdbcUtil.getConnection(), mid);
//				request.setAttribute("duplicatedId", rst);
//			} catch (SQLException e) {
//			}
//			return "/view/member/join.jsp";
//		}
		System.out.println("여기까지옴");
		Member member = new Member();
		
		member.setMid(request.getParameter("mid"));
		member.setMname(request.getParameter("mname"));
		member.setMpwd(request.getParameter("mpwd"));
		member.setMpwd2(request.getParameter("mpwd2"));
		member.setMemail(request.getParameter("memail")+"@"+request.getParameter("memail2"));
		member.setMhp(request.getParameter("mhp")+"-"+request.getParameter("mhp1")+"-"+request.getParameter("mhp2"));
		member.setMbd(request.getParameter("mbd"));
		
//		System.out.println("mid: "+memberReq.getMid());
//		System.out.println("mname: "+memberReq.getMname());
//		System.out.println("mpwd: "+memberReq.getMpwd());
//		System.out.println("mpwd2: "+memberReq.getMpwd2());
//		System.out.println("memail: "+memberReq.getMemail());
//		System.out.println("mhp: "+memberReq.getMhp());
//		System.out.println("mbd: "+memberReq.getMbd());
		
		//2.비즈니스로직수행(<->Service<->DAO<->DB)
		joinService.join(member);
		
		//3.Model
		//4.View지정
		return "/view/member/joinSuccess.jsp";
		
	}

}
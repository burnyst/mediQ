package controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.User;
import model.Member;
import controller.CommandHandler;


//마이페이지 요청을 담당하는 컨트롤러
public class MyinfoController implements CommandHandler {
	
	private static final String FORM_VIEW = "/view/member/myinfo.jsp";
	private MyinfoService myinfoService = new MyinfoService();
	
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("MyinfoController 진입성공");
		
		//할일
		//1.파라미터받기
				
		//2.비즈니스로직(<->Service<->DAO<->DB)
			
		//3.Model
		
		//4.View
		//GET방식으로  요청이 들어오면
		if(request.getMethod().equalsIgnoreCase("GET")) {
			System.out.println("joinForm.jsp의 method방식="+request.getMethod());
			return processForm(request,response);
		}else if(request.getMethod().equalsIgnoreCase("POST")) { //POST방식으로 요청이 들어오면
			System.out.println("joinForm.jsp의 method방식="+request.getMethod());
			return processSubmit(request,response);
		}else {
			//405에러
			response.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED); 
			return null;
		}	
		}

	//GET방식으로  요청이 들어오면  폼(/view/member/ModifyForm.jsp)을 보여주기
	private String processForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("MyinfoController의 processForm()호출");
		//할일
		//1.파라미터받기
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("AUTHUSER");
		String mid = user.getMid();
		System.out.println("세션에서 받은 id = "+mid);
		
		try {
			if(user==null) {
				response.setContentType("text/html; charset=UTF-8");				 
				PrintWriter out = response.getWriter();				 
				out.println("<script>alert('로그인하세요'); location.replace('login.do') </script>");				 
				out.flush();	
				out.close();
				return null;
			}else {
			String mmid = request.getParameter("mid");
			String mmname = request.getParameter("mname");
			String mmbd = request.getParameter("mbd");
			String mmemail = request.getParameter("memail");
			String mmhp = request.getParameter("mhp");
				
		//2.비즈니스로직(<->Service<->DAO<->DB)
			Member member = MyinfoService.getInfo(mid);
			System.out.println("MyinfoController-process(member)="+member);
			
			//3.Model
			request.setAttribute("member",member);
			
			//4.View
			return "/view/member/myinfo.jsp";
			}
		}catch(Exception e) {
			request.getServletContext().log("no article", e);
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			return null;
		}
	}
	
	private String processSubmit(HttpServletRequest request, HttpServletResponse response) {
//		//할일
//		//1.파라미터받기
//		Member mem = new Member();
//		
//		mem.setMid(request.getParameter("mid"));
//		mem.setMname(request.getParameter("mname"));
//		mem.setMbd(request.getParameter("mbd"));
//		mem.setMemail(request.getParameter("memail"));
//		mem.setMhp(request.getParameter("mhp"));
//		//2.비즈니스로직수행(<->Service<->DAO<->DB)
//		MyinfoUpdateService.myinfo(mem);
//			
//		//3.Model
//		
//		
//		//4.View지정
//		return "/view_member/myinfoUpdate.jsp";
		return null;
	}
}

package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Member;
import model.User;
import controller.CheckMpwdService;
public class XmemberController implements CommandHandler{

	private static final String FORM_VIEW = "/view/member/xmember.jsp";
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
	
	//GET방식으로  요청이 들어오면
			if(request.getMethod().equalsIgnoreCase("GET")) {
				return processForm(request,response);
			}else if(request.getMethod().equalsIgnoreCase("POST")) {//post방식으로 요청이 들어오면
				return processSubmit(request,response);
			}else {
				//405에러
				response.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
				return null;
			}
		}
		
		private String processForm(HttpServletRequest request, HttpServletResponse response) {
			System.out.println("XmemberController의 processFrom()호출");
			return FORM_VIEW;
		}
		
		//POST방식으로 요청이 들어오면 회원탈퇴 요청을 진행
		private String processSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
			//1. 요청파라미터 받기
			HttpSession session = request.getSession();
			User user = new User();
			//세션의 id(=AUTHUSER)에 해당하는 비번과 사용자가 입력한 비번이 같은지 확인
			user = (User) session.getAttribute("AUTHUSER");
			String mid = user.getMid();
			System.out.println(mid);
			String mpwd=request.getParameter("mpwd");
			String xreason=request.getParameter("xreason");
			
			System.out.print(mid+"님이 입력한 비밀번호는 "+mpwd+"입니다-");
			Boolean mpwdCheck=CheckMpwdService.check(mid,mpwd);
			
			System.out.println("비밀번호가 일치하는가?"+mpwdCheck);
			if(mpwdCheck == true) {
				XmemberService.update(mid,xreason);
				return "/view/member/xmemberSuccess.jsp";
			}else {
				return "/view/member/xmember.jsp";
			//3.Model
			//4.View지정
			}
		}
}

package controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Qnamodel;
import model.User;


public class QnamanagedetailController implements CommandHandler {

	private QnaManageDetailService qnamdetailservice = new QnaManageDetailService();
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("qnaManagedetailcontroller 호출 성공");
		
		String sn =request.getParameter("no");
		int no =Integer.parseInt(sn);
		String mid =request.getParameter("id");
		
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("AUTHUSER");
		
		try {
		//로그인을 안 했을시
		if(user==null) {
			response.setContentType("text/html; charset=UTF-8");				 
			PrintWriter out = response.getWriter();				 
			out.println("<script>alert('이 글은 작성자만 볼 수 있습니다.'); location.replace('qnalist.do') </script>");				 
			out.flush();	
			out.close();
			return null;
			}else if(user.getMlevel()==2){
				System.out.println("관리자 레벨");
				Qnamodel qma = qnamdetailservice.getAnswer(no);				
				request.setAttribute("qma", qma);
				return "qnalist.do";
			}else if(!(user.getMid().equals(mid))) {
			System.out.println("세션아이디와 등록아이디가 맞지않음");
			response.setContentType("text/html; charset=UTF-8");				 
			PrintWriter out = response.getWriter();				 
			out.println("<script>alert('이 글은 작성자만 볼 수 있습니다.');  location.replace('qnalist.do') </script>");				 
			out.flush();	
			out.close();
			return null;
		}else if( user.getMid().equals(mid)) {		
			System.out.println("세션아이디와 등록아이디가 일치");
			Qnamodel qma = qnamdetailservice.getAnswer(no);			
			request.setAttribute("qma", qma);
			return "qnalist.do";
		}else { return "qnalist.do";}
	}	catch(Exception e) {
		request.getServletContext().log("no article", e);
		response.sendError(HttpServletResponse.SC_NOT_FOUND);
		return null;
		}
	}   
}

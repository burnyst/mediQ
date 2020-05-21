package controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Qnamodel;
import model.User;

public class QnadetailController implements CommandHandler {
	
	private QnaDetailService qnadetailservice = new QnaDetailService();
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("qnadetailcontroller 호출 성공");
		//1.파라미터받기
		String noVal = request.getParameter("no");	//(게시글)글번호
		int no =Integer.parseInt(noVal);
		String mid =request.getParameter("id");
		System.out.println("no+id==>"+no+"/"+mid);
		//2.비즈니스로직(<->Service<->DAO<->DB)
		try {			
			//등록 글 id와 세션 id의 일치여부 
			HttpSession session = request.getSession();
			User user = (User)session.getAttribute("AUTHUSER");
			//String userid=user.getMid();
			System.out.println("detail user =>"+user);
			
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
					Qnamodel qm = qnadetailservice.getQna(no, true);
					request.setAttribute("qm",qm);
					request.setAttribute("user", user);		
					return "/view/cs/qna/qnadetail.jsp";
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
			//2-1.조회수증가 : 조회수증가시 true전달
			//2-2.상세내용조회
			Qnamodel qm = qnadetailservice.getQna(no, true);
			//3.Model
			request.setAttribute("qm",qm);		
			//4.View
			return "/view/cs/qna/qnadetail.jsp";
			}else { return "qnalist.do";}
			
		}catch(Exception e) {
			request.getServletContext().log("no article", e);
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			return null;
		}
	
	}
	}

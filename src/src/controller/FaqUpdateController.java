package controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Faq;
import model.FaqRequest;
import model.User;


public class FaqUpdateController implements CommandHandler{
	
	//View
	private static final String FORM_VIEW = "/view/cs/faq/faqupdate.jsp";

	//Service
	private FaqUpdateService updateService = new FaqUpdateService();
	private FaqReadService readService = new FaqReadService();
	Faq faq = new Faq();
	
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("FaqUpdateController의 process()진입");

		if(request.getMethod().equalsIgnoreCase("GET")) {
			System.out.println("FaqUpdate의 method방식="+request.getMethod());
			return processForm(request,response);
		}else if(request.getMethod().equalsIgnoreCase("POST")) { //POST방식으로 요청이 들어오면
			System.out.println("FaqUpdate의 method방식="+request.getMethod());
			return processSubmit(request,response);
		}else {
			//405에러
			response.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED); 
			return   null;
		}
	
	}

	private String processSubmit(HttpServletRequest request, HttpServletResponse response) 
				throws Exception{
		System.out.println("FaqUpdateController-수정처리processSubmit()");
		
		//파라미터 받기
		int sn = Integer.parseInt(request.getParameter("sn"));
		String category = request.getParameter("category");
		String title = request.getParameter("title");
		String contents = request.getParameter("contents");
		String mid = request.getParameter("mid");
		System.out.println("processSubmit sn="+sn+"/category="+category+"/title="+title+
				"/contents="+contents+"/mid="+mid);
		//비즈니스로직
		HttpSession session = request.getSession();
		User authUser = (User)session.getAttribute("authUser");

		
		//나중에 아이디 추가
		FaqRequest updateReq = new FaqRequest(
				sn,category, title, contents,mid);
		
		System.out.println("updateReq sn="+sn+"category="+category+"title="+title+
				"contents="+contents+"mid="+authUser.getMid());
		
		//에러정보
		Map<String,Boolean> errors = new HashMap<>();
		request.setAttribute("errors",errors);
		updateReq.validate(errors);
		if(!errors.isEmpty()) { //에러가 존재하면
			System.out.println("에러");
			return FORM_VIEW;   //수정폼으로 이동
		}
		
		//Model
		request.setAttribute("updateReq", updateReq);
		
		try {
			updateService.update(updateReq);
			return "/faqlist.do";
		}catch(FaqNotFoundException e) {
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			return null;
		}catch(PermissionDeniedException e) {
			response.sendError(HttpServletResponse.SC_FORBIDDEN);
			return null;
		}

	}

	private String processForm(HttpServletRequest request, HttpServletResponse response) 
		throws IOException{
		System.out.println("FaqUpdateController-수정처리processForm()");
		//파라미터받기
		int sn = Integer.parseInt(request.getParameter("sn"));
		String category = request.getParameter("category");
		String title = request.getParameter("title");
		String contents = request.getParameter("contents");
		String mid=request.getParameter("mid");
		
		System.out.println("process form sn="+sn+"category="+category+"title="+title+
				"contents="+contents+"mid="+mid);

		
		//비즈니스로직
		Faq faq = readService.getFaq(sn);
//		HttpSession session = request.getSession();
//		User authUser=(User)session.getAttribute("authUser");

	
		
//		if(!canUpdate(authUser,faq)) {
//			response.sendError(HttpServletResponse.SC_FORBIDDEN);
//			return null;
//		}
		
		
		
		
		FaqRequest updateReq = new FaqRequest(
				sn,category, title, contents,mid);
				System.out.println("processForm sn="+sn+"/category="+category+"/title="+title
							+"/contents="+contents+"/mid="+mid);
				
		
		//Model
		request.setAttribute("updateReq",updateReq);
		
		//View
		return FORM_VIEW;
		
	}

	
//	private boolean canModify(User authUser, Faq faq) {
//		//게시글작성자의 id
//		String writerId = faq.getMid();
//		
//		//로그인한유저의id.equals(게시글작성자의id)
//		return authUser.getId().equals(writerId);
//	}

	
	
	
	
}

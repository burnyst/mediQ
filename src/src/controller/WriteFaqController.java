package controller;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Faq;
import controller.CommandHandler;


public class WriteFaqController implements CommandHandler {

	//View
	private static final String FORM_VIEW = "/view/cs/faq/insertfaq.jsp";
	
	//Service
	private WriteFaqService writeService = new WriteFaqService();

	
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("WriteFaqController의 process()진입");
		
		if(request.getMethod().equalsIgnoreCase("GET")) {
			System.out.println("insertFaq.jsp의 method방식="+request.getMethod());
			return processForm(request,response);
		}else if(request.getMethod().equalsIgnoreCase("POST")) { //POST방식으로 요청이 들어오면
			System.out.println("insertFaq.jsp의 method방식="+request.getMethod());
			return processSubmit(request,response);
		}else {
			//405에러
			response.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED); 
			return   null;
		}
	
	}
	
	private String processForm(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("WriteFaqController의 processForm()호출");
		return FORM_VIEW;
	}

	
	private String processSubmit(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("WriteFaqController의 processSubmit()호출");
		Map<String , Boolean> errors = new HashMap<>();
		request.setAttribute("errors", errors);
		
		//파라미터 받기
		String title = request.getParameter("title");
		String contents = request.getParameter("contents");
		String category = request.getParameter("category");
	
	
		//회원 비지니스로직 수행 작성
	
	
	Faq writeFaq = createWriteRequest(category, title, contents);
	writeFaq.validate(errors);
	
	  if(!errors.isEmpty()) {
		  return FORM_VIEW; 
	  }
	  
	  //db에 insert성공시의 해당글번호가 newFaqNo에 리턴
	  int newFaqNo = writeService.write(writeFaq);
	  
	  request.setAttribute("newFaqNo",newFaqNo);
	  
	  return "/view/cs/faq/faqList.jsp";
	 

	}	


	


	private Faq createWriteRequest(String category, String title, String contents) {
		return new Faq(category,title,contents);
	}




	
}

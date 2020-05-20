package controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.News;
import newsService.NewsWriteService;
import model.User;

//p640
//글등록 폼 및 글등록 요청 담당 컨트롤러
/* 글등록 폼요청 /article/write.do	(GET방식)
 * 뷰		/view/article/newArticleForm.jsp 
 * 
 * 글등록 요청 	/article/write.do	(POST방식)
 * 성공시		/view/article/newArticleAccess.jsp
 * 실패시		/view/article/newArticleForm.jsp
 */
public class NewsWriteController implements controller.CommandHandler {
	//View
	private static final String FORM_VIEW =	"view/notice/news/newsInsert.jsp";   //view/notice/news/newsInsert.jsp..newsInsert.jsp
	//Service
	private NewsWriteService writeNewsService = 
			new NewsWriteService();
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("WriteArticleHandler의 process()진입");

		if(request.getMethod().equalsIgnoreCase("GET")) {
			System.out.println("newArticleForm.jsp의 method방식="+request.getMethod());
			return processForm(request,response);
		}else if(request.getMethod().equalsIgnoreCase("POST")) { //POST방식으로 요청이 들어오면
			System.out.println("newArticleForm.jsp의 method방식="+request.getMethod());
			return processSubmit(request,response);
		}else {
			//405에러
			response.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED); 
			return   null;
		}
	}
	
	//GET방식으로  요청이 들어오면  폼(/view/article/newArticleForm.jsp)을 보여주기
	private String processForm(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("WriteNewsHandler의 processForm()호출");
		return FORM_VIEW;
	}

	//P640 35
	//POST방식으로 요청이 들어오면
	private String processSubmit(HttpServletRequest request, 
			HttpServletResponse response) 
			throws Exception {
		System.out.println("WriteNewsHandler의 processSubmit()호출");
		
		Map<String, Boolean> errors = new HashMap<>();
		request.setAttribute("errors", errors);
		System.out.println("ERRORS"+errors);
		//1.파라미터받기
		String mid= request.getParameter("mid"); 
		String title = request.getParameter("title");
		String press = request.getParameter("press");
		String summary = request.getParameter("summary");
		String nimage = request.getParameter("nimage");		
		
		//2.비즈니스로직(<->Service<->DAO<->DB) p640 39
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("AUTHUSER");
		//글등록 p641 40
		WriteRequest writeReq = createWriteRequest(user, title,press, summary,nimage);
		writeReq.validate(errors);
		
		//유효성검사를 불통하여 글등록폼으로 이동
		if( !errors.isEmpty() ) {
			System.out.println("유효성검사");
			return FORM_VIEW;
		}
	
		//db에 insert성공시의  해당글번호가 newArticleNo에 리턴
		int newSn = 
			writeNewsService.insert(writeReq); //p641 47
		
		//3.Model(Request, session)
		request.setAttribute("newSn", newSn);

		//4.View
		return "newslist.do";
	}

	//p641 53
	private WriteRequest createWriteRequest(User user, String title, String summary, String nimage,String press) {
		return new WriteRequest
				(new User(user.getMid(),user.getMlevel()),title,summary,nimage,press);
	}//createWriteRequest
	//TimeStamp타입을 Date타입으로 변화 p648 47
		
}
/*
private QnaRequest createQnaRequest(User user,String title, String category, int qpublic, String question,String image) {
		return new QnaRequest(new User(user.getMid(),user.getMlevel()),title,category,qpublic,question,image);

	}
 */
















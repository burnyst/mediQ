package controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.News;



public class ModifyNewsController implements controller.CommandHandler {

	//View
	private static final String FORM_VIEW ="view/notice/news/newsModify.jsp";//view/notice/news/newsModify.jsp....newsModify.jsp
	
	//Service
	//수정처리용 서비스
	private ModifyNewsService modifynewsService =
			new ModifyNewsService();
//	private DetailNewsService detailnewsService=
//			new DetailNewsService();	
//	상세내용조회 서비스
	private ReadNewsService readService =
			new ReadNewsService();
//	News news = new News();
//	
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("ModifyNewsHandler의 process()진입");

		if(request.getMethod().equalsIgnoreCase("GET")) {
			System.out.println("ModifyNewsUpdate의 method방식="+request.getMethod());
			return processForm(request,response);
		}else if(request.getMethod().equalsIgnoreCase("POST")) { //POST방식으로 요청이 들어오면
			System.out.println("ModifyNewsUpdate의 method방식="+request.getMethod());
			return processSubmit(request,response);
		}else {
			//405에러
			response.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED); 
			return   null;
		}
	
	}

	//p670 66
	//수정폼에서 수정할내용을 받아서 수정처리 => update쿼리실행과 연결
	private String processSubmit(HttpServletRequest request, 
			HttpServletResponse response) throws Exception{
		System.out.println("ModifyNewsHandler-수정처리processSubmit()");
		
		//1.파라미터받기
		int sn = Integer.parseInt(request.getParameter("sn"));//글번호
		String title =request.getParameter("title");
		String summary = request.getParameter("summary");//글내용
		
//		String mid = request.getParameter("mid");
		
		//System.out.println("processSubmit sn="+sn+",mid="+mid+",title="+title+",summary="+summary);
		System.out.println("processSubmit sn="+sn+",title="+title+",summary="+summary);
		
		//2.비즈니스로직(<->Service<->DAO<->DB) p670 68
//		HttpSession session = request.getSession();
//		User authUser=(User)session.getAttribute("AUTHUSER"); //세션에 저장된 로그인유저의id,이름
		
		ModifyRequest modiReq = new ModifyRequest(				
				sn,title,summary);
		
		System.out.println("updateREq="+modiReq);
//		System.out.println("updateREq sn"+sn+"mid"+mid+"title"+title+"summary"+summary);
	
		
		
////		//에러정보 p677 77
//		Map<String,Boolean> errors = new HashMap<>();
//		request.setAttribute("errors",errors);
//		modiReq.validate(errors);
//		if(!errors.isEmpty()) { //에러가 존재하면 수정폼으로 이동.
//			return FORM_VIEW;
//		}
		
		//3.Model P670 75
		request.setAttribute("modiREQ", modiReq);
		
		modifynewsService.modify(modiReq);
		
		//4.View
		return "view/notice/news/newsModify.jsp";
		//view/notice/news/newsModify.jsp....newsModify.jsp
	}
	//p669 38
	private String processForm(HttpServletRequest request, 
			HttpServletResponse response) throws IOException {
		System.out.println("NewsUpdateController-수정처리processForm()");
		
		//1.파라미터받기
		int sn = Integer.parseInt(request.getParameter("sn")); //글번호
//		String mid = request.getParameter("mid");
		String title =request.getParameter("title");
		String summary = request.getParameter("summary");//글내용
		
		System.out.println("processForm sn"+sn+"title"+title+"summary"+summary);
		
		//2.비즈니스로직(<->Service<->DAO<->DB)
		News news = readService.getNews(sn);
		
//		HttpSession session = request.getSession();
//		User authUser=(User)session.getAttribute("AUTHUSER"); //세션에 저장된 로그인유저의id,이름
//		News newsd = readService.getNews(sn);
		
//		//ModifyRequest는 p666
		ModifyRequest modiReq = new ModifyRequest(
				sn,title,summary
			);
		System.out.println("sn"+sn+"/title="+title);
		
		
		//3.Model P670 53
		request.setAttribute("news", news);
		
		//4.View
		return FORM_VIEW;
	}


}








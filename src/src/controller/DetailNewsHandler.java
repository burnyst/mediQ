package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.News;

public class DetailNewsHandler implements controller.CommandHandler {

	private DetailNewsService DetailnewsService =	new DetailNewsService();

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//해야할일
		System.out.println("DetailNewsHandler 호출 성공");
		//1.파라미터 받기
			String title= request.getParameter("title");//(게시글)제목
			int sn = Integer.parseInt(request.getParameter("sn"));
			String pageNo = request.getParameter("pageNo");// 보고싶은 페이지(릴레이용)
		//2.비즈니스로직 수행(<->Service <-> DAO <- >DB)
		try {
			//p660 22
			//2-1조회수 증가 : 조회수 증가시 true 전달
			//2-2 상세내용 조회
			News newsd =DetailnewsService.getNews(sn);
			
			//3.MODEL
			request.setAttribute("newsd",newsd);
			
			//4.VIEw
			return "newsDetail.jsp";
			
		}catch(Exception e) {
			request.getServletContext().log("no article",e);
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			return null;
		}
			
	}

}

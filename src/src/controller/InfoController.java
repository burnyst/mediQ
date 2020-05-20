package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import page.InfoPage;

public class InfoController implements CommandHandler {

	private InfoListService listService = new InfoListService();
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		System.out.println("InfoController 호출 성공");
		return "/view/product/infolist.jsp";
}


}



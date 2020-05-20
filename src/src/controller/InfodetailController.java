package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.InfoModel;

public class InfodetailController implements CommandHandler {
	
	private InfodetailService InfodetailService = new InfodetailService();

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		System.out.println("infodetailcontroller 호출 성공");
		String noVal = req.getParameter("item_Name");	//(게시글)글번호
		//2.비즈니스로직(<->Service<->DAO<->DB)
		try {
			//2-1.조회수증가 : 조회수증가시 true전달
			//2-2.상세내용조회
			InfoModel im = InfodetailService.getinfo(null);
			//3.Model
			req.setAttribute("im",im);
			//request.setAttribute("pageNo",pageNo);//보고싶은페이지(릴레이용)
			
			//4.View
			return "/view/product/Infodetail.jsp";
		}catch(Exception e) {
			req.getServletContext().log("no article", e);
			res.sendError(HttpServletResponse.SC_NOT_FOUND);
			return null;
		}
	
	}
	}

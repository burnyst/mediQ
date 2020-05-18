package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Qnamodel;


public class QnamanagedetailController implements CommandHandler {

	private QnaManageDetailService qnamdetailservice = new QnaManageDetailService();
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("qnaManagedetailcontroller 호출 성공");
		
		String sn =request.getParameter("no");
		int no =Integer.parseInt(sn);
		try {
		Qnamodel qma = qnamdetailservice.getAnswer(no);
		
		request.setAttribute("qma", qma);
		return "qnalist.do";
	}	catch(Exception e) {
		request.getServletContext().log("no article", e);
		response.sendError(HttpServletResponse.SC_NOT_FOUND);
		return null;
		}
	}
}

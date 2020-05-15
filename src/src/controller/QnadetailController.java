package controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Qna;
import dbcp.JdbcUtil;
import model.Qnamodel;

public class QnadetailController implements CommandHandler {
	
	private QnaDetailService qnadetailservice = new QnaDetailService();
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("qnadetailcontroller 호출 성공");
		//1.파라미터받기
		String noVal = request.getParameter("no");	//(게시글)글번호
		int no =Integer.parseInt(noVal);
		System.out.println("no==>"+no);
		//2.비즈니스로직(<->Service<->DAO<->DB)
		try {
			//2-1.조회수증가 : 조회수증가시 true전달
			//2-2.상세내용조회
			Qnamodel qm = qnadetailservice.getQna(no, true);
			//3.Model
			request.setAttribute("qm",qm);
			//request.setAttribute("pageNo",pageNo);//보고싶은페이지(릴레이용)
			
			//4.View
			return "/view/cs/qna/qnadetail.jsp";
		}catch(Exception e) {
			request.getServletContext().log("no article", e);
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			return null;
		}
	
	}
	}

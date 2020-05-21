package controller;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.QnaDAO;
import dbcp.JdbcUtil;

public class QnadeleteController  implements CommandHandler  {

	private static final String FORM_VIEW = "qnalist.do";	
	QnaDAO qnaDao = new QnaDAO();
	@Override
	public String process(HttpServletRequest request, 
						  HttpServletResponse response) throws Exception {
		System.out.println("qnadeletecontroller진입성공");
		
				if(request.getMethod().equalsIgnoreCase("GET")) { 		
					return processSubmit(request,response);
				}else if(request.getMethod().equalsIgnoreCase("POST")) { //POST방식으로 요청이 들어오면
					return processSubmitQ(request,response);
				}else {
					//405에러
					response.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED); 
					return   null;
				}	
	}
	
	//Get 방식 답변삭제
	private String processSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("qnaDcontroller의 processSubmit()호출");	
		int sn =(Integer.parseInt(request.getParameter("no")));
		System.out.println("deleteA의 sn"+ sn);
		Connection conn  = null;
		try {
			conn = JdbcUtil.getConnection();
			conn.setAutoCommit(false);//트랜잭션 시작
			
			//특정글 번호 조회 및 삭제
			qnaDao.deleteA(conn,sn);				
			
			conn.commit();				
			return FORM_VIEW ;
	}catch(SQLException e) {
		JdbcUtil.rollback(conn);
		throw new RuntimeException(e);
	}finally {
		JdbcUtil.close(conn);
	}
	}//processSubmit end
	
	//Post 방식 질문삭제
	private String processSubmitQ(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("qnaDcontroller의 processSubmitQ()호출");	
		int sn=(Integer.parseInt(request.getParameter("no")));
		Connection conn  = null;
		try {
			conn = JdbcUtil.getConnection();
			conn.setAutoCommit(false);//트랜잭션 시작
			
			//특정글 번호 조회 및 삭제
			qnaDao.deleteQ(conn,sn);				
			
			conn.commit();				
			return FORM_VIEW ;
	}catch(SQLException e) {
		JdbcUtil.rollback(conn);
		throw new RuntimeException(e);
	}finally {
		JdbcUtil.close(conn);
	}
	}//processSubmit end
	
	
}

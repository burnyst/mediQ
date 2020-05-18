package controller;

import java.sql.Connection;
import java.sql.SQLException;

import dao.NewsDAO;
import dbcp.JdbcUtil;
import model.News;

//p658
//게시글 상세조회 요청 컨트롤러에서 호출하는 서비스클래스
public class DetailNewsService {
	
	//DAO테이블과 연동
	private NewsDAO newsDao = new NewsDAO();
	public News getNews (String title) {
		System.out.println("DetailNewsHandler getNewsDao호출성공");
		try {
		Connection conn = 
				JdbcUtil.getConnection();	
		
		//특정글번호 article조회
		News newd =newsDao.selectById(conn,title);
		
		if(newd==null) { //특정글번호 title 조회 실패p659 20
			try {
				throw new Exception();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
				
		return newd;
		
		}catch(SQLException e) {
			throw new RuntimeException(e);
	
	}
		
	}
	
}


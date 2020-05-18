package controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

import dao.NewsDAO;
import dbcp.JdbcUtil;
import model.News;
//p658
//게시글 상세조회 요청 컨트롤러에서 호출하는 서비스클래스
public class ReadNewsService {
	
	//News테이블과 연동
	private NewsDAO newsDao = new NewsDAO();
	
	
	public News getNews(int sn) {
	try {
		Connection conn = 
				JdbcUtil.getConnection();
		//특정 article조회
		News newsd = newsDao.selectBySn(conn,sn);
		
		if(newsd==null) { //특정글번호 article 조회 실패p659 20
			try {
				throw new Exception();
			} catch (Exception e) {
				
				e.printStackTrace();
			}
		}
		return newsd;
		
		}catch(SQLException e) {
			throw new RuntimeException(e);
	
	}
		
	}
	
}


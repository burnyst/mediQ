package controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import dao.NewsDAO;
import dbcp.JdbcUtil;
import model.News;

//p638
//글등록과 관련한 DAO와 연동
public class WriteNewsService {

	//article테이블과 연동하는  DAO
	private NewsDAO newsDao = new NewsDAO();
	
	
	//P639 19
	public int insert(WriteRequest req) {
		System.out.println("WriteNewsService -insert()호출");
		Connection conn = null;
		try {
			conn = JdbcUtil.getConnection();
			conn.setAutoCommit(false); //트랜잭션시작
			/*"insert into news String mid, String title,String press, String summary,Date rdate, String nimage " + 
		" values(?,?,?,?,?,?);*/
		
			//dao호출 p639 25
			News news = toNews(req);
			News savednews = newsDao.insert(conn,news);
			
			if(savednews==null) {//insert실패하면 null리턴
			 throw new RuntimeException("failt to insert article");
			}
			System.out.println("news.getSn()"+news.getSn());
			conn.commit(); //트랜잭션반영
			return savednews.getSn();
		}catch(SQLException e) {
			JdbcUtil.rollback(conn);
			throw new RuntimeException(e);
		}catch(RuntimeException e) {
			JdbcUtil.rollback(conn);
			throw e;
		}
	}

	private News toNews(WriteRequest req) {
		Date now = new Date();
		return new News(req.getSn(),req.getMid(),req.getTitle()
				,req.getPress(),req.getSummary(),now,req.getNimage());
	}

	
	

	
	

}








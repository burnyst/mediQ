package controller;

import java.sql.Connection;
import dao.NewsDAO;
import dbcp.JdbcUtil;
import model.News;


//667
//수정처리요청 컨트롤러에서 호출하는 서비스 클래스
public class ModifyNewsService {
	
	private NewsDAO newsDao = new NewsDAO();
	
	public void modify(ModifyRequest modiReq) {
		Connection conn =null;
		try {
			conn = JdbcUtil.getConnection();
			conn.setAutoCommit(false);
			
			//p667 23
			//articleDao.selectByID p655 1
			News news = newsDao.selectBySn(conn,modiReq.getSn());
			if(news==null) { //게시글이 없으면
				throw new Exception();
			}
			
			//정상적인 코드
			//p668 31
			//news테이블에 해당게시글 제목 수정
			newsDao.update(conn,modiReq.getSummary(),modiReq.getTitle(),modiReq.getSn());		
			
			conn.commit();
			
		}catch(Exception e) {
			JdbcUtil.rollback(conn);
			throw new RuntimeException();
		}finally {
			JdbcUtil.close(conn);
		}
		}
			
		
		
		
	}
	


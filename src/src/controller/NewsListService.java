package controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import dao.NewsDAO;
import dbcp.JdbcUtil;
import model.News;
import page.NewsPage;

//전체목록보기 요청 담당 컨트롤러에서 호출하는 서비스클래스
//p650
//DAO와 연동
public class NewsListService {

	private NewsDAO newsDao = new NewsDAO();
	private int size = 10; //한 페이지당 출력할 게시글 수
	//한 페이지당 출력할 게시글 수가 10개라면 size는 10
	
	//페이지정보
	public NewsPage getNewsPage(int pageNo) {
		try {
			Connection conn = JdbcUtil.getConnection();
			
			//전체 게시글수 조회
			int totalCount = NewsDAO.selectCount(conn);
			
			//특정페이지에 해당하는 게시글목록 조회
			//select(conn, 시작행번호, 가져올게시글수)
			//시작행번호는 0부터 시작되므로 첫게시글은 -1해야한다
			//보고싶은 페이지(pageNo)가 1이면 첫게시글의 인덱스번호는 0이되어야 한다
			
			List<News> content = 
				NewsDAO.select(conn, (pageNo-1)*size, size);
			
			//페이지정보가 포함된 내용을 리턴을 해줘야 한다
			return new NewsPage(totalCount, pageNo, size, content);
			
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
}








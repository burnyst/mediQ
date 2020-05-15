package controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import dao.Qna;
import dbcp.JdbcUtil;
import model.Qnamodel;
import page.QnaPage;

public class QnaListService {
	private Qna qna = new Qna();
	private int size = 10; //한 페이지당 출력할 게시글 수
	//페이지정보
	public QnaPage getQnaPage(int pageNo) {
		try {
			Connection conn = JdbcUtil.getConnection();
			
			//전체 게시글수 조회
			int total = Qna.selectCount(conn);
			//특정페이지에 해당하는 게시글목록 조회s
			//select(conn, 시작행번호, 가져올게시글수)
			//시작행번호는 0부터 시작되므로 첫게시글은 -1해야한다
			//보고싶은 페이지(pageNo)가 1이면 첫게시글의 인덱스번호는 0이되어야 한다
			
			List<Qnamodel> question= 
				qna.select(conn, (pageNo-1)*size, size);
			
			//페이지정보가 포함된 내용을 리턴을 해줘야 한다
			return new QnaPage(total, pageNo, size, question);
			
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
}

package controller;

import java.sql.Connection;
import java.sql.SQLException;

import dao.QnaDAO;
import dbcp.JdbcUtil;
import model.QnaRequest;
import model.Qnamodel;

public class QnaManageUpdateService {
	private QnaDAO qnaDao = new QnaDAO();
	
	public void updateAnswer(QnaRequest qnareq) {
		System.out.println("QnamanageUpdateService updateAnswer호출성공");
		Connection conn  = null;
		try {
			conn = JdbcUtil.getConnection();
			conn.setAutoCommit(false);//트랜잭션 시작
			
			//특정글 번호 조회
			Qnamodel qm = qnaDao.selectById(conn,qnareq.getSn());				
			
			//qnamodel테이블에 해당게시글의 답변등록
			qnaDao.update(conn,qnareq.getAnswer(),qnareq.getSn());
			
			conn.commit();				
			
	}catch(SQLException e) {
		JdbcUtil.rollback(conn);
		throw new RuntimeException(e);
	}finally {
		JdbcUtil.close(conn);
	}
	}

}

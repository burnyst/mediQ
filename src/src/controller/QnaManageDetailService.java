package controller;

import java.sql.Connection;
import java.sql.SQLException;

import dao.QnaDAO;
import dbcp.JdbcUtil;
import model.Qnamodel;


public class QnaManageDetailService {

	private QnaDAO qnaDao = new QnaDAO();
	
	public Qnamodel getAnswer(int no) {
		System.out.println("QnaMagagedetailservice getAnswer호출성공");
		Connection conn  = null;
		try {
			conn  = JdbcUtil.getConnection();
			
			Qnamodel qma = qnaDao.answerDetail(conn,no);
			return qma;
			
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}finally {
			JdbcUtil.close(conn);
		}
	}
}

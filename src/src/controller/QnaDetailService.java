package controller;

import java.sql.Connection;
import java.sql.SQLException;

import dao.QnaDAO;
import dbcp.JdbcUtil;
import model.Qnamodel;

public class QnaDetailService {

	private QnaDAO qnaDao = new QnaDAO();
	public Qnamodel getQna(int  no, boolean  incrementVCount) {
		System.out.println("Qnadetailservice getQna호출성공");
		Connection conn = null;
		try {
			conn  = JdbcUtil.getConnection();
			
			//특정글번호조회
			Qnamodel qm = qnaDao.selectById(conn, no);
			//조회수증가
			if( incrementVCount==true ) {
				qnaDao.incrementVCount(conn,no);
			}		
			System.out.println("qm==>"+qm);
			return qm;
			
	}catch(SQLException e) {
		throw new RuntimeException(e);
	}finally {
		JdbcUtil.close(conn);
	}
}
}

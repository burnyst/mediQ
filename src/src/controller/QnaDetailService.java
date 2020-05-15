package controller;

import java.sql.Connection;
import java.sql.SQLException;

import dao.Qna;
import dbcp.JdbcUtil;
import model.Qnamodel;

public class QnaDetailService {

	private Qna qnaDao = new Qna();
	public Qnamodel getQna(int  no, boolean  incrementVCount) {
		System.out.println("Qnadetailcontroller getQna호출성공");
		try {
			Connection conn  =
				JdbcUtil.getConnection();
			
			//특정글번호 article조회
			Qnamodel qm = qnaDao.selectById(conn, no);
			//조회수증가
			if( incrementVCount==true ) {
				qnaDao.incrementVCount(conn,no);
			}		
			System.out.println("qm==>"+qm);
			return qm;
			
	}catch(SQLException e) {
		throw new RuntimeException(e);
	}
}
}

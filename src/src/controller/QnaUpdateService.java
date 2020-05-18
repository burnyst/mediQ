package controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

import dao.QnaDAO;
import dbcp.JdbcUtil;
import model.QnaRequest;
import model.Qnamodel;
import dbcp.JdbcUtil;

//p596
//JoinHandler에서  호출
//회원가입기능을 제공 => DAO연동
public class QnaUpdateService {

	private QnaDAO qnaDao = new QnaDAO();
	
	
	//회원가입처리요청 p596-16  m801-832-38
	//qnaupdateconttoller에서  호출
	public  int update(QnaRequest qnaReq) {
		System.out.println("QnaUpdateService -update()호출");
		Connection conn = null;
		try {
			conn = JdbcUtil.getConnection();
			conn.setAutoCommit(false);//트랜잭션 시작
			
			//dao호출 
			Qnamodel qm = toqm(qnaReq);
			Qnamodel  savedQm = qnaDao.insert(conn,qm);
			
			if(savedQm==null) {//insert실패하면 
				 throw new RuntimeException("failt to insert qna");
				}
			System.out.println("qm.getSn()"+qm.getSn());
			conn.commit(); //트랙잭션 반영
			return   savedQm.getSn() ;
		}catch(SQLException e) {
			JdbcUtil.rollback(conn); //트랙잭션 취소
			throw new RuntimeException(e);
		}catch(RuntimeException e) {
			JdbcUtil.rollback(conn);
			throw e;
		}finally {
			JdbcUtil.close(conn);
		}
		
	}//end of update

	//★sn은 새로 생성되는 번호, mid 세션에서 받음  현재는 qnaReq.getSn() qnaReq.getMid() 해놓음
	//나머지 데이터를 채우는 함수 
	private Qnamodel toqm(QnaRequest qnaReq) {
		Date now = new Date();
		return new Qnamodel(qnaReq.getSn(),qnaReq.getTitle(),qnaReq.getCategory(),qnaReq.getQpublic(),0,"testid",now,qnaReq.getQuestion(),
				"answer",qnaReq.getImage(),0);
	}
	
}//end of class







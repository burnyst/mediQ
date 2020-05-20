package controller;

import java.sql.Connection;
import java.sql.SQLException;

import dbcp.JdbcUtil;
import dao.MemberDAO;
import model.Member;
import controller.DuplicateIdException;

public class JoinService {

	private MemberDAO memberDao = new MemberDAO();
	
	//회원가입처리요청과 관련된 함수 p.596 line 16
	public void join(MemberRequest joinReq) {
		Connection conn = null;
		try {
			conn = JdbcUtil.getConnection();
			conn.setAutoCommit(false);//트랜잭션시작
			
			//p.596 line 22-26 추가예정
			Member member = memberDao.selectById(conn, joinReq.getMid());
			if(member != null) {
				JdbcUtil.rollback(conn);
				throw new DuplicateIdException();
			}
			
			//p.596 line28
			memberDao.insert(conn, new Member(
									joinReq.getMid(), joinReq.getMname(),
									joinReq.getMpwd(), joinReq.getMemail(),
									joinReq.getMhp(), joinReq.getMbd(), joinReq.getMlevel()
			));
			conn.commit();//트랜잭션 반영
		}catch(SQLException e) {
			JdbcUtil.rollback(conn);	//트랜잭션 cancel
			throw new RuntimeException(e);
		}finally{
			JdbcUtil.close(conn);
		}//try
	}//end of join

	
	//회원가입시 id존재여부 체크
	public String searchId(String mid) {
		System.out.println("JoinService searchId(mid)="+mid);
		Connection conn = null;
		String result=null;
		try {
			conn = JdbcUtil.getConnection();
			result=memberDao.searchId(conn,mid);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			JdbcUtil.close(conn);
		}
		System.out.println("서비스의 리턴result="+result);
		return result;
	}
	
}

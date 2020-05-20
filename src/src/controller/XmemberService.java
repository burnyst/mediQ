package controller;

import java.sql.Connection;
import java.sql.SQLException;

import dao.MemberDAO;
import dbcp.JdbcUtil;

//회원탈퇴 관련 클래서
public class XmemberService {
	public static void update(String mid, String xreason) throws Exception {
		Connection conn = null;
		try {
			conn = JdbcUtil.getConnection();
			conn.setAutoCommit(false);//트랜잭션시작
			
			MemberDAO memberDao = new MemberDAO();
			
			memberDao.updateXmember(mid,xreason);
			conn.commit();//트랜잭션 반영
		}catch(SQLException e) {
			JdbcUtil.rollback(conn);	//트랜잭션 cancel
			throw new RuntimeException(e);
		}finally{
			JdbcUtil.close(conn);
		}//try
	}
}

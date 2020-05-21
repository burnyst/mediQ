package controller;

import java.sql.Connection;
import java.sql.SQLException;

import dao.MemberDAO;
import dbcp.JdbcUtil;

//회원탈퇴 폼에 입력한 비밀번호가 db의 비밀번호와 일치하는지 확인하는 클래스
public class CheckMpwdService {
	public static Boolean check(String mid, String mpwd) throws Exception {
		Connection conn = null;
		try {
			conn = JdbcUtil.getConnection();
			conn.setAutoCommit(false);//트랜잭션시작
			
			MemberDAO memberDao = new MemberDAO();
			
			Boolean mpwdCheck=memberDao.checkMpwd(conn,mid,mpwd);
			conn.commit();//트랜잭션 반영
			return mpwdCheck;
		}catch(SQLException e) {
			JdbcUtil.rollback(conn);	//트랜잭션 cancel
			throw new RuntimeException(e);
		}finally{
			JdbcUtil.close(conn);
		}//try
	}

}

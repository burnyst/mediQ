package controller;

import java.sql.Connection;
import java.sql.SQLException;

import dao.MemberDAO;
import dbcp.JdbcUtil;
import model.Member;
import model.MemberRequest;

public class MyinfoService {

	public void update(MemberRequest myinfoReq) throws SQLException {
		Connection conn = null;
		Member member = new Member();
		
		try {
			conn = JdbcUtil.getConnection();
			conn.setAutoCommit(false);
			
			MemberDAO memberDao = new MemberDAO();
			memberDao.insert(conn, member);
			
			if(memberDao != null) {
				JdbcUtil.rollback(conn);
				throw new DuplicateIdException();
			}
		}finally {
			
		}
	}

}

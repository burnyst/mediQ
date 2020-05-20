package controller;

import java.sql.Connection;
import java.sql.SQLException;
import dao.MemberDAO;
import dbcp.JdbcUtil;
import model.Member;

public class MyinfoUpdateService {
	
	private static MemberDAO memberDao = new MemberDAO();
	
	//마이페이지 처리 요청
	//MyinfoUpdateController에서 호출
	public static Member myinfo(Member mem) {
		Connection conn =null;
		System.out.println("MyinfoService의 myinfo()호출");
		try {
			conn=JdbcUtil.getConnection();
			conn.setAutoCommit(false);
			
			memberDao.update(conn,
					new Member(
						// 조건-> controller에
						//다 입력하지 않아도 수정 가능
						//현재 데이터와 다른 정보로만 수정 가능
						mem.getMpwd(),
						mem.getMpwd2(),
						mem.getMemail(),
						mem.getMhp()
						)
					);
			//트랜잭션 반영
			conn.commit();
		}catch(SQLException e) {
			JdbcUtil.rollback(conn);	//트랜잭션 취소
			throw new RuntimeException(e);
		}finally {
			JdbcUtil.close(conn);
		}
		return mem;
	}

	public static Member myinfo(String mid) {
		return null;
	}
}

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
	public static Member getInfo(String mid) {
		System.out.println("MyinfoService호출성공");
		Connection conn = null;
		try {
			conn = JdbcUtil.getConnection();
			
			Member minfo = memberDao.selectById(conn, mid);
			return minfo;
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}finally {
			JdbcUtil.close(conn);
		}

	}
	
	public void InfoUpdateService(String mid, String mpwd, String memail, String mhp) {
		System.out.println("InfoService호출성공");
		Connection conn = null;
		try {
			conn = JdbcUtil.getConnection();
			
			memberDao.updateMyinfo(conn, mid, mpwd, memail, mhp);
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}finally {
			JdbcUtil.close(conn);
		}
	}
	

}

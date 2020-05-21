package controller;

import java.sql.Connection;
import java.sql.SQLException;

import dao.MemberDAO;
import dbcp.JdbcUtil;
import model.Member;

public class MyinfoService {

	private static MemberDAO memberDao = new MemberDAO();
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
}

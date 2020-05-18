package controller;

import java.sql.Connection;
import java.sql.SQLException;

import controller.LoginFailException;
import model.User;
import dao.MemberDAO;
import dbcp.JdbcUtil;
import model.Member;

public class LoginService {
	private MemberDAO memberDao = new MemberDAO();
	
	//회원가입처리요청과 관련된 함수 p.596 line 16
	public User login(String mid, String mpwd) {
		Connection conn = null;
		try {conn = JdbcUtil.getConnection();
			
			Member member = memberDao.selectById(conn, mid);
			if(member != null) {
				throw new LoginFailException();
			}
			
			if (!member.matchPassword(mpwd)) {
				throw new LoginFailException();
			}
			return new User(member.getMid(), member.getMname(), member.getMlevel());
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
}

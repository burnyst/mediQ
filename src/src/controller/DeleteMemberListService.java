package controller;

import java.sql.Connection;
import java.sql.SQLException;

import dao.MemberListDAO;
import dbcp.JdbcUtil;


public class DeleteMemberListService {
	
	private MemberListDAO memberlistDAO = new MemberListDAO();

	public void delete(String mid) {
		Connection conn = null;
		try {
			conn = JdbcUtil.getConnection();
			conn.setAutoCommit(false);
			memberlistDAO.delete(conn,mid);
			
			conn.commit();
			
		}catch(SQLException e) {
			JdbcUtil.rollback(conn);
			throw new RuntimeException(e);
		}catch(RuntimeException e) {
			JdbcUtil.rollback(conn);
			throw e;
		}finally {
			JdbcUtil.close(conn);
		}
	}

}

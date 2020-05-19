package controller;

import java.sql.Connection;
import java.sql.SQLException;

import dao.NewsDAO;
import dbcp.JdbcUtil;


public class NewsDeleteService {
	
	private NewsDAO newsDAO = new NewsDAO();

	public void delete(int sn) {
		Connection conn = null;
		try {
			conn = JdbcUtil.getConnection();
			conn.setAutoCommit(false);
			newsDAO.delete(conn,sn);
			
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

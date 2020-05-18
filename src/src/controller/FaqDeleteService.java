package controller;

import java.sql.Connection;
import java.sql.SQLException;

import dao.FaqDAO;
import dbcp.JdbcUtil;


public class FaqDeleteService {
	
	private FaqDAO faqDAO = new FaqDAO();

	public void delete(int sn) {
		Connection conn = null;
		try {
			conn = JdbcUtil.getConnection();
			conn.setAutoCommit(false);
			faqDAO.delete(conn,sn);
			
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

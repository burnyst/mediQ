package controller;

import java.sql.Connection;
import java.sql.SQLException;

import dao.InfoDAO;
import dbcp.JdbcUtil;

public class DeleteInfoService {

	private InfoDAO infoDAO = new InfoDAO();

	public void delete(String itemName) {
		Connection conn = null;
		try {
			conn = JdbcUtil.getConnection();
			conn.setAutoCommit(false);
			InfoDAO.delete(conn, itemName);
			
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

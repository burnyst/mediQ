package controller;

import java.sql.Connection;
import java.sql.SQLException;

import dao.InfoDAO;
import dbcp.JdbcUtil;
import model.InfoContent;
import model.InfoModel;
import model.InfoRequest;
import model.ModiRequest;

public class ModiInfoService {

		private InfoDAO infoDao = new InfoDAO();
		
		public void update(ModiRequest updateReq) {
			Connection conn = null;
			System.out.println("modiInfoService -modify()호출");
			try {
				conn = JdbcUtil.getConnection();
				conn.setAutoCommit(false); //트랜잭션 시작
				
				//dao호출
				InfoModel savedinfo = infoDao.selectById(conn, updateReq.getItemName());
				if(savedinfo == null) { //insert실패
					throw new RuntimeException("fail to modi info");
				}
			
				
				infoDao.update(conn, updateReq.getItemSeq(), updateReq.getItemName(), updateReq.getEntpName(), updateReq.getItemPermitDate(), updateReq.getCancelDate(), updateReq.getEtcOtcCode(), updateReq.getChangeDate(), updateReq.getChart(), updateReq.getClassNo(),
					updateReq.getPackUnit(), updateReq.getNbDocData(), updateReq.getEeDocData(), updateReq.getUdDocData());
			
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

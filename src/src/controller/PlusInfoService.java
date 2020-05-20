package controller;

import java.sql.Connection;
import java.sql.SQLException;

import dao.InfoContentDAO;
import dao.InfoDAO;
import dbcp.JdbcUtil;
import model.InfoContent;
import model.InfoModel;
import model.InfoRequest;

public class PlusInfoService {

	private InfoDAO infoDao = new InfoDAO();
	
	public String plus(InfoRequest inforeq) {
		System.out.println("PlusInfoService -update(inforeq)호출="+inforeq);

		Connection conn = null;
		try {
			conn = JdbcUtil.getConnection();
			conn.setAutoCommit(false);
			
			//dao호출
			InfoModel info = toinfo(inforeq);
			InfoModel savedinfo = infoDao.insert(conn,info);
			if(savedinfo == null) { //insert실패
				throw new RuntimeException("fail to insert info");
			}
			System.out.println("info호출="+info);
			
		conn.commit(); //트랜잭션 반영
		return savedinfo.getItemName();
		
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

	private InfoModel toinfo(InfoRequest inforeq) {
		return new InfoModel(inforeq.getItemSeq(),inforeq.getItemName(),inforeq.getEntpName(),inforeq.getItemPermitDate()
				,inforeq.getNbDocData(),inforeq.getCancelDate(),inforeq.getEeDocData(),inforeq.getEtcOtcCode(),inforeq.getUdDocData(),
				inforeq.getChangeDate(),inforeq.getClassNo(),inforeq.getChart(),inforeq.getPackUnit());
	}	
}
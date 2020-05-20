package controller;

import java.sql.Connection;
import java.sql.SQLException;

import dao.InfoDAO;
import dbcp.JdbcUtil;
import model.InfoModel;


public class InfoReadService {

	private InfoDAO infoDao = new InfoDAO();
	public InfoModel getInfo(String itemName) {
		System.out.println("InfoDetail칸트롤러 getNewsDao호출성공");
		try {
		Connection conn = 
				JdbcUtil.getConnection();	
		
		//특정글번호 article조회
		InfoModel infod =infoDao.selectById(conn,itemName);
		
		if(infod==null) { //특정글번호 title 조회 실패p659 20
			try {
				throw new Exception();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
				
		return infod;
		
		}catch(SQLException e) {
			throw new RuntimeException(e);
	
	}
		
	}
	
}

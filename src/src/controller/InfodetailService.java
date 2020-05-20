package controller;

import java.sql.Connection;
import java.sql.SQLException;

import dao.InfoDAO;
import dbcp.JdbcUtil;
import model.InfoModel;

	public class InfodetailService {

		private InfoDAO infodao = new InfoDAO();
		public InfoModel getinfo(String itemName) {
			System.out.println("infodetailcontroller getInfo호출성공");
			try {
				Connection conn  =
					JdbcUtil.getConnection();
				
				//특정글번호 article조회
				InfoModel Im = infodao.selectById(conn,itemName);
				//조회수증가
				if(Im==null) {	//특정글번호 faq조회 실패
					throw new InfoNotFoundException();
				}
				
				
				System.out.println("Im==>"+Im);
				return Im;
				
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	}

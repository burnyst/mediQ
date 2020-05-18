package controller;

import java.sql.Connection;
import java.sql.SQLException;

import dao.FaqDAO;
import dbcp.JdbcUtil;
import model.Faq;

public class FaqReadService {

	private FaqDAO faqDao = new FaqDAO();
	
	public Faq getFaq(int sn) {
		try {
			Connection conn = JdbcUtil.getConnection();
			
			//특정글번호 faq조회
			Faq faq=faqDao.selectById(conn, sn);
			
			if(faq==null) {	//특정글번호 faq조회 실패
				throw new FaqNotFoundException();
			}
			return faq;
		
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
	
}

package controller;

import java.sql.Connection;
import java.sql.SQLException;

import dao.FaqDAO;
import dbcp.JdbcUtil;
import model.Faq;

public class FaqCountService {

	private FaqDAO faqDAO = new FaqDAO();

	public Faq getVcount(int sn, boolean vcount) {
		System.out.println("getVcount호출성공");
		try {
			Connection conn = JdbcUtil.getConnection();
			
			Faq faq =faqDAO.selectById(conn, sn);
			//조회수 증가
			if(vcount==true) {
				faqDAO.vcount(conn, sn);
			}
			
			return faq;
			
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
}

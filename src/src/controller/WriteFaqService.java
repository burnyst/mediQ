package controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

import dao.FaqDAO;
import dbcp.JdbcUtil;
import model.Faq;

public class WriteFaqService {

	private FaqDAO faqDao = new FaqDAO();
	
	public Integer write(Faq faq) {
		Connection conn = null;
		try {
			conn=JdbcUtil.getConnection();
			conn.setAutoCommit(false);
			
			Faq faq1  = toFaq(faq);
			Faq savedFaq = faqDao.insert(conn,faq1);
			
			if(savedFaq == null) {	//insert 실패시 null 리턴
				throw new RuntimeException("fail to insert faq");
			}
			
			conn.commit();
			
			return savedFaq.getSn();
		}catch (SQLException e) {
			JdbcUtil.rollback(conn);
			throw new RuntimeException(e);
		}catch (RuntimeException e) {
			JdbcUtil.rollback(conn);
			throw e;
		}finally {
			JdbcUtil.close(conn);
		}
		
	}

	private Faq toFaq(Faq faq) {
		Date now = new Date();
		return new Faq(null,faq.getTitle(),now,faq.getCategory(),0);
	}
}

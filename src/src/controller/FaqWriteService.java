package controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

import dao.FaqDAO;
import dbcp.JdbcUtil;
import model.Faq;
import model.FaqRequest;

public class FaqWriteService {

	private FaqDAO faqDAO = new FaqDAO();
	
	public  Integer write(FaqRequest writeFaq) {
		Connection conn = null;
		try {
			conn=JdbcUtil.getConnection();
			conn.setAutoCommit(false);
			
			Faq faq1 = toFaq(writeFaq);
			System.out.println("faq1="+faq1);
			Faq savedFaq = faqDAO.insert(conn,faq1);
			
			System.out.println("savedFaq="+savedFaq);
			System.out.println("faq1="+faq1);
			
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

	private Faq toFaq(FaqRequest writeFaq) {
		Date now = new Date();
		return new Faq(writeFaq.getSn(),writeFaq.getTitle(),writeFaq.getMid(),now,writeFaq.getCategory(),0,writeFaq.getContents());
	}
}

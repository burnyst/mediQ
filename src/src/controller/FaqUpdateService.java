package controller;

import java.sql.Connection;
import java.sql.SQLException;
import dao.FaqDAO;
import dbcp.JdbcUtil;
import model.Faq;
import model.FaqRequest;

public class FaqUpdateService {
	
	private FaqDAO faqDAO = new FaqDAO();

	public void update(FaqRequest updateReq) {
		Connection conn = null;
		try {
			conn = JdbcUtil.getConnection();
			conn.setAutoCommit(false);
			
			
			//Faq faq = faqDAO.selectById(conn, updateReq.getSn());
			
			//글작성자id와 로그인유저id 일치여부를 검사
//			if(!canUpdate(updateReq.getMid(),faq)){
//				throw new PermissionDeniedException();
//			}
			
			//faq테이블에 해당게시글의 제목 수정
			faqDAO.update(conn, updateReq.getCategory(), updateReq.getTitle(),
					updateReq.getContents(), updateReq.getSn());
			System.out.println("faqDao/////category="+updateReq.getCategory()
											+"/title="+updateReq.getTitle()+
											"/contents"+updateReq.getContents());
			
			conn.commit();
		}catch(SQLException e) {
			JdbcUtil.rollback(conn);
			throw new RuntimeException();
		}catch(PermissionDeniedException e) {
			throw e;
		}finally {
			JdbcUtil.close(conn);
		}
	}

//	private boolean canUpdate(String mid, Faq faq) {
//		String id = faq.getMid();
//		return id.equals(mid);
//	}

}

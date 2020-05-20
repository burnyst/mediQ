package controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import dao.FaqDAO;
import dao.MemberDAO;
import dbcp.JdbcUtil;
import model.Faq;
import model.Member;
import model.User;
import page.FaqPage;

//전체목록보기 요청 담당 컨트롤러에서 호출하는 서비스클래스
//p650
//DAO와 연동
public class FaqListService {
	
	private FaqDAO faqDAO = new FaqDAO();
	private MemberDAO memberDAO = new MemberDAO();
	private int size = 10;		//한페이지당 출력할 게시글 수
	
	public FaqPage getFaqPage(int pageNo) {
		System.out.println("getFaqPage호출");
		System.out.println("pageNo="+pageNo);
		try {
			Connection conn= JdbcUtil.getConnection();
			//전체 게시글수 조회
			int total = faqDAO.selectCount(conn);
			System.out.println("total"+total);
			
			//특정페이지를에 해당하는 게시글목록 조회
			//select(conn, 시작행번호, 가져올게시글수)
			//시작행번호는 0부터 시작되므로 첫게시글은 -1해야한다.
			//보고싶은 페이지가(pageNo)가 1이면 첫게시글의 인덱스번호는 0이 되어야 한다.
			//한 페이지당 출력할 게시글 수가 10개라면 size는 10
			List<Faq> content = faqDAO.select(conn,(pageNo-1)*size,size);
			System.out.println("pageNo"+pageNo);
			System.out.println("size"+size);
			
			
			//페이지정보가 포함된 내용을 리턴을 해줘야 한다
			return new FaqPage(total, pageNo, size, content);
		
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}

}

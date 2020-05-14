package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import dbcp.JdbcUtil;
import model.Faq;


public class FaqDAO {

	//전체게시물수 구하기
	public int selectCount(Connection conn) throws SQLException{
		System.out.println("전체게시물수 구하기 FaqDAO-selectCount()호출성공");
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "select count(*) from FAQ";
			pstmt = conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				return rs.getInt(1);
			}
			return 0;
		}finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}
		//select
		public List<Faq> select(Connection conn, int startRow, int size) throws SQLException{
			System.out.println("FaqDAO의 select(startRow,size)="
	                +startRow+"/"+size);
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				String sql=
						"select	rownum,sn,title,mid,rdate,category,vcount  " + 
						" from ( select	rownum,sn,title,mid,rdate,category,vcount from faq order by sn desc)  " +
						" where sn > ? and sn <= ?+?"	;
				
				pstmt=conn.prepareStatement(sql);
				pstmt.setInt(1,startRow);		
				pstmt.setInt(2,size);
				pstmt.setInt(3,startRow);
				rs = pstmt.executeQuery();
				List<Faq> result = new ArrayList<>();
				while(rs.next()) {
					result.add(convertFaq(rs));
				}
				return result;
				
			}finally {
				JdbcUtil.close(rs);
				JdbcUtil.close(pstmt);
			}
		}
		
		//select쿼리문 결과를 받아서 Faq클래스타입으로 묶어주는 함수 호출
		private Faq convertFaq(ResultSet rs) throws SQLException{
			System.out.println("FaqDAO의 convertFaq()");
			return new Faq(	
					rs.getInt("sn"),
					rs.getString("title"),
					rs.getString("mid"), 
					toDate(rs.getTimestamp("rdate")),
					rs.getString("catagory"),
					rs.getInt("vcount"),
					rs.getString("contents")
					);
		}

		private Date toDate(Timestamp timestamp) {
			System.out.println("FAQDAO의 toDate()");
			return new Date(timestamp.getTime());
		}
		
		/*
		//search select
		public List<Faq> selectSearch(Connection conn, String search) throws SQLException{
			System.out.println("검색 리스트FaqDAO-searchSelect()호출성공");
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				String sql="select * from FAQ where title like '%?%' ";
				
				pstmt=conn.prepareStatement(sql);
				pstmt.setString(1,search);		
				rs = pstmt.executeQuery();
				List<Faq> result = new ArrayList<>();
				while(rs.next()) {
					result.add(convertFaq(rs));
				}
				return result;
				
			}finally {
				JdbcUtil.close(rs);
				JdbcUtil.close(pstmt);
			}
		}
		
		//category select
		public void selectCagegory(Connection conn, Faq faq) throws SQLException{
			System.out.println("카테고리 리스트 구하기 FaqDAO-selectCategory()호출성공");
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				String sql = "select * from FAQ where category=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, faq.getCategory());
				rs=pstmt.executeQuery();
				

			}finally {
				JdbcUtil.close(rs);
				JdbcUtil.close(pstmt);
			}
		}
		
		
		
		//insert
		public Faq insert(Connection conn, Faq faq) throws SQLException{
			System.out.println("FaqDAO의 insert() faq="+faq);
			PreparedStatement pstmt = null;
			Statement stmt = null;
			ResultSet rs   = null;	
			try {
				String sql = "insert into FAQ(title,mid,rdate,contents,category,vcount) "
						+ " values (?,?,'관리자',?,?,?,0)";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1,faq.getMid());
				//pstmt.setString(3,faq.getMid());
				pstmt.setTimestamp(2, toTimestamp(faq.getRdate()));
				pstmt.setString(3, faq.getContents());
				pstmt.setString(4,faq.getCategory());
				int insertedCount = pstmt.executeUpdate();
				
				
				if(insertedCount>0) {
					stmt = conn.createStatement();
					rs = stmt.executeQuery("select faq_seq.currval sn from dual");
				
				if(rs.next()) {
					Integer newNum = rs.getInt(1);
					return new Faq(newNum,faq.getMid(),faq.getRdate(),faq.getCategory(),0);
				}
			}
				return null;
				
			}finally {
				JdbcUtil.close(rs);
				JdbcUtil.close(stmt);
				JdbcUtil.close(pstmt);
			}
		}

		
		private   Timestamp toTimestamp(Date date) {
			return new  Timestamp(date.getTime());
		}
		
		//조회수 증가
		public void incrementReadCount(Connection conn, int faqNum) throws SQLException{
			System.out.println("조회수증가 FaqDAO-vcount()호출성공");
			try {
				String sql = "update article"+
										" set vcount=vcount+1"+
										" where sn=?";
				PreparedStatement pstmt = conn.prepareStatement(sql);
				
				pstmt.setInt(1, faqNum);
				pstmt.executeUpdate();
			}finally {
				
			}
		}
		*/
		
		//modify
		
		
		
		
		//delete
		
		
	
}

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
import model.Member;
import model.User;


public class FaqDAO {

	//update
	public int update(Connection conn, String category, String title, String contents, String mid, int sn)
		throws SQLException{
		PreparedStatement pstmt = null;
		try {
			String sql="update faq set category=? , title=? , contents=? ,mid=? rdate=sysdate "
					+ " where sn=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, category);
			pstmt.setString(2, title);
			pstmt.setString(3, contents);
			pstmt.setString(4, mid);
			pstmt.setInt(5, sn);
			int cnt = pstmt.executeUpdate();
					
			System.out.println("글 수정FaqDAO-update()호출성공 category="+category
					+"title="+title+"/contents="+contents+"/sn="+sn);

			return cnt;
		}finally {
			JdbcUtil.close(pstmt);
		}
	}
	
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
						"select	rownum,sn,title,mid,rdate,category,vcount,contents  " + 
						" from ( select	rownum rn,sn,title,mid,rdate,category,vcount,contents from faq order by sn desc)  " +
						" where rn > ? and rn <= ?+?"	;
				
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
					rs.getDate("rdate"),
					rs.getString("category"),
					rs.getInt("vcount"),
					rs.getString("contents")
					);
		}
		
		
		//카테고리게시물수 구하기
		public int selectCountC(Connection conn, String keyword) throws SQLException{
			System.out.println("카테고리게시물수 구하기 FaqDAO-selectCountC()호출성공");
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				String sql = "select count(*) from FAQ where category=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, keyword);
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

		//category select
		public List<Faq> selectC(Connection conn,String category, int startRow, int size) throws SQLException{
			System.out.println("FaqDAO의 select(startRow,size)="
	                +startRow+"/"+size);
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				String sql=
						"select	rownum,sn,title,mid,rdate,category,vcount,contents  " + 
						" from ( select	rownum rn,sn,title,mid,rdate,category,vcount,contents from faq order by sn desc)  " +
						" where category=? and rn > ? and rn <= ?+?"	;
				
				pstmt=conn.prepareStatement(sql);
				pstmt.setString(1, category);
				pstmt.setInt(2,startRow);		
				pstmt.setInt(3,size);
				pstmt.setInt(4,startRow);
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
		
		//search 게시물수 구하기
		public int selectCountS(Connection conn, String category, String search) throws SQLException {
			System.out.println("search게시물수 구하기 FaqDAO-selectCountS()호출성공");
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				String sql = "select count(*) from faq  where title like '%' || ? || '%'  ";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, search);
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

		//search 게시물수 구하기 부분
		public int selectCountSC(Connection conn, String category, String search) throws SQLException {
			System.out.println("search게시물수 구하기 FaqDAO-selectCountSC()호출성공");
			System.out.println("category="+category+"/search="+search);
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				String sql = "select count(*) from (select title from FAQ where category=?)  where title like '%' || ? || '%'  ";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, category);
				pstmt.setString(2, search);
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
		
		
		//search select 전체
		public List<Faq> selectSA(Connection conn, String search, int startRow, int size) throws SQLException{
			System.out.println("FaqDAO의 select(startRow,size)="
	                +startRow+"/"+size);
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				String sql=
						"select	rownum,sn,title,mid,rdate,category,vcount,contents  " + 
						" from ( select	rownum rn,sn,title,mid,rdate,category,vcount,contents from faq order by sn desc)  " +
						" where title like '%' || ? || '%' and rn > ? and rn <= ?+?"	;
				
				pstmt=conn.prepareStatement(sql);
				pstmt.setString(1, search);
				pstmt.setInt(2,startRow);		
				pstmt.setInt(3,size);
				pstmt.setInt(4,startRow);
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
		
		//select search 부분
		public List<Faq> selectSC(Connection conn,String category, String search, int startRow, int size) throws SQLException{
			System.out.println("FaqDAO의 select(startRow,size)="
	                +startRow+"/"+size);
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				String sql=
						"select	rownum,sn,title,mid,rdate,category,vcount,contents  " + 
						" from ( select	rownum rn,sn,title,mid,rdate,category,vcount,contents from faq where category=? order by sn desc)  " +
						" where title like '%' || ? || '%' and rn > ? and rn <= ?+?"	;
				
				pstmt=conn.prepareStatement(sql);
				pstmt.setString(1, category);
				pstmt.setString(2, search);
				pstmt.setInt(3,startRow);		
				pstmt.setInt(4,size);
				pstmt.setInt(5,startRow);
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
		
		
		

		//insert
		public Faq insert(Connection conn, Faq faq) throws SQLException{
			System.out.println("FaqDAO의 insert() faq="+faq);
			PreparedStatement pstmt = null;
			Statement stmt = null;
			ResultSet rs   = null;	
			try {
				String sql = "insert into FAQ(title,mid,rdate,contents,category,vcount) "
						+ " values (?,?,?,?,?,0)";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1,faq.getTitle());
				pstmt.setString(2,faq.getMid());
				pstmt.setTimestamp(3, toTimestamp(faq.getRdate()));
				pstmt.setString(4, faq.getContents());
				pstmt.setString(5,faq.getCategory());
				pstmt.executeUpdate();
				
				return faq;
				
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
		public void vcount(Connection conn, int sn) throws SQLException{
			System.out.println("조회수증가 FaqDAO-vcount()호출성공");
			try {
				String sql = "update faq" + 
						" set vcount=vcount+1" + 
						" where sn=?";
				PreparedStatement pstmt = conn.prepareStatement(sql);
				
				pstmt.setInt(1, sn);
				pstmt.executeUpdate();
			}finally {
				
			}
		}
		
		//Faq테이블의 특정 글번호 조회
		public Faq selectById(Connection conn, int faqNum) throws SQLException {
			PreparedStatement pstmt = null;
			ResultSet rs =null;
			try {
				String sql = "select * from faq where sn=?";
				pstmt = conn.prepareStatement(sql);	
				pstmt.setInt(1, faqNum);
				rs = pstmt.executeQuery();
				
				Faq faq = null;
				if(rs.next()) {
					faq = convertFaq(rs);
				}
				return faq;
			}finally {
				JdbcUtil.close(rs);
				JdbcUtil.close(pstmt);
			}
		}

		//delete
		public int delete(Connection conn, int sn) throws SQLException {
			System.out.println("FaqDAO의 delete() sn="+sn);
			PreparedStatement pstmt = null;
			Statement stmt = null;
			ResultSet rs   = null;	
			try {
				String sql = "delete from faq where sn=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1,sn);
				pstmt.executeUpdate();
				
				return sn;
				
			}finally {
				JdbcUtil.close(rs);
				JdbcUtil.close(stmt);
				JdbcUtil.close(pstmt);
			}
		

	}
			
}

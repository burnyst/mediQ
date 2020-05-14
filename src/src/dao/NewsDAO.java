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
import model.News;

public class NewsDAO {



//p646
//전체게시물수 구하기(p451 66)
public int selectCount(Connection conn)throws SQLException {
	System.out.println("전체게시물수 구하기 dao-selectCount");
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	try {
		String sql = "select count(*) from news";
		pstmt=conn.prepareStatement(sql);
		rs= pstmt.executeQuery();
		if(rs.next()) {// 등록된 게시글이 존재하면
			return rs.getInt(1);//전체 게시물수가 리턴
		}
		return 0; //등록된 게시글이 존재하지 않으면 0처리
  }finally {
	JdbcUtil.close(rs);
	JdbcUtil.close(pstmt);
  }
  
}
public List<News> select (Connection conn,int startRow, int size ) throws SQLException {
	System.out.println("News의 insert(int startRow, int size) news="+startRow+ size);
	PreparedStatement pstmt = null;
	ResultSet rs   = null;
	try {
		String sql="select  String mid, String title,String press, String summary,Date rdate, String nimage" + 
				" from news " + 
				" order by sn desc " +
				" limit ?, ? ";
		//limit 0부터 시작행번호, 읽어올레코드 수 0
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);//시작행 번호
			pstmt.setInt(2, size);//읽어올 레코드 수
			rs=pstmt.executeQuery();
			List<News> result = new ArrayList<>();
			while(rs.next()) {
				result.add(convertNews(rs));					
			}
			return result;
	}finally {
		JdbcUtil.close(rs);
		JdbcUtil.close(pstmt);
	}
}
//select한 쿼리문 결과를 받아서 News클래스타입으로 묶어주는 함수 p647	36
private News convertNews(ResultSet rs) throws SQLException {
	System.out.println("ArticleDao convertArticle");
	return new News(rs.getInt("sn"),
			rs.getString("mid"),
			rs.getString("title"),
			rs.getString("press"),
			rs.getString("summary"),
			toDate(rs.getTimestamp("regdate")),
			rs.getString("nimage"));
}

public void insert(Connection conn,	News news) throws SQLException {
	System.out.println("NewsDAO의 insert() article="+news);
	
	PreparedStatement pstmt = null;
	
	//news테이블에서 입력된 마지막 article_id값을 가져오는
	//쿼리를 실행하기위해 필요한  stmt와
	//그 실행결과를 담기위한 rs변수 선언
	Statement stmt = null;
	ResultSet rs   = null;	
	try {
		String sql = 
		"insert into news String mid, String title,String press, String summary,Date rdate, String nimage " + 
		" values(?,?,?,?,?,?);";
		pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1,news.getMid());
		pstmt.setString(2,news.getTitle());
		pstmt.setString(3,news.getPress());
		pstmt.setString(4,news.getSummary());
		pstmt.setTimestamp(5, toTimestamp(news.getRdate()));
		pstmt.setString(6,news.getNimage());
		
	}finally {
		JdbcUtil.close(rs);
		JdbcUtil.close(stmt);
		JdbcUtil.close(pstmt);
	}
	
	
}

//Date타입을 Timestamp타입으로 변환
private   Timestamp toTimestamp(Date date) {
	return new  Timestamp(date.getTime());
}
//TimeStamp타입을 Date타입으로 변화 p648 47
	private   Date toDate(Timestamp timestamp) {
		return new  Date(timestamp.getTime());
	}
}

package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import dbcp.JdbcUtil;
import model.News;

public class NewsDAO {



//p646
//전체게시물수 구하기(p451 66)
public static int selectCount(Connection conn)throws SQLException {
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
//List 목록값 가져오기
public static List<News> select (Connection conn,int startRow, int size) throws SQLException {
	System.out.println("News의 insert(int startRow, int size) news="+startRow+"/"+ size);
	PreparedStatement pstmt = null;
	ResultSet rs   = null;
	try {
		String sql="select rownum, sn,mid,title,press,summary,rdate,nimage" + 
				" from (select rownum rn, sn,mid,title,press,summary,rdate,nimage from news order by sn desc)" + 
				" where rn> ? and rn <= ?+?" ;
		//limit 0부터 시작행번호, 읽어올레코드 수 0
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);//시작행 번호
			pstmt.setInt(2, size);//읽어올 레코드 수
			pstmt.setInt(3, startRow);
			System.out.println("pstmt 호출"+pstmt);  //sql문이 나와야 함
			rs=pstmt.executeQuery();
			System.out.println("rs호출"+rs);
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
	private static News convertNews(ResultSet rs)
			throws SQLException {
			System.out.println("NewsDao convertNews()");
			return new News(
				rs.getInt("sn"),
				rs.getString("mid"),
				rs.getString("title"),
				rs.getString("press"),
				rs.getString("summary"),
				toDate(rs.getTimestamp("rdate")),
				rs.getString("nimage")
				);
}

	//TimeStamp타입을 Date타입으로 변화 p648 47
	private static   Date toDate(Timestamp timestamp) {
		return new  Date(timestamp.getTime());
	}

	
	//뉴스등록
	public News insert(Connection conn,	News news) throws SQLException {
	System.out.println("NewsDAO의 insert() article="+news);
	
	PreparedStatement pstmt = null;
	
	try {
		String sql = "insert into news (mid, title, press, summary, rdate,nimage) "+
						"values(?,?,?,?,?,?)";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,news.getMid());
		pstmt.setString(2,news.getTitle());
		pstmt.setString(3,news.getPress());
		pstmt.setString(4,news.getSummary());
		pstmt.setTimestamp(5, toTimestamp(news.getRdate()));
		pstmt.setString(6,news.getNimage());
		pstmt.executeUpdate();
		return news;
	}finally {	
		JdbcUtil.close(pstmt);
	}
	
}
	//검색
	public static List<News> selectByIdT(Connection conn, String keyword)  throws SQLException {
		System.out.println("newsDAO의 검색 selectCountt="
						+ keyword);
		PreparedStatement pstmt = null;
		ResultSet rs   = null;
		try {
			String sql="select 	sn,mid, title, press,summary,"+
					 " rdate, nimage from news"+
					 " where title like '%' ||?|| '%'  order by sn desc ";
			pstmt =	conn.prepareStatement(sql);
			pstmt.setString(1,keyword);
			System.out.println("pstmt 호출"+pstmt); //sql문이 나와야함
			rs = pstmt.executeQuery();//p655 8
			System.out.println("rs 호출"+rs);
			List<News> resultt = new ArrayList<>();
			while( rs.next() ) {
				resultt.add(convertNews(rs));
			}
			return resultt;
			
	  }finally {
		JdbcUtil.close(rs);  
		JdbcUtil.close(pstmt);
	  }
	}
	
	//전체게시물수 구하기 검색관련 
			public static int selectCountt(Connection conn,String keyword1 ) throws SQLException {
				System.out.println("전체게시물수 구하기 QnaDAO-selectCountt()호출성공");
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				try {
					String sql = "select  count(*) "+
								 "	from news "+
								 "where title like '%' ||?|| '%'";
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1,keyword1); 
					System.out.println("pstmt=" +pstmt);
					
					rs = pstmt.executeQuery();
					System.out.println("rs" +rs);
					if(rs.next()) {//등록된 게시글이 존재하면
						return rs.getInt(1); //전체 게시물수가 리턴
					}
					return 0; //등록된 게시글이 존재x하면  0을 리턴
					
			  }finally {
				JdbcUtil.close(rs);  
				JdbcUtil.close(pstmt);
			  }
			  
			}//end of selectCount
	
			//질문 상세조회
			public News selectById(Connection conn, String title)throws SQLException{
				System.out.println("NewDAO의 selectById(title)="
		                +title);
				PreparedStatement pstmt=null;
				ResultSet rs =null;
				try {
					String sql="select 	sn,mid, title, press,summary,"+
							 " rdate, nimage from news"+
							 " where title=?";
					pstmt =conn.prepareStatement(sql);
					pstmt.setNString(1, title);
					rs = pstmt.executeQuery();
					News newsd =null;
					if(rs.next()) {
						newsd = new News(
								rs.getInt("sn"),
								rs.getString("mid"),
								rs.getString("title"),
								rs.getString("press"),
								rs.getString("summary"),
								toDate(rs.getTimestamp("rdate")),
								rs.getString("nimage")
								);
							
					}return newsd;	
				}finally {
					JdbcUtil.close(rs);
					JdbcUtil.close(pstmt);
				}
			}
			/*private Date toDate(Timestamp date) {
			return date == null? null: new Date(date.getTime()); 	
			}*/
			
//Date타입을 Timestamp타입으로 변환
private   Timestamp toTimestamp(Date date) {
	return new  Timestamp(date.getTime());
}
public int update(Connection conn,String summary ,String title)throws SQLException {
	System.out.println("글 수정 NewsDAO-update");
	PreparedStatement pstmt = null;
	try {
		String sql="update news set summary='?' ,rdate = NOW()" + 
				"where title='?' ;";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,summary );
		pstmt.setString(2,title );
		int cnt =pstmt.executeUpdate();
		//update성공적으로 실행되면 update된 레코드수가 리턴된다.
		//여기에선느 특정글번호만 update되므로 성공시에는 1이 리턴.
		
		return cnt;
	}finally {
		JdbcUtil.close(pstmt);
		
	}
	
	
	
	
	       
	


}
}


	
	

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

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import dbcp.JdbcUtil;
import model.Qnamodel;

	
public  class QnaDAO{
	//연결
	private DataSource ds;
	
	public QnaDAO() {
		
		try {
				Context ctx = new InitialContext();
				ds=(DataSource)ctx.lookup("java:comp/env/jdbc/orcl");
		}catch(Exception e){
				e.printStackTrace();
		}
	}
	
	
	//전체게시물수 구하기 
	public static int selectCount(Connection conn) throws SQLException {
		System.out.println("전체게시물수 구하기 QnaDAO-selectCount()호출성공");
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "select  count(*) "+
						 "	from  qna";
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {//등록된 게시글이 존재하면
				return rs.getInt(1); //전체 게시물수가 리턴
			}
			return 0; //등록된 게시글이 존재x하면  0을 리턴
			
	  }finally {
		JdbcUtil.close(rs);  
		JdbcUtil.close(pstmt);
	  }
	  
	}//end of selectCount
	
	//List 목록값 가져오기
	public static List<Qnamodel> select(Connection conn,
			int startRow,int size)  
			throws SQLException {
		System.out.println("QnaDAO의 select(startRow,size)="
			                +startRow+"/"+size);
		PreparedStatement pstmt = null;
		ResultSet rs   = null;
		try {
			String sql = 
			"select	rownum,sn,title,category,qpublic,vcount,mid,rdate,qstate  " + 
			" from ( select  rownum rn,sn,title,category,qpublic,vcount,mid,rdate,qstate from qna order by sn desc)  " +
			" where rn > ? and rn <= ?+?"		;
		// rownum 0부터시작행번호, 읽어올레코드수
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,startRow); //시작행번호
			pstmt.setInt(2,size); //읽어올레코드수
			pstmt.setInt(3,startRow); 
			System.out.println("pstmt 호출"+pstmt); //sql문이 나와야함
			rs = pstmt.executeQuery();
			System.out.println("rs 호출"+rs);
			List<Qnamodel> result = new ArrayList<>();
			while( rs.next() ) {
				result.add(convertQuestion(rs));
			}
			return result;
		}finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}	
	}
	//select쿼리문 결과를 받아서  Qnamodel클래스타입으로 묶어주는 함수
		private static Qnamodel convertQuestion(ResultSet rs) 
		    throws SQLException{
			System.out.println("QnaDAO의  convertQuestion()");
			return new Qnamodel(
					rs.getInt("sn"),
					rs.getString("title"),
					rs.getString("category"),
					rs.getInt("qpublic"),
					rs.getInt("vcount"),
					rs.getString("mid"),
					toDate(rs.getTimestamp("rdate")),
					rs.getInt("qstate")
					);
					
		}

		//Timestamp타입을 Date타입으로 변환 
		private static Date toDate(Timestamp timestamp) {
			return new Date(timestamp.getTime());
		}
		
		//전체게시물수 구하기 
		public static int selectCountt(Connection conn,String keyword1,String keyword2,String keyword3,String keyword4  ) throws SQLException {
			System.out.println("전체게시물수 구하기 QnaDAO-selectCountt()호출성공");
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				String sql = "select  count(*) "+
							 "	from  qna "+
							 " where title like '%' || ? || '%' and rdate like '%' || ? || '%' and mid like '%' || ? || '%' and category like  '%' || ? || '%' ";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1,keyword1); 
				pstmt.setString(2,keyword2);
				pstmt.setString(3,keyword3); 
				pstmt.setString(4,keyword4); 
				
				rs = pstmt.executeQuery();
				if(rs.next()) {//등록된 게시글이 존재하면
					return rs.getInt(1); //전체 게시물수가 리턴
				}
				return 0; //등록된 게시글이 존재x하면  0을 리턴
				
		  }finally {
			JdbcUtil.close(rs);  
			JdbcUtil.close(pstmt);
		  }
		  
		}//end of selectCount
		
		//검색 키워드 검색해서 list로 묶음
		public static List<Qnamodel> selectByIdT(Connection conn, String keyword1,String keyword2,String keyword3,String keyword4 )throws SQLException {
			System.out.println("검색 QnaDAO-selectByIdT()호출성공");
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				String sql = "select	rownum,sn,title,category,qpublic,vcount,mid,rdate,qstate  " + 
						" from ( select  rownum rn,sn,title,category,qpublic,vcount,mid,rdate,qstate from qna order by sn desc)  " +
						" where title like '%' || ? || '%' and rdate like '%' || ? || '%' and mid like '%' || ? || '%' and category like  '%' || ? || '%' ";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1,keyword1); 
				pstmt.setString(2,keyword2);
				pstmt.setString(3,keyword3); 
				pstmt.setString(4,keyword4); 	
				System.out.println("pstmt 호출"+pstmt); //sql문이 나와야함
				rs = pstmt.executeQuery();
				System.out.println("rs 호출"+rs);
				List<Qnamodel> resultt = new ArrayList<>();
				while( rs.next() ) {
					resultt.add(convertQuestiont(rs));
				}
				return resultt;
				
		  }finally {
			JdbcUtil.close(rs);  
			JdbcUtil.close(pstmt);
		  }
		}
			//selectByIdT쿼리문 결과를 받아서  Search클래스타입으로 묶어주는 함수 p647 36
			private static Qnamodel convertQuestiont(ResultSet rs) 
			    throws SQLException{
				System.out.println("QnaDAO의  convertQuestiont()");
				return new Qnamodel(
						rs.getInt("sn"),
						rs.getString("title"),
						rs.getString("category"),
						rs.getInt("qpublic"),
						rs.getInt("vcount"),
						rs.getString("mid"),
						toDatet(rs.getTimestamp("rdate")),
						rs.getInt("qstate")
						);
						
			}

			//Timestamp타입을 Date타입으로 변환 p648 47
			private static Date toDatet(Timestamp timestamp) {
				return new Date(timestamp.getTime());
			}

		//질문 상세조회
		public Qnamodel selectById(Connection conn, int no)throws SQLException{
			System.out.println("QnaDAO의 selectByID(no)="
	                +no);
			PreparedStatement pstmt=null;
			ResultSet rs =null;
			try {
				String sql="select sn,title,category,qpublic,vcount,mid,rdate,question,image,qstate " + 
						"from qna " + 
						"where sn=?";
				pstmt =conn.prepareStatement(sql);
				pstmt.setInt(1, no);
				rs = pstmt.executeQuery();
				Qnamodel qm =null;
				if(rs.next()) {
					qm = new Qnamodel(
							rs.getInt("sn"),
							rs.getString("title"),
							rs.getString("category"),
							rs.getInt("qpublic"),
							rs.getInt("vcount"),
							rs.getString("mid"),
							toDate(rs.getTimestamp("rdate")),
							rs.getString("question"),
							rs.getString("image"),
							rs.getInt("qstate")
							);
						
				}return qm;	
			}finally {
				JdbcUtil.close(rs);
				JdbcUtil.close(pstmt);
			}
		}
		/*private Date toDate(Timestamp date) {
		return date == null? null: new Date(date.getTime()); 	
		}*/
		
		//list테이블의 특정글번호 조회수 증가
		public void incrementVCount(Connection conn, 
				int no) throws SQLException{
			System.out.println("QnaDAO의 incrementVCount="
	                +no);
			try {
				String sql = 
					"update qna " + 
					" set   vcount=vcount+1 " + 
					" where sn=?";
				PreparedStatement pstmt =
					conn.prepareStatement(sql); 
				pstmt.setInt(1, no);
				pstmt.executeUpdate();
			}finally {}
			
		}

	//질문등록
	public Qnamodel insert(Connection conn, Qnamodel qm) 
		throws SQLException{
		System.out.println("QnaDAO의 insert() qm="+qm);
		PreparedStatement pstmt = null;
		//sn과 mid 체크
		try{String sql="insert into qna(title,category,qpublic,vcount,mid,rdate,question,image,qstate)  " + 
				"values (?,?,?,?,?,?,?,?,?)";
		
		pstmt = conn.prepareStatement(sql);
		//pstmt.setInt(1,qm.getSn());
		pstmt.setString(1,qm.getTitle() );
		pstmt.setString(2, qm.getCategory());
		pstmt.setInt(3, qm.getQpublic());
		pstmt.setInt(4,qm.getVcount());
		pstmt.setString(5,qm.getMid() );
		//pstmt.setTimestamp(5, new Timestamp(qm.getRdate().getTime()));
		pstmt.setTimestamp(6, toTimestamp(qm.getRdate()));
		pstmt.setString(7,qm.getQuestion() );
		//★인풋타입 파일, 문제
		pstmt.setString(8,qm.getImage() );
		pstmt.setInt(9,qm.getQstate());
		pstmt.executeUpdate();
		return qm; 
	}finally {
		JdbcUtil.close(pstmt);
	}		
}

//Date타입을 Timestamp타입으로 변환
private   Timestamp toTimestamp(Date date) {
	return new  Timestamp(date.getTime());
}
			
//답변등록

public int update(Connection conn, String answer,int no)
		throws SQLException{
	System.out.println("답변등록 QnaDAO-update()호출성공");
	PreparedStatement pstmt = null;
	try {
		String sql=
				"update qna "+
				 " set   answer=?, qstate=1 "+
				 " where sn=?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, answer);
		pstmt.setInt(2,no);
		int cnt = pstmt.executeUpdate();
		return cnt;
	}finally {
		JdbcUtil.close(pstmt);
	}	
}
// 답변 조회 
//질문 삭제
		}
	








package cs.qna.modeldao;
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

import cs.qna.modeldao.Qnamodel;
import jdbc.JdbcUtil;

	/*//질문 상세조회
	public Qnamodel selectById(Connection conn, String title)throws SQLException{
		PreparedStatement pstmt=null;
		ResultSet rs =null;
		try {
			String sql="select sn,title,category,qpublic,vcount,mid,rdate,questsion,image,qstate " + 
					"from qna " + 
					"where title=?";
			pstmt =conn.prepareStatement(sql);
			pstmt.setString(1, title);
			rs = pstmt.executeQuery();
			Qnamodel qnamodel =null;
			if(rs.next()) {
				qnamodel  = new Qnamodel(
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
					
			}return qnamodel;	
		}finally {
			JdbcUtill.close(rs);
			JdbcUtill.close(pstmt);
		}
	}
	private Date toDate(Timestamp date) {
	return date == null? null: new Date(date.getTime()); 	
	}
	*/
	
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
			" from ( select  rownum,sn,title,category,qpublic,vcount,mid,rdate,qstate from qna order by sn desc)  " +
			" where rownum > ? and rownum <= ?+?"		;
		//limit  0부터시작행번호, 읽어올레코드수
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
	//select쿼리문 결과를 받아서  Qnamodel클래스타입으로 묶어주는 함수 p647 36
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

		//Timestamp타입을 Date타입으로 변환 p648 47
		private static Date toDate(Timestamp timestamp) {
			return new Date(timestamp.getTime());
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
				
		}
	

//답변등록

//질문 삭제

//


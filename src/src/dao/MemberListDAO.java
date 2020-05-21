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
import model.Memberlist;
import model.News;

public class MemberListDAO {



//p646
//전체게시물수 구하기(p451 66)
public static int selectCount(Connection conn)throws SQLException {
	System.out.println("전체게시물수 구하기 dao-selectCount");
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	try {
		String sql = "select count(*) from member";
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
public static List<Memberlist> select (Connection conn,int startRow, int size) throws SQLException {
	System.out.println("News의 insert(int startRow, int size) news="+startRow+"/"+ size);
	PreparedStatement pstmt = null;
	ResultSet rs   = null;
	try {
		String sql="select rownum,mid,mname,memail,mhp,mbd,mlevel,xmember,xreason from " + 
				"(select rownum rn ,mid,mname,memail,mhp,mbd,mlevel,xmember,xreason from member order by rn desc) " + 
				"	 where rn> ? and rn <= ?+? " ;
		//limit 0부터 시작행번호, 읽어올레코드 수 0
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);//시작행 번호
			pstmt.setInt(2, size);//읽어올 레코드 수
			pstmt.setInt(3, startRow);
			System.out.println("pstmt 호출"+pstmt);  //sql문이 나와야 함
			rs=pstmt.executeQuery();
			System.out.println("rs호출"+rs);
			List<Memberlist> result = new ArrayList<>();
			while(rs.next()) {
				result.add(convertNews(rs));					
			}
			System.out.println("result 나오기 전,"+result);
			return result;
		}finally {
		JdbcUtil.close(rs);
		JdbcUtil.close(pstmt);
		}
		}
//select한 쿼리문 결과를 받아서 클래스타입으로 묶어주는 함수 p647	36
	private static Memberlist convertNews(ResultSet rs)
			throws SQLException {
			System.out.println("MemberListDao convertNews()");
			return new Memberlist(
				rs.getString("mid"),
				rs.getString("mname"),
				rs.getString("memail"),
				rs.getString("mhp"),
				rs.getString("mbd"),
				rs.getInt("mlevel"),
				rs.getBoolean("xmember"),
				rs.getString("xreason")
				);
			}
	public String delete(Connection conn, String mid) throws SQLException {
		System.out.println("MemberListDAO의 delete() mid="+mid);
		PreparedStatement pstmt = null;
		Statement stmt = null;
		ResultSet rs   = null;	
		try {
			String sql = "delete from member where mid=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,mid);
			pstmt.executeUpdate();
			
			return mid;
			
		}finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
			JdbcUtil.close(pstmt);
		}

}
	
	
	
	
	
}
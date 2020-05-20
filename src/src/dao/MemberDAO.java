package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dbcp.JdbcUtil;
import model.Member;

public class MemberDAO {
	
	public Member selectById(Connection conn, String mid) throws SQLException {
		System.out.println("MemberDAO-selectById(mid)호출="+mid);
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Member member = null;
		try {
			pstmt = conn.prepareStatement(
					" select mid, mname, mpwd, memail, mhp, mbd, mlevel " +
					" from member where mid = ?");
			pstmt.setString(1, mid);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				member = new Member(
						rs.getString("mid"),
						rs.getString("mname"),
						rs.getString("mpwd"),
						rs.getString("memail"),
						rs.getString("mhp"),
						rs.getString("mbd"),
						rs.getInt("mlevel"));
			}//if
			return member;
		}finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}
	
	public void insert(Connection conn, Member member) throws SQLException {
		String sql = "INSERT INTO member(mid,mname,mpwd,memail,mhp,mbd) " +
				"VALUES(?,?,?,?,?,?) ";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,member.getMid());
		pstmt.setString(2,member.getMname());
		pstmt.setString(3,member.getMpwd());
		pstmt.setString(4, member.getMemail());
		pstmt.setString(5, member.getMhp());
		pstmt.setString(6, member.getMbd());
		pstmt.executeUpdate();
	}
	
	//비밀번호변경을 위한 메서드
	public void update(Connection conn, Member member) throws SQLException {
			String sql="update member set memail=?,mpwd=? where mid=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getMemail());
			pstmt.setString(2,member.getMpwd());
			pstmt.setString(3, member.getMid());
			pstmt.executeUpdate();
	}

	//회원가입시 id존재여부 체크
	public String searchId(Connection conn,String mid) {
		System.out.println("dao searchId(mid)="+mid);
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		//boolean rst = false;
		String result = null;
		try {
			pstmt = conn.prepareStatement(
					" select mid " +
					" from member where mid = ?");
			
			pstmt.setString(1, mid);
			rs = pstmt.executeQuery();
			if(rs.next()) { //id사용중
				result = "이미 사용중인 아이디입니다.";
				//return result;
			}else {
				result = "사용할 수 있는 아이디입니다";
			}
			System.out.println("result0 = "+result);
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
		System.out.println("result1 = "+result);
		return result;
	}
	
	//회원정보 변경시 필요한 메서드
	public int updateMyInfo(Member member) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int check = 0;
		String sql = "";
		try { // 데이터베이스 연결은 익셉션을 발생시킬 수 있어서 try-catch 사용.
			sql = "select password from member where id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getMid());
			rs = pstmt.executeQuery();
			if(member.getMpwd().equals(rs.getString("pwd"))) {
				pstmt.close();
				pstmt = null;
				sql = "update member set mpwd = ?, mname = ?, memail = ?, mhp = ? where mid = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, member.getMpwd());
				pstmt.setString(2, member.getMname());
				pstmt.setString(3, member.getMemail());
				pstmt.setString(4, member.getMhp());
				pstmt.setString(5, member.getMid());
				pstmt.executeUpdate();
				check = 1;	//성공
			} else { 
				check = 0;	//실패
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally { // 최종적으로 사용했던 객체들 닫기용(오류가 발생해도 무조건 실행됨)
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
			JdbcUtil.close(conn);
		} return check;
	}
	
	//아이디찾기
	public static String findId(Connection conn, String name, String email) throws SQLException {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String rst = null;
		String sql = "select mid from member where mname = ? and memail = ?";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, name);
			stmt.setString(2, email);
			rs = stmt.executeQuery();
			if(rs.next()) {
				rst = rs.getString("mid");
			}
			return rst;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
		}
	}
	
	public static String findPw(Connection conn, String id, String email) throws SQLException {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String rst = null;
		String sql = "select mid from member where mid = ? and memail = ?";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, id);
			stmt.setString(2, email);
			rs = stmt.executeQuery();
			if(rs.next()) {
				rst = rs.getString("mid");
			}
			return rst;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
		}
	}
	
	public static void changePw(Connection conn, String id, String pw) throws SQLException {
		PreparedStatement stmt = null;
		String sql="update member set mpwd=? where mid=?";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, pw);
			stmt.setString(2, id);
			stmt.executeUpdate();
		} finally {
			JdbcUtil.close(stmt);
		}
	}
	
	//회원탈퇴시 필요한 메서드
	//탈퇴한 회원을 삭제하지 않고 리스트로 관리하기 위해 delete가 아니라 update를 사용
	public int updateXmember(String mid, String xreason) throws SQLException {
		Connection conn = null;
		conn = JdbcUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "";
		int check = 0;
		try {
			//xmember 를 알아서 고쳐야함 받을값 Y도(Y인지 T인지 모름)
			sql = "update member set xmember='Y', xreason=? where mid = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, xreason); // email로 정보 조회
			pstmt.setString(2, mid);
			
			System.out.println(pstmt);
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
			JdbcUtil.close(conn);
		} return check; // 최종적으로 체크값 리턴.
	}

	//회원탈퇴에서 비밀번호확인용
	public Boolean checkMpwd(Connection conn, String mid, String mpwd) throws Exception {

		PreparedStatement pstmt = null;
		ResultSet rs = null;   
		String sql = "select mpwd from member where mid=?";
		  
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, mid);
		rs=pstmt.executeQuery();
	      
		if(rs.next()) {
		     System.out.print("회원님의 실제 비밀번호는 "+rs.getString("mpwd")+"입니다");
		     if(rs.getString("mpwd").equals(mpwd)) {
		        return true;
		     }else {
		        return false;
		     }
		     
		}else {
			return false;
		}
	}
}

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
	
	public static boolean checkDuplicate(Connection conn, String mid) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		boolean rst = false;
		try {
			pstmt = conn.prepareStatement(
					" select count(*) " +
					" from member where mid = ?");
			pstmt.setString(1, mid);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				if (rs.getInt(1) > 0) {
					rst = true;
				}
			}
			return rst;
		} finally {
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
}

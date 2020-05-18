package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dbcp.JdbcUtil;
import model.Member;

public class MemberDAO {
	public static int getCount(Connection conn) throws SQLException {
		int rst = 0;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "select count(*) from Member";
		try {
			stmt = conn.prepareStatement(sql);
//			stmt.setString(1, name);
			rs = stmt.executeQuery();
			if (rs.next()) {
				rst = rs.getInt(1);
			}
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
		}
		return rst;
	}
	
	//임의로 아이디 비밀번호 체크 추가한거
	public String checkMember(Connection conn, String mid, String mpwd) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(
					"select mid from member where mid=? and mpwd=?");
			pstmt.setString(1, mid);;
			pstmt.setString(2, mpwd);
			rs=pstmt.executeQuery();
				if(rs.next())
					return (rs.getString("mid"));
				else
					return null;
		}finally {
			if(rs!=null)
				try {
					rs.close();
				}catch(SQLException e) {}
			if(pstmt!=null)
				try {
					pstmt.close();
				}catch(SQLException e) {}
		}
	}
	
	public Member selectById(Connection conn, String mid) throws SQLException {
		System.out.println("MemberDAO-selectById(mid)호출="+mid);
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Member member = null;
		try {
			pstmt = conn.prepareStatement(
					" select mid, mname, mpwd, memail, mhp, mbd, mlevel " +
					" from member" +
					" where mid = ?");
			pstmt.setString(1, mid);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				member = new Member(
						rs.getString("mid"),
						rs.getString("mname"),
						rs.getString("mpwd"),
						rs.getString("memail"),
						rs.getString("mhp"),
						rs.getString("mbd"));
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
	
}

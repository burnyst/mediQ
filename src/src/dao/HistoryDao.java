package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import dbcp.JdbcUtil;
import model.History;

public class HistoryDao {
	public static int getCount(Connection con, String mid) throws SQLException {
		int rst = 0;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "select count(*) from history where mid = ?";
		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, mid);
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
	public static List<History> getList(Connection con, String mid, int pageNo, int size) throws SQLException {
		List<History> rst = new ArrayList<History>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "select * from (select rownum rn, "
				+ "mid,"
				+ "history.ITEM_SEQ,"
				+ "ITEM_NAME,"
				+ "ENTP_NAME,"
				+ "ITEM_PERMIT_DATE,"
				+ "CANCEL_DATE,"
				+ "ETC_OTC_CODE,"
				+ "CHANGE_DATE,"
				+ "CLASS_NO,"
				+ "CHART,"
				+ "PACK_UNIT,"
				+ "NB_DOC_DATA,"
				+ "EE_DOC_DATA,"
				+ "UD_DOC_DATA,"
				+ "rdate "
				+ "from history join mdcinprductitem on history.item_seq = mdcinprductitem.item_seq "
				+ "where mid = ?) where rn between ? and ?";
		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, mid);
			stmt.setInt(2, pageNo);
			stmt.setInt(3, size);
			rs = stmt.executeQuery();
			while (rs.next()) {
				rst.add(
					new History(
						rs.getString("mid"),
						rs.getString("ITEM_SEQ"),
						rs.getString("ITEM_NAME"),
						rs.getString("ENTP_NAME"),
						rs.getString("ITEM_PERMIT_DATE"),
						rs.getString("NB_DOC_DATA"),
						rs.getString("CANCEL_DATE"),
						rs.getString("EE_DOC_DATA"),
						rs.getString("ETC_OTC_CODE"),
						rs.getString("UD_DOC_DATA"),
						rs.getString("CHANGE_DATE"),
						rs.getString("CLASS_NO"),
						rs.getString("CHART"),
						rs.getString("PACK_UNIT"),
						rs.getDate("rdate")
					)
				);
			}
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
		}
		return rst;
	}
	public static int Insert(Connection con, String mid, String itemSeq, Date rdate) throws SQLException {
		int rst = 0;
		PreparedStatement stmt = null;
		java.sql.Date rdateSqlDate = new java.sql.Date(rdate.getTime());
		String sql = "merge into history using dual on (mid = ? and ITEM_SEQ = ?) " + 
				"when matched then update set " + 
				"rdate=? " + 
				"when not matched then insert " + 
				"(mid, ITEM_SEQ, rdate) values (?, ?, ?)";
		try
		{
			stmt = con.prepareStatement(sql);
			stmt.setString(1, mid);
			stmt.setString(2, itemSeq);
			stmt.setDate(3, rdateSqlDate);
			stmt.setString(4, mid);
			stmt.setString(5, itemSeq);
			stmt.setDate(6, rdateSqlDate);
			rst = stmt.executeUpdate();
			return rst;
		} finally {
			JdbcUtil.close(stmt);
		}
	}
	
	public static int Delete(Connection con, String mid, String itemSeq) throws SQLException {
		int rst = 0;
		PreparedStatement stmt = null;
		String sql = "delete from history where mid = ? and ITEM_SEQ = ?";
		try
		{
			stmt = con.prepareStatement(sql);
			stmt.setString(1, mid);
			stmt.setString(2, itemSeq);
			rst = stmt.executeUpdate();
			return rst;
		} finally {
			JdbcUtil.close(stmt);
		}
	}
}

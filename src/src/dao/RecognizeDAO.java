package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dbcp.JdbcUtil;
import model.Recognize;

public class RecognizeDAO {

	//페이징처리
		public static int getCount(Connection con, String itemname) throws SQLException {
			int rst = 0;
			PreparedStatement stmt = null;
			ResultSet rs = null;
			String sql = "select count(*) from MdcinPrductItem where ITEM_NAME like '%' || ? || '%'";
			try {
				stmt = con.prepareStatement(sql);
				stmt.setString(1, itemname);
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

				
		
	public static List<Recognize> getList(Connection con, String itemname, int pageNo, int size) throws SQLException {
		List<Recognize> rst = new ArrayList<Recognize>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "select * from (select rownum rn, "
				+ "ITEM_SEQ,"
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
				+ "UD_DOC_DATA "
				+ "from MdcinPrductItem where ITEM_NAME like '%' || ? || '%') where rn between ? and ?";
		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, itemname);
			stmt.setInt(2, pageNo);
			stmt.setInt(3, size);
			rs = stmt.executeQuery();
			while (rs.next()) {
				rst.add(
					new Recognize(
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
						rs.getString("PACK_UNIT")
					)
				);
			}
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
		}
		return rst;
	}


}
		
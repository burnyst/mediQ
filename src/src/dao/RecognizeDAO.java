package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dbcp.JdbcUtil;
import model.RecognizeModel;

public class RecognizeDAO {

	//검색에서 사용되는 클래스입니다
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
		//목록 상세 조회
		
		
		
		//검색 키워드 검색해서 list로 묶음
		public static List<RecognizeModel> selectById(Connection conn, String itemName, int pageNo, int size)throws SQLException {
			System.out.println("검색 RecognizeDAO-selectById()호출성공");
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				String sql = "select itemname  " + 
						" from ( select item from MdcinPrductItem )  " +
						" where title like '%' || ? ||'";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1,itemName); 
				
				System.out.println("pstmt 호출"+pstmt); //sql문이 나와야함
				rs = pstmt.executeQuery();
				System.out.println("rs 호출"+rs);
				List<RecognizeModel> resultt = new ArrayList<>();
				while( rs.next() ) {
					resultt.add(a(rs));
				}
				return resultt;
				
		  }finally {
			JdbcUtil.close(rs);  
			JdbcUtil.close(pstmt);
		  }
		}
			//selectById쿼리문 결과를 받아서  Search클래스타입으로 묶어주는 함수 p647 36
			private static RecognizeModel a(ResultSet rs) 
			    throws SQLException{
				System.out.println("RecognizeDAO의  a()");
				return new RecognizeModel(
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
					);
			}
				
		
	public static List<RecognizeModel> getList(Connection con, String name, int pageNo, int size) throws SQLException {
		List<RecognizeModel> rst = new ArrayList<RecognizeModel>();
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
			stmt.setString(1, name);
			stmt.setInt(2, pageNo);
			stmt.setInt(3, size);
			rs = stmt.executeQuery();
			while (rs.next()) {
				rst.add(
					new RecognizeModel(
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
		
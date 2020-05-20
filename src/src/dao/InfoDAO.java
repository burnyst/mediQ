package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dbcp.JdbcUtil;
import model.Faq;
import model.InfoModel;
import model.Product;
import model.Qnamodel;

public class InfoDAO {

	//검색에서 사용되는 클래스입니다
		public static int getCount(Connection conn, String itemName) throws SQLException {
			int rst = 0;
			PreparedStatement stmt = null;
			ResultSet rs = null;
			String sql = "select count(*) from MdcinPrductItem where ITEM_NAME like '%' || ? || '%'";
			try {
				stmt = conn.prepareStatement(sql);
				stmt.setString(1, itemName);
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
	
	public static List<InfoModel> getList(Connection con, String itemName, int pageNo, int size) throws SQLException {
		List<InfoModel> rst = new ArrayList<InfoModel>();
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
			stmt.setString(1, itemName);
			stmt.setInt(2, pageNo);
			stmt.setInt(3, size);
			rs = stmt.executeQuery();
			while (rs.next()) {
				rst.add(
					new InfoModel(
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
	
	
	
	
	
	//테이블의 특정 글번호 조회
	public InfoModel selectById(Connection conn, String itemName) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		try {
			String sql = "select * from MdcinPrductItem where item_Name=?";
			pstmt = conn.prepareStatement(sql);	
			pstmt.setString(1, itemName);
			rs = pstmt.executeQuery();
			
			InfoModel item_Name1 = null;
			if(rs.next()) {
				item_Name1 = convertinfo(rs);
			}
			return item_Name1;
		
		}finally {
				JdbcUtil.close(rs);
				JdbcUtil.close(pstmt);
			}
		}
		
	//select쿼리문 결과를 받아서 info클래스타입으로 묶어주는 함수 호출
	InfoModel convertinfo(ResultSet rs) throws SQLException{
		return new InfoModel(
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
	

	
	
	public InfoModel insert(Connection conn, InfoModel im) throws SQLException{
		PreparedStatement pstmt = null;
		Statement stmt = null;
		ResultSet rs   = null;	
		try {
			String sql = "insert into MdcinPrductItem(ITEM_SEQ, ITEM_NAME, ENTP_NAME, ITEM_PERMIT_DATE, CANCEL_DATE, ETC_OTC_CODE, CHANGE_DATE, CHART, CLASS_NO,  PACK_UNIT, NB_DOC_DATA, EE_DOC_DATA, UD_DOC_DATA)" + 
					"            values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,im.getItemSeq());
			pstmt.setString(2,im.getItemName());
			pstmt.setString(3,im.getEntpName());
			pstmt.setString(4,im.getItemPermitDate());
			pstmt.setString(5,im.getCancelDate());
			pstmt.setString(6,im.getEtcOtcCode());
			pstmt.setString(7,im.getChangeDate());
			pstmt.setString(8,im.getChart());
			pstmt.setString(9,im.getClassNo());
			pstmt.setString(10,im.getPackUnit());
			pstmt.setString(11,im.getNbDocData());
			pstmt.setString(12,im.getEeDocData());
			pstmt.setString(13,im.getUdDocData());
			pstmt.executeUpdate();
			
			return im;
			
		}finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
			JdbcUtil.close(pstmt);
		}
	}
	
	
	public int update(Connection conn, String itemSeq, String itemName, String entpName,
			String itemPermitDate, String cancelDate, String etcOtcCode, String changeDate, String chart,
			String classNo, String packUnit, String nbDocData, String eeDocData, String udDocData) throws SQLException{
			PreparedStatement pstmt = null;
			try {
				String sql="update MdcinPrductItem set "
						+ " ItemSeq=?,ItemName=?,EntpName=?,ItemPermitDate=?,"
						+ "CancelDate=?,EtcOtcCode=?,ChangeDate=?,Chart=?,ClassNo=?,"
						+ "PackUnit=?,NbDocData=?,EeDocData=?,UdDocData=?"
						+ "where ITEM_NAME like '%' || ? || '%'";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1,itemSeq);
				pstmt.setString(2,itemName);
				pstmt.setString(3,entpName);
				pstmt.setString(4,itemPermitDate);
				pstmt.setString(5,cancelDate);
				pstmt.setString(6,etcOtcCode);
				pstmt.setString(7,changeDate);
				pstmt.setString(8,chart);
				pstmt.setString(9,classNo);
				pstmt.setString(10,packUnit);
				pstmt.setString(11,nbDocData);
				pstmt.setString(12,eeDocData);
				pstmt.setString(13,udDocData);
				int cnt =pstmt.executeUpdate();
						
				System.out.println("글 수정InfoDAO-update()호출성공 category="+cnt);

				return cnt;
			}finally {
				JdbcUtil.close(pstmt);
			}
	}


	//search select
		public List<InfoModel> selectt(Connection conn,int startRow, int size) throws SQLException{
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				String sql= "select * from (select rownum rn, "
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
				
				pstmt=conn.prepareStatement(sql);
				pstmt.setInt(1,startRow);		
				pstmt.setInt(2,size);
				pstmt.setInt(3,startRow);
				rs = pstmt.executeQuery();
				List<InfoModel> result = new ArrayList<>();
				while(rs.next()) {
					result.add(convertinfo(rs));
				}
				return result;
				
			}finally {
				JdbcUtil.close(rs);
				JdbcUtil.close(pstmt);
			}
		}

		//게시물 수 구하기
		public int selectCount(Connection conn) throws SQLException{
			System.out.println("전체게시물수 구하기 FaqDAO-selectCount()호출성공");
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				String sql = "select count(*) from MdcinPrductItem";
				pstmt = conn.prepareStatement(sql);
				rs=pstmt.executeQuery();
				if(rs.next()) {
					return rs.getInt(1);
				}
				return 0;
			}finally {
				JdbcUtil.close(rs);
				JdbcUtil.close(pstmt);
			}
		}

	



}
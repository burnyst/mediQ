package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dbcp.JdbcUtil;
import model.InfoContent;

public class InfoContentDAO {

	public static InfoContent insert(Connection conn, InfoContent content) throws SQLException{
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement("insert into InfoContent" +
		"content) value(?)");
		pstmt.setString(1, content.getContent());
		int insertedCount = pstmt.executeUpdate();
		if(insertedCount>0) {
			return content;
		}else {
		return null;
	}
}finally {
	JdbcUtil.close(pstmt);
}
}
}
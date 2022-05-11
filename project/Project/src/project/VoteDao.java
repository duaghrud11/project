package project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class VoteDao {

	Connection conn = null;
	PreparedStatement ptmt = null;
	ResultSet rs = null;
	JdbcTemplate jdbc;

	public VoteDao() {
		jdbc = JdbcTemplate.getInstance();
	}

	public boolean vote(VoteVo vo) {
		boolean flat = false;
		try {

			String sql = "select \"NAME\" from \"MENU\" where \"NUMBER\"=" + vo.getVote_num();

			conn = jdbc.getConnection();
			ptmt = conn.prepareStatement(sql);
			rs = ptmt.executeQuery();
			rs.next();
			String menustring = rs.getString(1);
			
			String sql2 = "insert into \"VOTE\" values (SEQ_VOTE.nextval,?)";
			conn = jdbc.getConnection();
			ptmt = conn.prepareStatement(sql2);
			ptmt.setString(1, menustring);
			ptmt.executeUpdate();
			System.out.println("투표가 실행되었습니다.");

			flat = true;
		} catch (SQLException e) {
			System.out.println("잘못입력하셧습니다 .");
		} finally {

			if (ptmt != null) {
				try {
					ptmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return flat;
	}
	public List<VoteVo> list() {
		List<VoteVo> arr = new ArrayList<>();
		try {
	
			String sql = "select \"NAME\",count(*) from \"VOTE\" group by \"NAME\"";
			conn = jdbc.getConnection();
			ptmt = conn.prepareStatement(sql);
			rs = ptmt.executeQuery();
	
			while (rs.next()) {
				VoteVo vv = new VoteVo(rs.getString(1), rs.getInt(2));
	
				arr.add(vv);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (ptmt != null) {
				try {
					ptmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	
		return arr;
}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}


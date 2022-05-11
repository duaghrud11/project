package project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class MenuDao {

	Connection conn = null;
	PreparedStatement ptmt = null;
	ResultSet rs = null;
	JdbcTemplate jdbc;

	MenuDao() {
		jdbc = JdbcTemplate.getInstance();
	}

	public boolean insert(MenuVo vo) {
		boolean flat = false;
		try {
			String sql = "insert into \"MENU\" values (SEQ_MENU.nextval,?)";
			conn = jdbc.getConnection();
			ptmt = conn.prepareStatement(sql);
			ptmt.setString(1, vo.getTour());
			ptmt.executeUpdate();
			System.out.println("설문 보기가 추가 되었습니다. ");
			flat = true;
		} catch (SQLException e) {
			e.printStackTrace();
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

	public List<MenuVo> show() {
		List<MenuVo> arr = new ArrayList<>();
		try {

			String sql = "select * from \"MENU\" order by \"NUMBER\"";
			conn = jdbc.getConnection();
			ptmt = conn.prepareStatement(sql);
			rs = ptmt.executeQuery();

			while (rs.next()) {
				MenuVo menu = new MenuVo(rs.getLong(1), rs.getString(2));

				arr.add(menu);
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

package processor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import data.KeepTickets;

public class KeepTicketsController {
	public boolean save(KeepTickets one) throws ClassNotFoundException {
		boolean result = false;
		// 1. 데이터 베이스 연결
		Class.forName("oracle.jdbc.driver.OracleDriver");
		try (Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@43.201.68.36:1521:xe", "homekeeper",
				"oracle")) {
			// 2. 필요한 작업요청을 전송하고 응답을 받으면 됨.
			String sql = "INSERT INTO keep_tickets VALUES(?, ?, ?)";
			PreparedStatement pst = conn.prepareStatement(sql);

			pst.setString(1, one.getCode());
			pst.setString(2, one.getUserId());
			pst.setDate(3, one.getExpiredAt());

			int n = pst.executeUpdate(); // 요청 전송하고 DB에서 응답을 받아옴.
			if (n == 1) {
				result = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public KeepTickets findById(String id) throws ClassNotFoundException {
		Class.forName("oracle.jdbc.driver.OracleDriver");

		try (Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@43.201.68.36:1521:xe", "homekeeper",
				"oracle")) {
			String sql = "SELECT * FROM USERS WHERE ID=?";

			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, id);

			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				KeepTickets one = new KeepTickets();

				one.setCode(rs.getString("code"));
				one.setUserId(rs.getString("user_id"));
				one.setExpiredAt(rs.getDate("expired_at"));
				return one;

			} else {
				return null;
			}

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

}

package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import data.Category;
import data.SpendLog;
import data.Users;

public class SpendLogDao {

	public boolean save(SpendLog one) throws ClassNotFoundException {
		boolean result = false;
		// 1. 데이터 베이스 연결
		Class.forName("oracle.jdbc.driver.OracleDriver");
		try (Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@43.201.68.36:1521:xe", "homekeeper",
				"oracle")) {
			// 2. 필요한 작업요청을 전송하고 응답을 받으면 됨.
			String sql = "INSERT INTO spend_log VALUES(SPEND_LOGS_SEQ.NEXTVAL, ?, ?, ?, ?, ?)";
			PreparedStatement pst = conn.prepareStatement(sql);

			pst.setString(1, one.getUserId());
			pst.setDate(2, one.getSpendAt());
			pst.setInt(3, one.getAmt());
			pst.setString(4, one.getUseDesc());
			pst.setInt(5, one.getCategoryId());

			int n = pst.executeUpdate(); // 요청 전송하고 DB에서 응답을 받아옴.
			if (n == 1) {
				result = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public List<SpendLog> findUserId(String userId) throws ClassNotFoundException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		try (Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@43.201.68.36:1521:xe", "homekeeper",
				"oracle")) {
			String sql = "select s.*, c.name from spend_log s join categorys c on s.category_id = c.id where user_id=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, userId);//요걸 반드시 추가해줘야한다.

			ResultSet rs = pst.executeQuery();
			List<SpendLog> list = new ArrayList<>();
			while (rs.next()) {
				// SpendLog(int no, String userId, int amt, Date spendAt, String useDesc, int
				// categoryId)
				SpendLog log = new SpendLog(rs.getInt("no"), rs.getString("user_id"), rs.getInt("amt"),
						rs.getDate("spend_at"), rs.getString("use_desc"), rs.getInt("category_id"),

						new Category(rs.getInt("category_id"), rs.getString("name"))); //에러났던 이유는 생성자가 없었기때문이다. 이걸 확인해야해.

				list.add(log);

			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}
	public boolean deleteByKey(String key) throws ClassNotFoundException { 
		boolean result = false;
		// 1. 데이터 베이스 연결
		Class.forName("oracle.jdbc.driver.OracleDriver");
		try (Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@43.201.68.36:1521:xe", "torich",
				"oracle")) {
			// 2. 필요한 작업요청을 전송하고 응답을 받으면 됨.
			String sql ="DELETE FROM PLAYERS WHERE ID=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, key);
			
			int n = pstmt.executeUpdate(); // 요청 전송하고 DB에서 응답을 받아옴.
			if (n == 1) {	// PK로 삭제시엔 1 or 0
				result = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}

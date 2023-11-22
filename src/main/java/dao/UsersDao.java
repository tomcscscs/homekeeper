package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import data.Avatars;
import data.Users;

public class UsersDao {

	public boolean save(Users one) throws ClassNotFoundException {
		boolean result = false;
		// 1. 데이터 베이스 연결
		Class.forName("oracle.jdbc.driver.OracleDriver");
		try (Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@43.201.68.36:1521:xe", "homekeeper",
				"oracle")) {
			// 2. 필요한 작업요청을 전송하고 응답을 받으면 됨.
			String sql = "INSERT INTO users VALUES(?, ?, ?, ?, ?, ?)";
			PreparedStatement pst = conn.prepareStatement(sql);

			pst.setString(1, one.getId());
			pst.setString(2, one.getPassword());
			pst.setInt(3, one.getBirth());
			pst.setString(4, one.getGender());
			pst.setString(5, one.getNickname());
			pst.setString(6, one.getAvatarId());

			int n = pst.executeUpdate(); // 요청 전송하고 DB에서 응답을 받아옴.
			if (n == 1) {
				result = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public Users findById(String id) throws ClassNotFoundException {
		Class.forName("oracle.jdbc.driver.OracleDriver");

		try (Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@43.201.68.36:1521:xe", "homekeeper",
				"oracle")) {
			String sql = "SELECT * FROM USERS WHERE ID=?";

			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, id);

			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				Users one = new Users();

				one.setId(rs.getString("id"));
				one.setPassword(rs.getString("password"));
				one.setBirth(rs.getInt("birth"));
				one.setGender(rs.getString("gender"));
				one.setNickname(rs.getString("nickname"));
				one.setAvatarId(rs.getString("avatar_Id"));

				return one;
//				String id = rs.getString(1); // rs.getInt("code")
//				String password = rs.getString(2); // rs.getString("name");
//				int balance = rs.getInt(3); // rs.getInt("price");
//
//				return new Player(id, password, balance);
			} else {
				return null;
			}

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	public Users findWithAvatarById(String userId) throws ClassNotFoundException {
		Class.forName("oracle.jdbc.driver.OracleDriver");

		try (Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@43.201.68.36:1521:xe", "homekeeper",
				"oracle")) {
			String sql = "select * from users u left join  avatars a on u.avatar_id = a.id where id=?";

			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, userId);

			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				Users user = new Users();

				user.setId(rs.getString("id"));
				user.setPassword(rs.getString("password"));
				user.setBirth(rs.getInt("birth"));
				user.setGender(rs.getString("gender"));
				user.setNickname(rs.getString("nickname"));
				user.setAvatarId(rs.getString("avatar_Id"));

				Avatars a = new Avatars();
				a.setId(rs.getString("avatar_id"));
				a.setAlt(rs.getString("alt"));
				a.setImageUrl(rs.getString("image_url"));

				user.setAvatar(a);

				return user;
			} else {
				return null;
			}

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	public boolean deleteByNo(int no) throws ClassNotFoundException {
		boolean result = false;
		// 1. 데이터 베이스 연결
		Class.forName("oracle.jdbc.driver.OracleDriver");
		try (Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@43.201.68.36:1521:xe", "homekeeper",
				"oracle")) {
			// 2. 필요한 작업요청을 전송하고 응답을 받으면 됨.
			String sql = "DELETE FROM spend_log WHERE no=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, no);

			int n = pst.executeUpdate(); // 요청 전송하고 DB에서 응답을 받아옴. 삭제는 이게 맞을 듯.
			if (n == 1) { // PK로 삭제시엔 1 or 0
				result = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}

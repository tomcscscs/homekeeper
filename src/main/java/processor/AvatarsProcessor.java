package processor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import data.Avatars;

public class AvatarsProcessor {
	public Avatars findByKey(Avatars key) throws ClassNotFoundException {
		Class.forName("oracle.jdbc.driver.OracleDriver");

		try (Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@43.201.68.36:1521:xe", "homekeeper", "oracle")) {

			String sql = "SELECT * FROM avatars WHERE id=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, key.getId());

			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				String id = rs.getString("id");
				String alt = rs.getString("alt");
				String imageUrl = rs.getString("image_url");

				return new Avatars(id, alt, imageUrl);
			} else {
				return null;
			}

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	public List<Avatars> findAll() throws ClassNotFoundException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		try (Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@43.201.68.36:1521:xe", "homekeeper", "oracle")) {
			String sql = "SELECT * FROM avatars ORDER BY alt desc";
			PreparedStatement pst = conn.prepareStatement(sql);

			ResultSet rs = pst.executeQuery();
			List<Avatars> list = new ArrayList<>();
			while (rs.next()) {
				String id = rs.getString("id");
				String alt = rs.getString("alt");
				String imageUrl = rs.getString("image_url");

				Avatars one = new Avatars(id, alt, imageUrl);
				list.add(one);

			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

}

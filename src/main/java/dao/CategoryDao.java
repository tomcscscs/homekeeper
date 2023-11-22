package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import data.Category;

public class CategoryDao {
	public List<Category> findAll() throws ClassNotFoundException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		try (Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@43.201.68.36:1521:xe", "homekeeper",
				"oracle")) {
			String sql = "SELECT * FROM categorys ORDER BY id asc";
			PreparedStatement pst = conn.prepareStatement(sql);

			ResultSet rs = pst.executeQuery();
			List<Category> list = new ArrayList<>();
			while (rs.next()) {
				int id = rs.getInt("id"); // rs.getInt("code")
				String name = rs.getString("name"); // rs.getString("name");

				Category one = new Category(id, name);
				list.add(one);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

}

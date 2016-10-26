package server_connections.database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DbConnection {
	// Fields
	private Connection con;
	private Statement st;

	public DbConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/steppe", "root", "");

		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
	}

	public List<String> getQuestion() {
		List<String> result = new ArrayList<String>();

		ResultSet rs = null;

		try {
			st = con.createStatement();

			rs = st.executeQuery(
					"Select p.idPlaces, p.latitude, p.longitude, p.name, p.description, p.photo, q.idQuestions, q.question from place as p join question as q on p.idPlaces=q.idPlaces order by rand() limit 1;  ");
			while (rs.next()) {
				result.add(rs.getString("latitude"));
				result.add(rs.getString("longitude"));
				result.add(rs.getString("question"));
				result.add(rs.getString("description"));
				result.add(rs.getString("name"));
				result.add(rs.getString("photo"));

				result.add(rs.getString("idPlaces"));
				result.add(rs.getString("idQuestions"));
				
			}
		} catch (SQLException e) {
			System.out.println(e);
		}

		return result;
	}

}

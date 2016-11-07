package server_connections.database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DbConnection {
	// Fields
	private Connection con;
	private Statement st;
	private ResultSet rs;

	public DbConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/steppe", "root", "");
			st = con.createStatement();
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
	}

	public List<String> getQuestion() {
		List<String> result = new ArrayList<String>();

		try {
			rs = st.executeQuery(
					"Select p.idPlace, p.latitude, p.longitude, p.name, p.description, p.photo, q.idQuestion, q.question from place as p join question as q on p.idPlace=q.idPlace order by rand() limit 1;  ");
			while (rs.next()) {
				result.add(rs.getString("latitude"));
				result.add(rs.getString("longitude"));
				result.add(rs.getString("question"));
				result.add(rs.getString("description"));
				result.add(rs.getString("name"));
				result.add(rs.getString("photo"));
				result.add(rs.getString("idPlace"));
				result.add(rs.getString("idQuestion"));

			}
		} catch (SQLException e) {
			System.out.println(e);
		}

		return result;
	}

	public void SignUp(String login, String name, String password) throws SQLException {

		st.executeUpdate("insert into user values ('" + login + "', '" + name + "', '" + password + "');");

	}

	public boolean SignIn(String login, String password) throws SQLException {

		rs = st.executeQuery("Select * from user where login='" + login + "' and password='" + password + "';");

		if (!rs.next()) {
			return false;
		}
		return true;
	}
}

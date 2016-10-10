package server_connections.database;

import java.sql.*;

public class Db_Connection {
	// Fields
	private Connection con;
	private Statement st;

	public Db_Connection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/steppe", "root", "");
			
			st = con.createStatement();
			
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
	}

	public String getData(String query) {
		String data = "";
		try {
			ResultSet rs = st.executeQuery(query);
			
			while(rs.next()){
				data+=rs.getString("idPlaces")+" ";
				data+=rs.getString("latitude")+" ";
				data+=rs.getString("longitude")+" ";
				data+=rs.getString("name")+" ";
				data+=rs.getString("description")+" ";
				data+=rs.getString("photo")+" ";
				
			}
			
		} catch (SQLException e) {
			System.out.println(e);
		}
		return data;
	}

}

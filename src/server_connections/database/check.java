package server_connections.database;

import java.sql.SQLException;

public class check {
	public static void main(String args[]) {
		DbConnection db = new DbConnection();
	
			System.out.println(db.SignIn("serik.zhilibayev", "qwerty123"));

	}
}

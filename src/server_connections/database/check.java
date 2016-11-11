package server_connections.database;

import java.sql.SQLException;
import java.util.Arrays;

public class check {
	public static void main(String args[]) {
		DbConnection db = new DbConnection();
	
			System.out.println(Arrays.toString(db.getListOfTopics("aidar.babanov").get(0)));

	}
}

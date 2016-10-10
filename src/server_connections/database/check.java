package server_connections.database;

public class check {
	
	public static void main(String args[]){
		Db_Connection connection = new Db_Connection();
		
		String s = connection.getData("select * from place;");
		System.out.println(s);
	}
}

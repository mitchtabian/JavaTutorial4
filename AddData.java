package SQL;

import java.sql.*;
import java.util.Scanner;

public class AddData {
	private static Connection conn = null;
	private static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		try {
			String userName = "root";
			String password = "";
			String url = "jdbc:mysql://localhost:3306/mitch_db?useSSL=false";
			conn = DriverManager.getConnection(url,userName,password);
			System.out.println("Enter the name.");
			String name = scan.next();
			System.out.println("Enter the email");
			String email = scan.next();
			addData(name,email);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
	private static void addData(String name, String email) throws SQLException {
		String query = "INSERT INTO names VALUES (NULL, '"+name+"', '"+email+"');";
		Statement stmt = null;
		stmt = conn.createStatement();
		stmt.executeUpdate(query);
		stmt.close();
		conn.close();
	}

}

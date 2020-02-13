package hr.atos.praksa.PatrikVinicki.zadatak15;
import java.util.Scanner;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionClass{
	private Connection conn;
	
	//defaul constructor is automattically created

	/*public ConnectionClass(Connection conn) {
		this.conn = conn;
	}*/

	/*public void query(String sql) {
		try {
			Statement query = conn.createStatement();
		} catch (SQLException e) {
			System.out.print("\nError connecting to DB!\n");
			e.printStackTrace();
		}
	}*/
	//function for creating connection with database and making a query
	public Connection connection() {
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			this.conn = null;
			//conncect to database
			this.conn = DriverManager.getConnection("jdbc:mysql://localhost/Tvrtka","root", "");
			System.out.print("Database is connected !");
			
			return conn;
		}
		//handle an exception
		catch(Exception e)
		{
			System.out.print("Error connecting to DB:"+e);
			return null;
		}
		
	}

}


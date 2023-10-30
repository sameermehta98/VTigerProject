package saturdayPractice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.mysql.cj.jdbc.Driver;
public class SampleForExecuteQueryJDBC {

	public static void main(String[] args) throws Throwable {

		Driver driver=new Driver();
		
		//Step1. Register the Driver
		DriverManager.registerDriver(driver);
		
		//Step 2. Connection with DataBase
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/empdb", "root", "qwerty");
		//Step 3. Issue create Statement
		Statement state = con.createStatement();
		//Step 4. Execute a query
		ResultSet result = state.executeQuery("select * from empinfo;");
	
		while(result.next()) {
			String value = result.getString(1);
			System.out.println(value);
		}
		con.close();
	}

}

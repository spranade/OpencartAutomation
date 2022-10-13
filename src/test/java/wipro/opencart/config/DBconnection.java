package wipro.opencart.config;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBconnection {

	
	public static void main(String args[]) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/finsys","root","");
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery("select * from cities");
		int i = 0;
		while(rs.next())
		{
			i++;
			System.out.println(rs.getString("cityname"));
			System.out.println("no of records ="+i);
		}
		
	}
	
	
	
}

package dataDrivenTesting;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;







public class ExecuteSelectQueryTest {
	public static void main(String[] args) throws SQLException {
		
		//1.load/register the data base
	
		Driver driverRef=new Driver();
		
		DriverManager.registerDriver(driverRef);
		
		//2.Connect to dataBase
		
	Connection connection=	DriverManager.getConnection("jdbc:mysql://49.249.28.218:3333/ninza_hrm","root","root");
	
	System.out.println("====Done===");
	
	//3.Create Sql Statement
	     Statement stat = connection.createStatement();
	 //4.Excute select query and get result
	     
	 ResultSet resultSet= stat.executeQuery("select* from project");
	 
	 while(resultSet.next())//to excute till there is null in table
	 {
	  
	  System.out.println(resultSet.getString(1)+"\t"+ resultSet.getString(2)+"\t" +resultSet.getString(3));//to check the expected data is available are not
	  //5. close connection
	  
	 }
	  connection.close();
	
	}


}


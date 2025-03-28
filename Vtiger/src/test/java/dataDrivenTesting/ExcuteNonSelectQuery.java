package dataDrivenTesting;


import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;

public class ExcuteNonSelectQuery {
	public static void main(String[] args) throws SQLException {
		
		Driver driverRef=new Driver();
		
		DriverManager.registerDriver(driverRef);
		
		
Connection connection=		DriverManager.getConnection("jdbc:mysql://49.249.28.218:3333/ninza_hrm","root","root");
          // Statement stat=connection.createStatement();
	}

}

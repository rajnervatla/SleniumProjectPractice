package mySqlDBConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {
	public static void main(String[] args) throws SQLException {

		// 1.Create a connection
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hr", "root", "root");

		// 2.Create a statement object
		Statement stmt = con.createStatement();

		String s = "select * from Employee";
		String s2 = "insert into Employee(F_Name,L_Name,Age,Address,city,state,salary) values('Billt','gates',20,'usa','c','usa',150000)";

		// 3.Execute the statement

		stmt.execute(s2);

		ResultSet rs = stmt.executeQuery(s);

		while (rs.next()) {

			String name = rs.getString("F_Name");
			int age = rs.getInt("Age");

			System.out.println("Name of Employee :: " + name + "  Age of the employee :: " + age);
		}

		// 4.Close the connection

		con.close();
		System.out.println("Connection Ended....");

	}

}

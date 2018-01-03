package com.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedHashMap;

import com.db.dbhelper.DataBaseHelper;
import com.db.dbhelper.SqlDbHelper;


public class DbConnection {

	public static void main(String[] args) throws SQLException {
		//Step 1 : Getting the Driver - jar
		//Setp 2 : Load the driver into the memory
		//Step 3 : Get the Connection
		//Step 4 : Create a object which will execute query
		
		
		
		String connectionString = "jdbc:sqlserver://localhost:1433;databaseName=SqlData;user=sa;password=admin@1234#;integratedSecurity=false;";
		Connection connection = null;
		Statement statement = null;
		ResultSet result;
		ResultSetMetaData data;
		
		DataBaseHelper db = new SqlDbHelper();
		db.setConnectionString(connectionString);
		try {
			LinkedHashMap<Integer, LinkedHashMap<String, String>> data1 = db.executeQuery("select * from Table_1 where id = 1");
			System.out.println(data1.toString());
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		
		String deleteQuery = "delete from Table_1 where id = 2";
		String updateQuery = "update Table_1 set code=105 where Name like 'Name%'";
		String insertQuery = "insert into Table_1 (Name,Address,Code,id) VALUES ('Name Four','Address Four','107',1)";
		
		
		// First apporach for loading the driver in memory
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			connection = DriverManager.getConnection(connectionString);
			statement = connection.createStatement();
			int count = statement.executeUpdate(insertQuery);
			System.out.println("Row affected : "+count);
			//result = statement.executeQuery("Select * from Table_1");
			//data = result.getMetaData();
			
			/*String [] columnName = new String[data.getColumnCount()];
			
			for(int i = 1; i <= data.getColumnCount(); i++){
				columnName[i - 1] = data.getColumnName(i);
			}
			*/
			
			/*while(result.next()){
				System.out.println(String.format("%s : %s : %d : %d", result.getString(1),result.getString(2),result.getInt(3),result.getInt(4)));
			}
			*/
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}finally {
			statement.close();
			connection.close();
		}
		// Second Apporach 
		
		/*try {
			DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
		} catch (SQLException e) {
			e.printStackTrace();
		}*/

	}

}

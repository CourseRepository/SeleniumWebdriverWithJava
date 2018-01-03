package com.db.dbhelper;

import java.sql.SQLException;
import java.util.LinkedHashMap;

public interface DataBaseHelper {

	public DataBaseHelper setConnectionString(String connString);
	
	public int executeUpdate(String sqlQuery) throws ClassNotFoundException, SQLException;
	
	//Outer map object will have data as <row no,MapObject>, inner map object will have the data as <Column Name,Column value>
	public LinkedHashMap<Integer, LinkedHashMap<String, String>> executeQuery(String sqlQuery) throws ClassNotFoundException, SQLException ;
	
}


// Sql data -> Sql helper class implement this DataBaseHelper and provide the implementation of 3 methods
// Oracle data -> Oracle helper class implement this DataBaseHelper and provide the implementation of 3 methods
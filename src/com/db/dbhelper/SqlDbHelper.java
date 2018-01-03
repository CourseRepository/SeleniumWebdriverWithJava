package com.db.dbhelper;

import java.io.Closeable;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.LinkedHashMap;

public class SqlDbHelper implements DataBaseHelper,Closeable {

	private String connString;
	
	private Connection getConnection() throws ClassNotFoundException, SQLException{
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		return DriverManager.getConnection(connString);
	}
	
	private Statement getStatement() throws ClassNotFoundException, SQLException{
		return getConnection().createStatement();
	}
	
	@Override
	public DataBaseHelper setConnectionString(String connString) {
		this.connString = connString;
		return this;
	}

	@Override
	public int executeUpdate(String sqlQuery) throws ClassNotFoundException, SQLException {
		return getStatement().executeUpdate(sqlQuery);
	}

	//Outer map object will have data as <row no,MapObject>, inner map object will have the data as <Column Name,Column value>
	
	@Override
	public LinkedHashMap<Integer, LinkedHashMap<String, String>> executeQuery(String sqlQuery) throws ClassNotFoundException, SQLException {
		ResultSet result = getStatement().executeQuery(sqlQuery);
		
		String[] columnName = getColumnName(result);
		
		LinkedHashMap<Integer, LinkedHashMap<String, String>> dbData = new LinkedHashMap<>();
		int couter = 1; // row no 1
		while(result.next()){
			dbData.put(couter, getDbData(columnName,result));
			couter++;
		}
		return dbData;
	}

	private LinkedHashMap<String, String> getDbData(String[] columnName, ResultSet result) throws SQLException {
		LinkedHashMap<String, String> columnData = new LinkedHashMap<>();
		
		for(int i = 0; i < columnName.length; i++){
			columnData.put(columnName[i], getColumnData(i,result));
		}
		
		return columnData;
		
	}

	private String getColumnData(int i, ResultSet result) throws SQLException {
		int type = result.getMetaData().getColumnType(i + 1);
		
		switch (type) {
		case Types.VARCHAR:
			return result.getString(i + 1);
		case Types.NUMERIC:
			return result.getInt(i+1) + "";
		}
		return null;
	}

	private String[] getColumnName(ResultSet result) throws SQLException {
		ResultSetMetaData data = result.getMetaData();
		String[] columnName = new String[data.getColumnCount()];
		
		for(int i = 1; i <= data.getColumnCount(); i++){
			columnName[i-1] = data.getColumnName(i);
		}
		return columnName;
	}

	@Override
	public void close() throws IOException {
		// Logic for managing the connection
		
	}



}

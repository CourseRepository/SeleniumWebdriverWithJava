package helper;

import java.util.*;
import java.sql.*;

/**
 * @author - rahul.rathore
 * @date - 16-Nov-2014
 */
public class ConnectionPoolManager {

	private final int MAX_POLL_SIZE;
	private final int Time_Out;
	private static Vector<Connection> connectionPool = null;
	private ReadConfigProperty prop = new ReadConfigProperty();
	
	public ConnectionPoolManager(final int size,int waitTime) {
		MAX_POLL_SIZE = size;
		Time_Out = waitTime; 
		createPool();
	}
	
	private void createPool() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		connectionPool = new Vector<Connection>(MAX_POLL_SIZE);
		while(connectionPool.size() < MAX_POLL_SIZE){
			connectionPool.add(generateConnection());
		}
		
	}

	private Connection generateConnection() {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:sqlserver://" + prop.getHost() + ":1433;databaseName=" + prop.getDbName() + ";selectMethod=cursor;sendStringParametersAsUnicode=false", prop.getUsername(), prop.getPassword());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
	
	public Connection getConnectionFromPool(){
		Connection connection = null;
		
		if(connectionPool.size() <= 0){
			waitforPoolObject();
			connection = connectionPool.remove(0);
		}else{
			connection = connectionPool.remove(0);
		}
		return connection;
	}
	
	private void waitforPoolObject() {
		long start = System.currentTimeMillis();
		while(connectionPool.size() <= 0 && (System.currentTimeMillis() - start) < Time_Out ){
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}

	public void returnToPool(Connection connection) {
		if(connectionPool.size() >= MAX_POLL_SIZE){
			throw new PoolOverFlowException("Pool is full. Can't add more Object to the pool");
		}else{
			if(connection != null){
				connectionPool.add(connection);
			}
		}
			
		
	}

}

class NoMoreConnectionPoolObjectException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public NoMoreConnectionPoolObjectException(String msg){
		super(msg);
	}
}

class PoolOverFlowException extends RuntimeException {
	
	private static final long serialVersionUID = -5492369951090684183L;

	public PoolOverFlowException(String msg){
		super(msg);
	}
}
	
	



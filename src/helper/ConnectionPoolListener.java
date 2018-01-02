package helper;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.log4j.Logger;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

/**
 * @author - rahul.rathore
 * @date - 16-Nov-2014
 */
public class ConnectionPoolListener implements ISuiteListener,ITestListener {
	
	private final String DBDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private final ReadConfigProperty prop = new ReadConfigProperty();
	private final String url = "jdbc:sqlserver://" + prop.getHost() + ":1433;databaseName=" + prop.getDbName() + ";selectMethod=cursor;sendStringParametersAsUnicode=false";
	private BasicDataSource source = null;
	public static Connection connection = null;
	private static final Logger oLog = LoggerHelper.getLogger(ConnectionPoolListener.class);
	
	private void intiDatabase() {
		try {
			source = new BasicDataSource();
			source.setDriverClassName(DBDriver);
			source.setUsername(prop.getDbUserName());
			source.setPassword(prop.getDbPassword());
			source.setUrl(url);
			source.setInitialSize(10);
			connection = source.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
			oLog.fatal(" Unable to Create the Database Pool : ", e);
		}
		
	}
	
	
	@Override
	public void onFinish(ISuite arg0) {
		try {
			if(connection != null){
				connection.close();
				connection = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			oLog.fatal(" Unable to Close the Database Connection : ", e);
			
		}
		
	}

	@Override
	public void onStart(ISuite arg0) {
		/*System.out.println("===============================================");
		System.out.println("=============== " + arg0.getName()+ " Started " + "===================");
		System.out.println("===============================================");*/
		oLog.info(arg0.getName()+ " Started ");
		intiDatabase();
		
	}
	
	public static Connection getConnectionObject(){
		return connection;
	}


	@Override
	public void onFinish(ITestContext arg0) {
		oLog.info(arg0.getName()+ " Finished ");
	}


	@Override
	public void onStart(ITestContext arg0) {
		/*System.out.println("===============================================");
		System.out.println("=============== " + arg0.getName()+ " Started " + "===================");
		System.out.println("===============================================");*/
		oLog.info(arg0.getName()+ " Started ");
		
	}


	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void onTestFailure(ITestResult arg0) {
		
	}


	@Override
	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void onTestStart(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void onTestSuccess(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

}

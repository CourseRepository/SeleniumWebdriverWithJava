package helper;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.log4j.Logger;

/**
 * @author - rahul.rathore
 * @date - 16-Nov-2014
 */
public class DatabaseHelper extends ConnectionPoolListener {

	private static String table_name = "";
	private static String[] col_name = null;
	private static String where_clause = "";
	private static Connection oConn = ConnectionPoolListener.getConnectionObject(); 
	private static final Logger oLog = LoggerHelper.getLogger(DatabaseHelper.class);
	/**
	 * @param tbl_name
	 * @param colName
	 * @param whereClause
	 * @return Map<String, String>
	 * @throws SQLException
	 */
	public static Object[][] getDataBaseData(String tbl_name, String[] colName,String whereClause) throws SQLException {
		
		table_name = tbl_name;
		col_name = colName;
		where_clause = whereClause;

		String SQLQuery = "select ";
		for (int i = 0; i < col_name.length - 1; i++)
			SQLQuery = SQLQuery + col_name[i] + ",";

		SQLQuery = SQLQuery + col_name[col_name.length - 1] + " from "
				+ table_name + " " + where_clause;

		int i = 0;
		Map<String, String> map;
		try {

			
			Statement oStmt = oConn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			ResultSet oRS = oStmt.executeQuery(SQLQuery);

			oRS.last();
			oRS.getRow();
			int NumOfRows = oRS.getRow();
			oRS.beforeFirst();

			Object[][] data = new Object[NumOfRows][1];

			while (oRS.next()) {

				map = new LinkedHashMap<String, String>();

				for (int j = 0; j < col_name.length; j++)
					map.put(col_name[j], oRS.getString(j + 1));

				data[i][0] = map;
				i++;
			}

			return data;

		} catch (Exception e) {
			e.printStackTrace();
			oLog.fatal(" Database Exception : ", e);

		} 
		return null;
	}
	
	public static void updateTable(String Query) {
		try {
			Statement smt = oConn.createStatement();
			smt.executeUpdate(Query);
		} catch (SQLException e) {
			e.printStackTrace();
			oLog.fatal(" Database Exception : ", e);
		}
		
	}
	
	
}

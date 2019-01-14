package com.uniwareauto.utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.uniwareauto.test.BaseTest;







public class dbQuery {
	private static String executeQueryString(String query) throws SQLException
	{
		ResultSet resultSet = null;
        String result;
		try {
			Statement statement = ((Connection) BaseTest.connection).createStatement();
			resultSet = statement.executeQuery(query);
		} catch (SQLException e) {
                  e.printStackTrace();
		}
		resultSet.next();
		result	=	resultSet.getString(1);
		return result;
	}
	private static String executeUpdateQueryString(String query) throws SQLException
	{
		ResultSet resultSet = null;
        String result;
		try {
			Statement statement = ((Connection) BaseTest.connection).createStatement();
			//resultSet = 
					statement.executeUpdate(query);
		//			.executeQuery(query);
		} catch (SQLException e) {
                  e.printStackTrace();
		}
		resultSet.next();
		result	=	resultSet.getString(1);
		return result;
	}
	private static String executeQueryWithVariable(String query) throws SQLException
	{
		ResultSet resultSet = null;
        String result;
		try {
			Statement statement = ((Connection) BaseTest.connection).prepareStatement(query);
			resultSet = statement.executeQuery(query);
		} catch (SQLException e) {
                  e.printStackTrace();
		}
		resultSet.next();
		result	=	resultSet.getString(1);
		return result;
	}
	private static List<String> executeQueryList(String query) throws Exception {
		List<String> list	=	new ArrayList<String>();
		ResultSet resultSet = null;
		try {
			Statement statement = ((Connection) BaseTest.connection).createStatement();
		
			resultSet = statement
					.executeQuery(query);

		} catch (SQLException e) {

		}
		while(resultSet.next())
		{
			if(resultSet.getString(1)==null)
	          list.add(resultSet.getString(1));
			else
			list.add(resultSet.getString(1).trim());	
		}
		return list;	
	}
	public static String getOrderStatus() throws SQLException{
		//String query="select status_code from sale_order where code = :statusCode";
		String query="select status_code from sale_order where customer_name ='Guest' order by created desc limit 1";
		String result	=	executeQueryString(query);
		return result;
	}
	public static String deleteParty() throws SQLException{
		//String query="select status_code from sale_order where code = :statusCode";
		String query="delete from party where code='autotest'";
		String result	=	executeUpdateQueryString(query);
		return result;
	}
	/*public static List<String> getBuyers() throws Exception{
		String query="select name from buyer order by name limit 50";
		List<String> result	=	executeQueryList(query);
		return result;
	}
	public static String getBuyer() throws SQLException{
		String query="select name from buyer where buyer_id='havels'";
		String result	=	executeQueryString(query);
		return result;
	}
	public static String getInvCount() throws SQLException{
		String query="select count(*) from invoice";
		String result = executeQueryString(query);
		return result;
		
	}*/
}

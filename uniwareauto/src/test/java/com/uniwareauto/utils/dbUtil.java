package com.uniwareauto.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class dbUtil {
	//public static Connection connection;
	static Connection connection;
	public static Connection getConnection(String dbname) throws ClassNotFoundException, SQLException{
		  //String dbUrl = "jdbc:mysql://54.255.164.1:3306/"+dbname;
		//String dbUrl = "jdbc:mysql://localhost:3306/"+dbname; 
		
		//Database Username     
	        String username = "root";   
	         
	        //Database Password     
	        String password = "uniware";             

	        //Query to Execute      
	        //String query = "select *  from buyer where buyer_id=100;";  
	         
	        //Load mysql jdbc driver        
	        Class.forName("com.mysql.jdbc.Driver");         
	    
	        //Create Connection to DB       
	        connection = DriverManager.getConnection(dbname,username,password);
	        System.out.println("db connection created");
	        
		return connection;
		
	}
	public static void closeConnection() throws SQLException{
		connection.close();
		System.out.println("SQL DB connection closed");
	}
}

package com.uniwareauto.utils;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SqlConnector {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		 //Connection URL Syntax: "jdbc:mysql://ipaddress:portnumber/db_name"        
        String dbUrl = "jdbc:mysql://54.255.164.1:3306/ems";                   

        //Database Username     
        String username = "automation";   
         
        //Database Password     
        String password = "NriMiYnNHZFEh1sJc6qQ";             

        //Query to Execute      
        String query = "select *  from buyer where buyer_id=100;";  
         
        //Load mysql jdbc driver        
        Class.forName("com.mysql.jdbc.Driver");         
    
        //Create Connection to DB       
        java.sql.Connection con = DriverManager.getConnection(dbUrl,username,password);
   
        //Create Statement Object       
       Statement stmt = con.createStatement();                  

        // Execute the SQL Query. Store results in ResultSet        
        ResultSet rs= stmt.executeQuery(query);                         
  
        // While Loop to iterate through all data and print results     
        while (rs.next()){
                    String myName = rs.getString(3);                                        
                    String myAge = rs.getString(4);                                                
                    System. out.println(myName+"  "+myAge);     
            }       
         // closing DB Connection       
        con.close();            
	}
	
}



	




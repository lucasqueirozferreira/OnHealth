/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gu.com.gls.connectionFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Gustavo Lopes
 */
public class ConnectionFactory {
    
    public static Connection getConnection() throws SQLException{
    	
    	System.out.println("Conectando...");
    	
        try{
        	
        	Class.forName("com.mysql.jdbc.Driver");
        	
        } catch(ClassNotFoundException e){
        	
            throw new SQLException(e);
        }
        
        return DriverManager.getConnection("jdbc:mysql://localhost/onhealth","root", "Gustalopes@3247");
        
    }
}

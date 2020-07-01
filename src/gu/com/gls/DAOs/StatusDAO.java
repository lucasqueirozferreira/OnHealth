/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gu.com.gls.DAOs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import gu.com.gls.Beans.StatusJB;
import gu.com.gls.connectionFactory.ConnectionFactory;

/**
 *
 * @author Gustavo Lopes
 */
public class StatusDAO {
    
    private Connection connection;
    public StatusDAO(){
    
        try {
			new ConnectionFactory();
			this.connection = ConnectionFactory.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

        
    }
    
    public void insert(StatusJB status){
    	
    	String sql = "INSERT INTO Status" + "(Descricao, Cod_Exame)" 
    	+ "values (?,?)";
    	
        try{
        
        	PreparedStatement stmt = this.connection.prepareStatement(sql);
        
        	stmt.setString(1, status.getDescricao());
        	stmt.setInt(2, status.getExame());
        
        	stmt.execute();
        	stmt.close();
        	System.out.println("Success!");
        	stmt.close();
        	
        } catch(SQLException e){
        	throw new RuntimeException(e);
        }
    }
    
public static StatusJB selectCod(int id) throws SQLException {
		
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		StatusJB status = new StatusJB();
		
		
		try {
			stmt = con.prepareStatement("SELECT * FROM Status WHERE ID = ?");
			stmt.setInt(1, id);
			
			rs = stmt.executeQuery();
			
			if(rs.next()) {
								
				status.setId(id);
				status.setDescricao(rs.getString("Descricao"));
				status.setExame(rs.getInt("Cod_Exame"));
			}
			
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return status;
		
	}
	public static String delete(int id) throws SQLException {
	
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
	
	
		try {
			stmt = con.prepareStatement("DELETE FROM Status WHERE ID = ?");
			stmt.setInt(1, id);
		
			rs = stmt.executeQuery();
		
			if(rs.next()) {
			return "Success";
			}
		
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return "Status excluído com sucesso";
	}
}

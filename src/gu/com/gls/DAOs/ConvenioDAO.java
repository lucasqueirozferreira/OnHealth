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

import gu.com.gls.Beans.ConvenioJB;
import gu.com.gls.connectionFactory.ConnectionFactory;

/**
 *
 * @author Gustavo Lopes
 */
public class ConvenioDAO {
    
    private Connection connection;
    public ConvenioDAO(){
    
        try {
			new ConnectionFactory();
			this.connection = ConnectionFactory.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

        
    }
    
    public void insert(ConvenioJB convenio){
    	
    	String sql = "INSERT INTO Convenio" + "(Codigo, Nome, Planos, Tel, Email, Licenca)" 
    	+ "values (?,?,?,?,?,?)";
    	
        try{
        
        	PreparedStatement stmt = this.connection.prepareStatement(sql);
        
        	stmt.setInt(1, convenio.getCod());
        	stmt.setString(2, convenio.getNome());
        	stmt.setString(3, convenio.getPlanos());
        	stmt.setInt(4, convenio.getTel());
        	stmt.setString(5, convenio.getEmail());
        	stmt.setString(6, convenio.getLicenca());
        
        	stmt.execute();
        	stmt.close();
        	System.out.println("Success!");
        	stmt.close();
        	
        } catch(SQLException e){
        	throw new RuntimeException(e);
        }
    }
    
public static ConvenioJB selectCod(int cod) throws SQLException {
		
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ConvenioJB convenio = new ConvenioJB();
		
		
		try {
			stmt = con.prepareStatement("SELECT * FROM Convenio WHERE Codigo = ?");
			stmt.setInt(1, cod);
			
			rs = stmt.executeQuery();
			
			if(rs.next()) {
								
				convenio.setCod(cod);
				convenio.setNome(rs.getString("Nome"));
				convenio.setPlanos(rs.getString("Planos"));
				convenio.setTel(rs.getInt("Tel"));
				convenio.setEmail(rs.getString("Email"));
				convenio.setLicenca(rs.getString("Licenca"));
				
				
				
			}
			
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return convenio;
		
	}
	public static String delete(int cod) throws SQLException {
	
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
	
	
		try {
			stmt = con.prepareStatement("DELETE FROM Convenio WHERE Codigo = ?");
			stmt.setInt(1, cod);
		
			rs = stmt.executeQuery();
		
			if(rs.next()) {
			return "Success";
			}
		
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return "Convênio excluído com sucesso";
	}
}

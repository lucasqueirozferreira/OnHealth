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
import gu.com.gls.Beans.Pac_MedicoJB;
import gu.com.gls.connectionFactory.ConnectionFactory;

/**
 *
 * @author Gustavo Lopes
 */
public class Pac_MedicoDAO {
    
    private Connection connection;
    public Pac_MedicoDAO(){
    
        try {
			new ConnectionFactory();
			this.connection = ConnectionFactory.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

        
    }
    
    public void insert(Pac_MedicoJB junction){
    	
    	String sql = "INSERT INTO Pac_Medico" + "(Quantidade_Medico, Quantidade_Paciente, Paciente, Medico)" 
    	+ "values (?,?,?,?)";
    	
        try{
        
        	PreparedStatement stmt = this.connection.prepareStatement(sql);
        
        	stmt.setInt(1, junction.getQtdMedico());
        	stmt.setInt(2, junction.getQtdPaciente());
        	stmt.setString(3, junction.getPaciente());
        	stmt.setInt(4, junction.getMedico());
        
        	stmt.execute();
        	stmt.close();
        	System.out.println("Success!");
        	stmt.close();
        	
        } catch(SQLException e){
        	throw new RuntimeException(e);
        }
    }
    
public static Pac_MedicoJB selectCod(int id) throws SQLException {
		
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Pac_MedicoJB junction = new Pac_MedicoJB();
		
		
		try {
			stmt = con.prepareStatement("SELECT * FROM Pac_Medico WHERE ID_PMedico = ?");
			stmt.setInt(1, id);
			
			rs = stmt.executeQuery();
			
			if(rs.next()) {
								
				junction.setId(id);
				junction.setPaciente(rs.getString("Paciente"));
				junction.setMedico(rs.getInt("Medico"));
				junction.setQtdPaciente(rs.getInt("Quantidade_Paciente"));
				junction.setQtdMedico(rs.getInt("Quantidade_Medico"));
			}
			
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return junction;
		
	}
	public static String delete(int id) throws SQLException {
	
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
	
	
		try {
			stmt = con.prepareStatement("DELETE FROM Pac_Medico WHERE ID_PMedico = ?");
			stmt.setInt(1, id);
		
			rs = stmt.executeQuery();
		
			if(rs.next()) {
			return "Success";
			}
		
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return "Junction excluído com sucesso";
	}
}

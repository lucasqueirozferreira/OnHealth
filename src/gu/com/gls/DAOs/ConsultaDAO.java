/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gu.com.gls.DAOs;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import gu.com.gls.Beans.ConsultaJB;
import gu.com.gls.Beans.PacienteJB;
import gu.com.gls.connectionFactory.ConnectionFactory;

/**
 *
 * @author Gustavo Lopes
 */
public class ConsultaDAO {
    
    private Connection connection;
    public ConsultaDAO(){
    
        try {
			new ConnectionFactory();
			this.connection = ConnectionFactory.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

        
    }
    
    public void insert(ConsultaJB consulta){
    	
    	String sql = "INSERT INTO consulta" + "(Nome, Data, Data_Resultado, Resultado, Paciente, Medico, Link_Consulta, Confirmada)" 
    	+ "values (?,?,?,?,?,?,?,?)";
    	
        try{
        
        	PreparedStatement stmt = this.connection.prepareStatement(sql);
        
        	stmt.setString(1, consulta.getNome());
        	stmt.setDate(2, consulta.getDataE());
        	stmt.setDate(3, consulta.getDataR());
        	stmt.setString(4, consulta.getResultado());
        	stmt.setString(5, consulta.getPaciente());
        	stmt.setString(6, consulta.getMedico());
        	stmt.setString(7, consulta.getLink());
        	stmt.setString(8, "Pendente");
        
        	stmt.execute();
        	stmt.close();
        	System.out.println("Success!");
        	stmt.close();
        	
        } catch(SQLException e){
        	throw new RuntimeException(e);
        }
    }
    
public static List<ConsultaJB> selectPac(String pac) throws SQLException {
		
	List<ConsultaJB> consultas = new ArrayList<>();
	
	Connection con = ConnectionFactory.getConnection();
	PreparedStatement stmt = null;
	ResultSet rs = null;
	
	try {
		
		stmt = con.prepareStatement("SELECT * FROM consulta WHERE paciente = ? ORDER BY Nome ASC");
		stmt.setString(1, pac);
		rs = stmt.executeQuery();
		
		while(rs.next()) {
			
			ConsultaJB consulta = new ConsultaJB();
			
			consulta.setNome(rs.getString("Nome"));
			consulta.setResultado(rs.getString("Resultado"));
			consulta.setPaciente(rs.getString("Paciente"));
			consulta.setMedico(rs.getString("Medico"));
			consulta.setDataE(rs.getDate("Data"));
			consulta.setDataR(rs.getDate("Data_Resultado"));
			consulta.setConfirm(rs.getString("Confirmada"));
			consulta.setLink(rs.getString("Link_Consulta"));
							
			consultas.add(consulta);
		}
	} catch(SQLException e){
		throw new RuntimeException(e);
	}
	return consultas;
		
}

	public static String delete(int cod) throws SQLException {
	
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
	
	
		try {
			stmt = con.prepareStatement("DELETE FROM Consulta WHERE Codigo = ?");
			stmt.setInt(1, cod);
		
			rs = stmt.executeQuery();
		
			if(rs.next()) {
			return "Success";
			}
		
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return "Consulta excluída com sucesso";
	}
	
	public static List<ConsultaJB> selectAll() throws SQLException{
		
		List<ConsultaJB> consultas = new ArrayList<>();
		
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			
			stmt = con.prepareStatement("SELECT * FROM consulta ORDER BY Nome ASC");
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				
				ConsultaJB consulta = new ConsultaJB();
				
				consulta.setNome(rs.getString("Nome"));
				consulta.setResultado(rs.getString("Resultado"));
				consulta.setPaciente(rs.getString("Paciente"));
				consulta.setMedico(rs.getString("Medico"));
				consulta.setDataE(rs.getDate("Data"));
				consulta.setDataR(rs.getDate("Data_Resultado"));
				consulta.setLink(rs.getString("Link_Consulta"));
				consulta.setConfirm(rs.getString("Confirmada"));
								
				consultas.add(consulta);
			}
		} catch(SQLException e){
			throw new RuntimeException(e);
		}
		return consultas;
	}
	
	public void update(ConsultaJB consulta) throws SQLException{
		
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		
		try {
			
			stmt = con.prepareStatement("UPDATE consulta set Data_Resultado = ?, Resultado = ?, Confirmada = ? WHERE Codigo = ?");
			
			stmt.setDate(1, consulta.getDataR());
			stmt.setString(2, consulta.getResultado());
			stmt.setString(3, "Realizada");
			stmt.setInt(4, consulta.getCod());
			
			stmt.executeUpdate();
			
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
public static List<ConsultaJB> selectPen() throws SQLException{
		
		List<ConsultaJB> consultas = new ArrayList<>();
		
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			
			stmt = con.prepareStatement("SELECT * FROM consulta WHERE Confirmada = 'Pendente' ORDER BY Data ASC");
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				
				ConsultaJB consulta = new ConsultaJB();
				
				consulta.setCod(rs.getInt("Codigo"));
				consulta.setNome(rs.getString("Nome"));
				consulta.setResultado(rs.getString("Resultado"));
				consulta.setPaciente(rs.getString("Paciente"));
				consulta.setMedico(rs.getString("Medico"));
				consulta.setDataE(rs.getDate("Data"));
				consulta.setDataR(rs.getDate("Data_Resultado"));
				consulta.setConfirm(rs.getString("Confirmada"));
				consulta.setLink(rs.getString("Link_Consulta"));
								
				consultas.add(consulta);
			}
		} catch(SQLException e){
			throw new RuntimeException(e);
		}
		return consultas;
	}

public static List<ConsultaJB> selectCod(int cod) throws SQLException {
	
	List<ConsultaJB> consultas = new ArrayList<>();
	
	Connection con = ConnectionFactory.getConnection();
	PreparedStatement stmt = null;
	ResultSet rs = null;
	
	try {
		
		stmt = con.prepareStatement("SELECT * FROM consulta WHERE Codigo = ? ORDER BY Nome ASC");
		stmt.setInt(1, cod);
		rs = stmt.executeQuery();
		
		while(rs.next()) {
			
			ConsultaJB consulta = new ConsultaJB();
			
			consulta.setCod(rs.getInt("Codigo"));
			consulta.setNome(rs.getString("Nome"));
			consulta.setResultado(rs.getString("Resultado"));
			consulta.setPaciente(rs.getString("Paciente"));
			consulta.setMedico(rs.getString("Medico"));
			consulta.setDataE(rs.getDate("Data"));
			consulta.setDataR(rs.getDate("Data_Resultado"));
			consulta.setConfirm(rs.getString("Confirmada"));
			consulta.setLink(rs.getString("Link_Consulta"));
							
			consultas.add(consulta);
		}
	} catch(SQLException e){
		throw new RuntimeException(e);
	}
	return consultas;
		
}

public void addLink(ConsultaJB consulta) throws SQLException{
	
	Connection con = ConnectionFactory.getConnection();
	PreparedStatement stmt = null;
	
	try {
		
		stmt = con.prepareStatement("UPDATE consulta set Link_Consulta = ?, Medico = ?, Confirmada = ? WHERE Codigo = ?");
		
		stmt.setString(1, consulta.getLink());
		stmt.setString(2, consulta.getMedico());
		stmt.setString(3, "Confirmada");
		stmt.setInt(4, consulta.getCod());
		
		stmt.executeUpdate();
		
	} catch(SQLException e) {
		throw new RuntimeException(e);
	}
}

public static List<ConsultaJB> selectMed(String crm) throws SQLException {
	
	List<ConsultaJB> consultas = new ArrayList<>();
	
	Connection con = ConnectionFactory.getConnection();
	PreparedStatement stmt = null;
	ResultSet rs = null;
	
	try {
		
		stmt = con.prepareStatement("SELECT * FROM consulta WHERE Medico = ? AND Confirmada = ? ORDER BY Nome ASC");
		stmt.setString(1, crm);
		stmt.setString(2, "Realizada");
		rs = stmt.executeQuery();
		
		while(rs.next()) {
			
			ConsultaJB consulta = new ConsultaJB();
			
			consulta.setCod(rs.getInt("Codigo"));
			consulta.setNome(rs.getString("Nome"));
			consulta.setResultado(rs.getString("Resultado"));
			consulta.setPaciente(rs.getString("Paciente"));
			consulta.setMedico(rs.getString("Medico"));
			consulta.setDataE(rs.getDate("Data"));
			consulta.setDataR(rs.getDate("Data_Resultado"));
			consulta.setConfirm(rs.getString("Confirmada"));
			consulta.setLink(rs.getString("Link_Consulta"));
							
			consultas.add(consulta);
		}
	} catch(SQLException e){
		throw new RuntimeException(e);
	}
	return consultas;
		
}

public static List<ConsultaJB> selectRes(int cod) throws SQLException {
	
	List<ConsultaJB> consultas = new ArrayList<>();
	
	Connection con = ConnectionFactory.getConnection();
	PreparedStatement stmt = null;
	ResultSet rs = null;
	
	try {
		
		stmt = con.prepareStatement("SELECT * FROM consulta WHERE Codigo = ?");
		stmt.setInt(1, cod);
		rs = stmt.executeQuery();
		
		while(rs.next()) {
			
			ConsultaJB consulta = new ConsultaJB();
			
			consulta.setCod(rs.getInt("Codigo"));
			consulta.setNome(rs.getString("Nome"));
			consulta.setResultado(rs.getString("Resultado"));
			consulta.setPaciente(rs.getString("Paciente"));
			consulta.setMedico(rs.getString("Medico"));
			consulta.setDataE(rs.getDate("Data"));
			consulta.setDataR(rs.getDate("Data_Resultado"));
			consulta.setConfirm(rs.getString("Confirmada"));
			consulta.setLink(rs.getString("Link_Consulta"));
							
			consultas.add(consulta);
		}
	} catch(SQLException e){
		throw new RuntimeException(e);
	}
	return consultas;
		
}
}
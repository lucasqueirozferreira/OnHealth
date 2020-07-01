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
import java.util.logging.Level;
import java.util.logging.Logger;

import gu.com.gls.Beans.MedicoJB;
import gu.com.gls.Beans.PacienteJB;
import gu.com.gls.connectionFactory.ConnectionFactory;

/**
 *
 * @author Gustavo Lopes
 */
public class MedicoDAO {
    
    private Connection connection;
    public MedicoDAO(){
    
        try {
			new ConnectionFactory();
			this.connection = ConnectionFactory.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

        
    }
    
    public void insert(MedicoJB medico){
    	
    	String sql = "INSERT INTO medico" + "(CRM, Nome, Nascimento, Especialidade, Tel, Email, Senha)" 
    	+ "values (?,?,?,?,?,?,?)";
    	
        try{
        
        	PreparedStatement stmt = this.connection.prepareStatement(sql);
        
        	stmt.setString(1, medico.getCrm());
        	stmt.setString(2, medico.getNome());
        	stmt.setDate(3, new Date(medico.getNascimento().getTimeInMillis()));
        	stmt.setString(4, medico.getEspecialidade());
        	stmt.setString(5, medico.getTel());
        	stmt.setString(6, medico.getEmail());
        	stmt.setString(7, medico.getSenha());
        
        	stmt.execute();
        	stmt.close();
        	System.out.println("Success!");
        	stmt.close();
        	
        } catch(SQLException e){
        	throw new RuntimeException(e);
        }
    }
    
public static MedicoJB selectCrm(String crm) throws SQLException {
		
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Date nascimento = null;
		MedicoJB medico = new MedicoJB();
		
		
		try {
			stmt = con.prepareStatement("SELECT * FROM Medico WHERE CRM = ?");
			stmt.setString(1, crm);
			
			rs = stmt.executeQuery();
			
			if(rs.next()) {
				
				nascimento = rs.getDate("Nascimento");
								
				medico.setCrm(crm);
				medico.setNome(rs.getString("Nome"));
				medico.setEspecialidade(rs.getString("Especialidade"));
				medico.setEmail(rs.getString("Email"));
				medico.setTel(rs.getString("Tel"));
				
				String[] dataSeparada = nascimento.toString().split("-");
				int ano = Integer.parseInt(dataSeparada[0]);
				int mes = Integer.parseInt(dataSeparada[1]);
				int dia = Integer.parseInt(dataSeparada[2]);
				
				Calendar hoje = Calendar.getInstance();
				
				int idade = hoje.get(Calendar.YEAR) - ano;
				if (hoje.get(Calendar.MONTH) + 1 == mes &&
		                hoje.get(Calendar.DAY_OF_MONTH) < dia ||
		                hoje.get(Calendar.MONTH) + 1 < mes) {
		            idade--;
		        }
				
				medico.setIdade(idade);
				
				
			}
			
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return medico;
		
	}
	public static String delete(String crm) throws SQLException {
	
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
	
	
		try {
			stmt = con.prepareStatement("DELETE FROM Medico WHERE CRM = ?");
			stmt.setString(1, crm);
		
			rs = stmt.executeQuery();
		
			if(rs.next()) {
			return "Success";
			}
		
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return "Médico excluído com sucesso";
	}
	
	public static boolean checkLogin(String crm, String senha) throws SQLException {
		
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Boolean check = false;
		
		try {
			stmt = con.prepareStatement("SELECT * FROM Medico WHERE CRM = ? AND Senha = ?");
			stmt.setString(1, crm);
			stmt.setString(2, senha);
			
			rs = stmt.executeQuery();
			
			if(rs.next()) {
				check = true;
			}
		} catch(SQLException e) {
			Logger.getLogger(MedicoDAO.class.getName()).log(Level.SEVERE, null, e);
		}
		return check;
	}
	
	public static List<MedicoJB> selectAll() throws SQLException{
		
		List<MedicoJB> medicos = new ArrayList<>();
		
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Date nascimento = null;
		
		try {
			
			stmt = con.prepareStatement("SELECT * FROM Medico ORDER BY Nome ASC limit 3");
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				
				MedicoJB medico = new MedicoJB();
				
				nascimento = rs.getDate("Nascimento");
				
				medico.setCrm(rs.getString("CRM"));
				medico.setNome(rs.getString("Nome"));
				medico.setEspecialidade(rs.getString("Especialidade"));
				medico.setEmail(rs.getString("Email"));
				medico.setTel(rs.getString("Tel"));
				
				String[] dataSeparada = nascimento.toString().split("-");
				int ano = Integer.parseInt(dataSeparada[0]);
				int mes = Integer.parseInt(dataSeparada[1]);
				int dia = Integer.parseInt(dataSeparada[2]);
				
				Calendar hoje = Calendar.getInstance();
				
				int idade = hoje.get(Calendar.YEAR) - ano;
				if (hoje.get(Calendar.MONTH) + 1 == mes &&
		                hoje.get(Calendar.DAY_OF_MONTH) < dia ||
		                hoje.get(Calendar.MONTH) + 1 < mes) {
		            idade--;
		        }
				
				medico.setIdade(idade);
				
				medicos.add(medico);
			}
		} catch(SQLException e){
			throw new RuntimeException(e);
		}
		return medicos;
	}
	
public static boolean checkEmail(String crm, String email) throws SQLException{
		
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		boolean check = false;
		
		try {
			stmt = con.prepareStatement("SELECT * FROM medico WHERE Email = ? AND CRM = ?");
			stmt.setString(1, email);
			stmt.setString(2, crm);
			
			rs = stmt.executeQuery();
			
			if(rs.next()) {
				check = true;
			}
		} catch(SQLException e) {
			Logger.getLogger(PacienteDAO.class.getName()).log(Level.SEVERE, null, e);
		}
		return check;
	}

public static void updateSenha(String crm, String senha) throws SQLException{
	Connection con = ConnectionFactory.getConnection();
	PreparedStatement stmt = null;
	
	
	stmt = con.prepareStatement("update medico set Senha = ? where CRM = ? ");
	stmt.setString(1, senha);
	stmt.setString(2, crm);
	
	stmt.execute();
	
	selectCrm(crm);
                
}

}

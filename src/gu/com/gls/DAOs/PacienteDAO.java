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

import gu.com.gls.Beans.PacienteJB;
import gu.com.gls.connectionFactory.ConnectionFactory;


/**
 *
 * @author Gustavo Lopes
 */
public class PacienteDAO {
    
    private Connection connection;
    public PacienteDAO(){
    
        try {
			new ConnectionFactory();
			this.connection = ConnectionFactory.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

        
    }
    
    public void insert(PacienteJB paciente){
    	
    	String sql = "INSERT INTO paciente" + "(CPF, Nome, Nascimento, RG, Sexo, Tel, Email, Endereco, Senha)" 
    	+ "values (?,?,?,?,?,?,?,?,?)";
    	
        try{
        
        	PreparedStatement stmt = this.connection.prepareStatement(sql);
        
        	stmt.setString(1, paciente.getCpf());
        	stmt.setString(2, paciente.getNome());
        	stmt.setDate(3, new Date(paciente.getNascimento().getTimeInMillis()));
        	stmt.setString(4, paciente.getRg());
        	stmt.setString(5, paciente.getSexo());
        	stmt.setString(6, paciente.getTel());
        	stmt.setString(7, paciente.getEmail());
        	stmt.setString(8, paciente.getEnd());
        	stmt.setString(9, paciente.getSenha());
        
        	stmt.execute();
        	stmt.close();
        	System.out.println("Success!");
        	stmt.close();
        	
        } catch(SQLException e){
        	throw new RuntimeException(e);
        }
    }
    
public static PacienteJB selectCpf(String cpf) throws SQLException {
		
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Date nascimento = null;
		PacienteJB paciente = new PacienteJB();
		
		
		try {
			stmt = con.prepareStatement("SELECT * FROM paciente WHERE CPF = ?");
			stmt.setString(1, cpf);
			
			rs = stmt.executeQuery();
			
			if(rs.next()) {
				
				nascimento = rs.getDate("nascimento");
								
				paciente.setCpf(cpf);
				paciente.setNome(rs.getString("Nome"));
				paciente.setRg(rs.getString("RG"));
				paciente.setEmail(rs.getString("Email"));
				paciente.setSexo(rs.getString("Sexo"));
				paciente.setTel(rs.getString("Tel"));
				paciente.setEnd(rs.getString("Endereco"));
				
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
				
				paciente.setIdade(idade);
				
				
			}
			
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return paciente;
		
	}
	public static String delete(String cpf) throws SQLException {
	
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
	
	
		try {
			stmt = con.prepareStatement("DELETE FROM paciente WHERE CPF = ?");
			stmt.setString(1, cpf);
		
			rs = stmt.executeQuery();
		
			if(rs.next()) {
			return "Success";
			}
		
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return "Paciente excluído com sucesso";
	}
	
	public static boolean checkLogin(String cpf, String senha) throws SQLException{
		
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		boolean check = false;
		
		try {
			stmt = con.prepareStatement("SELECT * FROM Paciente WHERE CPF = ? AND Senha = ?");
			stmt.setString(1, cpf);
			stmt.setString(2, senha);
			
			rs = stmt.executeQuery();
			
			if(rs.next()) {
				check = true;
				selectCpf(cpf);
			}
		} catch(SQLException e) {
			Logger.getLogger(PacienteDAO.class.getName()).log(Level.SEVERE, null, e);
		}
		return check;
	}
	
public static List<PacienteJB> selectAll() throws SQLException{
		
		List<PacienteJB> pacientes = new ArrayList<>();
		
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Date nascimento = null;
		
		try {
			
			stmt = con.prepareStatement("SELECT * FROM paciente ORDER BY Nome ASC LIMIT 5");
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				
				PacienteJB paciente = new PacienteJB();
				
				nascimento = rs.getDate("nascimento");
				
				paciente.setCpf(rs.getString("CPF"));
				paciente.setNome(rs.getString("Nome"));
				paciente.setRg(rs.getString("RG"));
				paciente.setEmail(rs.getString("Email"));
				paciente.setSexo(rs.getString("Sexo"));
				paciente.setTel(rs.getString("Tel"));
				paciente.setEnd(rs.getString("Endereco"));
				
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
				
				paciente.setIdade(idade);
				
				pacientes.add(paciente);
			}
		} catch(SQLException e){
			throw new RuntimeException(e);
		}
		return pacientes;
	}

	public static void updateSenha(String cpf,String senha) throws SQLException{
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		
		
		stmt = con.prepareStatement("update paciente set Senha = ? where CPF = ? ");
		stmt.setString(1, senha);
		stmt.setString(2, cpf);
		
		stmt.execute();
		
		selectCpf(cpf);
                    
}
	
public static boolean checkEmail(String cpf, String email) throws SQLException{
		
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		boolean check = false;
		
		try {
			stmt = con.prepareStatement("SELECT * FROM Paciente WHERE Email = ? AND CPF = ?");
			stmt.setString(1, email);
			stmt.setString(2, cpf);
			
			rs = stmt.executeQuery();
			
			if(rs.next()) {
				check = true;
			}
		} catch(SQLException e) {
			Logger.getLogger(PacienteDAO.class.getName()).log(Level.SEVERE, null, e);
		}
		return check;
	}
}

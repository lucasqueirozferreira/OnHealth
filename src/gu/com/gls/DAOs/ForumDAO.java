package gu.com.gls.DAOs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import gu.com.gls.Beans.ConsultaJB;
import gu.com.gls.Beans.ForumJB;
import gu.com.gls.Beans.ForumJBStatic;
import gu.com.gls.connectionFactory.ConnectionFactory;

public class ForumDAO {
	private Connection connection;
    public ForumDAO(){
    
        try {
			new ConnectionFactory();
			this.connection = ConnectionFactory.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

        
    }
    
    public void insert(ForumJB forum){
    	
    	String sql = "INSERT INTO Forum" + "(Titulo, Pergunta,Resposta)" 
    	+ "values (?,?,?)";
    	
        try{
        
        	PreparedStatement stmt = this.connection.prepareStatement(sql);
        
        	stmt.setString(1, forum.getTitulo());
        	stmt.setString(2, forum.getPergunta());
        	stmt.setString(3, forum.getResposta());
        
        	stmt.execute();
        	stmt.close();
        	System.out.println("Success!");
        	stmt.close();
        	
        } catch(SQLException e){
        	throw new RuntimeException(e);
        }
    }
    
    public static List<ForumJB> select() throws SQLException {
		
    	List<ForumJB> forums = new ArrayList<>();
    	
    	Connection con = ConnectionFactory.getConnection();
    	PreparedStatement stmt = null;
    	ResultSet rs = null;
    	
    	try {
    		
    		stmt = con.prepareStatement("SELECT * FROM Forum");
    		rs = stmt.executeQuery();
    		
    		while(rs.next()) {
    			
    			ForumJB forum = new ForumJB();
    			
    			forum.setId(rs.getInt("Id"));
    			forum.setTitulo(rs.getString("Titulo"));
    			forum.setPergunta(rs.getString("Pergunta"));
    			forum.setResposta(rs.getString("Resposta"));
    							
    			forums.add(forum);
    		}
    	} catch(SQLException e){
    		throw new RuntimeException(e);
    	}
    	return forums;
    		
    }
    
    public void selectCod(int cod) throws SQLException {
    	
    	
    	Connection con = ConnectionFactory.getConnection();
    	PreparedStatement stmt = null;
    	ResultSet rs = null;
    	
    	try {
    		
    		stmt = con.prepareStatement("SELECT * FROM Forum WHERE Id = ?");
    		stmt.setInt(1, cod);
    		rs = stmt.executeQuery();
    		
    		while(rs.next()) {
    			
    			ForumJBStatic forum = new ForumJBStatic();
    			
    			forum.setId(rs.getInt("Id"));
    			forum.setTitulo(rs.getString("Titulo"));
    			forum.setPergunta(rs.getString("Pergunta"));
    			forum.setResposta(rs.getString("Resposta"));
    							
 
    		}
    	} catch(SQLException e){
    		throw new RuntimeException(e);
    	}
    		
    }


	public static String delete(int id) throws SQLException {
	
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
	
	
		try {
			stmt = con.prepareStatement("DELETE FROM Forum WHERE ID = ?");
			stmt.setInt(1, id);
		
			rs = stmt.executeQuery();
		
			if(rs.next()) {
			return "Success";
			}
		
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return "Forum excluído com sucesso";
	}
	
	public void addResp(ForumJB forum) throws SQLException{
		
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		
		try {
			
			stmt = con.prepareStatement("UPDATE Forum set Resposta = ? WHERE Id = ?");
			
			stmt.setString(1, forum.getPergunta());
			stmt.setInt(2, forum.getId());
			
			stmt.executeUpdate();
			
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
}

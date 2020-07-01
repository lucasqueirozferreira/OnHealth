package gu.com.gls.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.SimpleEmail;

import gu.com.gls.DAOs.MedicoDAO;
import gu.com.gls.DAOs.PacienteDAO;

@WebServlet("/esq_senha")
public class EsqueciSenhaServlet extends HttpServlet{
	
    
    @Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
        Random random = new Random();
        
        String OHMail = "onhealthltda@gmail.com";
        String senhaEmail = "onhealth123";
    	List<String> list = new ArrayList<>();
    	
    	PrintWriter out = response.getWriter();
    	
    	String id = request.getParameter("id");
    	String email = request.getParameter("email");
	
    	for(int i=0;i>=200;i++){
    		list.add("aSfXlYhT" + Integer.toString(i));
    	}
    	
    	PacienteDAO daoPac = new PacienteDAO();
    	MedicoDAO daoMed = new MedicoDAO();
    	
    	boolean checking = false;
                    		
    	if(id != null && email != null && !id.isEmpty() && !email.isEmpty() && id.length() == 11){
    		try {
    			checking = daoPac.checkEmail(id, email);
    		} catch(SQLException e) {
    			e.printStackTrace();
    		}
				if(checking == true){
				
					int index = random.nextInt(list.size());
				
					String novaSenha = list.get(index);
					
					try {
					daoPac.updateSenha(id, novaSenha);
					} catch(SQLException e) {
						e.printStackTrace();
					}
					
					SimpleEmail mail = new SimpleEmail();
					
					mail.setHostName("smtp.gmail.com");
					mail.setSmtpPort(465);
					mail.setAuthenticator(new DefaultAuthenticator(OHMail, senhaEmail));
					mail.setSSLOnConnect(true);
				
					try{
						mail.setFrom(OHMail);
						mail.setSubject("OnHealth - Confira a sua nova senha!");
						mail.setMsg("Sua senha foi atualizada! A nova senha é:" + novaSenha);
						mail.addTo(email);
						mail.send();
					
						RequestDispatcher d = request.getRequestDispatcher("/Login.jsp");
						d.forward(request, response);
						
					}catch(Exception e){
						e.printStackTrace();
						
						RequestDispatcher d = request.getRequestDispatcher("/EsqueciSenha.jsp");
						d.forward(request, response);
					}
				}
    	} else if(id != null && email != null && !id.isEmpty() && !email.isEmpty() && id.length() == 10){
    		try {
    			checking = daoMed.checkEmail(id, email);
    		} catch(SQLException e) {
    			e.printStackTrace();
    		}
				if(checking == true){
				
					int index = random.nextInt(list.size());
				
					String novaSenha = list.get(index);
					
					try {
					daoMed.updateSenha(id, novaSenha);
					} catch(SQLException e) {
						e.printStackTrace();
					}
					
					SimpleEmail mail = new SimpleEmail();
					
					mail.setHostName("smtp.gmail.com");
					mail.setSmtpPort(465);
					mail.setAuthenticator(new DefaultAuthenticator(OHMail, senhaEmail));
					mail.setSSLOnConnect(true);
				
					try{
						mail.setFrom(OHMail);
						mail.setSubject("OnHealth - Confira a sua nova senha!");
						mail.setMsg("Sua senha foi atualizada! A nova senha é:" + novaSenha);
						mail.addTo(email);
						mail.send();
					
						RequestDispatcher d = request.getRequestDispatcher("/Login.jsp");
						d.forward(request, response);
						
					}catch(Exception e){
						e.printStackTrace();
						
						RequestDispatcher d = request.getRequestDispatcher("/EsqueciSenha.jsp");
						d.forward(request, response);
					}
				}
    	} else {
    		RequestDispatcher d = request.getRequestDispatcher("/EsqueciSenha.jsp");
			d.forward(request, response);
    	}
    }
}


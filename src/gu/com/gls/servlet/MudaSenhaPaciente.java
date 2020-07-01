package gu.com.gls.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gu.com.gls.Beans.PacienteJB;
import gu.com.gls.DAOs.PacienteDAO;


@WebServlet("/muda_senha")
public class MudaSenhaPaciente extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String SenhaNova = request.getParameter("senhaNova");
		String SenhaNova2 = request.getParameter("senhaNova2");
		
		PrintWriter out = response.getWriter();
		PacienteJB paciente = new PacienteJB();
		
		if(SenhaNova.equals(SenhaNova2)) {
			PacienteDAO DAO = new PacienteDAO();
			try {
				DAO.updateSenha(paciente.getCpf(), SenhaNova);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			RequestDispatcher d = request.getRequestDispatcher("/MenuCliente.jsp");
			d.forward(request, response);
		}
		else {
			RequestDispatcher d = request.getRequestDispatcher("/MenuCliente(TrocarSenha).jsp");
			d.forward(request, response);
		}
		
		
	}
}

package gu.com.gls.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gu.com.gls.Beans.ForumJB;
import gu.com.gls.DAOs.ForumDAO;

@WebServlet("/cad_for")
public class CadastroForumServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String titulo = request.getParameter("titulo");
		String pergunta = request.getParameter("pergunta");
		
		
		ForumJB forum = new ForumJB();
		
		forum.setTitulo(titulo);
		forum.setPergunta(pergunta);
		forum.setResposta(null);
		
		ForumDAO DAO = new ForumDAO();
		DAO.insert(forum);
		
		
		RequestDispatcher d = request.getRequestDispatcher("/MenuCliente(Forum).jsp");
		d.forward(request, response);

	}
}
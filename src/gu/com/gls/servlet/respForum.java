package gu.com.gls.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gu.com.gls.Beans.ForumJB;
import gu.com.gls.Beans.PacienteJB;
import gu.com.gls.DAOs.ForumDAO;
import gu.com.gls.DAOs.PacienteDAO;

@WebServlet("/resp_forum")
public class respForum extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		String resposta = request.getParameter("resposta");
		
		ForumJB forum = new ForumJB();
		forum.setId(id);
		forum.setPergunta(resposta);
		
		ForumDAO dao = new ForumDAO();
		try {
			dao.addResp(forum);
			RequestDispatcher d = request.getRequestDispatcher("/MenuMedico(Forum).jsp");
			d.forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

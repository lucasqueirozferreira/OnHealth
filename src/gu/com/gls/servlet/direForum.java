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

import gu.com.gls.Beans.ForumJB;
import gu.com.gls.DAOs.ForumDAO;

@WebServlet("/dire_Forum")
public class direForum extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		int cod = Integer.parseInt(request.getParameter("cod"));
			
		
		ForumDAO forum = new ForumDAO();
		try {
			forum.selectCod(cod);
			RequestDispatcher d = request.getRequestDispatcher("/MenuMedico(ForumResposta).jsp");
			d.forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		
		
	}
}

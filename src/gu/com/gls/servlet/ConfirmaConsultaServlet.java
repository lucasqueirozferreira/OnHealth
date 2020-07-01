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

import gu.com.gls.Beans.ConsultaJB;
import gu.com.gls.DAOs.ConsultaDAO;

@WebServlet("/conf_con")
public class ConfirmaConsultaServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
		String link = request.getParameter("link");
		int cod = Integer.parseInt(request.getParameter("cod"));
		String crm = request.getParameter("crm");
		
		ConsultaJB consulta = new ConsultaJB();
		
		consulta.setLink(link);
		consulta.setCod(cod);
		consulta.setMedico(crm);
		
		ConsultaDAO DAO = new ConsultaDAO();
		try {
			DAO.addLink(consulta);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		/*out.println("<html>");
		out.println("<body>");
		out.println("O paciente " + paciente.getNome() + " foi cadastrado com sucesso!");
		out.println("<br/>");
		out.println("<a href='LoginPaciente.jsp'>Ir a tela de Login</a>");
		out.println("</body>");
		out.println("</html>");*/
		
		RequestDispatcher d = request.getRequestDispatcher("/MenuMedico.jsp");
		d.forward(request, response);
	}
}

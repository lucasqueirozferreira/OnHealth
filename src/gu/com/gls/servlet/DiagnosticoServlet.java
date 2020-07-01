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

import gu.com.gls.Beans.ConsultaJB;
import gu.com.gls.DAOs.ConsultaDAO;

@WebServlet("/diag_con")
public class DiagnosticoServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
		String dataTexto = request.getParameter("dataR");
		java.sql.Date dataR = null;
		int cod = Integer.parseInt(request.getParameter("cod"));
		String diagnostico = request.getParameter("diagnostico");
		
		try {
			Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dataTexto);
			dataR = new java.sql.Date(date.getTime());
		} catch(ParseException e) {
			System.out.println("Erro de conversão de data");
			return;
		}
		
		ConsultaJB consulta = new ConsultaJB();
		
		consulta.setDataR(dataR);
		consulta.setCod(cod);
		consulta.setResultado(diagnostico);
		
		ConsultaDAO DAO = new ConsultaDAO();
		try {
			DAO.update(consulta);
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
		
		RequestDispatcher d = request.getRequestDispatcher("/successDiagnostico.jsp");
		d.forward(request, response);
	}
}

package gu.com.gls.servlet;

import java.io.IOException;
import java.io.PrintWriter;
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

@WebServlet("/cad_con")
public class RealizarConsultaServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
		String nome = request.getParameter("nome");
		String dataTexto = request.getParameter("dataE");
		java.sql.Date dataExame = null;
		String cpf = request.getParameter("cpf");
			
		try {
			Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dataTexto);
			dataExame = new java.sql.Date(date.getTime());
		} catch(ParseException e) {
			System.out.println("Erro de conversão de data");
			return;
		}
		
		ConsultaJB consulta = new ConsultaJB();
		
		consulta.setNome(nome);
		consulta.setDataE(dataExame);
		consulta.setPaciente(cpf);
		
		ConsultaDAO DAO = new ConsultaDAO();
		DAO.insert(consulta);
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<body>");
		out.println("<script>");
		out.println("function myFunction() {");
		out.println("alert('I am an alert box!')");
		out.println("}");
		out.println("</script>");
		out.println("</body>");
		out.println("</html>");
		
		
		RequestDispatcher d = request.getRequestDispatcher("/MenuCliente(CadastroConsulta).jsp");
		d.forward(request, response);
	}
}

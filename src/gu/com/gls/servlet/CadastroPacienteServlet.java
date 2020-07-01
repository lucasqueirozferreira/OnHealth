package gu.com.gls.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gu.com.gls.Beans.PacienteJB;
import gu.com.gls.DAOs.PacienteDAO;

@WebServlet("/cad_pac")
public class CadastroPacienteServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
		String cpf = request.getParameter("cpf");
		String nome = request.getParameter("nome");
		String dataTexto = request.getParameter("dataNascimento");
		Calendar dataNascimento = null;
		String rg = request.getParameter("rg");
		String sexo = request.getParameter("sexo");
		String tel = request.getParameter("telefone");
		String email = request.getParameter("email");
		String end = request.getParameter("end");
		String senha = request.getParameter("senha");
		String senha2 = request.getParameter("senha2");
			
		try {
			System.out.println(dataTexto);
			Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dataTexto);
			dataNascimento = Calendar.getInstance();
			dataNascimento.setTime(date);
		} catch(ParseException e) {
			System.out.println("Erro de conversão de data");
			return;
		}
		
		if(senha.equals(senha2)) {
		
		PacienteJB paciente = new PacienteJB();
		
		paciente.setCpf(cpf);
		paciente.setNome(nome);
		paciente.setNascimento(dataNascimento);
		paciente.setRg(rg);
		paciente.setSexo(sexo);
		paciente.setTel(tel);
		paciente.setEmail(email);
		paciente.setEnd(end);
		paciente.setSenha(senha);
		
		PacienteDAO DAO = new PacienteDAO();
		DAO.insert(paciente);
		
		/*out.println("<html>");
		out.println("<body>");
		out.println("O paciente " + paciente.getNome() + " foi cadastrado com sucesso!");
		out.println("<br/>");
		out.println("<a href='LoginPaciente.jsp'>Ir a tela de Login</a>");
		out.println("</body>");
		out.println("</html>");*/
		
		RequestDispatcher d = request.getRequestDispatcher("/success.jsp");
		d.forward(request, response);
		} else {
			RequestDispatcher d = request.getRequestDispatcher("/cadastroPaciente.jsp");
			d.forward(request, response);
		}
	}
}

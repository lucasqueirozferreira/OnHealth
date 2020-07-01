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
import javax.websocket.Session;
import gu.com.gls.Beans.MedicoJB;
import gu.com.gls.DAOs.MedicoDAO;

@WebServlet("/cad_med")
public class CadastroMedicoServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
		String crm = request.getParameter("crm");
		String nome = request.getParameter("nome");
		String dataTexto = request.getParameter("dataNascimento");
		Calendar dataNascimento = null;
		String especialidade = request.getParameter("esp");
		String tel = request.getParameter("telefone");
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		String senha2 = request.getParameter("senha2");
		
		try {
			Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dataTexto);
			dataNascimento = Calendar.getInstance();
			dataNascimento.setTime(date);
		} catch(ParseException e) {
			System.out.println("Erro de conversão de data");
			return;
		}
		
		if(senha.equals(senha2)) {
		
		MedicoJB medico = new MedicoJB();
		
		medico.setCrm(crm);
		medico.setNome(nome);
		medico.setNascimento(dataNascimento);
		medico.setEspecialidade(especialidade);
		medico.setTel(tel);
		medico.setEmail(email);
		medico.setSenha(senha);
		
		MedicoDAO DAO = new MedicoDAO();
		DAO.insert(medico);
		
		/*out.println("<html>");
		out.println("<body>");
		out.println("O médico " + medico.getNome() + " foi cadastrado com sucesso!");
		out.println("<br/>");
		out.println("<a href='LoginMedico.jsp'>Ir a tela de Login</a>");
		out.println("</body>");
		out.println("</html>");*/
		
		RequestDispatcher d = request.getRequestDispatcher("/successMedico.jsp");
		d.forward(request, response);
		} else {
			RequestDispatcher d = request.getRequestDispatcher("/cadastroMedico.jsp");
			d.forward(request, response);
		}
	}
}

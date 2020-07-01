<%@page import="gu.com.gls.DAOs.PacienteDAO"%>
<%@page import="gu.com.gls.DAOs.MedicoDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Login</title>
    <link rel="stylesheet" href="CSS\styleLogin.css">
</head>
<body>
 	<div class="container">
        <div class="content first-content">
            <div class="first-column">
                <h2 class="title title-primary">Óla, amigo!</h2>
                <p class="description description-primary">Não tem conta? Sem problema</p>
                <p class="description description-primary">Faça seu cadastro abaixo:</p>
                <form action="Cadastro.jsp"><button class="btn btn-primary">Cadastro</button></form>
            </div>
            <div class="second-column">
                <h2 class="title title-second">Login</h2>
                <form class="form">
                
                    <label class="label-input" for="">
                        <i class="far fa-envelope icon-modify"></i>
                        <input type="text" placeholder="CPF/CRM" name="login">
                    </label>
                
                    <label class="label-input" for="">
                        <i class="fas fa-lock icon-modify"></i>
                        <input type="password" placeholder="Senha" name="senha">
                    </label>
                
                    <a class="password" href="EsqueciSenha.jsp">Esqueceu sua senha?</a>
                    <button class="btn btn-second">login</button>
                </form>
            </div><!-- second column -->
        </div><!-- second-content -->
    </div>
    <%
	String login = request.getParameter("login");
	String senha = request.getParameter("senha");

    if(login != null && senha != null && !login.isEmpty() && !senha.isEmpty() && login.length() == 11){
       if(PacienteDAO.checkLogin(login, senha) == true){
          session.setAttribute("cpf", login);
          response.sendRedirect("MenuCliente.jsp");
       }
    }
                    	
    if(login != null && senha != null && !login.isEmpty() && !senha.isEmpty() && login.length() <= 10){
       if(MedicoDAO.checkLogin(login, senha) == true){
          session.setAttribute("crm", login);
          response.sendRedirect("MenuMedico.jsp");
       }
    }
%>

</body>
</html>
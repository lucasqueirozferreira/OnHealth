<%@page import="gu.com.gls.DAOs.PacienteDAO"%>
<%@page import="gu.com.gls.DAOs.MedicoDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Esqueci Minha Senha</title>
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
                <h2 class="title title-second">Insira sua identificação e email</h2>
                <form class="form" action="esq_senha">
                
                	<label class="label-input" for="">
                        <i class="far fa-envelope icon-modify"></i>
                        <input type="text" placeholder="CPF/CRM" name="id">
                    </label>
                    
                    <label class="label-input" for="">
                        <i class="far fa-envelope icon-modify"></i>
                        <input type="text" placeholder="Email" name="email">
                    </label>
                
                    <a class="password" href="Login	.jsp">Voltar ao Login</a>
                    <p><input onclick="myFunction()" class="btn btn-second" type="submit" value="Mudar Senha" style="width:200px"/><p>
                </form>
            </div><!-- second column -->
        </div><!-- second-content -->
    </div>
<script src="assets/js/util.js"></script> <!-- util functions included in the CodyHouse framework -->
  <script src="assets/js/menu-aim.js"></script>
  <script src="assets/js/main.js"></script>
  <script async="" src="//www.google-analytics.com/analytics.js"></script><script type="text/javascript" src="//code.jquery.com/jquery-2.0.3.min.js"></script>
  <script type="text/javascript" src="//assets.locaweb.com.br/locastyle/2.0.6/javascripts/locastyle.js"></script>
  <script type="text/javascript" src="//netdna.bootstrapcdn.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>
  <script>
	function myFunction() {
  		alert("Geramos uma nova senha para você e enviamos para o seu email!");
	}
  </script>
</body>
</html>
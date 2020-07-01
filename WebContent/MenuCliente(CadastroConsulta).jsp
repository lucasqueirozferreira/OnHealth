<%@page import="gu.com.gls.DAOs.MedicoDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="gu.com.gls.Beans.MedicoJB"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!doctype html>
<html lang="pt-br">
<head>
	<link rel="stylesheet" type="text/css" href="//netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="//assets.locaweb.com.br/locastyle/2.0.6/stylesheets/locastyle.css">

    <meta name="viewport" content="width=device-width, initial-scale=1">
  	<link rel="stylesheet" href="CSS/styleMenu.css">
  	<title></title>
</head>

<%
	String cpf = (String) session.getAttribute("cpf");
	if(cpf == null){
		response.sendRedirect("Teste.jsp");
	}
%>

<body>
  <header class="cd-main-header js-cd-main-header">
    <div class="cd-logo-wrapper">
      <a href="MenuCliente.jsp" class="cd-logo"><img src="https://imgur.com/3dYvHRT.png" alt="Logo"></a>
    </div>
  
    <button class="reset cd-nav-trigger js-cd-nav-trigger" aria-label="Toggle menu"><span></span></button>
  
    <ul class="cd-nav__list js-cd-nav__list">
      <li class="cd-nav__item cd-nav__item--has-children cd-nav__item--account js-cd-item--has-children">
        <a href="#0">
          <span>Conta</span>
        </a>
    
        <ul class="cd-nav__sub-list">
          <li class="cd-nav__sub-item"><a href="MenuCliente(Conta).jsp">Minha Conta</a></li>
          <li class="cd-nav__sub-item"><a href="Login.jsp">Sair</a></li>
        </ul>
      </li>
    </ul>
  </header> <!-- .cd-main-header -->
  
  <main class="cd-main-content">
    <nav class="cd-side-nav js-cd-side-nav">
      <ul class="cd-side__list js-cd-side__list">
        <li class="cd-side__label"><span>Main</span></li>
        <li class="cd-side__item cd-side__item--has-children cd-side__item--overview cd-side__item--selected js-cd-item--has-children">
          <a href="#0">Realizar Consulta</a>
        </li>

        <li class="cd-side__item cd-side__item--has-children cd-side__item--notifications cd-side__item--selected  js-cd-item--has-children">
          <a href="#0">Ver Consultas</a>
          
          <ul class="cd-side__sub-list">
            <li class="cd-side__sub-item"><a href="MenuCliente(VerConsultasPendentes).jsp">Pendentes</a></li>
            <li class="cd-side__sub-item"><a href="MenuCliente(VerConsultasRealizadas).jsp">Realizadas</a></li>
          </ul>
        </li>
    
        <li class="cd-side__item cd-side__item--has-children cd-side__item--comments js-cd-item--has-children">
          <a href="MenuCliente(Forum).jsp">Forum</a>
        </li>
      </ul>
    </nav>
  
    <div class="cd-content-wrapper">
      <div class="text-component text-center">
      	<h1>Realizar Consulta</h1>
      	<br>
      	<h5>Insira os dados da sua consulta:</h5>
      	<br>
      	<form action="cad_con">
      		<p>Titulo da Consulta: <input type="text" name="nome" required/></p>
      		<p>Data de preferencia: <input type="text" placeholder="Ex.: dd/mm/aaaa" data-mask="00/00/0000" maxlength="10" autocomplete="off" name="dataE" required/></p>
      		<input type="hidden" name="cpf" value="<%=cpf%>"/>
      		<p><input onclick="myFunction()" class="btn btn-second" type="submit" value="Solicitar" style="width:100px"/><p>
      	</form>
      </div>
    </div> <!-- .content-wrapper -->
  </main> <!-- .cd-main-content -->
  <script src="assets/js/util.js"></script> <!-- util functions included in the CodyHouse framework -->
  <script src="assets/js/menu-aim.js"></script>
  <script src="assets/js/main.js"></script>
  <script async="" src="//www.google-analytics.com/analytics.js"></script><script type="text/javascript" src="//code.jquery.com/jquery-2.0.3.min.js"></script>
  <script type="text/javascript" src="//assets.locaweb.com.br/locastyle/2.0.6/javascripts/locastyle.js"></script>
  <script type="text/javascript" src="//netdna.bootstrapcdn.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>
  <script>
	function myFunction() {
  		alert("Consulta Cadastrada com sucesso");
	}
  </script>
</body>
</html>
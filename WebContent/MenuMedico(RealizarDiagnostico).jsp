<%@page import="gu.com.gls.DAOs.MedicoDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="gu.com.gls.Beans.MedicoJB"%>
<%@page import="gu.com.gls.Beans.PacienteJB"%>
<%@page import="gu.com.gls.DAOs.PacienteDAO"%>
<%@page import="gu.com.gls.Beans.ConsultaJB"%>
<%@page import="gu.com.gls.DAOs.ConsultaDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!doctype html>
<html lang="pt-br">
<head>
	<link rel="stylesheet" type="text/css" href="//netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="//assets.locaweb.com.br/locastyle/2.0.6/stylesheets/locastyle.css">

  <meta http-equiv="Content-Language" content="pt-br">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="CSS/styleMenu.css">
  <title></title>
</head>

<%
	String crm = (String) session.getAttribute("crm");
	if(crm == null){
		response.sendRedirect("Teste.jsp");
	}
%>

<body>
  <header class="cd-main-header js-cd-main-header">
    <div class="cd-logo-wrapper">
      <a href="MenuMedico.jsp" class="cd-logo"><img src="https://imgur.com/3dYvHRT.png" alt="Logo"></a>
    </div>
  
    <button class="reset cd-nav-trigger js-cd-nav-trigger" aria-label="Toggle menu"><span></span></button>
  
    <ul class="cd-nav__list js-cd-nav__list">
      <li class="cd-nav__item cd-nav__item--has-children cd-nav__item--account js-cd-item--has-children">
        <a href="#0">
          <span>Conta</span>
        </a>
    
        <ul class="cd-nav__sub-list">
          <li class="cd-nav__sub-item"><a href="MenuMedico(Conta).jsp">Minha Conta</a></li>
          <li class="cd-nav__sub-item"><a href="Deslogar.jsp">Sair</a></li>
        </ul>
      </li>
    </ul>
  </header> <!-- .cd-main-header -->
  
  <main class="cd-main-content">
    <nav class="cd-side-nav js-cd-side-nav">
      <ul class="cd-side__list js-cd-side__list">
        <li class="cd-side__label"><span>Médico</span></li>
        <li class="cd-side__item cd-side__item--has-children cd-side__item--overview js-cd-item--has-children">
          <a href="MenuMedico(Consultas).jsp">Consultas</a>
        </li>

		<li class="cd-side__item cd-side__item--has-children cd-side__item--comments js-cd-item--has-children">
          <a href="MenuMedico(Diagnostico).jsp">Diagnóstico</a>
        </li>

        <li class="cd-side__item cd-side__item--has-children cd-side__item--notifications js-cd-item--has-children">
          <a href="MenuMedico(Historico).jsp">Histórico</a>
        
        <li class="cd-side__item cd-side__item--has-children cd-side__item--comments js-cd-item--has-children">
          <a href="MenuMedico(Forum).jsp">Forum</a>
        </li>
      </ul>
    </nav>
    
    <% List<ConsultaJB> consulta = ConsultaDAO.selectRes(Integer.parseInt(request.getParameter("cod"))); %>
	<% List<PacienteJB> pacientes = PacienteDAO.selectAll(); %>
  
    <div class="cd-content-wrapper">
      <div class="text-component text-center">
      <h2>Diagnóstico</h2>
      <br>
      	<div class="card">
      		<h5>Confirme os dados da consulta e adicione o diagnóstico:</h5>
      		<% if(consulta.get(0).getConfirm().equals("Confirmada") && consulta.get(0).getMedico().equals(crm)){ %>
      		<form action="diag_con">
      			<p>Código da consulta: <%= consulta.get(0).getCod() %>&nbsp;&nbsp;&nbsp;Paciente: <%= consulta.get(0).getPaciente()%></p>
      			<p>Título: <%= consulta.get(0).getNome() %></p>
      			<p>Data da consulta: <%= consulta.get(0).getDataE() %></p>
      			<p>Data do diagnóstico: <input type="text" placeholder="Ex.: dd/mm/aaaa" data-mask="00/00/0000" maxlength="10" autocomplete="off" name="dataR" required/></p>
      			<p>Diagnóstico: </p>
      			<p><textarea id="diagnostico" name="diagnostico" rows="12" cols="80"/></textarea></p>
      			<input type="hidden" name="cod" value="<%=consulta.get(0).getCod() %>"/>
      			<p><input class="btn btn-second" type="submit" value="Confirmar" style="width:100px"/></p>
      		</form>
      		<form action="MenuMedico(Diagnostico).jsp">
      			<input class="btn btn-second" type="submit" value="Voltar" style="width:100px"/>
      		</form>
      		<%} else if(consulta.get(0).getConfirm().equals("Confirmada") && !consulta.get(0).getMedico().equals(crm)){ %>
      		<form action="MenuMedico(Diagnostico).jsp">
      			<h5>Não foi você quem realizou essa consulta!</h5>
      			<p><input class="btn btn-second" type="submit" value="Voltar" style="width:100px"/>
      		</form>
      		<%} else if(consulta.get(0).getConfirm().equals("Pendente")){ %>
      		<form action="MenuMedico(Diagnostico).jsp">
      			<h5>É necessário confirmar a consulta primeiro!</h5>
      			<p><input class="btn btn-second" type="submit" value="Voltar" style="width:100px"/>
      		</form>
      		<%} else{%>
      		<form action="MenuMedico(Diagnostico).jsp">
      			<h5>Essa consulta já foi diagnosticada!</h5>
      			<p><input class="btn btn-second" type="submit" value="Voltar" style="width:100px"/>
      		</form>
      		<%} %>
      	</div>
      </div>
    </div> <!-- .content-wrapper -->
  </main> <!-- .cd-main-content -->
  <script src="assets/js/util.js"></script> <!-- util functions included in the CodyHouse framework -->
  <script src="assets/js/menu-aim.js"></script>
  <script src="assets/js/main.js"></script>
  <script async="" src="//www.google-analytics.com/analytics.js"></script><script type="text/javascript" src="//code.jquery.com/jquery-2.0.3.min.js"></script>
  <script type="text/javascript" src="//assets.locaweb.com.br/locastyle/2.0.6/javascripts/locastyle.js"></script>
  <script type="text/javascript" src="//netdna.bootstrapcdn.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>
</body>
</html>
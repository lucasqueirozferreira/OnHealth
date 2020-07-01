<%@page import="gu.com.gls.DAOs.MedicoDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="gu.com.gls.Beans.MedicoJB"%>
<%@page import="gu.com.gls.DAOs.ForumDAO"%>
<%@page import="gu.com.gls.Beans.ForumJBStatic"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!doctype html>
<html lang="pt-br">
<head>
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
    
    <% ForumJBStatic forum = new ForumJBStatic(); %>
  
    <div class="cd-content-wrapper">
      <div class="text-component text-center">
      	<h1>Realizar Consulta</h1>
      	<br>
      	<h5>Insira os dados da sua consulta:</h5>
      	<br>
      	<form action="resp_forum">
      		<% out.println("<p>" + "Título: " + forum.getPergunta() + "</p>");%>
      		<p><textarea id="resposta" name="resposta" rows="12" cols="80"/></textarea></p>
      		<input type="hidden" name="id" value="<%=forum.getId()%>"/>
      		<p><input onclick="myFunction()" class="btn btn-second" type="submit" value="Solicitar" style="width:100px"/><p>
      	</form>
      </div>
    </div> <!-- .content-wrapper -->
  </main> <!-- .cd-main-content -->
  <script src="assets/js/util.js"></script> <!-- util functions included in the CodyHouse framework -->
  <script src="assets/js/menu-aim.js"></script>
  <script src="assets/js/main.js"></script>
</body>
</html>
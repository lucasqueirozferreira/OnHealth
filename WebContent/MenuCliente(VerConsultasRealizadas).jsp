<%@page import="gu.com.gls.DAOs.MedicoDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="gu.com.gls.Beans.MedicoJB"%>
<%@page import="gu.com.gls.Beans.ConsultaJB"%>
<%@page import="gu.com.gls.DAOs.ConsultaDAO"%>
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

<% List<ConsultaJB> consultas = ConsultaDAO.selectPac(cpf); %>
<% List<MedicoJB> medicos = MedicoDAO.selectAll(); %>

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
          <li class="cd-nav__sub-item"><a href="Deslogar.jsp">Sair</a></li>
        </ul>
      </li>
    </ul>
  </header> <!-- .cd-main-header -->
  
  <main class="cd-main-content">
    <nav class="cd-side-nav js-cd-side-nav">
      <ul class="cd-side__list js-cd-side__list">
        <li class="cd-side__label"><span>Main</span></li>
        <li class="cd-side__item cd-side__item--has-children cd-side__item--overview js-cd-item--has-children">
          <a href="MenuCliente(CadastroConsulta).jsp">Realizar Consulta</a>
        </li>

        <li class="cd-side__item cd-side__item--has-children cd-side__item--notifications cd-side__item--selected  js-cd-item--has-children">
          <a href="">Ver Consultas</a>
          
          <ul class="cd-side__sub-list">
            <li class="cd-side__sub-item"><a href="MenuCliente(VerConsultasPendentes).jsp">Pendentes</a></li>
            <li class="cd-side__sub-item"><a href="#0">Realizadas</a></li>
          </ul>
        </li>
    
        <li class="cd-side__item cd-side__item--has-children cd-side__item--comments js-cd-item--has-children">
          <a href="MenuCliente(Forum).jsp">Forum</a>
        </li>
      </ul>
    </nav>
  
    <div class="cd-content-wrapper">
      <div class="text-component text-center">
      	<h2>Consultas Realizadas</h2>
      <% for(ConsultaJB c: consultas){
    	  if(c.getConfirm().equals("Realizada")){
    	  		out.print("<br>");
    		  	out.println("<div class='card'>");
    	  		out.println("<p>" + "Título: " + c.getNome() + "&nbsp;" + "&nbsp;" + "&nbsp;" + "Data: " + c.getDataE() + "</p>");
    	  		out.println("<p>" + "Status: " + c.getConfirm() + "</p>");
    	  		out.println("<p>" + "Gravação: " + "&nbsp;" + "<a href=" + c.getLink() + ">"  + c.getLink() + "</a>" + "</p>");
    	  		out.println("</div>");
      	  }
     	}
      %>
      </div>
    </div> <!-- .content-wrapper -->
  </main> <!-- .cd-main-content -->
</body>
</html>
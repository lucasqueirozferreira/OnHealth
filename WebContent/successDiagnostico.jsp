<%@page import="gu.com.gls.DAOs.PacienteDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="gu.com.gls.Beans.PacienteJB"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Diagnóstico</title>
<style>
* {
  box-sizing: border-box;
}

body {
  font-family: Arial;
  padding: 10px;
  background: #f1f1f1;
}

/* Header/Blog Title */
.header {
  padding: 30px;
  text-align: center;
  background: powderblue;
}

.header h1 {
  font-size: 30px;
  color: black;
}

/* Style the top navigation bar */
.topnav {
  overflow: hidden;
  background-color: blue;
}

/* Style the topnav links */
.topnav a {
  float: left;
  display: block;
  color: #f2f2f2;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
}

/* Change color on hover */
.topnav a:hover {
  background-color: #ddd;
  color: black;
}

/* Create two unequal columns that floats next to each other */
/* Left column */
.leftcolumn {   
  float: left;
  width: 75%;
}

/* Right column */
.rightcolumn {
  float: left;
  width: 25%;
  background-color: #f1f1f1;
  padding-left: 20px;
}

/* Fake image */
.fakeimg {
  background-color: #aaa;
  width: 100%;
  padding: 20px;
}

/* Add a card effect for articles */
.card {
  background-color: white;
  padding: 20px;
  margin-top: 20px;
}

/* Clear floats after the columns */
.row:after {
  content: "";
  display: table;
  clear: both;
}

/* Footer */
.footer {
  padding: 20px;
  text-align: center;
  background: powderblue;
  margin-top: 20px;
}

/* Responsive layout - when the screen is less than 800px wide, make the two columns stack on top of each other instead of next to each other */
@media screen and (max-width: 800px) {
  .leftcolumn, .rightcolumn {   
    width: 100%;
    padding: 0;
  }
}

/* Responsive layout - when the screen is less than 400px wide, make the navigation links stack on top of each other instead of next to each other */
@media screen and (max-width: 400px) {
  .topnav a {
    float: none;
    width: 100%;
  }
}
</style>

</head>
<body>
<%
	String crm = (String) session.getAttribute("crm");
	if(crm == null){
		response.sendRedirect("LoginMedico.jsp");
	}
%>

<% List<PacienteJB> pacientes = PacienteDAO.selectAll(); %>

<div class="header">
  <img src="https://i.imgur.com/fiUXrEJ.png" alt="OnHealth" style="width:25%">
  <h1>Uma comunidade saudável!</h1>
</div>

<div class="topnav">
  <a href="InicioMedico.jsp">Início</a>
  <a href="PerfilMedico.jsp">Perfil</a>
  <a href="ConsultasDisp.jsp">Consulta Disponível</a>
  <a href="HistoricoMedico.jsp">Ver Histórico</a>
  <a href="Diagnostico.jsp">Escrever Diagnóstico</a>
  <a href="DeslogarMedico.jsp" style="float:right">Sair</a>
</div>

<div class="row">
  <div class="leftcolumn">
    <div class="card">
      <h2>Diagnóstico adicionado com sucesso!</h2>
      <form action="Diagnostico.jsp">
      	<p><input type="submit" value="Voltar"/></p>
      </form>
    </div>
    </div>
  <div class="rightcolumn">
    <div class="card">
      <h2>Pacientes Cadastrados</h2>
      <% for(PacienteJB p: pacientes){
    	  		out.print("<p>" + p.getNome() + " " + p.getIdade() + " anos" + "</p>");
      }%>
      
    </div>
  </div>
</div>
</body>
</html>
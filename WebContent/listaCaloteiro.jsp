<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="br.com.triadworks.javaweb.dao.CaloteiroDAO" %>
<%@ page import="br.com.triadworks.javaweb.modelo.Caloteiro" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lista de devedores</title>
<link rel="stylesheet" type="text/css" href="css/lista-caloteiro.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />
</head>
<body>

	<div class="header">
		<div class="container">
			<p>Contabilidade & Cobrança</p>
			<ul class="pull-right">
				<li><a href="homepage.html">Página Inicial</a></li>
				<li><a href="adiciona-caloteiro.html">Cadastro</a></li>
				<li><a href="listaCaloteiro.jsp">Listagem de inadimplentes</a></li>
				<li><a href="consulta-caloteiro.html">Consultas</a></li>
			</ul>
		</div>
	</div>
	
	<jsp:useBean id="dao" class="br.com.triadworks.javaweb.dao.CaloteiroDAO"></jsp:useBean>
	<table border="1">
		<c:forEach var="caloteiro" items="${dao.lista}" varStatus="id">
			<tr bgcolor="{id.count % 2 == 0 ? 'ff0000' : 'ffffff' }">
				<td>${id.count}</td><td>${caloteiro.nome}</td>
				<c:if test="${not empty caloteiro.email}">
					<td><a href="mailto:${caloteiro.email}">${caloteiro.email}</a></td>
				</c:if>
			</tr>
		</c:forEach>
	</table>
	
	<div class="footer">
		<div class="container">
			<ul>
				<li>Contabilidade & Cobrança</li>
				<li>davi.leitao@hotmail.com</li>
				<li>Fortaleza, Ceará</li>
			</ul>
		</div>
	</div>
</body>
</html>
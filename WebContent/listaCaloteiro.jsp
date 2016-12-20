<%@ include file="/includes.jsp"%>
<%@ page import="br.com.triadworks.javaweb.dao.CaloteiroDAO"%>
<%@ page import="br.com.triadworks.javaweb.modelo.Caloteiro"%>
<%@ page import="java.util.List"%>
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

	<c:import url="header.jsp"></c:import>

	<jsp:useBean id="dao"
		class="br.com.triadworks.javaweb.dao.CaloteiroDAO"></jsp:useBean>
	<table border="1" id="lista-tabela">
		<tr>
			<td id="table-header">ID</td>
			<td id="table-header">NOME</td>
			<td id="table-header">EMAIL</td>
			<td id="table-header">VALOR</td>
			<td id="table-header">DATA</td>
			<td id="table-header">AÇÃO</td>
		</tr>
		<c:forEach var="caloteiro" items="${dao.lista}" varStatus="id">

			<tr bgcolor="${id.count % 2 == 0 ? 'white' : 'gray' }">
				<td>${id.count}</td>
				<td>${caloteiro.nome}</td>
				<c:choose>
					<c:when test="${not empty caloteiro.email}">
						<td><a href="mailto:${caloteiro.email}" id="link-email">${caloteiro.email}</a></td>
					</c:when>
					<c:otherwise>
						<td>E-mail não preenchido.</td>
					</c:otherwise>
				</c:choose>

				<c:choose>
					<c:when test="${not empty caloteiro.devendo }">
						<td>${caloteiro.devendo }</td>
					</c:when>
					<c:otherwise>
						<td>Sem dívida alguma</td>
					</c:otherwise>
				</c:choose>

				<c:choose>
					<c:when test="${not empty caloteiro.dataDivida }">
						<td><fmt:formatDate value="${caloteiro.dataDivida.time}"
								pattern="dd/MM/yyyy" /></td>
					</c:when>
					<c:otherwise>
						<td>Dívida sem data</td>
					</c:otherwise>
				</c:choose>

				<td>
					<form action="">
						<button type="submit" id="table-btn">delete</button>
					</form>
				</td>
			</tr>
		</c:forEach>
	</table>

	<c:import url="footer.jsp"></c:import>


</body>
</html>
<%@ include file="/includes.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Lista</title>
	<link rel="stylesheet" type="text/css" href="css/lista-caloteiro.css">
	<link rel="stylesheet" type="text/css" href="css/header.css">
		<link rel="stylesheet" type="text/css" href="css/footer.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />
</head>
<body>
	<c:import url="header.jsp"></c:import>
	<div class="main">
		<div class="container">
			<table border="1" id="lista-tabela">
				<tr>
					<td id="table-header">ID</td>
					<td id="table-header">NOME</td>
					<td id="table-header">EMAIL</td>
					<td id="table-header">VALOR</td>
					<td id="table-header">DATA</td>
					<td id="table-header">DELETA</td>
					<td id="table-header">ALTERA</td>
				</tr>
				<c:forEach var="caloteiro" items="${lista}" varStatus="id">
		
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
								<td>R$ ${caloteiro.devendo }</td>
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
							<form action="sistema?logica=DeletaCaloteiro&id=${caloteiro.id}"
								method="POST">
								<input type="submit" id="table-btn" value="Deleta" />
							</form>
						</td>
						<td>
							<form
								action="sistema?logica=AlteraCaloteiro&id=${caloteiro.id}" method="POST">
								<input type="submit" id="table-btn" value="Altera" />
							</form>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
	
	<c:import url="footer.jsp"></c:import>
</body>
<script type="text/javascript" src="jquery-3.1.1.js"></script>
<script type="text/javascript" src="js/header.js"></script>
</html>
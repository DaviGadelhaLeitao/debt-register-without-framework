<%@ include file="/includes.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head >
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Menu</title>
<link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="css/menu.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
	
</head>
<body>
<c:import url="header.jsp"></c:import>

<div class="main">
	<div class="container">
		<h1>Seja bem-vindo, ${usuarioLogado.nome}.</h1>
		<div class="expressionLanguageTest">
	<div class="container">
		<p>
		1. param: ${param.nome}<br>
		2. requestScope: ${requestScope.nome}<br>
		3. sessionScope: ${sessionScope.nome}<br>
		4. Sem especificar: ${nome}<br>
		</p>
	</div>
</div>
	</div>
</div>

<c:import url="footer.jsp"></c:import>
</body>
</html>
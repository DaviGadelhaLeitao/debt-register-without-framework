<%@ include file="/includes.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>login</title>
<link rel="stylesheet" type="text/css" href="css/header-pagina-login.css">
<link rel="stylesheet" type="text/css" href="css/login.css">
<link rel="stylesheet" type="text/css" href="css/footer.css">
<link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
</head>
<body>
<c:import url="header-pagina-login.jsp"></c:import>
<div class="main">
	<div class="container">
		<form action="sistema" method="POST" id="formLogar">
			<input type="hidden" name="logica" value=AutenticaUsuario>
			<input type="hidden" name="nome" value="Parametro">
			<div class="form-group">
				<label for="login">Login:</label>
				<input type="text" name="login" value="" class="form form-control" id="login"/>
			</div>
			<div class="form-group">
				<label for="senha">Senha:</label>
				<input type="password" name="senha" value="" class="form form-control"/>
			</div>
			<button type="submit" id="submit-btn">Submit</button>
		</form>
		<br>
		<p id="msgUsuario">${msgUsuario}</p>
	</div>
</div>
<c:import url="footer.jsp"></c:import>
</body>
</html>
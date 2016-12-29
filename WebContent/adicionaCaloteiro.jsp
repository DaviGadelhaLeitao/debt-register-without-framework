<%@ include file="/includes.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cadastro</title>
<link rel="stylesheet" type="text/css" href="css/adiciona-caloteiro.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
</head>
<body>

	<c:import url="header.jsp"></c:import>

	<div class="main">
		<div class="container">
			<div class="adiciona-caloteiro-form">
				<form action="sistema" method="POST">
				<input type="hidden" name="logica" value=AdicionaCaloteiro>
					<div class="form-group">
						<label for="nome">Nome:</label> <input type="text"
							class="form-control" id="nome" name="nome">
					</div>
					<div class="form-group">
						<label for="email">Email:</label> <input type="text"
							class="form-control" id="email" name="email" />
					</div>
					<div class="form-group">
						<label for="devendo">Devendo R$:</label> <input type="text"
							class="form-control" id="devendo" name="devendo" />
					</div>
					<div class="form-group">
						<label for="dataDivida">Data:</label> <input type="text"
							class="form-control" id="dataDivida" name="dataDivida" />
					</div>
					<input type="submit" value="Salvar" id="btn-submit"/>
				</form>
			</div>
		</div>
	</div>

	<c:import url="footer.jsp"></c:import>
	
</body>
</html>
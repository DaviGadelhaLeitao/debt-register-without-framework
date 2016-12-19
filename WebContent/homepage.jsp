<%@ include file="/includes.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home</title>
<link rel="stylesheet" type="text/css" href="css/homepage.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />
</head>
<body>

<c:import url="header.jsp"></c:import>

<div class="main">
		<div class="container">
			<h1>Seja bem vindo a nossa página de consultas financeiras!</h1>
			<p id="letter-spacing-3px">Disponibilizamos este serviço gratuitamente para todos os
				nossos clientes premium e parceiros de negócios.</p>

			<div class="box">
				<h2>Últimas notícias:</h2>
				<ul>
					<li>
						Agora é possível solicitar a exclusão do seu nome da lista de CPF
						inadimplentes através do site. Para saber mais clique <a>aqui.</a>
					</li>
					<li>
						Já está marcada a data para o próximo evento conciliatório. Saiba
						mais clicando <a>aqui.</a>
					</li>
				</ul>
			</div>
		</div>
	</div>

<c:import url="footer.jsp"></c:import>

</body>
</html>
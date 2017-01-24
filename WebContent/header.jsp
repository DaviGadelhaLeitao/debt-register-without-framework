<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="includes.jsp"%>
<!DOCTYPE html SYSTEM "about:legacy-compat">
<!--<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">-->
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Header.jsp</title>
<link rel="stylesheet" type="text/css" href="css/header.css">

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
	integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp"
	crossorigin="anonymous">


</head>

<body>

	<div class="header">
		<div class="container">
			<div class="row">
				<div class="col-md-4">
					<p id="title-p">Cobrança & Contabilidade</p>
				</div>

				<div class="col-md-8">
				
					<ul class="nav nav-pills" id="title-ul">
						<li role="presentation"><a href="homepage.jsp">Homepage</a></li>
						<li role="presentation"><a href="adicionaCaloteiro.jsp">Cadastro</a></li>
						<li role="presentation"><a href="sistema?logica=ListaCaloteiro">Listagem</a></li>
							
						<li>
							<a id="dropdown-link" href="#">${usuarioLogado.nome} <span class="caret"></span></a>
							<ul class="dropdown-menu">
								<li><a href="#">Submenu 1-1</a></li>
								<li><a href="#">Submenu 1-2</a></li>
								<li><a href="#">Logout</a></li>
							</ul>
						</li>
						
					</ul>
				</div>
			</div>
		</div>
	</div>


<script type="text/javascript" src="jquery-3.1.1.js"></script>
<!-- Latest compiled and minified JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
	integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
	crossorigin="anonymous"></script>
<script type="text/javascript" src="js/header.js"></script>
</body>

</html>
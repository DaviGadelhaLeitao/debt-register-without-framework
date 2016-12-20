<%@ include file="/includes.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Consulta</title>
<link rel="stylesheet" type="text/css" href="css/consulta-caloteiro.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />
</head>
<body>

	<c:import url="header.jsp"></c:import>

	<div class="main">
		<div class="container">
			<div class="consulta-caloteiro-form">
				<form action="consultaCaloteiro" method="POST">
					<div class="form-group">
						<label for="nome">ID:</label> <input type="text"
							class="form-control" id="id" name="id">
					</div>
<!-- 					<div class="form-group"> -->
<!-- 						<label for="email">Email:</label> <input type="text" -->
<!-- 							class="form-control" id="email" name="email" /> -->
<!-- 					</div> -->
					<input type="submit" value="Salvar" id="btn-save"/>
				</form>
			</div>
		</div>
	</div>

	<c:import url="footer.jsp"></c:import>

</body>
</html>
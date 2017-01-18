<%@ include file="includes.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Error Page</title>
<link rel="stylesheet" type="text/css" href="css/error-page.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />
</head>
<body>

	<c:import url="header.jsp"></c:import>
	
	<div class="main">
		<div class="container">
			<h1>Error Page!</h1>
			<p>Make sure you typed the right address!</p>
		</div>
	</div>
	
	<c:import url="footer.jsp"></c:import>


</body>
</html>
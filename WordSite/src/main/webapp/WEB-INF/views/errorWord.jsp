<%@page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<link href="<c:url value="/resources/css/bootstrap.min.css"/>" rel="stylesheet">
<title>예외 처리</title>
</head>
<body>
	<div class="jumbotron">
		<div class="container">
			<h2 class="alert alert-danger">
				해당 단어가 존재하지 않습니다.<br>
				word Id: ${invalidWordId}
			</h2>
		</div>
	</div>
	<div class="container">
		<p>${url}</p>
		<p>${exception}</p>
	</div>
	<div class="container">
		<p>
			<a href="<c:url value="/words/"/>" class="btn btn-secondary">
				단어 목록 &raquo;</a>
		</p>
	</div>
</body>
</html>
<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<title>My Page</title>
<head>
<link href="<c:url value="/resources/css/bootstrap.min.css"/>" rel="stylesheet">
<script src="<c:url value="/resources/js/controller.js"/>"></script>
</head>
<body>
	<div class="container">
		<div>
			<form:form name="clearForm" method="delete">
				<a href="javascript:clearMypage()" class="btn btn-danger pull-left">삭제하기</a>
			</form:form>
		</div>
		<div style="padding-top: 50px">
			<table class="table table-hover">
			<tr>
				<th>단어</th>
				<th>제목</th>
				<th>설명</th>
			</tr>
			
			<form:form name="removeForm" method="put">
				<c:forEach items="${cart.cartItems}" var="item">
				<tr>
					<td>${item.value.word.name}</td>
					<td>${item.value.word.title}</td>
					<td>${item.value.word.description}</td>
					<td><a href="javascript:removeFromMypage('../mypage/remove/${item.value.word.wordId}')" class="badge badge-danger">삭제</a></td>
				</tr>
				</c:forEach>
			</form:form>
			
			</table>
			<a href="<c:url value="/words"/>" class="btn btn-secondary">&laquo; 단어 목록</a>
		</div>
	</div>
</body>
</html>
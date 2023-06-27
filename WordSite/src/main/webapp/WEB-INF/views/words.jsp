<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
<link href="<c:url value="/resources/css/bootstrap.min.css"/>"
	  rel="stylesheet">
<title>단어 목록</title>
</head>
<body>
	<div class="container">
		<div class="row" align="center">
			<c:forEach items="${bookList}" var="book">
				<div class="col-md-4">				
					<h3>${word.name}</h3>
					<p>${word.title}
						<br>${word.releaseDate}
					<p align=left>${fn:substring(word.description, 0, 100)}...
					<p><a href="<c:url value="/words/word?id=${word.wordId}"/>" class="btn btn-secondary" role="button">상세정보 &raquo;</a>
				</div>
			</c:forEach>
		</div>
	</div>
</body>
</html>
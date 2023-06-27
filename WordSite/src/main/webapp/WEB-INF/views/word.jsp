<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %> 

<!DOCTYPE html>
<html>
<head>
<link href="<c:url value="/resources/css/bootstrap.min.css"/>" rel="stylesheet">
<script src="${pageContext.request.contextPath}/resources/js/controller.js"></script>
<title>단어 상세 정보</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-4">
			</div>
			<div class="col-md-8">
				<h3>${word.name}</h3>
				<p>${word.description}</p>
				<br>
				<p><b>등록일</b> : ${word.releaseDate}
				<br>
				<form:form name="addForm" method="put">
					<p><a href="javascript:addToMypage('../mypage/add/${word.wordId}')" class="btn btn-primary">좋아요 &raquo;</a>
					<a href="<c:url value="/mypage/"/>" class="btn btn-warning">마이페이지 &raquo;</a>
					<a href="<c:url value="/words/"/>" class="btn btn-secondary">단어 목록 &raquo;</a>
					
					<sec:authorize access="isAuthenticate()">
						<a href="<c:url value="/words/update?id=${word.wordId}"/>" class="btn btn-success">수정 &raquo;</a>
						<a href="<c:url value="/words/delete?id=${word.wordId}"/>" class="btn btn-danger">삭제 &raquo;</a>
						<%-- <a href="<c:url value="javascript:deleteConfirm('${word.wordId}')"/>" class="btn btn-danger">삭제 &raquo;</a> --%>
					</sec:authorize>
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>
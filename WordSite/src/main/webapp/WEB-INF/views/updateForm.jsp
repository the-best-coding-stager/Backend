<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<link href="<c:url value="/resources/css/bootstrap.min.css"/>" rel="stylesheet">
<title>도서 상세 정보</title>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-7">
        	<form:form modelAttribute="updateWord" action="./update?${_csrf.parameterName}=${_csrf.token}" class="form-horizontal">
            <fieldset>
                <div class="form-group row">
                    <label class="col-sm-2 control-label" >단어명</label>
                    <div class="col-sm-6">
                        <form:input path="name"  class="form-control" value="${word.name}"/>
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-sm-2 control-label" >제목</label>
                    <div class="col-sm-6">
                        <form:input path="unitPrice" class="form-control" value="${word.title}"/>
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-sm-2 control-label" >설명</label>
                    <div class="col-sm-10">
                    	<textarea path="description" cols="50" rows="2" class="form-control" >${word.description}</textarea>                 
                    </div>
                </div>
                <div class="form-group row">
                	<label class="col-sm-2 control-label" >등록일</label>
                	<div class="col-sm-6">
                    	<form:input path="releaseDate" class="form-control" value="${word.releaseDate}"/> 
                	</div>
                </div>

                <div class="form-group row">
                    <div class="col-sm-offset-2 col-sm-10" >
                        <input type="submit" class="btn btn-primary" value ="수정"/>  
                        <a href=" <c:url value="/words" />" class="btn btn-primary"> 취소</a>  
                    </div>
                </div>
            </fieldset>
            </form:form>
    </div>
    </div>
    </div>
</body>
</html>
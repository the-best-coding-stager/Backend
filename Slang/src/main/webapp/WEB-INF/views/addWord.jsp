<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
<link href="<c:url value="/resources/css/bootstrap.min.css"/>" rel="stylesheet">
<title>단어 등록</title>
</head>
<body>
    <nav class="navbar navbar-expand  navbar-dark bg-dark">
        <div class="container">
            <div class="navbar-header">
                <a class="navbar-brand" href="./home">Home</a>
            </div>
        </div>
    </nav>
    <div class="jumbotron">
        <div class="container">
            <h1 class="display-3">
            	<spring:message code="addBook.form.title.label" /> 
            </h1>
        </div>
    </div>

    <div class="container">
      <div class="float-right">
        <form:form action="${pageContext.request.contextPath}/logout" method="POST"> 
            <input type="submit" class="btn btn-sm btn-success" value="Logout" />
        </form:form>  
      </div>
    <div class="float-right" style="padding-right:30px">  
            <a href="?language=ko" >Korean</a>|<a href="?language=en">English</a>
    </div>  
        
    <br><br>
       <form:form modelAttribute = "NewWord" 
       action="./add?${_csrf.parameterName}=${_csrf.token}"
       class="form-horizontal" 
       enctype="multipart/form-data">
        <fieldset>
        <legend><spring:message code="addWord.form.subtitle.label" /></legend>
        <div class="form-group row">
            <label class="col-sm-2 control-label" >
            	<spring:message code="addWord.form.name.label" />
            </label>
            <div class="col-sm-3">
                <form:input  path="name"  class="form-control"/>  
            </div>
              <div class="col-sm-6">
                <form:errors path="name" cssClass="text-danger"/>  
            </div>
        
        </div>
        <div class="form-group row">
           <label class="col-sm-2 control-label" >
				<spring:message code="addWord.form.wordTitle.label" />
			</label>
           <div class="col-sm-3">
               <form:input  path="title" class="form-control"/>  
           </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 control-label" >
            	<spring:message code="addWord.form.description.label" />
            </label>
            <div class="col-sm-5">    
                <form:textarea  path="description" cols="50" rows="2" class="form-control"/>  
            </div>
        </div>
        <div class="form-group row">
            <div class="col-sm-offset-2 col-sm-10" >
            <input type="submit" class="btn btn-primary" value ="<spring:message code="addWord.form.button.label" /> "/>
            </div>
        </div>
        </fieldset>
        </form:form>  
        <hr>
    <footer>
        <p>&copy; BookMarket</p>
    </footer>
    </div>
</body>
</html>
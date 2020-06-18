<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>輸入頁</title>
</head>
<body>
	<div align = "center" >
		<form action="StudentServlet" method="post">
			<label for="num">請輸入要產生學生資料的筆數:</label>
			<input type="number" 
				   id="num" 
				   name="num"
				   min = "1"
				   required>
			<input type="hidden" id="insert" name="page" value="insert"/>
			<input type="submit" value="submit" />
		</form>	
		<c:set var = "success" scope = "request" value = "${success}"/>
		<c:set var = "failed" scope = "request" value = "${failed}"/>
		<c:if test="${not empty success || not empty failed}">
			<br>
			<p>
			<b>Success: </b>
			<c:out value="${success}" default = "0"></c:out>
			<c:remove var="success"/>
			<br>
			<b>Failed: </b>
			<c:out value="${failed}" default = "0"></c:out>
			<c:remove var="failed"/>
			
			<form action="StudentServlet" method ="post">
				<input type="hidden" id ="show" name="page" value="show"/>
				<input type="submit" value= "Show Result" />
			</form>
			<p>
		</c:if>
			
	</div>
</body>
</html>
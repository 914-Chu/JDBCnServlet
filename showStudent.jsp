<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
th, td {text-align: center}
</style>
<title>結果頁</title>
</head>
<body>
	<div align="center">
		<b>Result</b>
		<br>
		<table style="width:100%">
		<tr>
			<th>SNO</th>
			<th>NAME</th>
			<th>AGE</th>
			<th>SEX</th>
			<th>PID</th>
		</tr>
		<c:forEach var="student" items="${list}">
			<tr>
				<td><c:out value="${student.sno}"/></td>
				<td><c:out value="${student.sName}"/></td>
				<td><c:out value="${student.age}"/></td>
			    <td><c:out value="${student.sex}"/></td>
				<td><c:out value="${student.pId}"/></td>
			</tr>
		</c:forEach>
		</table>
	</div>

</body>
</html>
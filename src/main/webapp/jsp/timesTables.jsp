<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<style>
	td{border: 1px solid black;}

</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>times Tables</title>
</head>
<body>
	<c:set var="dan" value="${param.dan}"></c:set>
	<c:set var="gop" value="${param.gop}"></c:set>
	
	<c:if test="${dan == null}">
		<c:set var="dan" value="9"></c:set>
	</c:if>
	<c:if test="${gop == null}">
		<c:set var="gop" value="9"></c:set>
	</c:if>

	<table>
		<c:forEach var="i" begin="1" end="${dan}" step="1">
			<tr>
			<c:forEach var="j" begin="2" end="${gop }" step="1">
				<td>${j } *${i }=${j*i }</td>
			</c:forEach>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
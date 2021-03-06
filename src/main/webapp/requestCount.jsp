<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>requestCount</title>
</head>
<body>
	<!-- application(getServletContext() ) : requestMap -->
	<table border="1">
		<tr>
			<th>uri</th>
			<th>요청횟수</th>
		</tr>
		<c:forEach items="${requestMap}" var="request">
			<tr>
				<td>${request.key}</td>
				<td>${request.value}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
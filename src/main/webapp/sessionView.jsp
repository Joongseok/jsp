<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>sessionView</title>
</head>
<body>
<h2>sessionMap</h2>
<table border="1">
	<tr>
		<th>session ID</th>
		<th>USER_INFO.name</th>
	</tr>
	
	<c:forEach items="${sessionMap }" var="map">
		<tr>
			<td>${map.key }</td>
			<td>${map.value.getAttribute("USER_INFO").name }</td>
		</tr>
	</c:forEach>
</table>

<h2>sessionUserMap</h2>
<table border="1">
	<tr>
		<th>사용자 아이디</th>
		<th>사용자 이름</th>
	</tr>
	<c:forEach items="${sessionUserMap }" var="userMap">
	<tr>
		<td>${userMap.value.userId }</td>
		<td>${userMap.value.name}</td>
	</tr>
	</c:forEach>
</table>
</body>
</html>
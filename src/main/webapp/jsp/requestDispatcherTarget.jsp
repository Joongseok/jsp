<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>requestDispatcherTarget</title>
</head>
<body>
	<%
	System.out.println("userId(requestDispatcherTarget) : " + request.getParameter("userId"));
	%>
	requestDispatcherTarget.jsp
	
</body>
</html>
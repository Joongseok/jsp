<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>hello, world</title>
</head>
<body>
	hello, world
	
	
	<%Date date = new Date();%>
	현재시간 : <%= date %> 입니다.
	
</body>
</html>
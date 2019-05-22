<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>requestDispatchProcess</title>
</head>
<body>
	<%
		System.out.println("userId : " + request.getParameter("userId"));
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/requestDispatcherTarget.jsp");
		
		rd.forward(request, response);
	%>
</body>
</html>
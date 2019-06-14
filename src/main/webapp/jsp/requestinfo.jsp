<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>RequestInfo</title>
</head>
<body>

	<%
		/* 
			jsp의 내장객체, 묵시적객체(implict) 
			(이미 선언되어 있는 객체이기 때문에 별도의 선언없이 사용가능하다)
		*/
		
	%>
	request.getRemoteAddr() : <%=request.getRemoteAddr() %><br>
	request.getLocalAddr() : <%=request.getLocalAddr() %><br>
	request.getContentType() : <%=request.getContentType() %><br>
	request.getContextPath() : ${cp}<br>
	request.getMethod() : <%=request.getMethod() %><br>
	request.getRequestURI() : <%=request.getRequestURI() %><br>
	request.getProtocol() : <%=request.getProtocol() %><br>
	
	<img src="${cp}/img/sally.png"><br>

	request.getParameter("rangersName") : <%= request.getParameter("rangersName") %><br>
	
</body>
</html>
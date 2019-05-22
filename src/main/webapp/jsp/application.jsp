<%@page import="java.io.FileOutputStream"%>
<%@page import="java.io.OutputStream"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.File"%>
<%@page import="java.io.OutputStreamWriter"%>
<%@page import="java.io.InputStreamReader"%>
<%@page import="java.io.InputStream"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>application</title>
</head>
<body>
<%
	out.write("application.getContextPath() : " + application.getContextPath() + "<br>");
	
	out.write("application.getServerInfo() : " + application.getServerInfo() + "<br>");
	
	out.write("application.getMajorVersion() : " + application.getMajorVersion() + "<br>");
	
	out.write("application.getMinorVersion() : " + application.getMinorVersion() + "<br>");

	out.write("application.getInitParameter(\"ADMIN\") : " + application.getInitParameter("ADMIN") + "<br>");

	out.write("application.getRealPath(\"/res/190522.txt\") : " + application.getRealPath("/res/190522.txt") + "<br><br>");
	
	FileInputStream fis = new FileInputStream(application.getRealPath("/res/190522.txt"));
	InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
	
	int length = 0;
	while((length = isr.read()) != -1){
		if((char)length == '\n'){
			out.write("<br>");
		}
		out.write(length);
	}
	fis.close();
	isr.close();
%>
</body>
</html>
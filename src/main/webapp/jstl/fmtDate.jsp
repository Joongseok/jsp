<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>formatDate</h2>
	<c:set var="dt" value="<%=new Date() %>"></c:set>
	dt : ${dt }<br>
	dt : <fmt:formatDate value="${dt }"/><br>
	dt : <fmt:formatDate value="${dt }" pattern="yyyy-MM-dd"/><br>
	full dt : <fmt:formatDate value="${dt }" type="date" dateStyle="full"/><br>
	long dt : <fmt:formatDate value="${dt }" type="date" dateStyle="long"/><br>
	medium dt : <fmt:formatDate value="${dt }" type="date" dateStyle="medium"/><br>
	short dt : <fmt:formatDate value="${dt }" type="date" dateStyle="short"/><br>
	dt : <fmt:formatDate value="${dt }" type="both" dateStyle="full" timeZone="asia/hongkong"/><br>
	
	
	
	<h3>de</h3>
	<fmt:setLocale value="de_de"/>
	dt : <fmt:formatDate value="${dt }" /><br>
	
	
	<h2>parseDate(string -> date / 2019.6.13 -> date)</h2>
	<fmt:setLocale value="ko_kr"/>
	<c:set value="2019.6.13" var="dtStr"/>
	dtStr : ${dtStr }<br>
	dtStr : <fmt:parseDate value="${dtStr}" pattern="yyyy.MM.dd" /><br>	
</body>
</html>
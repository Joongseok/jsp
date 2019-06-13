<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:set value="1000000.12" var="num"/>
num : ${num }<br>


<h2>formatNumber (number -> string / 1000000 -> 1,000,000)</h2>
<fmt:setLocale value="ko_kr"/>
ko : <fmt:formatNumber value="${num }"/><br>
ko : <fmt:formatNumber value="${num }"  type="currency"/><br>
ko : <fmt:formatNumber value="${num }" type="percent"/><br>

<fmt:setLocale value="de_de"/>
de : <fmt:formatNumber value="${num }" type="currency" /><br>
de : <fmt:formatNumber value="${num }" type="percent"/><br>


<fmt:setLocale value="ko_kr"/>
<h2>parseNumber (string -> number / 1,000,000 -> 1000000)</h2>
<c:set value="1,000,000" var="numStr"/>
numStr : ${numStr }<br>
<fmt:parseNumber value="${numStr }" var="num"/>
parseNumber numStr : ${num }<br>
</body>
</html>
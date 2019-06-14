<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script>
	$(function (){
		$("#select").change(function (){
			$("#lan").val($(this).val());
			$("#fmt").submit();
		});
	});
</script>
</head>
<body>
<h2>select locale</h2>
<form id="fmt" action="${cp}/selectLocale" method="post">
	<select id="select">
		<option value="ko">한국어</option>
		<option value="en">english</option>
		<option value="ja">日本</option>
	</select>
	<input type="hidden" id="lan" name="lan" value="${lan}">
	<script>$("#select").val($("#lan").val());</script>
</form>

<fmt:setLocale value="${lan}"/>
<fmt:bundle basename="kr.or.ddit.msg.msg">
<fmt:message key="GREETING"/>
<fmt:message key="VISITOR">
	<fmt:param value="brown"></fmt:param>
</fmt:message>
</fmt:bundle>
</body>
</html>
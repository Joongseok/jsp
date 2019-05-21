<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
	td{border: 1px solid black;}

</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>times Tables</title>
</head>
<body>

	<table>
	<%
		for(int i = 1; i <= 9; i++){ // 첫번째 for문 시작
	%>
	<tr>
	<% 
			for(int j = 2; j <=9; j++){ // 두번쨰 for문 시작
	%>
			<td> 
			<%= j %> 
			* 
			<%= i %> 
			=	
			<%= j * i %>
			</td>
	<%
			} // 첫번째 for문 끝
	%>
	</tr>
	<% 
		} // 두번째 for문 끝
	%>
	</table>


</body>
</html>
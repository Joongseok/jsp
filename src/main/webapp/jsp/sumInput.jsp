<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>sumInput</title>
</head>
<body>
	<form action="${cp}/sumCalculation" method="post">
		<input type="text" name="start" value="5">
		<input type="text" name="end" value="7">
		<input type="submit" value="전송">
	</form>
</body>
</html>
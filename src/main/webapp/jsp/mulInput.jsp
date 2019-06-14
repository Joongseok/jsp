<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>mulInput</title>
</head>
<body>
	<form action="${cp}/jsp/mulCalculation" method="post">
		<input type="text" name="param1"value="3">
		<input type="text" name="param2"value="6">
		<input type="submit"value="전송">
	</form>
</body>
</html>
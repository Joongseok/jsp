<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>fileUploadForm</title>
</head>
<body>
<form action="${pageContext.request.contextPath }/fileUpload" method="post" enctype="multipart/form-data">
	userId : <input type="text" name="userId" value="brown"><br>
	file : <input type="file" name="profile"><br>
	<input type="submit" value="전송"><br>
</form>
</body>
</html>
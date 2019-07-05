<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script>
var isCtrl = false;
	document.onkeydown=function(e){
		if(e.which == 17) 
			isCtrl = true;
		if(e.which == 13 && isCtrl == true){
			alert("hi")
			isCtrl = false;
		}
	}

</script>

</head>
<body>
1
</body>
</html>
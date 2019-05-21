<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Factorial</title>
</head>
<body>

<%!
	public String hello() {
		return "hello~";
	}
%>

<%! 
	public int factorial(int num) {
	
		if(num == 1) {
			return num;
		}else if(num == 0){
			return 1;
		}
		return factorial(num-1) * num;
	}
%>

<% int result = 0; %>

	hello() : <%= hello() %> <br>
	
	fac (0) : <%= result = factorial(0) %><br>
	fac (1) : <%= result = factorial(1) %><br>
	fac (2) : <%= result = factorial(2) %><br>
	fac (3) : <%= result = factorial(3) %><br>
	fac (4) : <%= result = factorial(4) %><br>
	fac (5) : <%= result = factorial(5) %><br>
	fac (6) : <%= result = factorial(6) %><br>
	fac (7) : <%= result = factorial(7) %><br>
	fac (8) : <%= result = factorial(8) %><br>

</body>
</html>
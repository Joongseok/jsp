<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>Login</title>

<link href="<%=request.getContextPath() %>/bootstrap/css/bootstrap.min.css" rel="stylesheet">

<link href="<%=request.getContextPath() %>/css/signin.css" rel="stylesheet">

</head>

<body>

	<div class="container">

		<form class="form-signin"
			  method="post" action="<%=request.getContextPath() %>/login">
			<h2 class="form-signin-heading">Login</h2>
			<label for="userId" class="sr-only">userId</label> 
			<input type="text" name="userId" id="userId" class="form-control" placeholder="userId" required autofocus>
			 <label	for="password" class="sr-only">password</label> 
			 <input	type="password" name="password" id="password" class="form-control" placeholder="password" required>
			<div class="checkbox">
				<label> <input type="checkbox" value="remember-me">	remember</label>
			</div>
			<button class="btn btn-lg btn-primary btn-block" type="submit">login </button>
		</form>

	</div>
</body>
</html>

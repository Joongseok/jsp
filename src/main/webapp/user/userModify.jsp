<%@page import="kr.or.ddit.paging.model.PageVO"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.user.model.UserVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<%@include file="/common/basicLib.jsp" %>

<script>
$(document).ready(function (){
	var msg = '${msg}';
	if(msg != ''){
		alert(msg);
	}
	$("#addrSearchBtn").on("click", function(){
		
		new daum.Postcode({
	        oncomplete: function(data) {
	            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분입니다.
	            // 예제를 참고하여 다양한 활용법을 확인해 보세요.
	            console.log(data);
	            console.log(data.roadAddress);
	            console.log(data.zonecode);
	            $("#addr1").val(data.roadAddress);
	            $("#zipcd").val(data.zonecode);
	        }
	    }).open();
	});
	
	$("#userRegBtn").on("click", function() {
		console.log("userRegBtn click")
		if($("#userId").val() == ""){
			alert("아이디를 입력해주세요");
			return;
		}
		if($("#name").val() == ""){
			alert("이름을 입력해주세요");
			return;
		}
		if($("#alias").val() == ""){
			alert("별명을 입력해주세요");
			return;
		}
		if($("#pass").val() == ""){
			alert("비밀번호를 입력해주세요");
			return;
		}
		$("#frm").submit();
		
	});
		
	
});

</script>
<title>사용자 수정</title>

<!-- css, js -->
<%@include file="/common/basicLib.jsp"%>

</head>

<body>
	<!-- header -->
	<%@include file="/common/header.jsp"%>

	<div class="container-fluid">
		<div class="row">

			<!-- left -->
			<%@include file="/common/left.jsp"%>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<div class="row">
					<div class="col-sm-8 blog-main">
						<h2 class="sub-header">사용자 수정</h2>
							
							
						<form id="frm" class="form-horizontal" action="${cp}/userModify" method="post" role="form"
						enctype="multipart/form-data">

							<div class="form-group">
								<label for="filename" class="col-sm-2 control-label">사용자
									사진</label>
								<div class="col-sm-10">
									<input type="file" id="file"
										name="modifyFile" value="${userVo.filename}" >
								</div>
							</div>
							
							<div class="form-group">
								<label for="userId" class="col-sm-2 control-label">사용자
									아이디</label>
								<div class="col-sm-10">
									<label class="control-label">${userVo.userId }</label>
								</div>
							</div>
							
							<div class="form-group">
								<label for="name" class="col-sm-2 control-label">사용자
									이름</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="name"
										name="name" value="${userVo.name}" placeholder="사용자 이름">
								</div>
							</div>
							
							<div class="form-group">
								<label for="alias" class="col-sm-2 control-label">별명</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="alias"
										name="alias" value="${userVo.alias}"  placeholder="사용자 별명">
								</div>
							</div>
							
							<div class="form-group">
								<label for="addr1" class="col-sm-2 control-label">주소</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" id="addr1"
										name="addr1" value="${userVo.addr1}" readonly placeholder="주소">
								</div>
								<div class="col-sm-2">
									<button id="addrSearchBtn" type="button" class="btn btn-default pull-right">주소검색</button>
								</div>
							</div>
						
							<div class="form-group">
								<label for="addr2" class="col-sm-2 control-label">상세주소</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="addr2"
										name="addr2" value="${userVo.addr2}" placeholder="상세주소">
								</div>
							</div>
						
							<div class="form-group">
								<label for="zipcd" class="col-sm-2 control-label">우편번호</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="zipcd"
										name="zipcd" value="${userVo.zipcd}" readonly placeholder="우편번호">
								</div>
							</div>
						
							<div class="form-group">
								<label for="birth" class="col-sm-2 control-label">생년월일</label>
								<div class="col-sm-10">
									<input type="date" class="form-control" id="birth"
										name="birth" value="${userVo.birthStr}" placeholder="생년월일">
								</div>
							</div>
							
							<div class="form-group">
								<label for="pass" class="col-sm-2 control-label">사용자
									비밀번호</label>
								<div class="col-sm-10">
									<input type="password" class="form-control" id="pass"
										name="pass" value="${userVo.pass}" placeholder="사용자 비밀번호">
								</div>
							</div>

							<div class="form-group">
								<div class="col-sm-offset-2 col-sm-10">
									<button id="userRegBtn" type="button" class="btn btn-default">사용자 수정</button>
								</div>
							</div>
						</form>
						
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>

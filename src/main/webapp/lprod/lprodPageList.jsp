<%@page import="kr.or.ddit.lprod.model.LprodVO"%>
<%@page import="kr.or.ddit.paging.model.PageVO"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.user.model.UserVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

<title>lprodList</title>
<style>
	.lprodTr:hover{
		cursor: pointer;
	}
</style>
<!-- css, js -->
<%@include file="/common/basicLib.jsp"%>

<script>
	$(document).ready(function() {
		$(".lprodTr").on('click', function(){
			var lprodId = $(this).data("lprodid");
			$("#lprodid").val(lprodId);
			$("#frm").submit();
			
		});
	});

</script>

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
						<h2 class="sub-header">lprod</h2>
						
						<form id="frm" action="${pageContext.request.contextPath}/lprod" method="get">
							<input type="hidden" id="lprodid" name="lprod_id">
						</form>
						
						<div class="table-responsive">
							<table class="table table-striped">
								<tr>
									<th>LPROD ID</th>
									<th>LPROD NAME</th>
									<th>LRPDO GU</th>
									<th>등록일시</th>
								</tr>

								<c:forEach items="${lprodList }" var="lprod">
									<tr class="lprodTr" data-lprodid="${lprod.lprod_id}">
										<td>${lprod.lprod_id }</td>
										<td>${lprod.lprod_nm }</td>
										<td>${lprod.lprod_gu }</td>
										<td></td>
									</tr>
								</c:forEach>
							</table>
						</div>

						<a class="btn btn-default pull-right">사용자 등록</a>
						<div class="text-center">
							<ul class="pagination">
								<c:choose>
									<c:when test=" ${pageVo.page == 1 }">
										<li class="disabled"><span>«</span></li>
									</c:when>
									<c:otherwise>
										<li><a href="${pageContext.request.contextPath}/lprodPagingList?page=${pageVo.page - 1 }&pageSize=${pageVo.pageSize}">«</a></li>
									</c:otherwise>
								</c:choose>
								
								<c:forEach var="i" begin="1" end="${paginationSize}" step="1">
									<li> 
									<c:choose>    
										<c:when test="${pageVo.page == i}">
											<li class="active" ><span>${i }</span> </li>
										</c:when>
										<c:when test="${pageVo.page != i}">
											<a href="${pageContext.request.contextPath}/lprodPagingList?page=${i}&pageSize=${pageVo.pageSize}">${i}</a>
										</c:when>
									</c:choose>
									</li>
								</c:forEach>	
								
								<c:choose>
									<c:when test=" ${pageVo.page == paginationSize }">
										<li class="disabled"><span>»</span></li>
									</c:when>
									<c:otherwise>
										<li><a href="${pageContext.request.contextPath}/lprodPagingList?page=${pageVo.page + 1 }&pageSize=${pageVo.pageSize}">»</a></li>
									</c:otherwise>
								</c:choose>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>

<%@page import="kr.or.ddit.lprod.model.LprodVO"%>
<%@page import="kr.or.ddit.paging.model.PageVO"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.user.model.UserVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

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
						<h2 class="sub-header">사용자</h2>
						<div class="table-responsive">
							<table class="table table-striped">
								<tr>
									<th>LPROD ID</th>
									<th>LPROD NAME</th>
									<th>LRPDO GU</th>
									<th>등록일시</th>
								</tr>

								<%
									List<LprodVO> lprodList = (List<LprodVO>) request.getAttribute("lprodList");
									for (LprodVO lprod : lprodList) {
								%>
								<tr>
									<td><%=lprod.getLprod_id()%></td>
									<td><%=lprod.getLprod_nm()%></td>
									<td><%=lprod.getLprod_gu()%></td>
									<td></td>
								</tr>
								<%
									}
								%>
							</table>
						</div>

						<a class="btn btn-default pull-right">사용자 등록</a>
						<div class="text-center">
							<ul class="pagination">
								
								<%// 내가 현재 몇번째 페이지에 있는가?
								PageVO pageVo = (PageVO)request.getAttribute("pageVo");
									int paginationSize = (Integer) request.getAttribute("paginationSize");%>
									<%if(pageVo.getPage() == 1) {%>
									<li class="disabled"><span>«</span></li>
									<%} else{%>
									<li><a href="<%=request.getContextPath()%>/lprodPagingList?page=<%=pageVo.getPage()-1%>&pageSize=<%=pageVo.getPageSize()%>">«</a></li>
									<% }%>
									<%for (int i = 1; i <= paginationSize; i++) {	%>
									<li 
									<%if(i==pageVo.getPage()){ %>
										class="active"
									<% }%>
									>
									<%if(i!=pageVo.getPage()){ %>
										<a href="<%=request.getContextPath()%>/lprodPagingList?page=<%=i%>&pageSize=<%=pageVo.getPageSize()%>"><%=i%></a>
									<%} else{%>
										<span><%=i %></span>
									<%}%>
									</li>
								<%
									}
								%>
								<%if (pageVo.getPage() == paginationSize) {%>
								<li class="disabled"><span>»</span></li>
								<%} else{ %>
								<li><a href="<%=request.getContextPath()%>/lprodPagingList?page=<%=pageVo.getPage() + 1%>&pageSize=<%=pageVo.getPageSize()%>">»</a></li>
								<% }%>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>

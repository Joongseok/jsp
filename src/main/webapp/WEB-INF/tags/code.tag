<%@tag import="kr.or.ddit.lprod.model.ProdVO"%>
<%@tag import="java.util.List"%>
<%@tag import="kr.or.ddit.lprod.dao.ILprodDao"%>
<%@tag import="kr.or.ddit.lprod.dao.LprodDaoImpl"%>
<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ attribute name="code" type="java.lang.String" required="true" %>

<% ILprodDao dao = new LprodDaoImpl();
	String prodLgu = (String)jspContext.getAttribute("code");
	List<ProdVO> prodList = dao.getProdName(prodLgu);
	
	jspContext.setAttribute("prodList", prodList);
%>

<select>
	<c:forEach items="${prodList }" var="prod">
		<option value="${prod.prod_id }">${prod.prod_name }</option>
	</c:forEach>
</select>

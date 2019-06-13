<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ attribute name="color" type="java.lang.String" required="true"%>
<%@ attribute name="size" type="java.lang.Integer" required="false"%>

<%-- <c:if test="${size eq null}"> --%>
<%-- 	<c:set value="5" var="size"></c:set> --%>
<%-- </c:if> --%>
<font color="${color}">
	<c:forEach begin="1" end="${size eq null ? 5 : size}">=</c:forEach>
</font>
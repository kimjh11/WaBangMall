<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:if test="${inCnt>0}">
	<script>
		alert("주문해 주셔서 감사합니다.");
		location.href="<%=request.getContextPath()%>/index.do";
	</script>
</c:if>
<c:if test="${inCnt<=0}">
	<script>
		alert("주문하기 실패.");
		history.back();
	</script>
</c:if>
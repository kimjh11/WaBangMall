<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:if test="${cnt>0 }">
	<script>
		alert("주문취소 완료.");
		location.href="<%=request.getContextPath()%>/mypage/myOrder.do";
	</script>
</c:if>
<c:if test="${cnt<=0 }">
	<script>
		alert("주문취소 실패.");
		history.go(-1);
	</script>
</c:if>
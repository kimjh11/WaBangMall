<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page trimDirectiveWhitespaces = "true" %>
<c:if test="${cnt>0 }">
	<script>
		if(confirm("장바구니를 확인하시겠습니까?")){
			loaction.href="<%=request.getContextPath()%>/orderpage/storeShoppingList.do?i-code=20180308";
		}else{
			history.back();
		}
	</script>
</c:if>
<c:if test="${cnt<=0 }">
	<script>
		alert("장바구니 추가 실패");
		history.back();
	</script>
</c:if>
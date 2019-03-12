<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page trimDirectiveWhitespaces = "true" %>
${list.size() }
<c:if test="${list.size()>0 }">
	<script>
		if(confirm("장바구니를 확인하시겠습니까?")){
			location.href="<%=request.getContextPath()%>/orderpage/shoppingList.do?";
		}else{
			history.back();
		}
	</script>
</c:if>
<c:if test="${list.size()<=0 }">
	<script>
		alert("장바구니 추가 실패");
		history.back();
	</script>
</c:if>
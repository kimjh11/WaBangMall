<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- 글 수정 성공시 -->
<c:if test="${cnt > 0}">
	<form id="updateForm" action="<%=request.getContextPath()%>/notice/noticeView.do">
		<input type="hidden" name="num" value="${num}">
		<input type="hidden" name="n_num" value="${n_num}">
	</form>
	<script>
		document.getElementById("updateForm").submit();
	</script>
</c:if>
<!-- 글 수정 실패시 -->
<c:if test="${cnt <= 0}">
	<script>
		alert("글 수정이 실패 했습니다.");
		history.back();
	</script>
</c:if>
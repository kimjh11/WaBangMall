<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- 글 수정 성공 -->
<c:if test="${cnt>0}">
	<script>
		location.href="<%=request.getContextPath()%>/qna/qnaView.do?num=${num}&q_num=${q_num}";
	</script>
</c:if>
<!-- 글 수정 실패 -->
<c:if test="${cnt<=0}">
	<script>
		alert("질문 글 수정을 실패했습니다.");
		history.back();
	</script>
</c:if>
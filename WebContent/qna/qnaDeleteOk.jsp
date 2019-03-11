<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- 질문 글 삭제 완료 -->
<c:if test="${cnt>0}">
	<script>
		location.href="<%=request.getContextPath()%>/qna/qnaList.do?num=${vo.num}";
	</script>
</c:if>
<!-- 질문 글 삭제 실패 -->
<c:if test="${cnt<=0}">
	<script>
		alert("질문 글 삭제가 실패하였습니다.");
		history.back();
	</script>
</c:if>
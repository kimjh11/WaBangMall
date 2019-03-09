<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- 공지사항 등록 완료 -->
<c:if test="${cnt>0}">
	<script>
		location.href="<%=request.getContextPath()%>/notice/notice.do";
	</script>
</c:if>
<!-- 공지사항 등록 실패 -->
<c:if test="${cnt<=0}">
	<script>
		alert("공지사항 등록을 실패하였습니다.");
		history.back();
	</script>
</c:if>
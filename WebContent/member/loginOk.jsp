<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- 로그인 성공 -->
<c:if test="${vo.loginStatus == 'Y' || adminvo.adminloginStatus == 'Y'}">
	<script>
		location.href="<%=request.getContextPath()%>/index.do";
	</script>
</c:if>
<!-- 로그인 실패 -->
<c:if test="${vo.loginStatus == 'N' || adminvo.adminloginStatus == 'N'}">
	<script>
		alert("아이디와 비밀번호를 확인해 주세요.");
		history.back();
	</script>
</c:if>
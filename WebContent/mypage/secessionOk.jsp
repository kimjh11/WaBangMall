<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- 회원탈퇴 완료 -->
<c:if test="${membercnt>0}">
	<script>
		alert("WaBang 홈페이지를 이용해 주셔서 감사합니다.");
		location.href="<%=request.getContextPath()%>/index.do";
	</script>
</c:if>

<!-- 회원탈퇴 실패 -->
<c:if test="${membercnt<=0}">
	<script>
		alert("비밀번호를 다시 한번 확인해 주세요.");
		history.back();
	</script>
</c:if>
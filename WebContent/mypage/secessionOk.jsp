<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- 회원탈퇴 완료 -->
<c:if test="${cnt>0}">
	<script>
		alert("회원 탈퇴 되었습니다.");
		location.href="<%=request.getContextPath()%>/index.do";
	</script>
</c:if>

<!-- 회원탈퇴 실패 -->
<c:if test="${cnt<=0}">
	<script>
		alert("비밀번호를 다시 한번 확인해 주세요.");
		history.back();
	</script>
</c:if>
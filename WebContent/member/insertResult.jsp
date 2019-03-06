<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- 회원가입 성공시, 로그인 폼으로 이동 -->
<c:if test="${cnt>0}">
	<script>
		alert("WaBang에 회원가입 되었습니다. 환영합니다.");
		location.href="<%=request.getContextPath()%>/member/login.do";
	</script>
</c:if>
<!-- 회원가입 실패시, 회원가입 폼으로 이동 -->
<c:if test="${cnt<=0}">
	<script>
		alert("회원가입에 실패 했습니다.");
		history.back();
	</script>
</c:if>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- 회원 수정 완료 -->
<c:if test="${cnt>0}">
	<script>
		alert("회원 정보가 수정 되었습니다.");
	</script>
</c:if>
<script>
	history.back();
</script>

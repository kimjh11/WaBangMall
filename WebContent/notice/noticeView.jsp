<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>공지사항 보기</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js" integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k" crossorigin="anonymous"></script>
<script src="https://cdn.ckeditor.com/4.11.2/full/ckeditor.js"></script>

<!-- 커스텀 CSS -->
<link href="../css/common.css" rel="stylesheet"/>
<link href="../css/notice.css" rel="stylesheet"/>

<script>
	//글 삭제하기
	function deleteCheck(){
		if(confirm("글을 삭제하시겠습니까?")){
			location.href="<%=request.getContextPath()%>/notice/noticeDeleteOk.do?num=${vo.num}&n_num=${vo.n_num}";
		}	
	}
</script>

</head>
<%@ include file="../index/store-header.jspf" %>
<body>
<!-- 로그인 여부 -->
<c:if test="${(loginStatus == null || loginStatus == ' ') && (adminloginStatus == null || adminloginStatus == ' ')}">
	<script>
		alert("로그인 후 공지사항을 읽을 수 있습니다.\n 로그인 화면으로 이동합니다.");
		location.href="<%=request.getContextPath()%>/member/login.do";
	</script>
</c:if>
	<div class="container">
	<h2 id="noticeTitle">공지사항</h2>
		
		<!-- 글 수정/삭제 (어드민 아이디로 접속시 보이게) -->
		<div>
			<!-- 로그인 아이디와 글쓴 아이디가 같을 경우 수정/삭제 -->
			<c:if test="${adminloginId == vo.adminId }">
				<button type="button" class="btn btn-outline-dark btn-sm" id="noticedeleteBtn">
		  			<a href="<%=request.getContextPath()%>/notice/noticeUpdateForm.do?num=${vo.num}&n_num=${vo.n_num}">수정하기</a>
		  		</button>
				<button type="button" class="btn btn-outline-dark btn-sm" id="noticeupdateBtn">
					<!-- 페이지 이동 개념보다 함수를 호출하는 개념으로. -->
		  			<a href="javascript:deleteCheck()">삭제하기</a>
		  		</button>   
			</c:if>
		</div>
		
		<!-- 글 제목, 글 내용  -->
		<div class="form-group row text">
			<label class="col-sm-9" id="noticeViewTitle">${vo.n_title}</label>
		</div>
		<div class="form-group row" id="noticeContent">
			<label class="form-control col-sm-10" id="noticeViewContent">${vo.n_content}</label>
		</div>
	</div>
</body>
</html>

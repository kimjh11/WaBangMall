<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>질문 & 답변 수정</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js" integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k" crossorigin="anonymous"></script>
<script src="https://cdn.ckeditor.com/4.11.2/full/ckeditor.js"></script>

<!-- 커스텀 CSS -->
<link href="../css/common.css" rel="stylesheet"/>
<link href="../css/qna.css" rel="stylesheet"/>

</head>
<%@ include file="../index/store-header.jspf" %>
<body>
	<div class="container">
		<form method="post" id="freeFrm" action="<%=request.getContextPath()%>/qna/qnaUpdateOk.do" class="form-horizontal">
			<div class="form-group row">
				<label class="col-sm-2 text">아이디</label>
				<input type="text" id="userid" name="userid" value="${loginId}" readonly class="form-control col-sm-9"/>
			</div>
			<div class="form-group row text">
				<label class="col-sm-2">제목</label>
				<input type="text" id="title" name="title" value="${vo.q_title}" class="form-control col-sm-9"/>
			</div>
			<div class="form-group row" id="qnaContent">
				<label class="col-sm-2 text">글내용</label>
				<textarea type="text" id="content" name="content" class="form-control col-sm-10">${vo.q_content}</textarea>
				<script>
					CKEDITOR.replace("content");
				</script>
			</div>
			<!-- 레코드 번호, 페이지 번호 -->
			<input type="hidden" name="num" value="${vo.num}"/>
			<input type="hidden" name="q_num" value="${vo.q_num}"/>
			
			<input type="submit" value="수정하기" class="form-control btn btn-outline-dark btn-sm"/>
		</form>
	</div>
</body>
</html>
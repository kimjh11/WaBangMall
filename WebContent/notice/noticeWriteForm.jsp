<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>공지사항 등록</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js" integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k" crossorigin="anonymous"></script>
<script src="https://cdn.ckeditor.com/4.11.2/full/ckeditor.js"></script>

<!-- 커스텀 CSS -->
<link href="../css/common.css" rel="stylesheet"/>
<link href="../css/notice.css" rel="stylesheet"/>

</head>
<%@ include file="../index/store-header.jspf" %>
<body>
	<div class="container">
		<form method="post" id="freeFrm" action="<%=request.getContextPath()%>/notice/noticeWrite.do" class="form-horizontal">
			<div class="form-group row">
				<label class="col-sm-2 text">아이디</label>
				<input type="text" id="adminid" name="adminid" value="${adminloginId}" readonly class="form-control col-sm-9"/>
			</div>
			<div class="form-group row text">
				<label class="col-sm-2">제목</label>
				<input type="text" id="title" name="title" class="form-control col-sm-9"/>
			</div>
			<div class="form-group row" id="noticeContent">
				<label class="col-sm-2 text">글내용</label>
				<textarea type="text" id="content" name="content" class="form-control col-sm-10"></textarea>
				<script>
					CKEDITOR.replace("content");
				</script>
			</div>
			<input type="submit" value="공지사항 등록" class="form-control btn btn-outline-dark btn-sm"/>
		</form>
	</div>
</body>
</html>
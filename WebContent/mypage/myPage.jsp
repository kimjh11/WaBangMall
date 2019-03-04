<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1"/>
<title>제목</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js" integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k" crossorigin="anonymous"></script>
</head>
<style>
	#mpDiv{margin-top:50px}
	h1{padding-bottom:50px;background:blue}
	h2{padding-top:20px;background:yellow}
</style>
<body>
	<!-- head -->
	
	<!-- body -->
	<div id="mpDiv">
		<h1>My Page</h1>
		
		<ul class="nav nav-tabs">
			<li class="nav-item"><a href="#tabMenu1" class="nav-link active" data-toggle="tab">내정보</a></li>
			<li class="nav-item"><a href="#tabMenu2" class="nav-link" data-toggle="tab">주문정보</a></li>
			<li class="nav-item"><a href="#tabMenu3" class="nav-link" data-toggle="tab">질문&답변</a></li>
			<li class="nav-item"><a href="#tabMenu4" class="nav-link" data-toggle="tab">장바구니</a></li>
		</ul>
		
		<div class="tab-content">
			<div id="tabMenu1" class="tab-pane active">
				<h2>내정보</h2>
				<%@include file="myInfo.jspf" %>
			</div>
			<div id="tabMenu2" class="tab-pane">
				<h2>주문정보</h2>
				<%@include file="order.jspf" %>
			</div>
			<div id="tabMenu3" class="tab-pane">
				<h2>질문&답변</h2>
				<%@include file="qna.jspf" %>
			</div>
			<div id="tabMenu4" class="tab-pane">
				<h2>장바구니</h2>
				
			</div>
		</div><!-- (tab-content) END -->
	</div>
	
	<!-- footer -->
</body>
</html>
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
<link rel="stylesheet" href="../css/common.css"/>
<style>
	.content{margin:0 auto;width:1200px}
	.content>h2{font-size:2em}
	#questionLiDiv{margin-top:30px;}
	h2{margin-top:30px}
</style>
</head>
<body>
<%@ include file="../index/store-header.jspf" %>
<div class="content">
<%@include file="menu.jspf"%>
<h2>문의목록</h2>
<div id="questionLiDiv">
	<table id="questionLiTa" class="table table-bordered table-striped">
			<thead>
			<tr>
				<td>제목</td>
				<td>내용</td>
				<td>문의날짜</td>
				<td>답변여부</td>
				<td>답변날짜</td>
			</tr>
			</thead>
			<tbody id="questionList">
				<c:forEach var="DepositVO" items="${list}">
					<tr>
						<td>${DepositVO.q_title }</td>
						<td>${DepositVO.q_content }</td>
						<td>${DepositVO.q_regdate }</td>
						<td></td>
						<td></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
</div>
</div>

</body>
</html>
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
<style>
	#orderLiDiv{margin-top:30px;}
	h2{margin-top:30px}
</style>
</head>
<body>
<div class="container">
<%@include file="menu.jspf"%>
<h2>주문목록</h2>
<div id="orderLiDiv">
	<table id="orderLiTa" class="table table-bordered table-striped">
			<thead>
			<tr>
				<td>주문번호</td>
				<td>상품코드</td>
				<td>선택옵션</td>
				<td>결제금액</td>
				<td>받는주소</td>
				<td>결제여부</td>
				<td>배송여부</td>
			</tr>
			</thead>
			<tbody id="orderList">
					<tr>
						<td>asdf123</td>
						<td>asdf1234</td>
						<td>흰색</td>
						<td>26800원</td>
						<td>서울 금천구 시흥</td>
						<td>미결제</td>
						<td>결제미확인</td>
					</tr>
			</tbody>
		</table>
</div>	
</div>
</body>
</html>
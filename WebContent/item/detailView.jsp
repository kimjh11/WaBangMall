<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces = "true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1"/>
<title>상품 상세페이지</title>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/common.css"/>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.7.7/angular.min.js"></script>
<script src="<%=request.getContextPath() %>/js/common.js"></script>
</head>
<body>
<div id="detail-wrap">
<!-- Header -->
<%@ include file="../index/store-header.jspf" %>
<section>
<div class="div-wrap width-auto">
	<div class="thumnail-frame">
		<!-- angular이용해서 클릭한 이미지 가져오기 -->
		<div id="thumnail-focus"></div>
		<ul id="thumnail-list">
		<c:forEach var="cnt" begin="1" end="3">
			<li><a href=""><img src=""/></a></li>
		</c:forEach>
		</ul>
	</div>
	<div class="item-info">
		
	</div>
</div>


</section>
<!-- Footer -->
<%@ include file="../index/store-footer.jspf" %>
</div>
</body>
</html>
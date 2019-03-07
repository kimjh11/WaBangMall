<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<!-- 지시부 태그 라이브러리 표시 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1"/>
<title>WaBangMall</title>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/common.css"/>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/index.css"/>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.7.7/angular.min.js"></script>
<script src="<%=request.getContextPath() %>/js/common.js"></script>
<script src="<%=request.getContextPath() %>/js/index.js"></script>
<script src="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.min.js"></script>
</head>
<!-- 추가 -->
<body>
<div id="index-wrap">
<!-- Header -->
<%@ include file="index/store-header.jspf" %>
<section>
	<!-- 이벤트 배너 : index.js, jquery로 li생성-->	
	<div id="event-banner-wrap" class="full_size">
		<ul id="event-banner" class="event-slider">
		<c:forEach var="img" begin="1" end="5">
			<li><a href="#" style="background-image:url(${ctx}img/store/event-banner-img-${img }.png)"></a></li>
		</c:forEach>
		</ul>
	</div>
	
	<!-- 베스트상품 start -->
	<div id="best-item-warp" class="width-auto">
		<!-- 베스트 상품 타이틀 -->
		<div class="main-title div-underline">
			<h3>베스트상품</h3>
			<a class="more-view" href="#">더보기</a>
		</div>
		<!-- 베스트 상품 리스트시작 -->
		<ul id="best-item-slider" class="best-item-slider">
			<c:forEach var="i" begin="1" end="10">
			<li>
				<a href="#">
					<span class="rank">${i }</span>
					<img src="${ctx }img/store/item-thumnail-${i }.jpg">
					<div class="item-info">
						<p class="i-name">${i }번째 상품명</p>
						<span class="i-discount">20</span>
						<strong class="i-price">45000</strong>
					</div>
				</a>
			</li>
			</c:forEach>
		</ul>
	</div>
	<!-- 베스트상품 end -->
	
	<!-- 자주찾는 카테고리 start -->
	<div id="popular-cate-wrap" class="width-auto">
		<!-- 자주찾는 카테고리 타이틀 -->
		<div class="main-title div-underline">
			<h3>자주찾는 카테고리</h3>
			<a class="more-view" href="#">더보기</a>
		</div>
		<!-- 자주찾는 카테고리 리스트 -->
		<ul id="popular-cate-list">
			<c:forEach var="j" begin="1" end="8">
			<c:if test="${j<=4 }">
				<li class="col-top">
					<a href="#">카테고리${j }</a>
				</li>
			</c:if>
			<c:if test="${j>4 }">
				<li class="col-bottom">
					<a href="#">카테고리${j }</a>
				</li>
			</c:if>
			</c:forEach>
		</ul>
	</div>
	<!-- 자주찾는 카테고리 end -->
	
	
	<!-- 초특가 상품배너 start -->
	<div class="line-banner-wrap">
		<a href="#" class="line-banner ">
			<span class="width-auto">초특가 상품 이벤트 명</span>
			<img src=""/>
		</a>
	</div>
	<!-- 초특가 상품배너 end -->
	
	
	<!-- 오늘만특가 start -->
	<div id="today-sale" class="width-auto">
		<!-- 오늘만특가 타이틀 -->
		<div class="main-title div-underline">
			<h3>오늘만 특가</h3>
			<a class="more-view" href="#">더보기</a>
		</div>
		<!-- 오늘만특가 상품리스트 -->
		<ul>
			<c:forEach var="z" begin="1" end="3">
			<li>
				<a href="#">
					<span class="i-name">특가상품명${z }</span>
					<span class="i-discount top-label">76</span>
					<img class="i-thumnail op-scale" src="${ctx }img/store/sale-item-${z }.jpg"/>
				</a>
			</li>
			</c:forEach>
		</ul>
	</div>
	<!-- 오늘만특가 end -->
</section>

<!-- Footer -->
<%@ include file="index/store-footer.jspf" %>
</div>
</body>

</html>
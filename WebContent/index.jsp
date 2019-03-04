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
<link rel="stylesheet" href="css/common.css"/>
<link rel="stylesheet" href="css/index.css"/>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.7.7/angular.min.js"></script>
<script src="js/index.js"></script>
<script src="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.min.js"></script>
</head>

<body>
<!-- Header -->
<%@ include file="index/store-header.jspf" %>
<section>
	<!-- 이벤트 배너 : index.js, jquery로 li생성-->	
	<div id="event-banner-wrap" class="full_size">
		<ul id="event-banner" class="bxslider"></ul>
	</div>
	
	<!-- 베스트상품 -->
	<div id="best-item" class="width-auto">
		<div class="menu-title div_underline">
			<h3>베스트상품</h3>
			<a class="more-view" href="#">더보기<span></span></a>
		</div>	
		<ul id="best_item_list" class="bxslider_second">
			<li>
				<a href="#">
					<span class="best_item_txt">
						<p>오로라스텐드</p>
						<span>59%</span>
						<span><strong>23,000</strong>원</span>
					</span>
				</a>
			</li>
		</ul>
	</div>
	
	<!-- 자주찾는 카테고리 -->
	<div id="more-view-category" class="width-auto">
		<div class="store_home_title">
			<h3>자주찾는 카테고리</h3>
			<a class="more-view" href="#">더보기<span></span></a>
		</div>
	</div>
	
	<!-- 초특가 상품배너 -->
	<div class="line-banner">
		<a href="#" class="width-auto">
			<span>초특가 상품배너</span>
		</a>
	</div>
	
	<!-- 오늘만특가 -->
	<div id="today_sale_item" class="container">
		<div class="store_home_title">
			<h3>오늘만 특가</h3>
			<a class="more-view" href="#">더보기<span></span></a>
		</div>
		<ul>
			<li class="col3">
				<a href="#">
					<span class='top_rank_info'>76%</span>
					<span>노래부르고싶은 영화포스터, 1+1</span>
				</a>
			</li>
			<li class="col3">
				<a href="#">
					<span class='top_rank_info'>27%</span>
					<span>요리는 장비빨! 냄비 풀세트</span>
				</a>
			</li>
			<li class="col3">
				<a href="#">
					<span class='top_rank_info'>42%</span>
					<span>따뜻한 감성, 페브릭소파</span>
				</a>
			</li>
		</ul>
	</div>
</section>
<!-- Footer -->
<%@ include file="index/store-footer.jspf" %>
</body>

</html>
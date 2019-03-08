<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces = "true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1"/>
<title>상품 상세페이지</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/common.css"/>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/detailView.css"/>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js" integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k" crossorigin="anonymous"></script>
<script src="<%=request.getContextPath() %>/js/common.js"></script>
<script src="<%=request.getContextPath() %>/js/detailView.js"></script>
<script src="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.min.js"></script>
</head>
<body>
<div id="detail-wrap">
<!-- Header -->
<%@ include file="../index/store-header.jspf" %>
<section>
<div class="div-wrap width-auto">
	<div class="top-content">
		<div class="thumnail-wrap">
			<!-- 썸네일 메인이미지 -->
			<div id="thumnail-focus"></div>
			<!-- 썸네일 리스트(하단) -->
			<ul id="thumnail-list">
			<c:forEach var="cnt" begin="1" end="3">
				<li>
					<a href="#">
						<img src="${ctx }img/store/detailview-thumnail-${cnt}.jpg"/>
					</a>
				</li>
			</c:forEach>
			</ul>
		</div>
		<div class="info-wrap">
			<nav class="i-category">
				<c:forEach var="cate" begin="1" end="3">
				<a href="">카테고리${cate }</a>
				</c:forEach>
			</nav>
			<div class="info-div">
				<h4 id="i-name">상품명상품명상품명상품명상품명상품명상품명상품명상품명상품명상품명</h4>
				<strong id="i-discount" class="percent">10</strong>
				<div class="price-div">
					<span id="i-price" class="del-line won">99000</span>
					<strong id="sell-price" class="won">2525667</strong>
				</div>
			</div>  
			<!-- 옵션/컬러/수량 선택 -->
			<ul class="opt-div">
				<li>
					<span class="info-title">옵션</span>
					<select id="opt-select">
						<!-- 옵션 -->
						<c:forEach var="opt" begin="0" end="3">
						<c:if test="${opt<=0 }">
							<option value="">옵션을 선택해주세요</option>
						</c:if>
						<c:if test="${opt>0 }">
							<option value="옵션가격${opt }">옵션명${opt }</option>
						</c:if>
						</c:forEach>
					</select>
				</li>
				<li>
					<span class="info-title">색상</span>
					<select id="color-select">
						<!-- 색상  -->
						<c:forEach var="color" begin="0" end="3">
						<c:if test="${color<=0 }">
							<option value="">색상을 선택해주세요</option>
						</c:if>
						<c:if test="${color>0 }">
							<option value="색상추가금액${color }">색상${color}</option>
						</c:if>	
						</c:forEach>
					</select>
				</li>
			</ul>
			<!-- 옵션/컬러/수량 선택 end-->
			<!-- 주문 체크 -->
			<div class="order-chk-div">
				<div class="cnt-wrap" style="display:none">
					<span class="info-title" >수량</span>
					<div class="cnt-div">
						<button class="minus-btn">―</button>
						<input id="i-count" type="number" value="1" readonly>
						<button class="plus-btn">＋</button>
					</div>
				</div>
				<div class="opt-chk" style="display:none">
					
				</div>
				<div class="price-chk">
					<span class="info-title">총금액</span>
					<strong id="total-price" class="won">0</strong>
				</div>
			</div>
			<!-- 주문 체크 end -->
			<!-- 장바구니/구매하기 버튼 -->
			<ul class="order_btn">
				<li><a data-toggle="modal" data-target="#add-shopping-list" href="#">장바구니</a></li>
				<li><a href="#">구매하기</a></li>
			</ul>
			<!-- 장바구니 담기 모달 -->
			<div id="add-shopping-list" class="modal fade">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">장바구니에 물건을 담았습니다 :)</div>
						<div class="modal-body">
							<a href="StoreShoppingList.html">장바구니 확인하기</a>
							<a data-dismiss="modal" href="#">계속쇼핑하기</a>
						</div>
						<div class="modal-footer">
							<a href="#">
								<img data-dismiss="modal" alt="종료버튼" src="${ctx }img/store/close-btn.png">
							</a>
						</div>
					</div>
				</div>
			</div>
			<!-- 장바구니 담기 모달 end -->
		</div>
		<!-- info-wrap end -->
	</div>
	<!-- top-content end -->
	<div class="main-content">
		<!-- 탭메뉴 -->
		<ul class="nav nav-tabs"></ul>
		<!-- 탭메뉴 end-->
		<div class="tab-content">
			<!-- 상세페이지 view -->
			<div id="content0"class="tab-pane active" >
				상품상세페이지
			</div>
			<!-- 상세페이지 view end -->
			<!-- 리뷰 -->
			<div id="content1"class="tab-pane" >
				리뷰
			</div>
			<!-- 리뷰  end -->
			<!-- 배송/교환/환불 -->
			<div id="content2"class="tab-pane" >
				배송/교환/환불
			</div>
			<!-- 배송/교환/환불 end -->
			<!-- 문의사항 -->
			<div id="content3"class="tab-pane" >
				문의사항
			</div>
			<!-- 문의사항 end -->
		</div>
		
	</div>
</div>


</section>
<!-- Footer -->
<%@ include file="../index/store-footer.jspf" %>
</div>
</body>
</html>
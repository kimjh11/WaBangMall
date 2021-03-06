<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces = "true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1"/>
<title>상품 상세페이지</title>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/detailView.css"/>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="<%=request.getContextPath() %>/js/detailView.js"></script>
</head>
<body>
<div id="content-wrap">
<!-- Header -->
<%@ include file="../index/store-header.jspf" %>
<section>
<div class="div-wrap width-auto">
<form id="frm" method="post" enctype="multipart/form-data">
	<input type="hidden" name="iCode" value="${vo.iCode }"/>
	<input type="hidden" name="loginStatus" value="<%=session.getAttribute("loginStatus") %>"/>
	<div class="top-content">
		<div class="thumnail-wrap">
			<!-- 썸네일 메인이미지 -->
			<div id="thumnail-focus"></div>
			<!-- 썸네일 리스트(하단) -->
			<ul id="thumnail-list">
			<c:forTokens var="img" items="${vo.iThumbnailStr }" delims="|">
				<li>
					<a href="#">
						<img src="http://172.16.1.14:9090/WaBangAdmin/item/itemImg/${img }"/>
					</a>
				</li>
			</c:forTokens>
			</ul>
		</div>
		<div class="info-wrap">
			<nav class="i-category">
			<c:forTokens var="category" items="${vo.iCategoryStr }" delims="|">
				<a href="">${category }</a>
			</c:forTokens>
			</nav>
			<div class="info-div">
				<h4 id="i-name">${vo.iName }</h4>
				<strong id="i-discount" class="percent">${vo.iDiscount }</strong>
				<div class="price-div">
					<span id="i-price" class="del-line won">${vo.iPrice }</span>
					<strong id="sell-price" class="won">${vo.noOptPrice }</strong>
				</div>
			</div>  
			<!-- 옵션/컬러/수량 선택 -->
			<ul class="opt-div">
				<li>
					<span class="info-title">옵션</span>
					<select id="opt-select">
						<!-- 옵션 -->
						<option value="">옵션을 선택해주세요</option>
						<!-- 옵션이 없을경우 -->
						<c:if test='${vo.iOptStr.contains("undefined")==true}'>
							<option value='${vo.noOptPrice }'>선택안함</option>
						</c:if>
						<!-- 옵션이 있을경우 -->
						<c:if test='${vo.iOptStr.contains("undefined")==false}'>
							<option value=0>선택안함</option>
							<!-- 옵션나누기 -->
							<c:forTokens var="opt" items="${vo.iOptStr }" delims="|">
								<!-- 추가 옵션가가 있을 경우 : value값 = 옵션가 -->
								<c:if test='${fn:contains(opt,"+") }'>
									<!-- 옵션명/옵션가 나누기 -->
									<option value='${opt.substring(opt.indexOf("+")+1) }'>${opt }</option>
								</c:if>
								<!-- 추가옵션가가 없을 경우 : value값 = 0-->
								<c:if test='${!fn:contains(opt,"+") }'>
									<option value=0>${opt }</option>
								</c:if>
							</c:forTokens>
						</c:if>
					</select>
				</li>
				<li>
					<span class="info-title">색상</span>
					<select id="color-select">
						<!-- 색상  -->
						<option value="">색상을 선택해주세요</option>
						<!-- 색상옵션이 없을경우 -->
						<c:if test='${vo.iColorStr.contains("undefined")==true}'>
							<option value=0>선택안함</option>
						</c:if>
						<c:if test='${vo.iColorStr.substring(vo.iColorStr.indexOf("|")+1)==""}'>
							<option value=0>선택안함</option>
						</c:if>
						<!-- 색상옵션이 있을경우 -->
						<c:if test='${vo.iColorStr.contains("undefined")==false}'>
							<!-- 색상나누기 -->
							<c:forTokens var="color" items="${vo.iColorStr }" delims="|">
								<!-- 추가 옵션가가 있을 경우 : value값 = 옵션가 -->
								<c:if test='${fn:contains(color,"+") }'>
									<option value='${color.substring(opt.indexOf("+")+1) }'>${color }</option>
								</c:if>
								<!-- 추가 옵션가가 없을 경우: value값 = 옵션가 -->
								<c:if test='${!fn:contains(color,"+") }'>
									<option value=0>${color }</option>
								</c:if>
							</c:forTokens>
						</c:if>
					</select>
				</li>
			</ul>
			<!-- 옵션/컬러/수량 선택 end-->
			<!-- 주문 체크 -->
			<div class="order-chk-div">
				<ul class="opt-chk" style="display:none"></ul>
				<div class="price-chk">
					<span class="info-title">총금액</span>
					<input type="number" name="bPayment" id="bPayment" readonly/>원
				</div>
			</div>
			<!-- 주문 체크 end -->
			<!-- 장바구니/구매하기 버튼 -->
			<ul class="order_btn">
				<li><input type="button" value="장바구니담기"/></li>
				<li><input type="button" value="구매하기" class="buy-btn"/></li>
			</ul>
			<!-- 장바구니 담기 모달 -->
			<!-- <div id="add-shopping-list" class="modal fade">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">장바구니에 물건을 담았습니다 :)</div>
						<div class="modal-body">
							<button>장바구니 확인하기</button>
							<a data-dismiss="modal" href="#">계속쇼핑하기</a>
						</div>
						<div class="modal-footer">
							<a href="#">
								<img data-dismiss="modal" alt="종료버튼" src="http://localhost:9090/WaBangMall/img/store/close-btn.png">
							</a>
						</div>
					</div>
				</div>
			</div> -->
			<!-- 장바구니 담기 모달 end -->
		</div>
		<!-- info-wrap end -->
	</div>
	<!-- top-content end -->
</form>
	<div class="main-content">
		<!-- 탭메뉴 -->
		<ul class="nav nav-tabs"></ul>
		<!-- 탭메뉴 end-->
		<div class="tab-content">
			<!-- 상세페이지 view -->
			<div id="content0"class="tab-pane active" >
				<img src="http://172.16.1.14:9090/WaBangAdmin/item/itemImg/${vo.iDetail }"/>
			</div>
			<!-- 상세페이지 view end -->
			<!-- 리뷰 -->
			<div id="content1"class="tab-pane" >
			<c:if test="${loginStatus=='Y' }">
				<button>리뷰등록하기</button>
			</c:if>
			<!--
			<table>
				<thead>
					<tr>
						<td></td>
					</tr>
				</thead>
			</table>
			<form method="post" action="">
				<input type="text" value="title" />
				<span>regdate</span>
				<textarea>content</textarea>
				
				<input type="button" value="등록하기"/>
			</form>
			</div>
			 -->
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
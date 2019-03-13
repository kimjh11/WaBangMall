<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1"/>
<title>장바구니</title>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/common.css"/>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/itemList.css"/>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="<%=request.getContextPath() %>/js/common.js"></script>
<script src="<%=request.getContextPath() %>/js/shoppingList.js"></script>
</head>
<body>
<div id="content-wrap">
<!-- Header -->
<%@ include file="../index/store-header.jspf" %>
<section>
<div class="div-wrap width-auto">
	<h4>장바구니</h4>
	<div id="shoppingLiDiv">
		<!-- 체크박스 -->
		<div class="list-checkbox">
			<input type="checkbox" class="all-chk"/>
			<a href="#" class="all-chk txt-btn">전체선택</a>
			<a href="#" class="del-btn part">선택삭제</a>
			<a href="#" class="del-btn all">전체삭제</a>
		</div>
		<!-- 선택상품 리스트 -->
		<div class="table-wrap" id="shopTb" >
		<table class="shopping-list">
			<colgroup>
				<col class="col1">
				<col class="col2">
				<col class="col3">
				<col class="col4">
				<col class="col5">
			</colgroup>
			<thead>
				<tr>
					<td>상품정보</td>
					<td>수량</td>
					<td>배송료</td>
					<td>금액</td>
					<td>주문관리</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="vo" items="${list }">
				<tr>
					<!-- 상품정보 -->
					<td class="item-info">
						<!-- 체크박스 -->
						<input type="checkbox" name="row-check"/>
						<!-- 썸네일 -->
						<div class="img-wrap">
							<c:forTokens var="img" items='${vo.iThumbnail }' delims="|">
							<a href="#" class="img-click">
								<img src="${ctx }img/store/${img }"/>
							</a>
							</c:forTokens>
						</div>
						<!-- 카테고리 -->
						<div class="i-category">
							<c:forTokens var="category" items="${vo.iCategory }" delims="|">
							<span>${category }</span>
							</c:forTokens>
						</div>
						<!-- 상품명/옵션 -->
						<div class="item-title">
							<h5><a href="${ctx }item/detailView.do">${vo.iName }</a></h5>
							<span><strong>옵션명</strong>${vo.bSelectOptStr }</span><br/>
							<span><strong>색상</strong>${vo.bColorStr }</span>
						</div>
					</td>
					<!-- 상품수량 -->
					<td class="cnt-txt">${vo.bCountStr }</td>
					<!-- 배송료 -->
					<td>----</td>
					<!-- 가격 -->
					<td class="won">${vo.bPrice * vo.bCountStr }</td>
					<!-- 기타옵션 -->
					<td class="setting">
						<button class="btn-pointer del-btn row">상품삭제</button>		
					</td>
				</tr>
				</c:forEach>
			</tbody>
			<tfoot>
			<!-- 선택상품 합친가격,수량 -->
				<tr>
					<td colspan="5">
						<div>
							<span class="fs15">총 수량</span>
							<strong class="fs15 total-cnt"></strong>
						</div>
						<div>
							<span class="fs15">배송료</span>
							<strong class="fs15">무료</strong>
						</div>
						<div>
							<span class="fs15">총 구매금액</span>
							<strong class="fs15 won">53,500</strong>
						</div>
					</td>
				</tr>
			</tfoot>
		</table>
		</div>
		
		<!-- 쇼핑계속 and 주문하기 btn -->
		<div id="chdiv">
			<a href="#" class="chBtn" style="margin-left:250px;">쇼핑계속하기</a>
			<a href="${ctx }orderpage/storeOrderList.do" class="chBtn" style="margin-left:20px;">주문하기</a>
		</div>
	</div>
</div>
</section>
<!-- Footer -->
<%@ include file="../index/store-footer.jspf" %>
</div><!-- content-wrap -->
</body>
</html>
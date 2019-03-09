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

<link rel="stylesheet" href="<%=request.getContextPath() %>/css/common.css"/>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/index.css"/>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.7.7/angular.min.js"></script>
<script src="<%=request.getContextPath() %>/js/common.js"></script>
<script src="<%=request.getContextPath() %>/js/index.js"></script>
<script src="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.min.js"></script>
</head>
<style>
	#shoppingDiv{margin: 0 auto;width:900px}
	#shoppingDiv>h4{font-size:2em}
	#shoppingLiDiv{margin-top:30px;margin-bottom:100px}
	h4{margin-top:30px}
	#shopTb{margin-top:30px}
	#itemDiv>ul>li{float:left}
	#itemintro>div{float:left}
	.fs15{font-size:1.5em}
	#chDiv{margin-top:50px}
	#chDiv>ul>li{float:left}
	.chBtn{font-size:3em;color:pink}
</style>
<body>
<%@ include file="../index/store-header.jspf" %>
<div id="shoppingDiv">
	<h4>장바구니</h4>
	<div id="shoppingLiDiv">
		
		<!-- 장바구니 선택상품 삭제 -->
		<div class="list_chk_option">
			<input type="checkbox" id="all_chk" onclick="checkAll()"/>
			<a href="#" onclick="checkAll(0)">전체선택</a><span>｜</span>
			<a href="#" onclick="tr_del()">선택삭제</a><span>｜</span>
			<a href="#" onclick="all_del()">전체삭제</a>
		</div>
		
		<!-- 선택상품 리스트 -->
		<div id="shopTb" >
			<table>
				<thead style="border-bottom:1px solid gray">
					<tr class="fs15 row" style="margin-bottom:10px">
						<td class="col-sm-6" style="width:700px">상품정보</td>
						<td class="col-sm-2">수량</td>
						<td class="col-sm-2">배송료</td>
						<td class="col-sm-2">금액</td>
					</tr>
					<tr>
					<td>
					
					</td>
					</tr>
				</thead>
				<tbody>
					<tr class="row">
						<td class="col-sm-6">
							<!-- 선택 상품이미지 -->	
							<div id="itemDiv" style="margin-top:20px">
								<ul>
									<li><input type="checkbox"/> 스토어<span>></span></li>
									<li>가전<span>></span></li>
									<li>계절가전<span>></span></li>
									<li>가습기</li>
								</ul><br/>
								<div id="itemintro" style="margin-top:20px;background:red;">
									<div>
										<a href="#">
											<img src="../img/store/detailview-thumnail-1.jpg" style="width:150px;height:150px"alt="장바구니상품이미지"/>
										</a>
									</div>
									<div style="width:150px;height:150px;padding-left:20px">
										<span><a style="font-size:2.5em">상품명1</a></span><br/><br/>
										<span class="fs15">선택옵션</span><br/>
										<span class="fs15">선택색상</span>
									</div>
								</div>
							</div>	
						</td>
						<!-- 수량 -->
						<td class="col-sm-2 fs15" style="line-height:200px">
							개
						</td>
						<!-- 배송비 -->
						<td class="col-sm-2 fs15" style="line-height:200px">
							무료
						</td>
						<!-- 가격 -->
						<td class="col-sm-2 fs15" style="line-height:200px">
							원
						</td>
					</tr>
				</tbody>
			<tfoot>
				<tr>
					<td colspan="5" style="text-align:right">
						<div>
							<span class="fs15">총 수량</span>
							<strong class="fs15">1</strong><small class="fs15">개</small>
						</div>
						<div>
							<span class="fs15">배송료 합계</span>
							<strong class="fs15">4,000</strong><small class="fs15">원</small>
						</div><div>
							<span class="fs15">총 구매금액</span>
							<strong class="fs15">53,500</strong><small class="fs15">원</small>
						</div>
					</td>
				</tr>
			</tfoot>
		</table>
		</div>
		
		<!-- 쇼핑계속 and 주문하기 btn -->
		<div id="chdiv">
			<a href="#" class="chBtn" style="margin-left:250px;">쇼핑계속하기</a>
			<a href="#" class="chBtn" style="margin-left:20px;">주문하기</a>
		</div>
	</div>
</div>
</body>
</html>
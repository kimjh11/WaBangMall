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

		<!-- 선택상품 리스트 -->
		<div id="shopTb" >
			<table>
				<thead style="border-bottom:1px solid gray">
					<tr class="fs15" style="margin-bottom:10px">
						<td style="width:600px">상품정보</td>
						<td style="width:100px">수량</td>
						<td style="width:100px">배송료</td>
						<td style="width:100px">금액</td>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="vo" items="${list }">
					<tr>
						<td>
							<!-- 선택 상품이미지 -->	
							<div id="itemDiv" style="margin-top:20px">
								<ul class="i-category">
								<c:forTokens var="category" items="${vo.iCategory }" delims="|">
									<li>${category }</li>
								</c:forTokens>
								</ul><br/>
								<div id="itemintro" style="margin-top:20px;background:red;">
									<div>
										<a href="#">
											<img src="../img/store/detailview-thumnail-1.jpg" style="width:150px;height:150px"alt="장바구니상품이미지"/>
										</a>
									</div>
									<div style="width:150px;height:150px;padding-left:20px">
										<span><a style="font-size:2.5em">${vo.iName }</a></span><br/><br/>
										<span class="fs15">${vo.bSelectOptStr }</span><br/>
										<span class="fs15">${vo.bColorStr }</span><br/><br/>
										<span class="fs15"><a href="" style="color:red">장바구니 제외</a></span>
									</div>
								</div>
							</div>	
						</td>
						<!-- 수량 -->
						<td class="fs15 b-cnt" style="line-height:200px">
							${vo.bCountStr }
						</td>
						<!-- 배송비 -->
						<td class="fs15" style="line-height:200px">
							무료
						</td>
						<!-- 가격 -->
						<td class="fs15" style="line-height:200px">
							${vo.bPrice * vo.bCountStr }
						</td>
					</tr>
					</c:forEach>
				</tbody>
				
			<!-- 선택상품 합친가격,수량 -->
			<tfoot>
				<tr>
					<td colspan="5" style="text-align:right">
						<div>
							<span class="fs15">총 수량</span>
							<strong class="fs15 total-cnt"></strong>
							<small class="fs15">개</small>
						</div>
						<div>
							<span class="fs15">배송료</span>
							<strong class="fs15">무료</strong>
						</div><div>
							<span class="fs15">총 구매금액</span>
							<strong class="fs15">53,500</strong>
							<small class="fs15">원</small>
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
<script>
	$(function(){
		$('tbody').ready(function(){
			var bCount = Number($('.b-cnt').text());
			console.log($('.b-cnt').text());
			var cntSum = 0;
			for(i=0; i<bCount.index(); i++){
				cntSum = cntSum+bCount;
			}
			$('.total-cnt').text(cntSum);
		});
	});
</script>
</body>
</html>
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
	#orderLiDiv{margin-top:30px;}
	h2{margin-top:30px}
</style>
</head>
<body>
<%@ include file="../index/store-header.jspf" %>
<div class="content">
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
				<td>주문날짜</td>
				<td>결제여부</td>
				<td>배송여부</td>
				<td>주문여부</td>
			</tr>
			</thead>
			<tbody id="orderList">
				<c:forEach var="OrderVO" items="${list}">
					<tr>
						<td>${OrderVO.o_num }</td>
						<td>${OrderVO.i_code }</td>
						<td>
							옵션: ${OrderVO.o_selectOpt }<br/>
							색상: ${OrderVO.o_selectColor }<br/>
							수량: ${OrderVO.o_count }
						</td>
						<td>${OrderVO.o_payment } 원</td>
						<td>
							우편번호: ${OrderVO.m_zipCode}<br/>
							${OrderVO.m_addr}&nbsp;
							${OrderVO.m_addrDetail}
						</td>
						<td>${OrderVO.o_date }</td>
						<c:if test="${OrderVO.o_deposit=='미결제' }">					
							<td><a href="${ctx }mypage/payment.do?i_code=${OrderVO.i_code }&o_num=${OrderVO.o_num }" style="color:red">${OrderVO.o_deposit }</a></td>					
						</c:if>
						<c:if test="${OrderVO.o_deposit=='결제완료' }">					
							<td><a href="${ctx }mypage/payment.do?i_code=${OrderVO.i_code }&o_num=${OrderVO.o_num }" style="color:blue">${OrderVO.o_deposit }</a></td>					
						</c:if>
						<c:if test="${OrderVO.o_delivery=='배송준비중' }">
							<td style="color:red">${OrderVO.o_delivery}</td>
						</c:if>
						<c:if test="${OrderVO.o_delivery=='배송완료' }">
							<td style="color:blue">${OrderVO.o_delivery}</td>
						</c:if>
						<td><a href="${ctx }mypage/orderDelete.do?m_id=${OrderVO.m_id}&o_num=${OrderVO.o_num }&i_code=${OrderVO.i_code }&o_selectOpt=${OrderVO.o_selectOpt }">주문취소</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
</div>
	<!-- 페이징 start -->
		<div id="pageBtn">
			<ul class="pagination justify-content-center">
			
			<!-- 이전 페이지 start -->
				<c:if test="${vo.num == 1}">
					<li class="page-item disabled"><a class="page-link" href="#">＜</a></li>
				</c:if>
				<c:if test="${vo.num > 1}">
					<li class="page-item"><a class="page-link" href="<%=request.getContextPath()%>/mypage/myOrder.do?num=${vo.num-1}">＜</a></li>
				</c:if>
			<!-- 이전 페이지 end -->
			
			<!-- 페이지 수 start -->
			<!--                                  1                    1       +       5-1         -->
				<c:forEach var="i" begin="${vo.startPage}" end="${vo.startPage + vo.pageNumCount-1}">
					<c:if test="${i<=vo.totalPage}">
						<c:choose>
							<c:when test="${ i == vo.num }">
								<li class="page-item active"><a class="page-link" href="<%=request.getContextPath()%>/mypage/myOrder.do?num=${i}">${i}</a></li>
							</c:when>
							<c:otherwise>
								<li class="page-item"><a class="page-link" href="<%=request.getContextPath()%>/mypage/myOrder.do?num=${i}">${i}</a></li>
							</c:otherwise>
						</c:choose>
					</c:if>
				</c:forEach>
			<!-- 페이지 수 end -->	
			
			<!-- 다음 페이지 start  -->
				<c:if test="${vo.num == vo.totalPage}">
					<li class="page-item disabled"><a class="page-link" href="#">＞</a></li>
				</c:if>
				<c:if test="${vo.num < vo.totalPage}">
					<li class="page-item"><a class="page-link" href="<%=request.getContextPath()%>/mypage/myOrder.do?num=${vo.num+1}">＞</a></li>
				</c:if>
			<!-- 다음 페이지 end -->
			</ul>
		</div>
		<!-- 페이징 end -->
</div>
</body>
</html>
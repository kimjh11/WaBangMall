<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1"/>
<title>내 문의</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<link rel="stylesheet" href="../css/common.css"/>

<style>
	.content{margin:0 auto;width:1200px}
	.content>h2{font-size:2em;margin-left: 10px;}
	#questionLiDiv{margin-top:30px;}
	h2{margin-top:30px}
	
	/* 긴 제목 처리하기 */
	.wordCut{white-space : nowrap; overflow: hidden; text-overflow:ellipsis}

</style>

</head>
<body>
<%@ include file="../index/store-header.jspf" %>

<div class="content">
	<%@include file="menu.jspf"%>
	<h2>문의목록</h2>
	<div id="questionLiDiv">
		<table id="questionLiTa" class="table table-bordered table-striped">
				<thead>
				<tr>
					<td>번호</td>
					<td>제목</td>
					<td>내용</td>
					<td>문의날짜</td>
					<td>답변여부</td>
					<td>답변날짜</td>
				</tr>
				</thead>
				<tbody id="questionList">
					<c:forEach var="DepositVO" items="${list}">
						<tr>
							<td>${DepositVO.q_num}</td>
							<td class="wordCut"><a href="<%=request.getContextPath()%>/qna/qnaView.do?q_num=${DepositVO.q_num}&num=${vo.num}">${DepositVO.q_title}</a></td>
							<td class="wordCut"><a href="<%=request.getContextPath()%>/qna/qnaView.do?q_num=${DepositVO.q_num}&num=${vo.num}">${DepositVO.q_content}</a></td>
							<td>${DepositVO.q_regdate }</td>
							
							<c:if test="${DepositVO.a_regdate !=null && DepositVO.a_regdate != ' '}">
								<td style="color: blue;">답변완료</td>
							</c:if>
							<c:if test="${DepositVO.a_regdate ==null || DepositVO.a_regdate == ' '}">
								<td style="color: red;">미답변</td>
							</c:if>
							
							<td>${DepositVO.a_regdate }</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<!-- 페이징 start -->
			<div id="pageBtn">
				<ul class="pagination justify-content-center">
				
				<!-- 이전 페이지 start -->
					<c:if test="${vo.num == 1}">
						<li class="page-item disabled"><a class="page-link" href="#">＜</a></li>
					</c:if>
					<c:if test="${vo.num > 1}">
						<li class="page-item"><a class="page-link" href="<%=request.getContextPath()%>/mypage/mydeposit.do?num=${vo.num-1}">＜</a></li>
					</c:if>
				<!-- 이전 페이지 end -->
				
				<!-- 페이지 수 start -->
				<!--                                  1                    1       +       5-1         -->
					<c:forEach var="i" begin="${vo.startPage}" end="${vo.startPage + vo.pageNumCount-1}">
						<c:if test="${i<=vo.totalPage}">
							<c:choose>
								<c:when test="${ i == vo.num }">
									<li class="page-item active"><a class="page-link" href="<%=request.getContextPath()%>/mypage/mydeposit.do?num=${i}">${i}</a></li>
								</c:when>
								<c:otherwise>
									<li class="page-item"><a class="page-link" href="<%=request.getContextPath()%>/mypage/mydeposit.do?num=${i}">${i}</a></li>
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
						<li class="page-item"><a class="page-link" href="<%=request.getContextPath()%>/mypage/mydeposit.do?num=${vo.num+1}">＞</a></li>
					</c:if>
				<!-- 다음 페이지 end -->
				</ul>
			</div>
		<!-- 페이징 end -->		
	</div>
</div>
</body>
</html>
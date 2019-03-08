<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>공지사항</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js" integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k" crossorigin="anonymous"></script>

<!-- 커스텀 CSS -->
<link href="../css/common.css" rel="stylesheet"/>
<link href="../css/notice.css" rel="stylesheet"/>
<!-- 폰트 CSS -->
<link href="../fonts/fonts.css" rel="stylesheet">

<style>
	/* 긴 제목 처리하기 */
	.wordCut{white-space : nowrap; overflow: hidden; text-overflow:ellipsis}
</style>

</head>
<%@ include file="../index/store-header.jspf" %>
<body>
<section class="container">
	<div class="wrap">
		<div class="container">
		  <h2 id="noticeTitle">공지사항</h2> 
		  
		  <!-- 관리자로 로그인시 등록 버튼 보이고, 일반 유저로 로그인 시 등록 버튼 안 보이게하기. -->
		  <c:if test="${adminloginStatus == 'Y'}">
		  	<button type="button" class="btn btn-outline-dark btn-sm" id="noticeBtn">
		  		<a href="<%=request.getContextPath()%>/notice/noticeWriteForm.do">공지사항 등록</a>
		  	</button>  
		  </c:if>
		  <!-- 테이블 내용  start-->
		  <table class="table table-hover">
		    <thead>
		      <tr>
		        <th>no.</th>
		        <th>제목</th>
		        <th>등록일</th>
		      </tr>
		    </thead>
		    <c:forEach var="vo1" items="${list}">
		    	<tbody>
		      		<tr>
			        	<td>${vo1.n_num}</td>
			        	<td class="wordCut"><a href="<%=request.getContextPath()%>/notice/noticeView.do?n_num=${vo1.n_num}&num=${vo.num}">${vo1.n_title}</a></td>
			        	<td>${vo1.n_regdate}</td>
		      		</tr>
		    	</tbody>
		    </c:forEach>
		  </table>
		  <!-- 테이블 내용  end-->
		</div>
		<!-- 검색어 start -->
		<form class="form-inline" id="searchFrm" action="<%=request.getContextPath()%>/notice/notice.do">
			<div class="list-group-item list-group-item-action searchForm">
				<div id="searchDiv">
					<select name="searchKey" class="form-control">
						<option value="n_num">번호</option>
						<option value="n_title">제목</option>
						<option value="n_regdate">등록일</option>
					</select>
					<input type="text" name="searchWord" id="searchWord" class="form-control"/>
					<input type="submit" value="Search" class="form-control"/>
				</div>
			</div>
		</form>
		<!-- 검색어 end -->
		<!-- 페이징 start -->
		<div id="pageBtn">
			<ul class="pagination justify-content-center">
			
			<!-- 이전 페이지 start -->
				<c:if test="${vo.num == 1}">
					<li class="page-item disabled"><a class="page-link" href="#">＜</a></li>
				</c:if>
				<c:if test="${vo.num > 1}">
					<li class="page-item"><a class="page-link" href="<%=request.getContextPath()%>/notice/notice.do?num=${vo.num-1}&searchKey=${vo.searchKey}&searchWord=${vo.searchWord}">＜</a></li>
				</c:if>
			<!-- 이전 페이지 end -->
			
			<!-- 페이지 수 start -->
			<!--                                  1                    1       +       5-1         -->
				<c:forEach var="i" begin="${vo.startPage}" end="${vo.startPage + vo.pageNumCount-1}">
					<c:if test="${i<=vo.totalPage}">
						<c:choose>
							<c:when test="${ i == vo.num }">
								<li class="page-item active"><a class="page-link" href="<%=request.getContextPath()%>/notice/notice.do?num=${i}&searchKey=${vo.searchKey}&searchWord=${vo.searchWord}">${i}</a></li>
							</c:when>
							<c:otherwise>
								<li class="page-item"><a class="page-link" href="<%=request.getContextPath()%>/notice/notice.do?num=${i}&searchKey=${vo.searchKey}&searchWord=${vo.searchWord}">${i}</a></li>
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
					<li class="page-item"><a class="page-link" href="<%=request.getContextPath()%>/notice/notice.do?num=${vo.num+1}&searchKey=${vo.searchKey}&searchWord=${vo.searchWord}">＞</a></li>
				</c:if>
			<!-- 다음 페이지 end -->
			</ul>
		</div>
		<!-- 페이징 end -->		
	</div>
</section>
</body>
</html>
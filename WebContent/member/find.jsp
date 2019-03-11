<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그인</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js" integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k" crossorigin="anonymous"></script>
<!-- footer css -->
<!-- 커스텀 CSS -->
<link href="../css/Footer.css" rel="stylesheet" media="screen">
<!-- 폰트 CSS -->
<link href="../fonts/fonts.css" rel="stylesheet">
<!-- 커스텀 CSS -->
<link href="../css/Join.css" rel="stylesheet" media="screen">
<!-- 폰트 CSS -->
<link href="../fonts/fonts.css" rel="stylesheet">
<!-- 커스텀 CSS -->
<link href="../css/login.css" rel="stylesheet" media="screen">
<!-- 폰트 CSS -->
<link href="../fonts/fonts.css" rel="stylesheet">
<style>
#chDiv{margin-top:50px}
	#chDiv>a{float:left}
	.chBtn{font-size:1.5em;color:pink}
</style>
</head>
<body>
	<section class="container">
		<div class="wrap">
			<div class="loginLogo">
				<h1 class="font-coiny"><a href="<%=request.getContextPath()%>/index.do">WA BANG</a></h1>
				<p class="font-noto-login">홈>아이디/비밀번호찾기</p>
				<hr/>
			</div>
			<div id="accordion">
			<!-- 아이디찾기  -->
				<div class="card">
					<div class="card-header"><a href="#acc1" data-toggle="collapse" data-parent="#accordion" class="font-noto-login-T">아이디 찾기</a></div>
					<div id="acc1" class="collapse show" style="text-align:center">
						<!-- 이메일 -->
						<form class="form-inline" id="searchId" action="<%=request.getContextPath()%>/member/findId.do">
							<div class="searchForm" style="margin:30px auto 30px;text-align:center">
								이메일
								<input type="text" name="email1" id="email1" class="form-control" style="width:200px;"/>				
								<!-- 확인 btn -->
								<input type="submit" value="확인" class="form-control" />
							</div>
						</form>
						 검색한 아이디: ${id}
					</div>
				</div>
			</div>
			<!--  -->
			<div class="card">
				<div class="card-header"><a href="#acc2" data-toggle="collapse" data-parent="#accordion" class="font-noto-login-T">비밀번호 찾기</a></div>
				<div id="acc2" class="collapse show" style="text-align:center">
					<form class="form-inline" id="searchPwd" action="<%=request.getContextPath()%>/member/findPwd.do">
						<div class="searchForm" style="margin:30px auto 30px;text-align:center">
							아이디
							<input type="text" id="userid" name="userid" class="form-control" style="width:200px;margin-bottom:10px"/><br/>
							이메일
							<input type="text" name="email2" id="email2" class="form-control"/><br/>			
							<!-- 확인 btn -->
							<input type="submit" value="확인" class="form-control" style="width:252px;margin-top:10px"/>
						</div>
					</form>
					검색한 비밀번호: ${pwd}		
				</div>
				</div>
		</div>		
	</section>
</body>
</html>
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

<script>
	$(function(){
		/* 아이디를 입력하지 않았을때 */
		$("#loginBtn").on("click",function(){
			var userid = $("#userid").val(); //text값 변수에 저장
			if(userid == ""){
				$("#warning").text("아이디 또는 비밀번호를 입력해주세요.");
			}else{
				return true;
			}
			return false;
		});
		/* 아이디 입력시 경고글 없어지게 하는 부분 */
		$("#userid").on("keydown",function(){
			$("#warning").text("");
		});
		
		/* 비밀번호 입력하지 않았을때 */
		$("#loginBtn").on("click",function(){
			var userpwd = $("#userpwd").val();
			if(userpwd == ""){
				$("#warning").text("아이디 또는 비밀번호를 입력해주세요.");
			}else{
				return true;
			}
			return false;
		});
		/* 비밀번호 입력시 경고글 없어지게 하는 부분 */
		$("#userpwd").on("keydown",function(){
			//$("#warningpwd").text("");
			$("#warning").text("");
		});
	});
</script>

<!-- 커스텀 CSS -->
<link href="../css/login.css" rel="stylesheet" media="screen">
<!-- 폰트 CSS -->
<link href="../fonts/fonts.css" rel="stylesheet">
</head>
<body>
	<section class="container">
		<div class="wrap">
			<div class="loginLogo">
				<h1 class="font-coiny"><a href="<%=request.getContextPath()%>/index.do">WA BANG</a></h1>
				<p class="font-noto-login">홈>로그인</p>
				<hr/>
			</div>
			
			<div class="formDiv">
				<form method="post" action="<%=request.getContextPath()%>/member/loginOk.do" name="frm1" id="frm1">
					<div class="form-group" id="useridDiv">
						<label for="userid" class="font-noto-login-T">아이디</label><br/>
						<input type="text" id="userid" name="userid" placeholder="아이디를 입력해주세요." 
							   class="form-control"/>
						<label></label>
					</div>
					<div class="form-group">
						<label for="userpwd" class="font-noto-login-T">비밀번호</label><br/>
						<input type="password" id="userpwd" name="userpwd" placeholder="비밀번호를 입력해주세요." 
						       class="form-control"/>
						<label></label>
					</div>
					<label id="warning"><!-- 경고글 --></label>
					<input type="submit" value="로그인" id="loginBtn" class="font-noto-login-T form-control btn"/>
				</form>
				
				<div class="join">
					<a href="<%=request.getContextPath()%>/member/join.do" class="font-noto-login-T">회원가입</a> &nbsp;&nbsp;
					<a href="#" class="font-noto-login-T">아이디/비밀번호찾기</a>
				</div>
				<hr/>
			</div>
		</div>
	</section>
</body>
</html>
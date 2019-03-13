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

<!-- 폰트 CSS -->
<link href="../fonts/fonts.css" rel="stylesheet">
<!-- 커스텀 CSS -->
<link href="../css/login.css" rel="stylesheet" media="screen">
<link href="../css/find.css" rel="stylesheet" media="screen">

<script>
	$(function(){
		$("#useridBtn").on("click",function(){
			//이메일 
			var emailVal = $("#email1").val();	
			var emailcheck = /^(\w+\.)*\w+@(\w+\.)+[A-Za-z]+$/;
			//var emailcheck = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
			
			if(emailVal.match(emailcheck) == null){
		    	$("#warningid").text("이메일 형식이 옳바르지 않습니다 :)");
		    	return false;
		    }    
		});
		
		$("#passwordBtn").on("click",function(){
			
			//아이디
			// text박스에 아무것도 입력 안할때.
			var userid = $("#userid").val(); //text값 변수에 저장
			if(userid == ""){
				$("#warningpwd1").text("아이디를 입력해주세요. :)");
				return false;
			}
			//아이디 8~12글자 까지 입력가능
			if(userid.length<8 || userid.length>12){
				$("#warningpwd1").text("아이디를 다시 입력해주세요 :)");
			}else if(userid.length>=8 && userid.length<=12){
				$("#warningpwd1").text("");
			}
			//아이디는 숫자,소문자만 입력가능
			var num=0; alpha=0;
			for(i=0; i<userid.length; i++){
				var cha = userid.substr(i,1);
				//소문자-검사
				if(cha>='a' && cha<='z'){
					alpha++;
				}
				//숫자-검사
				if(cha>='0' && cha<='9'){
					num++;
				}
			}
			if(alpha<=0 || num<=0){
				$("#warningpwd1").text("아이디를 다시 입력해주세요 :)");
			}
			
			//이메일 
			var emailVal = $("#email2").val();	
			var emailcheck = /^(\w+\.)*\w+@(\w+\.)+[A-Za-z]+$/;
			
			if(emailVal.match(emailcheck) == null){
		    	$("#warningpwd2").text("이메일 형식이 옳바르지 않습니다 :)");
		    	return false;
		    }   
		});
		
		//아이디 입력시 경고글 없어지게
		$("#userid").on("keydown",function(){
			$("#warningpwd1").text("");
		});
		
		//이메일 입력시 경고글 없어지게
	    $("#email1").on("keydown",function(){
			$("#warningid").text("");
		});
	    $("#email2").on("keydown",function(){
			$("#warningpwd2").text("");
		});
	});
</script>
	
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
			<!-- 아이디 찾기  -->
				<div class="card">
					<div class="card-header">
						<a href="#acc1" data-toggle="collapse" data-parent="#accordion" class="font-noto-login-T">아이디 찾기</a>
					</div>
					<div id="acc1" class="collapse show">
						<!-- 이메일 -->
						<form class="form-horizontal" id="searchId" action="<%=request.getContextPath()%>/member/findId.do">
							<div class=" form-group row">
								<label class="font-noto-login-T col-sm-2">이메일</label>
								<input type="text" name="email1" id="email1" class="form-control col-sm-3"/>
								<label id="warningid"><!-- 경고글 --></label><br/>				
							</div>
							<div class=" form-group row">
								<input type="submit" value="확인" class="form-control" id="useridBtn"/>
							</div>
						</form>
						
						 <c:if test="${ (id != null) && (id !='') }"> 
							<label class="font-noto-login-T searchColor">검색한 아이디: ${id}</label>
						 </c:if> 
					</div>
				</div>
			</div>
			<!-- 비밀번호 찾기 -->
			<div class="card">
				<div class="card-header">
					<a href="#acc2" data-toggle="collapse" data-parent="#accordion" class="font-noto-login-T">비밀번호 찾기</a>
				</div>
				<div id="acc2" class="collapse show">
					<form class="form-horizontal" id="searchPwd" action="<%=request.getContextPath()%>/member/findPwd.do">
						<div class="form-group row">
							<label class="font-noto-login-T col-sm-2">아이디</label>
							<input type="text" id="userid" name="userid" class="form-control col-sm-3"/><br/>
							<label id="warningpwd1"><!-- 경고글 --></label><br/>
						</div>
						<div class="form-group row">
							<label class="font-noto-login-T col-sm-2">이메일</label>
							<input type="text" name="email2" id="email2" class="form-control col-sm-3"/><br/>
							<label id="warningpwd2"><!-- 경고글 --></label><br/>			
						</div>
						<div>
							<input type="submit" value="확인" class="form-control" id="passwordBtn"/>
						</div>
					</form>
					<c:if test="${ (pwd != null) && (pwd !='') }"> 
						<label class="font-noto-login-T searchColor">검색한 비밀번호: ${pwd}</label>	
					</c:if> 
				</div>
			</div>
		</div>		
	</section>
</body>
</html>
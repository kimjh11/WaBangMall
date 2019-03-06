<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>아이디 중복 검사</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js" integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k" crossorigin="anonymous"></script>

<!-- 커스텀 CSS -->
<link href="../css/idChk.css" rel="stylesheet" media="screen">
<!-- 폰트 CSS -->
<link href="../fonts/fonts.css" rel="stylesheet">

<script>
	$(function(){
		$("#setID").on("click",function(){
			//회원가입 폼에 아이디 뿌려줌
			opener.document.getElementById("userid").value = $("#blueTxt").text();
			opener.document.getElementById("loginStatus").value= "Y";
			//현재 창 닫기
			window.close();
		});
		
		$("#idChk").on("click",function(){
			//
			var userid = $("#userid").val(); //text값 변수에 저장
			//아이디 8~12글자 까지 입력가능
			if(userid.length<8 || userid.length>12){
				$("#warningid").text("아이디는 8~12 글자 사이로 입력해주세요.");
				return false;
			}else if(userid.length>=8 && userid.length<=12){
				$("#warningid").text("");
			}
			return true;
		});
	});
</script>
</head>
<body>
	<div class="container">
		<form method="post" action="<%=request.getContextPath()%>/member/idChk.do">
			<label class="col-sm-2 font-noto-join-T" >아이디</label> 
			<input type="text" name="userid" id="userid" value="${userid}" class="form-control col-sm-5"/>
			<input type="submit" value="중복검사" id="idChk" class="form-control btn font-noto-join-T"/>
			<label id="warningid" class="font-noto-join-T"><!-- 경고글 --></label>
		</form>
		<hr/>
		
		<!-- 사용 불가능 아이디 -->
		<c:if test="${cnt>0}">
			<span id="redTxt" class="font-noto-join-T">${userid}</span>는 사용 불가능 합니다.
		</c:if>
	
		<!-- 사용 가능한 아이디 -->
		<c:if test="${cnt<=0}">
			<span id="blueTxt" class="font-noto-join-T">${userid}</span>는 사용가능 합니다.
			<input type="button" value="확인" id="setID" class="form-control btn font-noto-join-T"/>
		</c:if>
	</div>
</body>
</html>
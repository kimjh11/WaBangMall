<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원가입</title>
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

<script>
	$(function(){
		$("#joinBtn").on("click",function(){
			//아이디
			// text박스에 아무것도 입력 안할때.
			var userid = $("#userid").val(); //text값 변수에 저장
			if(userid == ""){
				$("#warningid").text("아이디를 입력해주세요. :)");
				return false;
			}
			//아이디 8~12글자 까지 입력가능
			if(userid.length<8 || userid.length>12){
				$("#warningid").text("아이디는 8~12 글자 사이로 입력해주세요.");
			}else if(userid.length>=8 && userid.length<=12){
				$("#warningid").text("");
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
				$("#warningid").text("아이디는 영문소문자 또는 숫자 8~12자로 입력해주세요.");
			}
			
			//비밀번호
		    var userpwd1 = $("#userpwd1").val();
		    var userpwd2 = $("#userpwd2").val();
		    if(userpwd1 == "" ){
		    	$("#warningpwd").text("비밀번호를 입력해주세요. :)");
		    	return false;
		    }
		    //비밀번호 영대소문자,숫자,특수문자 포함 8~16자
		    var chkpwd = /^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{8,12}$/;
		    if(!chkpwd.test(userpwd1)){
		    	$("#warningpwd").text("비밀번호는 (영어대소문자,숫자,특수문자의 조합),8~12자");
		    }
		    //비밀번호 확인하기
		    if(userpwd2 ==""){
		    	$("#warningpwd").text("비밀번호 확인을 입력해주세요. :)");
		    }else if(userpwd1 != userpwd2){
		    	$("#warningpwd").text("비밀번호가 일치하지 않습니다.");	
		    }
		    
		    //이름
		    var username = $("#username").val();
		    if(username =="" ){
		    	$("#warningusername").text("이름을 입력해주세요. :)");
		    	return false;
		    }
		    
		    //주소
		  	var postcode = $("#postcode").val();
		    var address = $("#address").val();
		    var detailAddress = $("#detailAddress").val();
		    var extraAddress = $("#extraAddress").val();
		    if(postcode == "" || address == "" || detailAddress == "" || extraAddress == ""){
		    	$("#warningaddr").text("주소를 입력해주세요. :)");
		    	return false;
		    }
		    
		    //휴대전화
		    var tel1 = $("#tel1").val();
		    var tel2 = $("#tel2").val();
		    var tel3 = $("#tel3").val();
		    if(tel1 == "" || tel2 == "" || tel3 == ""){
		    	$("#warningtel").text("전화번호를 입력해주세요. :)");
		    	return false;
		    }
		    //휴대전화 4자리-4자리 정규식
		    var firstTel = /^[0-9]{4}$/;
		    var lastTel = /^[0-9]{4}$/;
		    if(!firstTel.test(tel2) || !lastTel.test(tel3)){
		    	$("#warningtel").text("휴대전화 형식이 옳바르지 않습니다.");
		    	return false;
		    }
		    
		    //이메일
		    var email1 = $("#email1").val();
		    var email2 = $("#email2").val();
		    if(email1 == "" || email2 == ""){
		    	$("#warningemail").text("이메일을 입력해주세요. :)");
		    	return false;
		    }
		    //직접입력시 정규식
		    var lastemail = /^[a-zA-z0-9]{2,10}[.][a-z]{2,3}([.][a-z]{2,3})?$/;
		    if(!lastemail.test(email2)){
		    	$("#warningemail").text("이메일 형식이 옳바르지 않습니다.");
		    	return false;
		    } 
		});
		
		//아이디 중복 검사
		$("#idchk").on("click",function(){
			var userid = $("#userid").val(); //text값 변수에 저장
			//아이디 8~12글자 까지 입력가능
			if(userid.length<8 || userid.length>12){
				$("#warningid").text("아이디는 8~12 글자 사이로 입력해주세요.");
			}else if(userid.length>=8 && userid.length<=12){
				window.open("<%=request.getContextPath()%>/member/idChk.do?userid="+$("#userid").val(),"idChk","width=400px, height=250px");
				$("#warningid").text("");
			}
		});
		//아이디 중복 검사 확인 여부
		$("#frm").submit(function(){
			//
			if($("#loginStatus").val()=="N"){
				alert("중복검사를 해주세요.");
				return false;
			}
			return true;
		});
		
		
		//이메일 리스트(naver.com,daum.net...) 클릭시 입력하기 
	    $("#select-email").on("change",function(){
	    	var email2 = $(this).val(); //option값 저장
	    	$("#email2").val(email2);
	    	
	    	if(email2 == "etc"){
	    		$("#email2").val("");
	    		$("#email2").prop("disabled",false);
	    	}else if(email2 == "0"){
	    		$("#email2").val("");
	    		$("#email2").prop("disabled",true);
	    	}else if(email2 != "etc"){
	    		$("#email2").prop("disabled",true);
	    	}
	    });
		
		//아이디 입력시 경고글 없어지게 하는 부분
		$("#userid").on("keydown",function(){
			$("#warningid").text("");
		});
		//비밀번호 입력시 경고글 없어지게 하는 부분
		$("#userpwd1").on("keydown",function(){
			$("#warningpwd").text("");
		});
		$("#userpwd2").on("keydown",function(){
			$("#warningpwd").text("");
		});
		//이름 입력시 경고글 없어지게 하는 부분
		$("#username").on("keydown",function(){
			$("#warningusername").text("");
		});
		//주소 입력시 경고글 없어지게 하는 부분
		$("#postcode").on("keydown",function(){
			$("#warningaddr").text("");
		});
		$("#address").on("keydown",function(){
			$("#warningaddr").text("");
		});
		$("#detailAddress").on("keydown",function(){
			$("#warningaddr").text("");
		});
		$("#extraAddress").on("keydown",function(){
			$("#warningaddr").text("");
		});
		//휴대전화 입력시 경고글 없어지게 하는 부분
		$("#tel1").on("keydown",function(){
			$("#warningtel").text("");
		});
		$("#tel2").on("keydown",function(){
			$("#warningtel").text("");
		});
		$("#tel3").on("keydown",function(){
			$("#warningtel").text("");
		});
		//이메일 입력시 경고글 없어지게 하는 부분
		$("#email1").on("keydown",function(){
			$("#warningemail").text("");
		});
		$("#email2").on("keydown",function(){
			$("#warningemail").text("");
		});
	});
	
	/*전화번호 숫자만 입력*/
	function setOnlyNum(){
		var inCode = window.event.keyCode;
		if(inCode>=48 && inCode<=57 || inCode==8 || inCode==9){
			window.event.returnValue=true;
			return;
		}
		window.event.returnValue=false;
	}
</script>

</head>
<body>
	<section class="container">
		<div class="wrap">
			<div class="joinLogo">
				<h1 class="font-coiny"><a href="<%=request.getContextPath()%>/index.do">WA BANG</a></h1>
				<p class="font-noto-join">홈>회원가입</p>
				<hr/>
			</div>
			
			<div class="formDiv">
				<form method="post" action="<%=request.getContextPath()%>/member/joinOk.do" name="frm" id="frm" class="form-horizontal">
					<!-- 아이디/ 비밀번호 -->
					<div class="form-group row">
						<label class="col-sm-2 font-noto-join-T">아이디<span id="star">＊</span></label>
						<input type="text" id="userid" name="userid" class="form-control  col-sm-5"/>
						<input type="button" value="아이디 중복 검사" id="idchk" class="btn font-noto-join-T"/>
						<label id="warningid"><!-- 경고글 --></label>
						
						<!-- 아이디 중복검사 결과에 필요 -->
						<input type="hidden" name="loginStatus" id="loginStatus" value="N">
					</div>
					<div class="form-group row">
						<label class="col-sm-2 font-noto-join-T">비밀번호<span id="star">＊</span></label>
						<input type="password" id="userpwd1" name="userpwd1" class="form-control  col-sm-5"/>
						<label id="telInfo" class="col-sm-10 font-noto-join-T">(8~12자이상 영문 대 소문자, 숫자, 특수문자를 사용하세요.)</label>
					</div>
					<div class="form-group row">
						<label class="col-sm-2 font-noto-join-T">비밀번호 확인<span id="star">＊</span></label>
						<input type="password" id="userpwd2" name="userpwd2" class="form-control  col-sm-5"/>
						<label id="warningpwd"><!-- 경고글 --></label>
					</div>		
					
					<hr/>
					<!-- 이름 -->
					<div class="form-group row">
						<label class="col-sm-2 font-noto-join-T">이름<span id="star">＊</span></label>
						<input type="text" id="username" name="username" class="form-control col-sm-5">	
						<label id="warningusername"><!-- 경고글 --></label>
					</div>
										
					<!-- 우편번호 -->
					<div class="form-group row">
						<label class="col-sm-2 font-noto-join-T">주소<span id="star">＊</span></label>
						<input type="text" id="postcode" name="postcode" placeholder="우편번호" class="form-control col-sm-3 font-noto-join-T">
						<input type="button" onclick="execDaumPostcode()" class="btn font-noto-join-T"  id="codeBtn" value="우편번호">
					</div>
					<div class="form-group row">
						<label class="col-sm-2"></label>
						<input type="text" id="address" name="address" placeholder="주소" class="form-control col-sm-5 font-noto-join-T">
					</div>
					<div class="form-group row">
						<label class="col-sm-2"></label>
						<input type="text" id="detailAddress" name="detailAddress" placeholder="상세주소" class="form-control col-sm-5 font-noto-join-T">
					</div>
					<div class="form-group row">
						<label class="col-sm-2"></label>
						<input type="text" id="extraAddress" name="extraAddress" placeholder="참고항목" class="form-control col-sm-5 font-noto-join-T">
					</div>
					<div class="form-group row">
						<label class="col-sm-5" id="warningaddr"><!-- 경고글 --></label>
					</div> 
					<!-- ==========================다음 API 연동 start ============================= -->
					<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
					<script>
					    function execDaumPostcode() {
					        new daum.Postcode({
					            oncomplete: function(data) {
					                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.
					
					                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
					                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
					                var addr = ''; // 주소 변수
					                var extraAddr = ''; // 참고항목 변수
					
					                //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
					                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
					                    addr = data.roadAddress;
					                } else { // 사용자가 지번 주소를 선택했을 경우(J)
					                    addr = data.jibunAddress;
					                }
					
					                // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
					                if(data.userSelectedType === 'R'){
					                    // 법정동명이 있을 경우 추가한다. (법정리는 제외)
					                    // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
					                    if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
					                        extraAddr += data.bname;
					                    }
					                    // 건물명이 있고, 공동주택일 경우 추가한다.
					                    if(data.buildingName !== '' && data.apartment === 'Y'){
					                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
					                    }
					                    // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
					                    if(extraAddr !== ''){
					                        extraAddr = ' (' + extraAddr + ')';
					                    }
					                    // 조합된 참고항목을 해당 필드에 넣는다.
					                    document.getElementById("extraAddress").value = extraAddr;
					                
					                } else {
					                    document.getElementById("extraAddress").value = '';
					                }
					
					                // 우편번호와 주소 정보를 해당 필드에 넣는다.
					                document.getElementById('postcode').value = data.zonecode;
					                document.getElementById("address").value = addr;
					                // 커서를 상세주소 필드로 이동한다.
					                document.getElementById("detailAddress").focus();
					            }
					        }).open();
					    }
					</script>
					<!-- ==========================다음 API 연동 end ============================= -->				
					<!-- 휴대전화 -->	
					<div class="form-group row">
						<label class="col-sm-2 font-noto-join-T">휴대전화<span id="star">＊</span></label>
						<select name=tel1 id="tel1" class="form-control col-sm-2 font-noto-join-T">
							<script>
								var phoneNum=["010","011","016","017","018","019"]
								for(i=0; i<phoneNum.length; i++){
									document.write("<option value='"+phoneNum[i]+"'>"+phoneNum[i]+"</option>");	
								}
							</script>
						</select>
						&nbsp;-&nbsp; <input type="text" name="tel2" id="tel2" maxlength="4" size="4" onKeyDown ="setOnlyNum()" class="form-control col-sm-2"/>
						&nbsp;-&nbsp; <input type="text" name="tel3" id="tel3" maxlength="4" size="4" onKeyDown ="setOnlyNum()" class="form-control col-sm-2"/>
					</div>
					<div class="form-group row">
						<label class="col-sm-5" id="warningtel"><!-- 경고글 --></label>
					</div>
					<!-- 이메일 -->
					<div id="emailDiv" class="form-group row">
						<label class="col-sm-2 font-noto-join-T">이메일<span id="star">＊</span></label>
						<input type="text" name="email1" id="email1" class="form-control col-sm-3"/>&nbsp;@&nbsp;
						<input type="text" name="email2" id="email2" class="form-control col-sm-3" disabled/>
						<select name="email2" id="select-email" class="form-control col-sm-3 font-noto-join-T">
							<option value="0">선택하세요.</option>
							<option value="naver.com">naver.com</option>
							<option value="daum.net">daum.net</option>
							<option value="nate.com">nate.com</option>
							<option value="gmail.com">gmail.com</option>
							<option value="yahoo.com">yahoo.com</option>
							<option value="etc">직접입력</option>
						</select>
					</div>
					<div class="form-group row">
						<label class="col-sm-5" id="warningemail"><!-- 경고글 --></label>
					</div>
					
					<input type="submit" value="회원가입" id="joinBtn" class="form-control btn font-noto-join-T"/>
				</form>
			</div>
		</div>
	</section>
</body>
</html>
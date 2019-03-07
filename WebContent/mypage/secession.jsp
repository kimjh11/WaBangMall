<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원탈퇴</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!-- 커스텀 CSS -->
<link href="../css/secession.css" rel="stylesheet" media="screen">
<link rel="stylesheet" href="../css/common.css"/>
<!-- 폰트 CSS -->
<link href="../fonts/fonts.css" rel="stylesheet">

<style>
	.content{margin:0 auto;width:1200px}
	.content>h2{font-size:2em}
	#secessionDiv{margin-top:30px;}
	h2{margin-top:30px}
</style>

</head>
<body>
	<%@ include file="../index/store-header.jspf" %>
	<div class="content">
	<%@include file="menu.jspf"%>
	<h2>회원탈퇴</h2>
	<div id="secessionDiv">
				<label><h5>저희 WaBang 사이트를 이용해 주셔서 감사합니다.</h5></label>
			
				<!-- 버튼 --> 
    			<button class="trigger" id="deleteBtn">회원 탈퇴하기</button> 
				
				<!-- 팝업 될 레이어 --> 
			    <div class="modal"> 
			         <div class="modal-content"> 
			             <span class="close-button">&times;</span> 
			             <h1 class="title">회원탈퇴</h1> 
			             <form method="POST" action="<%=request.getContextPath()%>/mypage/secessionOk.do"> 
			               <label>비밀번호</label> 
			               <input type="password" name="userpwd" placeholder="비밀번호를 입력해 주세요." required="required"> 
			               <label></label>
			                <input type="submit" id="submit" value="확인">  
			               <input type="button" id="cancel" value="취소"> 
			             </form> 
			         </div> 
			     </div>
			     
			     <script type="text/javascript"> 
					var modal = document.querySelector(".modal"); 
				    var trigger = document.querySelector(".trigger"); 
				    var closeButton = document.querySelector(".close-button"); 
				    var cancelButton = document.querySelector("#cancel");
				
				    function toggleModal() { 
				    	 modal.classList.toggle("show-modal"); 
				    }
				
				   	function windowOnClick(event) { 
				       	if (event.target === modal) { 
				         	toggleModal(); 
				        } 
				   	}
				
				    trigger.addEventListener("click", toggleModal); 
				    closeButton.addEventListener("click", toggleModal); 
				    cancel.addEventListener("click", toggleModal); 
				    window.addEventListener("click", windowOnClick); 
				</script>     
			</div>
		</div>
</body>
</html>
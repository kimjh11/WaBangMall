<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces = "true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1"/>
<title>상품 리스트</title>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/common.css"/>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/index.css"/>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.7.7/angular.min.js"></script>
<style>
	#back{height:900px}
	#cate span{font-size: 2.8em;margin:20px 0 20px 20px;display: inline-block;font-weight: bold;}
	#mid{font-size:2.5em}
	select, option{font-size:1.2em}
	 .img{width:100%;heght:250px;margin-top:20px;border-radius:30px}
	.Pack{height:310px; width: 20%; margin-top:35px;text-align:center;float:left;margin-left: 4%;border-radius:30px;font-size:1.5em;}
	.Pack:nth-child(4n+1){margin-left:0;}
	.Pack a{display:inline-block;}
	.thum{overflow:hidden;height:235px; border-radius:30px; margin-bottom:6px;}
	.itemName{font-size:1.1em; font-weight:bold;}
	.itemdate{fomt-size:1em; text-lign:center;margin:0 auto}
	.box .price{padding:10px 10px 0 10px; position:relative;}
	.itemPrice, .discount{font-size:1em;}
	.itemPrice{color:rgb(87, 150, 246);position:absolute;font-size:17pt;font-weight: bold;}
	.disprice{font-weight: bold;line-height:30px; font-size: 15pt;text-align: right;}
	.discount{text-decoration: line-through;position: absolute; top: 0;right:12px; font-size:10pt}
	select , .off{display:none}
	#start, .on, .on1 {display:inline}
	#category{text-align:right;margin-right:100px}
	#category select{height: 30px;width: 15%;font-size: 10pt;font-family: 'Noto Sans KR';padding-left: 5px;}
	#category select#start{margin-right:10px;}

</style>
<script src="<%=request.getContextPath() %>/js/index.js"></script>	
<script src="index.js"></script>
<script>
	var mid;
	function select(){
		 for(i=1;i<=4;i++){
			 if($("#start option:selected").attr("id")=="big"+i){
				 $(".on").removeClass("on");
				 $("#mid"+i).addClass("on");
				 $("#big").html($("#start option:selected").val());
				 $("#mid").html("");
			 }
		 }$(".Pack").filter(function(){
			 if($(this).find("input").val().indexOf($("#start option:selected").val()) > -1){
				 $(this).addClass("on");
				 $(this).removeClass("off");
			 } else{
				 $(this).addClass("off");
				 $(this).removeClass("on");
				 
			 } 
		 })
	}
	//중간카테고리를 선택할때 소카테고리가 변경되는것 ------------------
	function select1(){
		 $(".Pack").filter(function(){
				 $("#mid").html($("#mid1").val());
			 if($(this).find("input").val().indexOf($("#mid1 option:selected").val()) > -1){
				 $(this).addClass("on");
				 $(this).removeClass("off");
			 } else{
				 $(this).addClass("off");
				 $(this).removeClass("on");
				 
			 }
		 })
	}
	function select2(){
		$(".Pack").filter(function(){
				 $("#mid").html($("#mid2").val());
			 if($(this).find("input").val().indexOf($("#mid2 option:selected").val()) > -1){
				 $(this).addClass("on");
				 $(this).removeClass("off");
			 } else{
				 $(this).addClass("off");
				 $(this).removeClass("on");
				 
			 } 
		 })
	}
	function select3(){
		$(".Pack").filter(function(){
				 $("#mid").html($("#mid3").val());
			 if($(this).find("input").val().indexOf($("#mid3 option:selected").val()) > -1){
				 $(this).addClass("on");
				 $(this).removeClass("off");
			 } else{
				 $(this).addClass("off");
				 $(this).removeClass("on");
				 
			 } 
		 })
	}
	function select4(){
		 $(".Pack").filter(function(){
				 $("#mid").html($("#mid4").val());
			 if($(this).find("input").val().indexOf($("#mid4 option:selected").val()) > -1){
				 $(this).addClass("on");
				 $(this).removeClass("off");
			 } else{
				 $(this).addClass("off");
				 $(this).removeClass("on");
				 
			 } 
		 })
	}
	$(function(){
		var category ="<%=request.getParameter("category")%>";
		 $(".Pack").filter(function(){
				 $("#big").html(category);
			 if($(this).find("input").val().indexOf(category)>-1){
				 $(this).addClass("on");
				 $(this).removeClass("off");
			 } else{
				 $(this).addClass("off");
				 $(this).removeClass("on");
				 
			 } 
		 })
	})
</script>
</head>
<body>
<div>
<!-- Header -->
 <%@ include file="../index/store-header.jspf" %> 
<div id="back"> <!-- 전체를 담을 박스 -->
<div id="cate" class="width-auto">
	<span id="big">전체 </span><span id="mid"></span>
	<div id="category" class="width-auto"> <!-- selectBox --></div>
</div>
	<div class="width-auto"> <!-- 상품 하나하나를 담을 곳 -->
		<c:forEach var="item" items="${list}" varStatus="status">
			<div class="Pack"> <!-- 상품하나 -->
				<a href="${ctx}item/detailView.do?code=${item.code}">
				<div class="thum">
					<img src="http://172.16.1.14:9090/WaBangAdmin/item/itemImg/${item.thumbnail}" style="display: inline-block;width: 100%;margin-left: 0px;margin-top: 0px;height: 250px;"/>
				</div>
				<div class="box">
					<label class="itemName">${item.name}</label><br/>
					<div class="price">
						<div class="itemPrice">${item.discount}% </div>
						<div class="discount">${item.price}원</div>
						<div class="disprice">${item.disprice}원</div>
					</div>
					<input type="hidden" id="category" name="category" class="category" value="${item.category}"/>
				</div>
				</a>
			</div>
		</c:forEach>
	</div>
</div>
<!-- Footer -->
 <%@include file="../index/store-footer.jspf" %> 
</body>
</html>
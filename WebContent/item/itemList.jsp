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
<script src="<%=request.getContextPath() %>/js/common.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.7.7/angular.min.js"></script>
<style>
	#back{height:900px}
	#big{font-size:3em}
	#mid{font-size:2.5em}
	select, option{font-size:1.2em}
	 .img{width:100%;heght:250px;margin-top:20px;border-radius:30px}
	.Pack{height:310px ;width:330px;margin-top:35px;text-align:center;float:left;margin-left:6%; border-radius:30px;
			font-size:1.5em}
	.thum{overflow:hidden;height:235px; border-radius:30px}
	.itemName{font-size:1.5em;}
	.itemdate{fomt-size:1em; text-lign:center;margin:0 auto}
	.itemPrice, .discount{font-size:1em; width:30%;margin:0 auto;float:left}
	.itemPrice{color:rgb(87, 150, 246);margin-left:15%}
	.disprice{width:33%;font-weight: bold; margin:0 auto}
	.discount{text-decoration: line-through;}
	select , .off{display:none}
	#start, .on, .on1 {display:inline}
	#cate{margin-left:100px}
	#category{text-align:right;margin-right:100px}

</style>
<script src="<%=request.getContextPath() %>/js/index.js"></script>
<script src="<%=request.getContextPath() %>/js/common.js"></script>	
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
				 $("#mid").html("-"+$("#mid1").val());
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
				 $("#mid").html("-"+$("#mid2").val());
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
				 $("#mid").html("-"+$("#mid3").val());
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
				 $("#mid").html("-"+$("#mid4").val());
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
<div id="cate">
	<span id="big">전체 </span><span id="mid"></span>
	<div id="category"> <!-- selectBox --></div>
</div>
	<div> <!-- 상품 하나하나를 담을 곳 -->
		<c:forEach var="item" items="${list}" varStatus="status">
			<div class="Pack"> <!-- 상품하나 -->
				<a href="${ctx}item/detailView.do?code=${item.code}">
				<div class="thum">
					<img src="http://localhost:9090/WaBangAdmin/item/itemImg/${item.thumbnail}" style="display: inline-block;width: 100%;margin-left: 0px;margin-top: 0px;height: 250px;"/>
				</div>
				<div class="box">
					<label class="itemName">${item.name}</label><br/>
					<div class="price">
						<div class="itemPrice">${item.discount}% </div>
						<div class="discount">${item.price}원</div><br/>
						<div class="disprice">${item.disprice}원</div><br/>
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
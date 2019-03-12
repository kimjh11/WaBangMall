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
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.7.7/angular.min.js"></script>
<script src="<%=request.getContextPath() %>/js/common.js"></script>	
<style>
	#back{height:800px}
	 img{width:250px;heght:300px;margin-top:20px}
	.Pack{border:1px solid; height:310px ;width:350px;margin-top:35px;text-align:center;float:left;margin-left:6.5%}
	.thum{overflow:hidden;height:235px}
	.itemName{font-size:2em}
	.itemPrice, .itemDate{font-size:1em; text-lign:center;margin:0 auto}
	.discount{text-decoration: line-through;}
	select , .off{display:none}
	#start, .on, .on1 {display:inline}
	#cate{text-align:right;margin-right:100px}
</style>
<script src="index.js"></script>
<script>
	var mid;
	function select(){
		 for(i=1;i<=4;i++){
			 if($("#start option:selected").attr("id")=="big"+i){
				 $(".on").removeClass("on");
				 $("#mid"+i).addClass("on");
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
		 /* for(i=1;i<=21;i++){
			 if($("#mid1 option:selected").attr("id")=="midselect"+i){
				 $(".on1").removeClass("on1");
				 $("#small"+i).addClass("on1");
				 }
		 } */$(".Pack").filter(function(){
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
		/*  for(i=1;i<=21;i++){
			 if($("#mid2 option:selected").attr("id")=="midselect"+i){
				 $(".on1").removeClass("on1");
				 $("#small"+i).addClass("on1");
				 }
		 } */$(".Pack").filter(function(){
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
		 /* for(i=1;i<=21;i++){
			 if($("#mid3 option:selected").attr("id")=="midselect"+i){
				 $(".on1").removeClass("on1");
				 $("#small"+i).addClass("on1");
				 }
		 } */$(".Pack").filter(function(){
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
		 /* for(i=1;i<=21;i++){
			 if($("#mid4 option:selected").attr("id")=="midselect"+i){
				 $(".on1").removeClass("on1");
				 $("#small"+i).addClass("on1");
			 }
		 } */
		 $(".Pack").filter(function(){
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
		$(".Pack").filter(function(){
			if($(this).find("input").val().indexOf(${category})){
				alert(${category});
				$(this).addClass("on");
			}else{
				$(this).addClass("off");
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
	<h1>카테고리명</h1>
	<div id="category"> <!-- selectBox --></div>
</div>
	<div> <!-- 상품 하나하나를 담을 곳 -->
		<c:forEach var="item" items="${list}" varStatus="status">
			<div class="Pack"> <!-- 상품하나 -->
				<a href="${ctx}item/detailView.do?code=${item.code}">
				<div class="thum">
					<img src="http://localhost:9090/WaBangAdmin/item/itemImg/${item.thumbnail}"/>
				</div>
				<div class="box">
					<label class="itemName">${item.name}</label><br/>
					<%-- <span id="allPrice${status.count}"></span> --%>
					<label class="itemPrice">${item.discount}% <span class="discount">${item.price}</span>${item.disprice}</label><br/>
					<label class="itemDate">${item.regdate}</label>
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
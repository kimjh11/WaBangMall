$(function(){
	/* 메인 썸네일 이미지 */
	var focusImg = $("#thumnail-list li a img").first().clone();
	$("#thumnail-focus").html(focusImg);
	
	/* 썸네일 리스트 클릭 이벤트 */
	$("#thumnail-list li a img").click(function(){
		$("#thumnail-focus").html($(this).clone());
	});
	
	/*판매가 세팅*/
	var price;
	$('#total-price').ready(function(){
		price = $("#sell-price").text();
		$('#total-price').text(price);
	});
	
	/* 수량 버튼 클릭이벤트 */
	$(".cnt-div button").click(function(){
	     var cnt = $(this).siblings("input").val();
	     if($(this).attr("class")=='plus-btn'){
	    	 cnt++;
	     }else{
	    	 cnt--;
	        if(cnt==0) return;
	     }
	     $(this).siblings("input").val(cnt);
	     totalPrice(cnt);
	});
	
	/* 총구매금액 : 판매가+옵션+수량적용 */
	function totalPrice(cnt){
	   $("#total-price").text(price*cnt);
	}
	
	
	
});
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
	
	/* 옵션선택 */
	$('select').change(function(){
		var optPrice="";  
		var colorPrice="";
		if($('#opt-select option:selected').val()!=""){
			opt = $('#opt-select option:selected').text();
			optPrice = $('#opt-select option:selected').val();	
		}
		if($('#color-select option:selected').val()!=""){
			color = $('#color-select option:selected').text();
			colorPrice = $('#color-select option:selected').val();
		}
		//옵션을 두개다 선택했을경우
		if(optPrice!="" && colorPrice!=""){
			optChkShow(opt,optPrice,color,colorPrice);

			//초기값세팅
			$('#opt-select').val("").prop("select",true);
			$('#color-select').val("").prop("select",true);
		}
	});
	
	/* 선택한 옵션 확인창 생성 */
	function optChkShow(opt,optPrice,color,colorPrice){
		if($('.opt-chk').css('display','none')){
			$('.opt-chk').css('display','block');
		}
		
		var tag = "<div>옵션 : "+opt+" / 색상 : "+color+"</div>";
		$('.opt-chk').append(tag);
		var cnt = $('.cnt-wrap').first().clone().css('display','block');
		$('.opt-chk').append(cnt);	
	}
	
	/*var opt="";
	var color="";
	
	$('#opt-select').change(function(){
		if($('#opt-select option:selected').val()!=""){
			opt = $('#opt-select option:selected').val();
			console.log(opt);
		}
		if(opt!="" && color!=""){
			$('.opt-chk').css('display','block');
		}
	});

	$('#color-select').change(function(){
		if($('#color-select option:selected').val()!=""){
			color = $('#color-select option:selected').val();
			console.log(color);
		}
		if(opt!="" && color!=""){
			$('.opt-chk').css('display','block');
		}
	});*/
	

	
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
	
	/* 탭메뉴 */
	$('.nav-tabs').ready(function(){
		var tapMenu = ["상품정보","리뷰","배송/교환/반품","문의사항"];
		for(i=0; i<tapMenu.length; i++){
			var tapTag = '<li><a href="#content'+i+'" data-toggle="tab">'+tapMenu[i]+'</a></li>';
			$('.nav-tabs').append(tapTag);
		}
	});
	
	
	
	
	
	
	
});
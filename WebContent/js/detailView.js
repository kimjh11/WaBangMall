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
			var select = opt+color;
			if(!$('.opt-chk div').hasClass(select)){
				optChkShow(select,opt,optPrice,color,colorPrice);
			}else{
				alert('동일한 옵션이 선택되어 있습니다');
			}

			//초기값세팅
			$('#opt-select').val("").prop("select",true);
			$('#color-select').val("").prop("select",true);
		}
	});
	
	/* 선택한 옵션 확인창 생성 */
	function optChkShow(select,opt,optPrice,color,colorPrice){
		optPrice = Number(optPrice);
		colorPrice = Number(colorPrice);
		
		if($('.opt-chk').css('display','none')){
			$('.opt-chk').css('display','block');
			$('.opt-chk').addClass('show');
		}
		var tag = "<div class="+select+">옵션 : "+opt+" / 색상 : "+color+"</div>";
		$('.opt-chk').append(tag);//옵션 설명 추가
		var cnt = $('.cnt-wrap').first().clone(true).css('display','block');//복제
		cnt.children('.select-price').val(optPrice+colorPrice);//추가되는 옵션가 추가
		$("#total-price").text(price);
		
		totalPrice(optPrice+colorPrice);//총 판매가 변경
	
		$('.opt-chk').append(cnt);//수량 버튼 추가
	}


	/* 수량 버튼 클릭이벤트 */
	$(".cnt-div button").click(function(){
	    var cnt = $(this).siblings("input").val();//수량
	    var add = Number($(this).parent().next().val());//추가되는 옵션가

	    if($(this).attr("class")=='plus-btn'){
	    	 cnt++;
	    	 totalPrice(add);//총구매금액 변경
	     }else{
	    	 if(cnt==0) return;
	    	 cnt--;
	    	 totalPrice(-add);//총구매금액 변경
	     }
	     $(this).siblings("input").val(cnt);
	});

	
	/* 총구매금액 : 판매가+옵션+수량적용 */
	function totalPrice(add){
		 var price = Number($('#total-price').text());
		 $("#total-price").text(price+add);
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









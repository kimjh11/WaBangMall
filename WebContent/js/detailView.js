$(function(){
	/* 메인 썸네일 이미지 */
	var focusImg = $("#thumnail-list li a img").first().clone();
	$("#thumnail-focus").html(focusImg);
	
	/* 썸네일 리스트 클릭 이벤트 */
	$("#thumnail-list li a img").click(function(){
		$("#thumnail-focus").html($(this).clone());
	});
	
	
	/*판매가 세팅*/
	$('#bPayment').ready(function(){
		var price;
		price = $("#sell-price").text();
		$('#bPayment').val(price);
	});
	
	/* 옵션선택 */
	$('select').change(function(){
		var opt="";
		var optPrice="";  
		var color="";
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
			if(!$('.opt-chk li div').hasClass(select)){
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
		

		var txtDiv = "<li><div class="+select+">옵션 : "+opt+" / 색상 : "+color+"</div>";
		
		var cntDiv = '<div class="cnt-wrap">';
			cntDiv += 	'<span class="info-title" >수량</span>';
			cntDiv += 	'<div class="cnt-div">';
			cntDiv += 		'<button class="minus-btn">―</button>';
			cntDiv += 		'<input type="number" value="1" readonly>';
			cntDiv += 		'<button class="plus-btn">＋</button>';
			cntDiv += 	'</div></div></li>';

		$('.opt-chk').append(txtDiv+cntDiv);

		totalPrice(optPrice+colorPrice);//총 판매가 변경
		
		//input상자 value
		var bSelectOpt = $('#bSelectOpt').val();
		var SelectOptPrice = $('#SelectOptPrice').val();
		var bColor = $('#bColor').val();
		var bColorPrice = $('#bColorPrice').val();
		var bCount = $('#bCount').val();
		
		
		$('#bSelectOpt').val(bSelectOpt+'/'+opt);
		$('#SelectOptPrice').val(SelectOptPrice+'/'+optPrice);
		$('#bColor').val(bColor+'/'+color);
		$('#bColorPrice').val(bColorPrice+'/'+colorPrice);
		$('#bCount').val(bCount+'/'+1);
	}
	
	
	/* 수량버튼 클릭시 수량/금액변경*/
	$(".cnt-div button").click(function(){
		alert('클릭');
	    var cnt = $(this).siblings("input").val();//수량
	    var add = Number($(this).parent().next().val());//추가되는 옵션가
	    console.log(add);

	    if($(this).attr("class")=='plus-btn'){
	    	 cnt++;
	    	 totalPrice(add);//총구매금액 변경
	     }else{
	    	 if(cnt<=1) return;
	    	 cnt--;
	    	 totalPrice(-add);//총구매금액 변경
	     }
	     $(this).siblings("input").val(cnt);
	     
	     var idx = $(this).parent().parent().parent().index();
	     console.log(idx);
	     
	});
	
	
	/* 옵션 삭제버튼 클릭시 */
	//삭제한 상자의 인덱스
	// 인덱스번째/부터 다음/까지의 값을 제거
	
	
	/* 총구매금액 : 판매가+옵션+수량적용 */
	function totalPrice(add){
		 var price = Number($('#bPayment').val());
		 $("#bPayment").val(price+add);
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









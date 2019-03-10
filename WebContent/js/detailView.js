$(function(){
	/* 메인 썸네일 이미지 */
	var focusImg = $("#thumnail-list li a img").first().clone();
	$("#thumnail-focus").html(focusImg);
	
	/* 썸네일 리스트 클릭 이벤트 */
	$("#thumnail-list li a img").click(function(){
		$("#thumnail-focus").html($(this).clone());
	});
	
	/*판매가 초기값세팅*/
	$('#bPayment').ready(function(){
		var price;
		price = $("#sell-price").text();
		$('#bPayment').val(price);
	});
	
	
	/* 옵션선택 */
	$('select').change(function(){
		var selectOpt="";//옵션명
		var selectOptPrice="";//옵션가 
		var selectColor="";//컬러
		var selectColorPrice="";//컬러옵션가
		var selectCount=1;
		
		if($('#opt-select option:selected').val()!=""){
			selectOpt = $('#opt-select option:selected').text();
			selectOptPrice = $('#opt-select option:selected').val();	
		}
		if($('#color-select option:selected').val()!=""){
			selectColor = $('#color-select option:selected').text();
			selectColorPrice = $('#color-select option:selected').val();
			console.log(selectColor+","+selectColorPrice);
		}
		
		//옵션을 두개다 선택했을경우
		if(selectOptPrice!="" && selectColorPrice!=""){
			//선택한 옵션확인창
			var chk = optChkShow(selectOpt,selectColor);
			
			if(chk!=false){//동일한 선택이 없을경우
				//총판매가 변경
				totalPriceChange(selectOptPrice,selectColorPrice);
				//input에 값 저장
				optInsert(selectOpt,selectOptPrice,selectColor,selectColorPrice,selectCount);
			}
			
			//옵션선택 초기화
			$('#opt-select').val("").prop("select",true);
			$('#color-select').val("").prop("select",true);
		}
		
	});


	/* 선택한 옵션 확인창 생성 */
	function optChkShow(selectOpt,selectColor){
		//옵션체크상자 block
		if($('.opt-chk').css('display','none')){
			$('.opt-chk').css('display','block');
		}
		
		//선택한 옵션추가
		var txtDiv = "<li><div class="+selectOpt+selectColor+">"
			txtDiv += "옵션 : "+selectOpt+" , 색상 : "+selectColor+"</div></li>";
		
		//동일한옵션이 없을때 txtDiv 추가
		if(!$('.opt-chk li div').hasClass(selectOpt+selectColor)){
			$('.opt-chk').append(txtDiv);
		}else{
			alert('동일한 옵션이 선택되어 있습니다');
			return false;
		}
		
		//수량 버튼 추가
		var cntDiv = $('.cnt-wrap').first().clone(true,true).css('display','block');
		$('.opt-chk li').append(cntDiv);	
	};

	/* 총구매금액 : 판매가+옵션+수량적용 */
	function totalPriceChange(selectOptPrice,selectColorPrice){
		selectOptPrice = Number(selectOptPrice);
		selectColorPrice = Number(selectColorPrice);
		var price = Number($('#bPayment').val());
		$("#bPayment").val(price + selectOptPrice + selectColorPrice);
	}

	/* input insert */
	function optInsert(selectOpt,selectOptPrice,selectColor,selectColorPrice,selectCount){
		var bSelectOpt = $('#bSelectOpt').val();
		var SelectOptPrice = $('#SelectOptPrice').val();
		var bColor = $('#bColor').val();
		var bColorPrice = $('#bColorPrice').val();
		var bCount = $('#bCount').val();
		
		$('#bSelectOpt').val(bSelectOpt+'/'+selectOpt);
		$('#SelectOptPrice').val(SelectOptPrice+'/'+selectOptPrice);
		$('#bColor').val(bColor+'/'+selectColor);
		$('#bColorPrice').val(bColorPrice+'/'+selectColorPrice);
		$('#bCount').val(bCount+'/'+selectCount);
	}
/////////////////////////////////////////////////////////////////////
	
	

	/* 수량버튼 클릭시 수량/금액변경*/
	$('.cnt-div button').click(function(){
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
	     
	});
	
	
	/* 옵션 삭제버튼 클릭시 */
	//삭제한 상자의 인덱스
	// 인덱스번째/부터 다음/까지의 값을 제거
	
	

	
	/* 탭메뉴 */
	$('.nav-tabs').ready(function(){
		var tapMenu = ["상품정보","리뷰","배송/교환/반품","문의사항"];
		for(i=0; i<tapMenu.length; i++){
			var tapTag = '<li><a href="#content'+i+'" data-toggle="tab">'+tapMenu[i]+'</a></li>';
			$('.nav-tabs').append(tapTag);
		}
	});
	
});









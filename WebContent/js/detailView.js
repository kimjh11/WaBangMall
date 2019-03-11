$(function(){
	/* 메인 썸네일 이미지 */
	var focusImg = $("#thumnail-list li a img").first().clone();
	$("#thumnail-focus").html(focusImg);
	
	/* 썸네일 리스트 클릭 이벤트 */
	$("#thumnail-list li a img").click(function(){
		$("#thumnail-focus").html($(this).clone());
	});
	
	/*판매가 초기값세팅*/
	$('#total-price').ready(function(){
		var price;
		price = $("#sell-price").text();
		$('#total-price').text(price);
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
		/*var txtDiv = "<li class="+selectOpt+selectColor+"><div>"
			txtDiv += "옵션 : "+selectOpt+" , 색상 : "+selectColor+"</div></li>";*/
		
		var optDiv = "<li class="+selectOpt+selectColor+">";
			optDiv += 	"<div>옵션 : "+selectOpt+" , 색상 : "+selectColor+"</div>";
			optDiv += 	"<div class='cnt-clone'>";
			optDiv +=	"<span class='info-title' >수량</span>";
			optDiv +=	"<div class='cnt-div'>";
			optDiv +=		"<button class='cnt-down'>―</button>";
			optDiv +=		"<input type='number' value=1 readonly>";
			optDiv +=		"<button class='cnt-up'>+</button>";
			optDiv +=	"</div></div></li>";
		
		//동일한옵션이 없을때 optDiv 추가
		if(!$('.opt-chk li').hasClass(selectOpt+selectColor)){
			$('.opt-chk').append(optDiv);
		}else{
			alert('동일한 옵션이 선택되어 있습니다');
			return false;
		}
		
		//수량 버튼 추가
		/*var cntClone = $('.cnt-wrap').clone(true,true);
			cntClone.attr('class','cnt-clone');
			cntClone.css('display','block');

		if($('.opt-chk li').attr('class')==selectOpt+selectColor){
			$('.opt-chk li').append(cntClone);
		}*/	
	};

	/* 총구매금액 : 판매가+옵션+수량적용 */
	function totalPriceChange(selectOptPrice,selectColorPrice){
		selectOptPrice = Number(selectOptPrice);
		selectColorPrice = Number(selectColorPrice);
		var price = Number($('#total-price').text());
		$('#total-price').text(price + selectOptPrice + selectColorPrice);
		//var type=$('#bPayment').val();
		//console.log(jQuery.type(type));
	}

	/* input insert */
	function optInsert(selectOpt,selectOptPrice,selectColor,selectColorPrice,selectCount){
		var bSelectOpt = $('#bSelectOpt').val();
		var SelectOptPrice = $('#SelectOptPrice').val();
		var bColor = $('#bColor').val();
		var bColorPrice = $('#bColorPrice').val();
		var bCount = $('#bCount').val();
		var bPayment = $('#bPayment').val();
		
		$('#bSelectOpt').val(bSelectOpt+'/'+selectOpt);
		$('#SelectOptPrice').val(SelectOptPrice+'/'+selectOptPrice);
		$('#bColor').val(bColor+'/'+selectColor);
		$('#bColorPrice').val(bColorPrice+'/'+selectColorPrice);
		$('#bCount').val(bCount+'/'+selectCount);
		$('#bPayment').val($('#total-price').text());
		
	}
/////////////////////////////////////////////////////////////////////
	
	/* 장바구니,구매하기 버튼 클릭시 */
	$('.order_btn li button').click(function(){
		if($('.opt-chk li').length==0){
			alert('옵션을 선택해주세요');
			return;
		}else{
			if($(this).hasClass('buy-btn')){//구매하기
				var input = $("<input>") .attr("type", "hidden") .attr("name", "order-chk").val("buy"); 
				$('#frm').append(input);
			}else{//장바구니
				alert("장바구니 클릭");
				var input = $("<input>") .attr("type", "hidden") .attr("name", "order-chk").val("shoppingList"); 
				$('#frm').append(input);
			}
			$('#frm').submit();	
		}
	});

	/* 수량버튼 클릭시 수량/금액변경*/
	console.log($('.opt-chk li').length);
	/*$(
		|| $('.opt-chk li')){
			
		}*/
	
	
	/* 옵션 삭제버튼 클릭시 */
	//삭제한 상자의 인덱스
	// 인덱스번째/부터 다음/까지의 값을 제거
	
	
	/* 장바구니담기, 구매하기 버튼 클릭이벤트 */
	/*$('.order_btn li a').click(function(){
		if()
	});*/
	
	/* 탭메뉴 */
	$('.nav-tabs').ready(function(){
		var tapMenu = ["상품정보","리뷰","배송/교환/반품","문의사항"];
		for(i=0; i<tapMenu.length; i++){
			var tapTag = '<li><a href="#content'+i+'" data-toggle="tab">'+tapMenu[i]+'</a></li>';
			$('.nav-tabs').append(tapTag);
		}
	});
	
});









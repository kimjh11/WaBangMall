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
		var price = $("#sell-price").text();
		$('#bPayment').val(price);
	});
	
	
	/* 옵션선택 */
	$('select').change(function(){
		var bSelectOpt="";//옵션명
		var bSelectOptPrice="";//옵션가 
		var bColor="";//컬러
		var bColorPrice="";//컬러옵션가
		
		var opt = $('#opt-select option:selected');
		var color = $('#color-select option:selected');
		
		if(opt.val()!=""){
			if(opt.text().indexOf("+")>=0){
				bSelectOpt = opt.text().substring(0, opt.text().indexOf("+"));
				bSelectOptPrice = opt.val();
			}else{
				bSelectOpt = opt.text();
				bSelectOptPrice = opt.val();
			}	
		}
		if(color.val()!=""){
			if(color.text().indexOf("+")>=0){
				bColor = color.text().substring(0, color.text().indexOf("+"));
				bColorPrice = color.val();
			}else{
				bColor = color.text();
				bColorPrice = color.val();
			}
		}
		
		//옵션을 두개다 선택했을경우
		if(bSelectOptPrice!="" && bColorPrice!=""){
			//선택한 옵션확인창
			var chk = optChkShow(bSelectOpt,bSelectOptPrice,bColor,bColorPrice);
			
			if(chk!=false){//동일한 선택이 없을경우
				//총판매가 변경
				totalPriceChange(bSelectOptPrice,bColorPrice);
			}
			//옵션선택 초기화
			$('#opt-select').val("").prop("select",true);
			$('#color-select').val("").prop("select",true);
		}
	});


	/* 선택한 옵션 확인창 생성 */
	function optChkShow(bSelectOpt,bSelectOptPrice,bColor,bColorPrice){
		//옵션체크상자 block
		if($('.opt-chk').css('display','none')){
			$('.opt-chk').css('display','block');
		}
		
		var addOption = '<li class="'+bSelectOpt+bColor+'">';
			addOption += 	'<span>옵션</span>';
			addOption += 	'<input type="text" name="bSelectOpt" value="'+bSelectOpt+'" readonly/>';
			addOption += 	'<input type="text" name="bSelectOptPrice" value="'+bSelectOptPrice+'" readonly/>';
			addOption += 	'<span>색상</span>';
			addOption += 	'<input type="text" name="bColor" value="'+bColor+'" readonly/>';
			addOption += 	'<input type="text" name="bColorPrice" value="'+bColorPrice+'" readonly/>';
			addOption +=	'<div class="cnt-div">';
			addOption +=		"<input type='button' class='cnt-btn' value='-' />";
			addOption +=		"<input type='number' name='bCount' class='cnt-val' value=1 readonly>";
			addOption +=		"<input type='button' class='cnt-btn up' value='+'/>";
			addOption +=	'</div>';
			addOption +=	'<span class="close"></span>';
			addOption += '</li>';
			
		//동일한옵션이 없을때 추가
		if(!$('.opt-chk li').hasClass(bSelectOpt+bColor)){
			$('.opt-chk').append(addOption);
		}else{
			alert('동일한 옵션이 선택되어 있습니다');
			return false;
		}
	};

	/* 수량버튼 클릭 */
	$(document).on('click','.cnt-btn',function(){
		var cnt = $(this).siblings('.cnt-val').val();//선택한 옵션의 수량
		var bSelectOptPrice = $(this).parent().siblings('input[name="bSelectOptPrice"]').val();
		var bColorPrice = $(this).parent().siblings('input[name="bColorPrice"]').val();

		if($(this).hasClass('up')){
			cnt++;
			totalPriceChange(bSelectOptPrice,bColorPrice);
		}else{
			if(cnt<=1) return;
			cnt--;
			totalPriceChange(bSelectOptPrice*-1,-bColorPrice*-1);
		}
		$(this).siblings('.cnt-val').val(cnt);
	});
	
	
	/* 총구매금액 : 판매가+옵션+수량적용 */
	function totalPriceChange(bSelectOptPrice,bColorPrice){
		bSelectOptPrice = Number(bSelectOptPrice);
		bColorPrice = Number(bColorPrice);
		
		var price = Number($('#bPayment').val());
		var sum = price + bSelectOptPrice + bColorPrice;
		
		$('#bPayment').val(sum);
	}
	
	/* 장바구니,구매하기 버튼 클릭시 */
	$('.order_btn li input').click(function(){
		if($('.opt-chk li').length==0){
			alert('옵션을 선택해주세요');
			return;
		}else{
			if($(this).hasClass('buy-btn')){//구매하기버튼클릭
				$("#frm").attr("action","WabangMall/orderpage/storeOrderList.do");
				$("#frm").submit();
			}else{//장바구니 담기 클릭
				if($('input[name="loginStatus"]').val()=='Y'){//로그인 :Y
					var form = $('#frm').serialize();
					var data = new FormData(form);
					//ajax호출
					$.ajax({
						type : "post",
						enctype : "multipart/form-data",
						url : "/WaBangMall/orderpage/basketInsert.do",
						data : form ,
						dataType :"text",
						success: function(result){
							console.log(result);
							if(confirm('장바구니로 이동하시겠습니까?')){//장바구니 확인
								location.href= "/WaBangMall/orderpage/basketView.do";								
							}
						},
						error: function(){
							alert('장바구니 생성실패');
						}
					});
				}else{//로그인 :N
					if(confirm('로그인 후 이용가능합니다.\n로그인페이지로 이동하시겠습니까?')){
						location.href="/WaBangMall/member/login.do";
						return;
					}	
				}
			}
		}
	});
	
	/* 옵션닫기 */
	$(document).on('click','.opt-chk .close',function(){
		//해당 옵션의 금액을 빼준다
		var bSelectOptPrice = Number($(this).siblings('input[name="bSelectOptPrice"]').val());
		var bColorPrice = Number($(this).siblings('input[name="bColorPrice"]').val());
		var cnt = Number($(this).siblings('.cnt-div').children('.cnt-val').val());
		var price = Number($('#bPayment').val());
		
		var minus = price - ((bSelectOptPrice + bColorPrice) * cnt);
		
		$('#bPayment').val(minus);
		$(this).parent().remove();
	});
	
	/* 탭메뉴 */
	$('.nav-tabs').ready(function(){
		var tapMenu = ["상품정보","리뷰","배송/교환/반품","문의사항"];
		for(i=0; i<tapMenu.length; i++){
			var tapTag = '<li><a href="#content'+i+'" data-toggle="tab">'+tapMenu[i]+'</a></li>';
			$('.nav-tabs').append(tapTag);
		}
	});
	
});









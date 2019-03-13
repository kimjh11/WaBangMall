$(function(){
	var id = $('input[name=id]').val();

	//썸네일 첫번째 이미지만 출력
	$('.img-click').ready(function(){
		$('.img-wrap').each(function(index,item){
			$(item).children().eq(0).css('display','block');
		});
	 });
	
	$('table').ready(function(){
		totalSum();
	});
	
	//총 수량, 합계
	function totalSum(){
		var totalCnt = 0;
		var totalPrice = 0;
		
		$('tbody tr').each(function(){
			totalCnt = totalCnt + Number($(this).children('.cnt-txt').text());
			totalPrice = totalPrice + Number($(this).children('.won').text());
		});
		$('.total-cnt').text(totalCnt);
		$('.total-price').text(totalPrice);
	};
	
	//상단 체크항목 선택시
	$('.all-chk').click(function(){
		var on=0;
		var idx=0;
		//체크된 박스 개수확인
		$("tbody input[type=checkbox]").each(function(idex,data){
			if($(data).is(':checked')==true){
				on++;
			}
		});
		if(on!=0 && on!=$("tbody input[type=checkbox]").length){
			chkClear();
		}
		if($(this).hasClass('txt-btn')){
			if($(this).text()=='전체선택'){
				$(this).text('선택해제');
			}else{
				$(this).text('전체선택');
			}
		}
		$("tbody input[type=checkbox]").prop('checked',function(){
			return !$(this).prop('checked');
		});
		checkName();
	});	

	//체크박스 전체해제
	function chkClear(){
		$('input[type=checkbox]').prop('checked',false);
	}
	
	//삭제 버튼 이벤트
	$('.del-btn').click(function(){
		alert('삭제하시겠습니까?');
		if($(this).hasClass('all')){
			$("tbody input[type=checkbox]").each(function(){
				$(this).prop('checked', true);
			});
		}
		if($(this).hasClass('part')){
			if($('input[name=check]:checked').length<=0){
				alert('삭제할 상품을 선택해주세요');
				return;
			}
		}
		if($(this).hasClass('row')){
			$(this).parent().siblings('.item-info').children('input').prop('checked', true);
		}
		dataDelete();
	});
	
	//데이터 삭제
	function dataDelete(){
		var form = $('#frm').serialize();
		$.ajax({
			type : "post",
			url : "/WaBangMall/orderpage/basketDelete.do",
			data : form ,
			dataType : "html",
			success: function(){
				viewDelete();
				totalSum();
			},
			error: function(){
				alert('장바구니 삭제실패');
			}
		});
	};
	
	function viewDelete(){
		$("tbody input[type=checkbox]").each(function(){
			if($(this).is(':checked')){
				$(this).parent().parent().remove();
			}
		});
	};
	
	
	/*주문관리 이벤트*/
	/*$(".table_item_setting button").click(function(){
		if($(this).index()==0){//옵션변경
			window.open('StoreOptionPop.html','옵션창','width=350,height=500,location=no,status=no,scrollbars=yes');
		}else if($(this).index()==1){//선택삭제
			$(this).parent().parent().remove();
		}else if($(this).index()==2){//바로주문
			
		}
	});*/
	
});



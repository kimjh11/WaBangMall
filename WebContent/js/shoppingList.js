$(function(){
	//썸네일 첫번째 이미지만 출력
	$('.img-click').ready(function(){
		$('.img-wrap').each(function(index,item){
			$(item).children().eq(0).css('display','block');
		});
	 });
	
	//체크박스 이벤트
	$('.all-chk').click(function(){
		var on=0;
		var idx=0;
		$("input[name=row-check]").each(function(idex,data){
			if($(data).is(':checked')==true){
				on++;
			}
		});
		console.log(on);
		if(on!=0 && on!=$("input[name=row-check]").length){
			chkClear();
		}
		if($(this).hasClass('txt-btn')){
			if($(this).text()=='전체선택'){
				$(this).text('선택해제');
			}else{
				$(this).text('전체선택');
			}
		}
		$("input[name=row-check]").prop('checked',function(){
			return !$(this).prop('checked');
		});
	});	
	
	//체크박스 전체해제
	function chkClear(){
		$('input[name=row-check]').prop('checked',false);
	}
	
	//장바구니 삭제
	$('.del-btn').click(function(){
		alert('삭제');
	});

	
	
	
		/* $('tbody').ready(function(){
			var bCount = Number($('.b-cnt').text());
			console.log($('.b-cnt').text());
			var cntSum = 0;
			for(i=0; i<bCount.index(); i++){
				cntSum = cntSum+bCount;
			}
			$('.total-cnt').text(cntSum);
		}); */
	
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

$(function(){
	/*주문관리 이벤트*/
	$(".table_item_setting button").click(function(){
		if($(this).index()==0){//옵션변경
			window.open('StoreOptionPop.html','옵션창','width=350,height=500,location=no,status=no,scrollbars=yes');
		}else if($(this).index()==1){//선택삭제
			$(this).parent().parent().remove();
		}else if($(this).index()==2){//바로주문
			
		}
	});
	
	$(".list_chk_option a").eq(0).click(function(){
		$("#all_chk").prop("checked",true);
	});
})

function checkAll(idx){
	if($("#all_chk").is(":checked")||idx==0){
		$("input[name=row_chk]").prop("checked",true);
	}else{
		$("input[name=row_chk]").prop("checked",false);
	}
}
function tr_del(){
	$(":checked").parent().parent().remove();
}
function all_del(){
	checkAll(0);
	tr_del();
}


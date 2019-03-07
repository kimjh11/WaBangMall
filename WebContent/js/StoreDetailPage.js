$(function(){
	
	
	/*수량 변경*/
/*	$(".item_count button").click(function(){
		var num = $(".item_count input").val();
		if($(this).attr("class")=='plus_btn'){
			num++;
		}else{
			num--;
			if(num==0) return;
		}
		$(".item_count input").val(num);
		totalPrice(num);
	})
	*/
	   $(".item_count button").click(function(){
		      var num = $(this).siblings("input").val();
		      console.log(num);
		      if($(this).attr("class")=='plus_btn'){
		         num++;
		      }else{
		         num--;
		         if(num==0) return;
		      }
		      $(this).siblings("input").val(num);
		      totalPrice(num);
		   })
		   
		   /*금액 세팅*/
		   var price = $(".store_cost_sell").val();
		   console.log(price);
		   $(".final-cost").val(price);
		   
		   function totalPrice(num){
		      $(".final-cost").val(price*num);
		   }
	
	/*세부페이지 탭 메뉴*/
	$(".store_tab_menu ul li").click(function(){
		var idx = $(this).index();
		$(".store_detail_main ul li").css("display","none");
		$(".store_detail_main ul li").eq(idx).css("display","block");
	});
	
})
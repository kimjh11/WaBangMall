$(function(){
	/*디테일 메인이미지 등록*/
	var imgTag = $("#detail_img_list li a img").first().clone();
	$("#detail_img_frame").html(imgTag);
	
	/*이미지 클릭이벤트*/
	$("#detail_img_list li a img").click(function(){
		$("#detail_img_frame").html($(this).clone());
	});
	
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
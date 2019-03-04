
$(function(){
	/* 전체카테고리 호버이벤트 */
	$("#store_menu_nav li a").first().hover(function(){
		$(this).children("span").css("background-image","url('img/store/arrow-down-hover.png')");
	},function(){
		$(this).children("span").css("background-image","url('img/store/arrow-down.png')");
	});
	
	/* 전체카테고리 클릭이벤트 */
	$("#store_menu_nav li a").first().click(function(){
		if($("#store_all_category").hasClass("open")){
			$("#store_all_category").removeClass("open");
			$("#store_all_category").css("display","none");
		}else{
			$("#store_all_category").addClass("open");
			$("#store_all_category").css("display","block");
			$("#store_menu_nav li").first().addClass("nav-down");
		}
	});
	
	/* 카테고리 타이틀 */
	var cateTitle = ["가구","페브릭","홈데코","가전","수납/생활","주방","DIY자재"];
	var cateSub1 = ["쇼파","거실가구","침실가구","수납가구","학생/서재가구","주방가구","의자/스톨","테이블"];
	var cateSub2 = ["커튼","카페트","쿠션","러그","침구류"];
	var cateSub3 = ["시계","식물","조명","기타"];
	
	var cateTag = "<ul class='cate-title'>"
	for(j=0; j<cateTitle.length; j++){
		cateTag += "<li><button class='btn_pointer'>"+cateTitle[j]+"</button></li>";
	}
	cateTag += "</ul>";
	$("#store_all_category").append(cateTag);
	
	/* 하위 카테고리 */
	var cateSub = "<div class='cate-sub'>";
	for(col=0; col<cateTitle.length; col++){
		console.log("cateSub실행");
		cateSub += "<ul>"
		for(i=0; i<cateSub1.length; i++){
			console.log("cateSub-li실행");
			cateSub += "<li><button class='btn_pointer'>"+cateSub1[i]+"</button></li>";
		}
		cateSub += "</ul>";
	}
	cateSub += "</div>";
	$("#store_all_category").append(cateSub);
	
	/*탑배너 이미지*/
	var topBannerImg="";
	for(i=0; i<5; i++){//최대5개
		topBannerImg = "<img src='img/store/top_banner_img_0"+(i+1)+".png' id='top_img_"+i+"' alt='탑배너이미지'/>";
		$("#store_top_banner_img > li > a").eq(i).prepend(topBannerImg);
	}
	
	/* 더보기 이벤트 */
	$(".more-view").hover(function(){
		$(this).children("span").css("left","40px");
	},function(){
		$(this).children("span").css("left","35px");
	});
	
	/*베스트 상품 이미지*/
	var bestItemImg="";
	for(i=0; i<10; i++){//최대10개
		bestItemImg = "<span class='top_rank_info'>"+(i+1)+"</span><img src='img/store/best_item_0"+(i+1)+".jpg' alt='베스트상품이미지'/>";
		if(i==9){
			bestItemImg = "<span class='top_rank_info'>"+(i+1)+"</span><img src='img/store/best_item_"+(i+1)+".jpg' alt='베스트상품이미지'/>";
		}
		$("#best_item_list > li > a").eq(i).prepend(bestItemImg);
	}
	
	/*자주찾는 카테고리*/
	var specialCategory = ["침대","2인쇼파","책상","암막커튼","무드조명","식기세트","테이블","카페트"];
	var specialCategoryTag = "<ul>"
	for(i=0; i<specialCategory.length; i++){
		specialCategoryTag += "<li><a href='#'>"+specialCategory[i]+"</a></li>";
	}
	specialCategoryTag += "<ul>";
	$("#special_category").append(specialCategoryTag);
	
	/*오늘만 특가*/
	var superSaletag ="";
	for(i=0; i<3; i++){
		superSaletag = "<img class='scale' src='img/store/sale_item_0"+(i+1)+".jpg'>";
		$("#today_sale_item > ul > li > a").eq(i).prepend(superSaletag);
	}
	
	/* 도큐멘트 창 가로크기가 576~767사이일떄 ,container클레스 삭제 */
	$(window).resize(function(){
		winWidthChk();
		bxSliderMove();
	}); 	
	
	/* 푸터검색버튼 */
	$("#footer_search_btn").click(function(){
		if($($(this).siblings()).css("display")=="block"){
			$(this).siblings().css("display","none");
		}else{
			$(this).siblings().css("display","block");
		}
	});
	
	

	
})

//도큐멘트 창 크기 확인
function winWidthChk(){
	var winWidth = window.innerWidth;
	console.log(winWidth);
	if(winWidth<=575){
		$("section").addClass("small-page");
		$("#store_footer .store_search_bar").css("display","none");
	}else if(winWidth>575 && winWidth<=767){
		$(".container").removeClass("container");
		$(".nav_icon").css("display","block");
		$("section").addClass("small-page");
		$("#store_footer .store_search_bar").css("display","none");
	}else if(winWidth>767){
		$("section").removeClass("small-page");
		$("#store_all_category").addClass("container");
		$("#store_menubar").addClass("container");
		$("#best_item").addClass("container");
		$("#special_category").addClass("container");
		$("#super_sale_banner span").addClass("container");
		$("#today_sale_item").addClass("container");
		$("footer > div").addClass("container");
		$(".nav_icon").css("display","none");
		$("#store_footer .store_search_bar").css("display","block");
	}
}

function bxSliderMove(){
	   var slider = $('.bxslider-second').bxSlider();
	     if(!$("section").hasClass("small-page")){
	        $(".bxslider_second").bxSlider({
	               minSlides: 4
	               , maxSlides: 5
	               , slideWidth: 230
	               , slideMargin: 30
	               , moveSlides: 1
	               , pager: false
	               , speed: 1000
	               , infiniteLoop: false
	               , hideControlOnEnd: true
	               , nextText: '<span></span>'
	               , prevText: '<span></span>'
	               , onSlideBefore: function ($slideElement, oldIndex, newIndex) {}
	           });
	        slider.reloadSlider();
	     }else{
	        $(".bxslider_second").bxSlider({
	               minSlides: 2
	               , maxSlides: 3
	               , slideWidth: 230
	               , slideHeight : 300
	               , slideMargin: 10
	               , moveSlides: 1
	               , pager: false
	               , speed: 1000
	               , infiniteLoop: false
	               , hideControlOnEnd: true
	               , nextText: '<span></span>'
	               , prevText: '<span></span>'
	               , onSlideBefore: function ($slideElement, oldIndex, newIndex) {}
	           });
	        slider.reloadSlider();
	     }
	    }


/*메뉴바에 카테고리 생성*/
function cateSet(root){
	console.log(root)
	/*메뉴바에 카테고리 생성*/	
	$.getJSON('/WaBangMall/index/category.json',function(allCategory){
		var cateTag = '<ul id="main-category">';
		
		for(var mainCateTitle in allCategory){
			//console.log(mainCateTitle);
			cateTag += 	'<li class="col">';
			cateTag += 	'<h3><a href="/WaBangMall/item/itemList.do?category='+mainCateTitle+'">'+mainCateTitle+'</a></h3>';
			cateTag += 	'<ul id="middle-category">';

			for(var middleCateTitle in allCategory[mainCateTitle]){
				//console.log(middleCateTitle);
				cateTag += 	'<li>';
				cateTag +=		'<h3><a href="/WaBangMall/item/itemList.do?category='+middleCateTitle+'">'+middleCateTitle+'</a></h3>';
				cateTag +=		'<ul id="sub-category" >';
				for(var subCateTitle in allCategory[mainCateTitle][middleCateTitle]){
					cateTag +=			'<li><a href="#" style="display:none">'+allCategory[mainCateTitle][middleCateTitle][subCateTitle]+'</a></li>';
				}
				cateTag +='</ul></li>';
			}
			cateTag += '</ul></li>';
		}
		cateTag += '</ul>';
		$(".dropdown").append(cateTag);
	});
};


$(function(){
	/*전체카테고리 클릭시*/
	$('#all-category').click(function(){
		$('.dropdown').toggleClass('show');
	});

	/*푸터 접기,펼치기*/
	$('#toggle-pointer').click(function(){
		if($(this).hasClass('show')){
			$(this).removeClass('show');
			$(this).text('펼치기');
			$(this).css('bottom',0);
			$('#footer-menubar-warp').css('height',0);
			$('footer nav').hide();
			$('#footer-info-warp').css('margin-bottom',0);
		}else{
			$(this).addClass('show');
			$(this).text('접기');
			$(this).css('bottom','50px');
			$('#footer-menubar-warp').css('height','50px');
			$('footer nav').show();
			$('#footer-info-warp').css('margin-bottom','50px');
		}
	});	
});



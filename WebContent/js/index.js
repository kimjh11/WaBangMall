$(function(){
	/*전체카테고리 클릭시*/
	$('#all-category').click(function(){
		$('.dropdown').toggleClass('show');
	});

	/*메뉴바에 카테고리 생성*/	
	$.getJSON('index/category.json',function(allCategory){
		var cateTag = '<ul id="main-category">';
		
		for(var mainCateTitle in allCategory){
			//console.log(mainCateTitle);
			cateTag += 	'<li class="col">';
			cateTag += 	'<h3><a href="#">'+mainCateTitle+'</a></h3>';
			cateTag += 	'<ul id="middle-category">';

			for(var middleCateTitle in allCategory[mainCateTitle]){
				//console.log(middleCateTitle);
				cateTag += 	'<li>';
				cateTag +=		'<h3><a href="#">'+middleCateTitle+'</a></h3>';
				cateTag +=		'<ul id="sub-category" >';
				for(var subCateTitle in allCategory[mainCateTitle][middleCateTitle]){
					cateTag +=			'<li><a href="#" style="display:none">'+allCategory[mainCateTitle][middleCateTitle][subCateTitle]+'</a></li>';
				}
				cateTag +='</ul></li>';
			}
			cateTag += '</ul></li></ul>';
		}
		$(".dropdown").append(cateTag);
	});
	
	/*이벤트 베너 생성*/
	

	
});
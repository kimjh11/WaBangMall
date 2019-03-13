$(function(){
	/*메뉴바에 카테고리 생성*/	
	$.getJSON('category.json',function(allCategory){
		var cateTag = "<select id='start'name='start' onChange='select()'>";
		var big = 1;
		for(var mainCateTitle in allCategory){
			//console.log(mainCateTitle);
			cateTag += 	"<option id='big"+big+"' value='"+mainCateTitle+"' >"+mainCateTitle+"</option>";
			big++;
		}cateTag += "</select>"
			
		var catemid = "";	
		var totalmid= "<select style='display:inline'>";
		var mid = 1;
		var midselect = 1;
		for(var mainCateTitle in allCategory){
			
			catemid += "<select id='mid"+mid+"' class='mid' onChange='select"+mid+"()'>";
			for(var middleCateTitle in allCategory[mainCateTitle]){
				//console.log(middleCateTitle);
				totalmid += "<option>"+middleCateTitle+"</option>";
				catemid += "<option id='midselect"+midselect+"' value='"+middleCateTitle+"'>"+middleCateTitle+"</option>";
				midselect++;
			}mid++;
			catemid += "</select>";
		}
		totalmid += "</select>";
		
		var catesm = "";
		var small =1; 
		var smallselect = 1;
		for(var mainCateTitle in allCategory){
			for(var middleCateTitle in allCategory[mainCateTitle]){
				catesm += "<select id='small"+small+"' class='last'>";
				for(var subCateTitle in allCategory[mainCateTitle][middleCateTitle]){
					catesm +=	"<option id='smallselect"+smallselect+"' value='"+allCategory[mainCateTitle][middleCateTitle][subCateTitle]+"'>"+allCategory[mainCateTitle][middleCateTitle][subCateTitle]+"</option>";
					smallselect++;
				}small++;
				catesm += "</select>";
				
			}
		}
		$("#category").append(cateTag);
		$("#category").append(catemid);
		//$("#category").append(totalmid);
		//$("#category").append(catesm);
	});
});
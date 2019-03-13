$(function(){
	/*이벤트 베너 생성*/
	$('#event-banner').ready(function eventTagSet(){
		$('.event-slider').bxSlider({
			mode: 'fade'
			, auto:true
			, speed:1000
		});
	});
	
	/* 더보기 호버 이벤트 */
	$(".more-view").hover(function(){
		$(this).toggleClass('motion');
	});
	
	/* 베스트상품 이미지 슬라이드 */
	$('#best-item-slider').ready(function(){
		if(!$('#index-wrap').hasClass('small-page')){//데스크탑용
			$(".best-item-slider").bxSlider({
				auto: true
				//, responsive: true
				, minSlides: 4
				, maxSlides: 7
				, slideWidth: 230
				, slideMargin: 10
				, moveSlides: 1
				, pager: false
				, speed: 1000
				, infiniteLoop: true
				, hideControlOnEnd: true
				, nextText: '<span></span>'
				, prevText: '<span></span>'
				, onSlideBefore: function ($slideElement, oldIndex, newIndex) {}
           });
		};
		
	});
	
});
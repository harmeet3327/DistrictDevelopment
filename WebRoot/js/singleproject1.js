 
  
  
  
	$(window).load(function() {
		$("#status").fadeOut();
		$("#preloader").delay(350).fadeOut("slow");
	})  
	
	
	


	
	
	$(document).ready(
	function() {  
		$("html").niceScroll();
		}
	);	
	
	
	$(document).ready(function(){
		$('.bxslider').bxSlider({
			adaptiveHeight: true,
			touchEnabled: true,
			pager: false,
			controls: true,
			pause: 4000,
			auto: true,
			slideMargin: 1
		});
	});	


  $(document).ready(function(){
    // Target your .container, .wrapper, .post, etc.
    $(".media").fitVids();
  });	









	
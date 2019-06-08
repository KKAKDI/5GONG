$(function(){
	/* navigation */
	$(function () {
		$("#GNB > ul > li").hover(
			function () {
				$(this).parent("ul").stop().animate({ height: 202 }, 400);
				$(this).parents("#GNB").next(".sub_shadow").stop().animate({ height: 162 }, 400);
			},
			function () {
				$(this).parent("ul").stop().animate({ height: 40 }, 400);
				$(this).parents("#GNB").next(".sub_shadow").stop().animate({ height: 0 }, 400);
			}
		);
		$("#GNB > ul > li").focusin(function () {
			$(this).find("li").addClass("active");
			$(this).parent("ul").stop().animate({ height: 202 }, 400);
			$(this).parents("#GNB").next(".sub_shadow").stop().animate({ height: 162 }, 400);
		});
		$("#GNB > ul > li").focusout(function () {
			$(this).find("li").removeClass("active");
			$(this).parent("ul").stop().animate({ height: 40 }, 400);
			$(this).parents("#GNB").next(".sub_shadow").stop().animate({ height: 0 }, 400);
		});
	});


	/* keyvisual */
	var w;
	var total=4;
	var amount=0;

	$(window).resize(function(){
		w=$(window).width();

		if(w > 1200){
			distance=w;
		}
		else{
			distance=1200;
		}
		$(".hero .gallery").css({width:distance*total});
	});
	$(window).trigger("resize");

	$(".direction_nav .left").click(function(e){ // ���������� �̵�
		e.preventDefault();
		amount-=distance;
		$(".gallery").css({left:amount});
		$(".gallery").prepend($(".gallery li").last());

		amount+=distance;
		$(".gallery").animate({left:amount}, 500);
	});
	$(".direction_nav .right").click(function(e){ // �������� �̵�
		e.preventDefault();
		amount-=distance;
		$(".gallery").animate({left:amount}, 500, function(){
			amount+=distance;
			$(this).css({left : amount});
			$(this).append($(".gallery li").first());
		});
	});
});
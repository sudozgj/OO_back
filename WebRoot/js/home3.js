$(function() {
	/*
	//...内容框布局，剩余自适应...
	var leftW = $(".content").width()-205;
	var style = "width:"+leftW+"px;height:100%;float: left;";
	$(".content_body").attr("style",style);
	//$(".content_menu_title").attr("style","cursor:pointer;");
	//...内容框布局...*/
	
	//logout
	$(".heading_out").click(function(){
		if(!confirm("logout?"))
			return;
		$.ajax({
			type : "post",
			url : "logout.action",
			dataType : "json",
			success : function(data) {
				location.href="login.jsp";
			},
			error : function(jqXHR) {
				alert("error");
			}
		});
	});
	$(".heading_title").click(function(){
		location.href="home.jsp";
	});
	
/*	$("#cont01").mouseenter(function(){
//		if($("#cul01").is(":visible"))
//			$("#cul01").hidden();
		if($("#cul01").is(":hidden"))
			$("#cul01").show();
//		$("#cul01").toggle();
	});
	$("#cont01").mouseleave(function(){
		if($("#cul01").is(":visible")){
			$("#cul01").hide();
		}
	});*/
//	$(".hl").hover(function(){	//jq 动画  ，为实现
//		$(".hl").animate({
////			background:'#FFFFFF',
//			color:'#E4393C'
//		},"slow");
//	});
	
	$("#cont01").click(function(){
		if($("#cul01").is(":hidden")){
			$("#cont01").attr("style","background: #374247;");
			$("#cul01").slideToggle();	//slideUp + slideDown
		}
		else{ 
			$("#cont01").attr("style","background: #22282E;");
			$("#cul01").slideToggle();	//slideUp + slideDown
		}
	});
	$("#cont02").click(function(){
		if($("#cul02").is(":hidden")){
			$("#cont02").attr("style","background: #374247;");
			$("#cul02").slideToggle();	//slideUp + slideDown
		}
		else{ 
			$("#cont02").attr("style","background: #22282E;");
			$("#cul02").slideToggle();	//slideUp + slideDown
		}
	});
	$("#cont03").click(function(){
		if($("#cul03").is(":hidden")){
			$("#cont03").attr("style","background: #374247;");
			$("#cul03").slideToggle();	//slideUp + slideDown
		}
		else{ 
			$("#cont03").attr("style","background: #22282E;");
			$("#cul03").slideToggle();	//slideUp + slideDown
		}
	});
	$("#cont04").click(function(){
		if($("#cul04").is(":hidden")){
			$("#cont04").attr("style","background: #374247;");
			$("#cul04").slideToggle();	//slideUp + slideDown
		}
		else{ 
			$("#cont04").attr("style","background: #22282E;");
			$("#cul04").slideToggle();	//slideUp + slideDown
		}
	});
	$("#cont05").click(function(){
		if($("#cul05").is(":hidden")){
			$("#cont05").attr("style","background: #374247;");
			$("#cul05").slideToggle();	//slideUp + slideDown
		}
		else{ 
			$("#cont05").attr("style","background: #22282E;");
			$("#cul05").slideToggle();	//slideUp + slideDown
		}
	});
	$("#cont06").click(function(){
		if($("#cul06").is(":hidden")){
			$("#cont06").attr("style","background: #374247;");
			$("#cul06").slideToggle();	//slideUp + slideDown
		}
		else{ 
			$("#cont06").attr("style","background: #22282E;");
			$("#cul06").slideToggle();	//slideUp + slideDown
		}
	});
});
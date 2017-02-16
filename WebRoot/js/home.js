$(function() {
	$("#heading_out").click(function(){
//		debugger;
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
	
	$("#heading_title").click(function(){
		location.href="home3.jsp";
	});
	/*
	$("#menu_title").click(function(){
		//var t = document.getElementById("gg");
//		t.style.display="block";
		
//		$("#content_menu_d01 ul").show();
		$("#content_menu_d01 ul").hide();
	});*/
	
	$(".c1").click(function(){
		$("#content_menu_d01 ul.u01").toggle();
	});
});
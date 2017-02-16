$(function(){
//	$.ajaxSetup ({
//		cache: false //关闭AJAX缓存
//	});
//	
	$.ajax({					//全局加载一次用户列表
		type:"post",
		url:"getUserList.action",
		async : true,
		cache: false,
		dataType:"json",
		success:function(data){
			if(data[0].result){		//无权限
				alert(data[0].result);
			}else{					//有权限
				$("#userList tbody").empty();
				for(var i=0;i<data.length;i++){
					var tableData ="<tr>"
										+ "<td> <input type='checkbox' class='ckBox' /></td>" 
										+ "<td>" +data[i].id + "</td>"
										+ "<td>" +data[i].name + "</td>"
										+ "<td>" +data[i].username + "</td>"
										+ "<td>" +data[i].password + "</td>"
										+ "<td>" + changeTime(data[i].createtime) + "</td>"
									+ "</tr>";
					$('#userList tbody').append(tableData);
				}
			}
		},
		error:function(jqXHR){
			alert("error");
		}
	});
			
//	setInterval(getUL,10000);	//n毫秒 定时刷新
	function getUL(){			//获取用户列表函数
		$.ajax({
			type:"post",
			url:"getUserList.action",
			cache: false,
			dataType:"json",
			success:function(data){
				$("#userList tbody").empty();	//清空表格
				for(var i=0;i<data.length;i++){
					var tableData ="<tr>"
					+ "<td> <input type='checkbox' class='ckBox' /></td>" 
					+ "<td class='Id'>" +data[i].id + "</td>"
					+ "<td>" +data[i].name + "</td>"
					+ "<td>" +data[i].username + "</td>"
					+ "<td>" +data[i].password + "</td>"
					+ "<td>" + changeTime1(data[i].createtime) + "</td>"
					+ "</tr>";
					$('#userList tbody').append(tableData);	//添加表格数据
				}
			},
			error:function(jqXHR){
				alert("error");
			}
		});
	}
			
	$("#xlsButton").click(function(){	//导出表格函数
		var trList = document.getElementsByTagName("tr");
		
		var tmp=0;		//用于判断用户是否勾选，没有选则一直为0
		var array = new Array();
		for(var i=0;i<trList.length;i++){
			//debugger;
			array[i]="";
			if(i==0){	//表格头标题行
				for(var j=1;j<trList[0].cells.length;j++){
					if(j!=trList[0].cells.length-1){
						array[i] += trList[i].cells[j].innerHTML+"-";
					}
					else{
						array[i] += trList[i].cells[j].innerHTML;
					}
				}
			}
			if($(".ckBox").eq(i-1).is(':checked') && i>=1){	//被勾选的数据
				for(var j=1;j<trList[0].cells.length;j++){
					if(j!=trList[0].cells.length-1)
						array[i] += trList[i].cells[j].innerHTML+"-";
					else
						array[i] += trList[i].cells[j].innerHTML;
				}
				tmp++;	//有勾选的标志
			}
		}
		if(tmp===0){
			alert("请勾选列表");
			return;
		}
		var str="";
		for(var k=0;k<array.length;k++){	//将数组拼接为string用于传输
			if(array[k]!=""){
				if(k!=array.length-1)
					str+=array[k]+"=";
				else
					str+=array[k];
			}
		}
		$.ajax({
			type:"post",
			url:"xlsExport.action",
			data:{"data":str},
			dataType:"json",
			success:function(data){
				location.href=data[0].result;
			},
			error:function(jqXHR){
				alert("error");
			}
		});
	});
			
	$("#ckHead").bind("click",function(){	//全选函数
		if($("#ckHead").is(':checked'))
			$("[class=ckBox]:checkbox").attr("checked",true);
		else
			$("[class=ckBox]:checkbox").attr("checked",false);
	});
	
	function changeTime(ts){		//时间戳转时间函数
		var timestamp = new Date(ts);
		var dtime = timestamp.toLocaleDateString().replace(/\//g, "/")+" "+ timestamp.toTimeString().substr(0, 8);
		return dtime;
	}
	
	$("#deleteButton").click(function(){	//删除表格数据
		var trList = document.getElementsByTagName("tr");
		//debugger;
		//var id=new Array();
		var idStr="";
		for(var i=0;i<trList.length-1;i++){
			if($(".ckBox").eq(i).is(':checked')){
				//alert(trList[i+1].cells[1].innerHTML);
				var s = trList[i+1].cells[1].innerHTML;
				idStr += s+"-";
			}
		}
		idStr=idStr.substring(0,idStr.length-1);
		//alert(idStr);
		if(idStr===""){
			alert("请勾选列表");
			return;
		}
		$.ajax({
			type:"post",
			url:"deleteUser.action",
			data:{"id":idStr},
			dataType:"json",
			success:function(data){
				if(data[0].result==="1"){
					alert("删除用户成功");
					//document.frames("cont").location.reload();
					//location.href="home.jsp";
					window.location.reload();
					//document.getElementById("#userCtl").click();
				}
				else{
					alert(data[0].result);
					window.location.reload();
				}
			},
			error:function(jqXHR){
				alert("error");
			}
		});
	});
	
});
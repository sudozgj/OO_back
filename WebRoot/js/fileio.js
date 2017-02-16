$(function(){
	$.ajax({					//全局加载一次用户列表
		type:"post",
		url:"getFileList.action",
		cache: false,
		dataType:"json",
		success:function(data){
			if(data[0].result){		//无权限
				alert(data[0].result);
			}else{					//有权限
//				$("#fileList tbody").empty();
				var tableData;
				for(var i=0;i<data.length;i++){
					tableData +="<tr>"
										+ "<td>" +data[i].id + "</td>"
										+ "<td>" +data[i].filename + "</td>"
										+ "<td>" +data[i].username + "</td>"
										+ "<td>" +changeTime(data[i].uploadtime) + "</td>"
										+ "<td> <input type='button' id='downloadButton' onclick='downF(this)' /> </td>"
										+ "<td> <input type='button' id='deleteButton' onclick='deleteF(this)' /> </td>"
									+ "</tr>";
				}
				$('#fileList tbody').html(tableData);
			}
		},
		error:function(jqXHR){
			alert("error");
		}
	});
	
	function changeTime(ts){		//时间戳转时间函数
		var timestamp = new Date(ts);
		var dtime = timestamp.toLocaleDateString().replace(/\//g, "/")+" "+ timestamp.toTimeString().substr(0, 8);
		return dtime;
	}
	
});
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>日志</title>
	<link rel="stylesheet" href="css/tableStyle.css" type="text/css" />
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript">
		$(function(){
			$.ajax({
				type:"post",
				url:"getLogList.action",
				cache: false,
				success:function(data){
					if(data[0].result){
						alert(data[0].result);
						window.location.href="back.jsp";
					}else{
						var tableData;
						for(var i=0;i<data.length;i++){
							tableData +="<tr>"
												+ "<td>" +data[i].id + "</td>"
												+ "<td>" +data[i].username + "</td>"
												+ "<td>" +data[i].operation + "</td>"
												+ "<td>" +data[i].time + "</td>"
											+ "</tr>";
						}
						$('#logList tbody').html(tableData);
					}
				},
				error:function(jqXHR){
					alert("error");
				}						
			});
		});
	</script>
</head>
<body>
	<div>
		<form>
			<input type="text" name="key" id="key" />
			<select name="key">
				<option value="1"></option>
			</select>
			<input type="button" value="search" />
			
		</form>
	</div>
	<table id="logList" border="1" class="tables01">
		<thead>
			<tr>
				<th>id</th>
				<th>用户</th>
				<th>操作</th>
				<th>时间</th>
			</tr>
		</thead>
		<tbody></tbody>
	</table>
</body>
</html>
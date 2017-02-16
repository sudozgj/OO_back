<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>file upload</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
	<link rel="stylesheet" href="css/tableStyle.css" type="text/css" />
	
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript" src="js/fileio.js"></script>
	<script type="text/javascript">
		function downF(o){
			var id = $(o).parent().parent().children('td').eq(0).text();
			location.href="fileDownload.action?id="+id;
		}
		function deleteF(o){
			var id = $(o).parent().parent().children('td').eq(0).text();
			/*location.href="deleteFile.action?id="+id;*/
			
			if(confirm("确认删除文件吗?")){
				$.ajax({
					type:"post",
					url:"deleteFile.action",
					cache: false,
					dataType:"json",
					data:{"id":id},
					success:function(data){
						if(data[0].result==1){
							alert("删除文件成功");
							window.location.reload();
						}
						else if(data[0].result==0)
							alert("删除文件失败");
						else
							alert(data[0].result);
					},
					error:function(jqXHR){
						alert("error");
					}
				});
			}
		}
	</script> 
  </head>
  
  <body>
  	<!-- 使用struts2上传，但是并没有上传成功的反馈，接下来尝试使用ajax的方式提交 -->
  	<form action="fileUpload.action" method="post" enctype="multipart/form-data" id="form">
  		<input type="file" name="upFile" id="upFile" />
  		<input type="submit" value="upload" id="uploadButton"/>
  	</form>
  	<p></p>
  	<table id="fileList" border="1" class="tables01">
  		<thead>
  			<tr>
  				<th>id</th>
  				<th>文件名</th>
  				<th>分享者</th>
  				<th>上传时间</th>
  				<th>下载</th>
  				<th>删除</th>
  			</tr>
  		</thead>
  		<tbody></tbody>
  	</table>
  	<p></p>
  </body>
</html>

<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>32bit MD5 test</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript" src="js/md5.js"></script>
	<script type="text/javascript" src="js/sha1.js"></script>
	<script type="text/javascript">
		$(function(){
			$("#md5Button").click(function(){
				var md5 = hex_md5($("#md5T").val());
				$("#md5T").val(md5);
			});
			$("#sha1Button").click(function(){
				var sha1 = hex_sha1($("#sha1T").val());
				$("#sha1T").val(sha1);
			});
		});
	</script>
  </head>
  <body>
  	MD5 :&nbsp;&nbsp;<input type="text" id="md5T" style="width:400px;" />
  	<input type="button" id="md5Button" value="to-md5" />
  	<p></p>
  	SHA1:&nbsp;&nbsp;<input type="text" id="sha1T" style="width:400px;" />
  	<input type="button" id="sha1Button" value="to-sha1" />
  </body>
</html>

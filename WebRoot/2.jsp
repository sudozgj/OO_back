<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>宽度自适应布局</title>
	<style>
		body,div{ margin:0; padding:0;}
		div{ height:200px; color:#F00;}
		.left{ float:left; width:100px; background:#00f; _margin-right:-3px;}
		.center{ background:#333; margin:0 100px; _margin:0 97px;}
		.right{ float:right; width:100px; background:#0f0; _margin-left:-3px;}
	</style>
</head>
<body>
	<form action="register">
		<input type="submit" value="register" />
	</form>
	<div class="left">我是left</div>
	<div class="right">我是right</div>
	<div class="center">我是center</div>
	<a href="http://localhost:8080/OO/pictureDir/201603271705.zip">mp4</a>
	人数: <%=getServletContext().getAttribute("onlineCount") %>
</body>
</html>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>memory</title>
    <!-- 引入 echarts.js -->
    
    <script src="../js/echarts.js"></script>
    <script type="text/javascript" src="../js/jquery.min.js"></script>
	<script type="text/javascript" src="js/memory.js"></script>
	<script type="text/javascript" src="js/memory02.js"></script>
</head>
<body>
    <!-- 为ECharts准备一个具备大小（宽高）的Dom -->
    <div id="main" style="width: 600px;height:400px;"></div>
    <div id="main02" style="width: 600px;height:400px;"></div>
    
</body>
</html>
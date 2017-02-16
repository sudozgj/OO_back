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
    
    <script type="text/javascript" src="../js/jquery.min.js"></script>
    <script src="../js/echarts.js"></script>
	<script type="text/javascript" src="js/disk.js"></script>
	<script type="text/javascript" src="js/disk02.js"></script>
</head>
<body>
    <!-- 为ECharts准备一个具备大小（宽高）的Dom -->
    <div id="main" style="width: 400px;height:260px;"></div>
    
    <div id="main02" style="width: 400px;height:260px;"></div>
</body>
</html>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>user</title>
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
	<script type="text/javascript" src="js/user.js"></script>
  </head>
  
  <body>
  	<table id="userList" border="1" class="tables01">
  		<thead>
  			<tr>
  				<th><input type="checkbox"  id="ckHead" value="hao"/> </th>
  				<th>id</th>
  				<th>name</th>
  				<th>username</th>
  				<th>password</th>
  				<th>date</th>
  			</tr>
  		</thead>
  		<tbody></tbody>
  	</table>
  	<br>
  	<button id="xlsButton" >导出xls</button>
  	<button id="deleteButton" >删除</button>
  	<button id="addButton" >添加</button>
  </body>
</html>

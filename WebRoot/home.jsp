<%@page import="org.model.User"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head lang="en">
<title>OO</title>
<link href="css/home.css" type="text/css" rel="stylesheet">

<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/home.js"></script>
</head>
<body background="images/bg.jpg">
	<div id="container">
		<div id="heading">
			<div id="heading_title"><img alt="" src="images/home.png"></div>
			<div id="heading_line">
				<ul>
					<li>首页</li>
					<li>下载</li>
					<li>文档</li>
					<li>社区</li>
					<li class="r">关于我们</li>
				</ul>
			</div>
			<div id="heading_name">zgj</div>
			<div id="heading_out">
				logout
			</div>
		</div>
		<div id="content_menu">
			<div id="content_menu_d01">
				<a href="fileio.jsp" target="cont">
					<div id="menu_title">
						<strong>文件IO</strong>
					</div>
				</a>
				<ul>
					<li><a href="http://meigesir.iteye.com/blog/1539358" target="cont">图片上传</a>
					</li>
					<li><a href="" target="cont">b</a>
					</li>
					<li><a href="" target="cont">d</a>
					</li>
				</ul>
				<a href="user.jsp" target="cont">
					<div id="menu_title">
						<strong>RBAC</strong> 
					</div>
				</a>
				<ul>
					<li><a href="user.jsp" target="cont" id="userCtl">用户管理</a>
					</li>
					<li><a href="role.jsp" target="cont">角色管理</a>
					</li>
					<li><a href="authority.jsp" target="cont">权限管理</a>
					</li>
				</ul>
				<a href="1.jsp" target="cont">
					<div id="menu_title">
						<strong>list</strong> 
					</div>
				</a>
				<ul>
					<li><a href="" target="cont">a</a>
					</li>
					<li><a href="" target="cont">b</a>
					</li>
					<li><a href="" target="cont">d</a>
					</li>
					<li><a href="" target="cont">r</a></li>
				</ul>
				<a href="3.jsp" target="cont">
					<div id="menu_title">
						<strong>configuration</strong> 
					</div>
				</a>
				<ul>
					<li><a href="javascript:void(0)" target="cont">CPU</a>
					</li>
					<li><a href="" target="cont">Men</a>
					</li>
					<li><a href="" target="cont">Disk</a>
					</li>
				</ul>
				<a href="3.jsp" target="cont">
					<div id="menu_title" class="c1">
						<strong>布局</strong> 
					</div>
				</a>
				<ul class="u01">
					<li><a href="http://www.ainatec.com/" target="cont">CPU</a>
					</li>
					<li><a href="" target="cont">Men</a>
					</li>
					<li><a href="" target="cont">Disk</a>
					</li>
				</ul>
				<a href="hash.jsp" target="cont">
					<div id="menu_title">
						<strong>加密算法</strong>
					</div>
				</a>
				<p>...</p>
				<p>...</p>
			</div>
		</div>
		<div id="content_body">
			<div id="content_body_d01">
				<iframe  name="cont" width="100%" height="100%"
					frameborder="0" scrolling="yes" style="background: #FFFFFF"></iframe>
			</div>
		</div>
		<div id="footing">@OO</div>
	</div>
</body>
</html>

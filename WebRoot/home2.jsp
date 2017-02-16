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
<meta charset="UTF-8">
<title>ERP</title>
<link href="css/home.css" type="text/css" rel="stylesheet">

<style type="text/css">
*{margin: 0;padding: 0}
ul,li{list-style: none;}
a:link,a:visited{text-decoration: none;}
.list{border-bottom:solid 1px #316a91;}
.list ul li{background-color:#22282E; border:solid 1px #316a91; border-bottom:0;}
/*.list ul li:hover{background-color:#37424F;}*/
.list ul li a{padding-left: 10px;color: #fff; font-size:15px; display: block; font-weight:bold; height:36px;line-height: 36px;position: relative;
}
/*.list ul li .inactive{ background:url(images/off.png) no-repeat 184px center;}*/
/*.list ul li .inactives{background:url(images/on.png) no-repeat 184px center;} */
.list ul li ul{display: none;}
.list ul li ul li { border-left:0; border-right:0; background-color:#293038; border-color:#467ca2;}
.list ul li ul li ul{display: none;}
.list ul li ul li a{ padding-left:20px;}
.list ul li ul li ul li { background-color:#d6e6f1; border-color:#6196bb; }
.last{ background-color:#d6e6f1; border-color:#6196bb; }
.list ul li ul li ul li a{ color:#316a91; padding-left:30px;}
</style>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/home.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$('.inactive').click(function(){
			if($(this).siblings('ul').css('display')=='none'){
				$(this).parent('li').siblings('li').removeClass('inactives');
				$(this).addClass('inactives');
				$(this).siblings('ul').slideDown(100).children('li');
				if($(this).parents('li').siblings('li').children('ul').css('display')=='block'){
					$(this).parents('li').siblings('li').children('ul').parent('li').children('a').removeClass('inactives');
					$(this).parents('li').siblings('li').children('ul').slideUp(100);
				}
			}else{
				//控制自身变成+号
				$(this).removeClass('inactives');
				//控制自身菜单下子菜单隐藏
				$(this).siblings('ul').slideUp(100);
				//控制自身子菜单变成+号
				$(this).siblings('ul').children('li').children('ul').parent('li').children('a').addClass('inactives');
				//控制自身菜单下子菜单隐藏
				$(this).siblings('ul').children('li').children('ul').slideUp(100);
				//控制同级菜单只保持一个是展开的（-号显示）
				$(this).siblings('ul').children('li').children('a').removeClass('inactives');
			}
		});
	});
</script>
</head>
<body background="images/bg.jpg">
	<div id="container">
		<div id="heading">
			<div id="heading_title">OO</div>
			<div id="heading_name">zgj</div>
			<div id="heading_out">
				logout
			</div>
		</div>
		<div class="list" id="content_menu">
	<ul class="yiji">
		<li><a class="inactive">11</a></li>
		<li><a class="inactive">22</a>
			<ul style="display: none">
				<li><a class="inactive active">44</a>
					<ul>
						<li><a>1</a></li>
						<li><a>2</a></li>
						<li><a>3</a></li>
					</ul>
				</li> 
				<li class="last"><a>《美术》杂志社</a></li> 
			</ul>
		</li>
		<li><a class="inactive">组织机构</a>
			<ul style="display: none">
				<li><a class="inactive active">美协机关</a>
					<ul>
						<li><a>办公室</a></li>
						<li><a>人事处</a></li>
						<li><a>1</a></li>
						<li><a>2</a></li>
						<li><a>3</a></li>
					</ul>
				</li> 
				<li><a class="inactive active">afgdsg</a>   
					<ul>
						<li><a>综合部</a></li>
						<li><a>大型活动部</a></li>
						<li><a>展览部</a></li>
						<li><a>艺委会工作部</a></li>
						<li><a>信息资源部</a></li>
						<li><a>双年展办公室</a></li>
					</ul>
				</li> 
				<li class="last"><a>《美术》杂志社</a></li> 
			</ul>
		</li>
	</ul>
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

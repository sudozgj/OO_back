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
	<link href="css/home3.css" type="text/css" rel="stylesheet">
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript" src="js/home3.js"></script>
</head>
<body background="images/bg.jpg">
	<%
		User user = (User)session.getAttribute("user");
		if(user==null){
	 %>
	 <script type="text/javascript">
	 	alert("请先登录！");
	 	location.href="login.jsp";
	 </script>
	 <%
	 	}
	  %>
	<div class="container">
		<div class="heading">
			<div class="heading_title"><img src="images/home.png"></div>
			<div class="heading_line">
				<div class="hl"><a>首页</a></div>
				<div class="hl"><a>下载</a></div>
				<div class="hl"><a>文档</a></div>
				<div class="hl"><a>社区</a></div>
				<div class="hl"><a>关于我们</a></div>
				<div class="hl"><a href="log.jsp" target="cont">日志</a></div>
			</div>
			<div class="heading_out">
				logout
			</div>
			<div class="heading_user">
			<%
				String a="null";
				User user1 = (User)session.getAttribute("user");
				if(user1!=null){
					a=user1.getUsername();
				}
			 %>
			 <%=a %>
			</div>
		</div>
		<div class="content">
			<div class="content_menu">
				<div class="content_menu_title" id="cont01">
					<img alt="" src="images/plus.png" width="15px" height="15px">
					<strong>文件IO</strong>
				</div>
					<ul id="cul01">
						<li><a href="fileio.jsp" target="cont">文件共享</a>
						</li>
					</ul>
				<div class="content_menu_title" id="cont02">
					<img alt="" src="images/plus.png" width="15px" height="15px">
					<strong>RBAC</strong> 
				</div>
					<ul id="cul02">
						<li><a href="user.jsp" target="cont">用户管理</a>
						</li>
						<li><a href="role.jsp" target="cont">角色管理</a>
						</li>
						<li><a href="https://segmentfault.com/a/1190000002664237" target="cont">权限管理</a>
						</li>
					</ul>
				<div class="content_menu_title" id="cont03">
					<img alt="" src="images/plus.png" width="15px" height="15px">
					<strong>主机参数</strong> 
				</div>
					<ul id="cul03">
						<li><a href="" target="cont">CPU</a></li>
						<li><a href="property/memory.jsp" target="cont">内存</a></li>
						<li><a href="property/disk.jsp" target="cont">硬盘</a></li>
					</ul>
				<div class="content_menu_title" id="cont04">
					<img alt="" src="images/plus.png" width="15px" height="15px">
					<strong>chart</strong>
				</div>
					<ul id="cul04">
						<li><a href="chart/curve_chart.jsp" target="cont">折线图</a>
						</li>
						<li><a href="chart/bar_chart.jsp" target="cont">堆叠柱状图</a>
						</li>
						<li><a href="chart/circular_chart.jsp" target="cont">环形图</a>
						</li>
						<li><a href="chart/pie_chart.jsp" target="cont">饼图</a>
						</li>
						<li><a href="chart/pie_chart02.jsp" target="cont">饼图2</a>
						</li>
						<li><a href="chart/pie_chart03.jsp" target="cont">饼图纹理</a>
						</li>
						<li><a href="chart/area_chart.jsp" target="cont">面积图</a>
						</li>
						<li><a href="chart/radar_chart.jsp" target="cont">雷达图</a>
						</li>
						<li><a href="chart/dash_chart.jsp" target="cont">仪表盘</a>
						</li>
					</ul>
				<div class="content_menu_title" id="cont05">
					<img alt="" src="images/plus.png" width="15px" height="15px">
					<strong>Bolg</strong> 
				</div>
					<ul id="cul05">
						<li><a href="http://lib.csdn.net/zhhy88/chart/Struts2" target="cont">a</a>
						</li>
						<li><a href="http://www.cnblogs.com/jifeng/archive/2012/05/16/2503519.html" target="cont">sigar</a>
						</li>
						<li><a href="http://www.2cto.com/kf/201312/263690.html" target="cont">r</a></li>
					</ul>
				<div class="content_menu_title" id="cont06">
					<img alt="" src="images/plus.png" width="15px" height="15px">
					<strong>加密算法</strong>
				</div>
					<ul id="cul06">
						<li><a href="hash.jsp" target="cont">MD5  SHA1</a>
						</li>
					</ul>
			</div>
			<div class="content_body">
				<iframe name="cont" frameborder="0" scrolling="yes" src="ifm.jsp">
				
				</iframe>
			</div>
		</div>
		<div class="footing"></div>
	</div>
</body>
</html>

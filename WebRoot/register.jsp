<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" class="no-js">
<head>
<meta charset="UTF-8" />

<title>登录页面</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description"
	content="Login and Registration Form with HTML5 and CSS3" />
<meta name="keywords"
	content="html5, css3, form, switch, animation, :target, pseudo-class" />
<meta name="author" content="Codrops" />
<link rel="shortcut icon" href="../favicon.ico">
<link rel="stylesheet" type="text/css" href="css/demo.css" />
<link rel="stylesheet" type="text/css" href="css/style.css" />
<link rel="stylesheet" type="text/css" href="css/animate-custom.css" />

	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript">
		$(function(){
			$("#username").blur(function(){
				var uname = $("#username").val();
				//alert("username is :"+uname);
				$.ajax({
					type:"post",
					url:"checkUsername.action",
					data:{"username":uname},
					dataType:"json",
					success:function(data){
						if(!data[0].result.match("1")){
							alert(data[0].result);
							$("#username").val("");
							$("#username").focus();
						}
					},
					error:function(jqXHR){
						alert("error");
					}
				});
			});
			$("#registerButton").click(function(){
				if($("name").val()==""||$("#username").val()==""||$("#password").val()==""){
					alert("信息不完整!");
					return;
				}
				var user={
					"name":$("#name").val(),
					"username":$("#username").val(),
					"password":$("#password").val()
				};
				$.ajax({
					type:"post",
					url:"register.action",
					data:user,
					dataType:"json",
					success:function(data){
						if(data[0].result.match("1")){
							if(confirm("注册成功，转到登录...")){
								location.href="login.jsp";
							}
							else{
								$("#username").val("");
								$("#name").val("");
								$("#password").val("");
							}
						}
						else
							alert(data[0].result);
					},
					error:function(jqXHR){
						alert("error");
					}
				});
			});
		});
	
	</script>
</head>
<body>
	<div class="container">
		<!-- Codrops top bar -->
		<br /> <br />
		<section>
			<div id="container_demo">

				<a class="hiddenanchor" id="toregister"></a> <a class="hiddenanchor"
					id="tologin"></a>
				<div id="wrapper">
					<div id="login" class="animate form">
						<form>
							<h1>Register</h1>
							<p>
								<label for="name" class="uname" data-icon="u">姓名 </label> <input
									id="name" name="name" required="required" type="text" />
							</p>
							<p>
								<label for="username" class="uname" data-icon="u">用户名 </label> <input
									id="username" name="username" required="required" type="text" />
							</p>
							<p>
								<label for="password" class="youpasswd" data-icon="p">
									密码 </label> <input id="password" name="password" required="required"
									type="password" />
							</p>
							<p class="login button" >
								<input type="button" value="注册" id="registerButton"/>
							</p>
							<a href="login.jsp">登录</a>
						</form>
					</div>
				</div>
			</div>
		</section>
	</div>
</body>
</html>
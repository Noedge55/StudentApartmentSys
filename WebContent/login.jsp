<%@ page contentType="text/html; charset=utf-8"%>
<!doctype html>
<html>
	<head>
	<title>学生公寓管理系统-登录界面</title>
		<link rel="stylesheet" href="css/reset.min.css">
		<link rel="stylesheet" href="css/login.css">
	</head>
	<body>
		<div class="login-container">
			<b style="color:gray;">登录界面</b>
			<img class="user-avatar" src="img/user_avatar.png">
			<form action="LoginServlet" method="post">
				<span id="login_msg" style="color: red"><%=request.getAttribute("info")!=null?request.getAttribute("info"):""%></span>
				<input class="input-login" type="text" name="userid" style="background-image: url('img/user_name.png');"placeholder="请输入用户名" value="<%=request.getParameter("userid")!=null?request.getParameter("userid"):""%>">
				<input class="input-login" type="password" name="password" style="background-image: url('img/user_password.png');" placeholder="请输入密码" value="<%=request.getParameter("password")!=null?request.getParameter("password"):""%>">
				<input class="input-login" type="text" name="code" style="background-image: url('image.jsp');background-position: left;padding-left: 85px"placeholder="请输入左图验证码">
				<input id="rememberPassword" type="checkbox" name="isremeber">
				<label for="rememberPassword">记住密码</label>
				<input class="button-login"type="submit" value="登录">
			</form>
		</div>
	</body>
</html>
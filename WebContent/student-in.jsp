<%@ page contentType="text/html" pageEncoding="utf-8"%>
<html>
<head>
<title>学生入住</title>
<link rel="stylesheet" href="css/reset.min.css">
<style type="text/css">
	body{
		background: linear-gradient(rgba(38, 172, 217,0.7), rgba(38, 172, 217,0)) no-repeat;
	}
	div.container{
		text-align:center;
		width:500px;
		height:400px;
		margin:0px auto;
		border-style: solid;
		border-color: rgb(38,172,217);
		border-radius: 6px;
	}
	font{
		display: block;
		margin-top: 10px;
		margin-bottom:10px;
		text-align: center;
		font-family: "Comic Sans MS", cursive, sans-serif;
		color: white;
		background:rgb(0, 172, 230);
	}
	table,tr,td{	
		border: solid rgb(0, 172, 230) 1px;
		border-radius:6px;
		color: white;
		text-align: center;
	}
	input{
		background: rgb(38,172,217);
		color: #fff;
	}
</style>
<script type="text/javascript">
	var id = "<%=session.getAttribute("userid")%>"
	if(id == "null"){
		alert("你还没有登录，请登录");
		window.location.href="index.jsp";
	}
</script>
</head>
<body>
	<div class="container">
	<font>待入住学生</font>
	<form action="#" method="post">
		<table style="display: inline-block;">
			<tr>
				<th>学生学号</th>
				<th>学生名字</th>
				<th>专业班级</th>
				<th>入住操作</th>
			</tr>
			<tr>
				<td>*</td>
				<td>*</td>
				<td>*</td>
				<td><input type="button" value="入住"></td>
			</tr>
			<tr>
				<td>*</td>
				<td>*</td>
				<td>*</td>
				<td><input type="button" value="入住"></td>
			</tr>
		</table>
		<br>
	</form>	
	</div>
</body>
</html>
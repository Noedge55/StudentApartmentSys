<%@ page contentType="text/html" pageEncoding="utf-8"%>
<html>
<head>
<title>维修信息</title>
<script type="text/javascript">
	var id = "<%=session.getAttribute("userid")%>"
	if(id == "null"){
		alert("你还没有登录，请登录");
		window.location.href="index.jsp";
	}
</script>
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
</head>
<body>
	<div class="container">
	<font>101寝室物品维修信息</font>
	<form action="#" method="post">
		<table style="display: inline-block;">
			<tr>
				<th>维修单号</th>
				<th>物品号</th>
				<th>物品名称</th>
				<th>记录时间</th>
				<th>维修时间</th>
				<th>是否维修</th>
				<th>维修备注</th>
			</tr>
			<tr>
				<td>*</td>
				<td>*</td>
				<td>*</td>
				<td>*</td>
				<td>*</td>
				<td>*</td>
				<td>*</td>
			</tr>
			<tr>
				<td>*</td>
				<td>*</td>
				<td>*</td>
				<td>*</td>
				<td>*</td>
				<td>*</td>
				<td>*</td>
			</tr>
		</table>
		<br>
	</form>	
	</div>
</body>
</html>
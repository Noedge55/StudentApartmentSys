<%@ page contentType="text/html" pageEncoding="utf-8"%>
<html>
<head>
<title>寝室基本信息</title>
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
		height:560px;
		margin:0px auto;
		border-style: solid;
		border-color: rgb(38,172,217);
		border-radius: 6px;
	}
	div.top{
		display:inline-block;
		text-align: center;
		width: 200px;
		height: 100px;
		border-style:solid;
		border-width:1px;
		border-color: rgb(38,172,217);
		padding-top: 50px;
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
	<font>${dormitory.dorno }寝室基本信息</font>
	<form action="#" method="post">
		<table style="display: inline-block;">
			<tr>
				<td>公寓号：</td>
				<td>${dormitory.apartno }</td>
			</tr>
			<tr>
				<td>寝室号：</td>
				<td>${dormitory.dorno }</td>
			</tr>
			<tr>
				<td>寝室容纳总人数：</td>
				<td>${dormitory.stutotnum }</td>
			</tr>
			<tr>
				<td>寝室已居住人数：</td>
				<td>${dormitory.stulivnum }</td>
			</tr>
		</table>

		<font>寝室入住学生基本信息</font>
		<table style="display: inline-block;">
			<tr>
				<th>学生学号</th>
				<th>学生姓名</th>
				<th>专业班级</th>
				<th>手机号码</th>
				<th>入住时间</th>
				<th>操作</th>
			</tr>
			<tr>
				<td>*</td>
				<td>*</td>
				<td>*</td>
				<td>*</td>
				<td>*</td>
				<td><input type="button" name="" value="退宿"></td>
			</tr>
		</table>
		<br>
		<input type="button" name="" value="学生入住" onclick="window.location.href='student-in.jsp'">
		<font>维修管理</font>
			<input type="button" name="addrepair" value="记录维修信息" onclick="window.location.href='repair-add.jsp'">
			<input type="button" name="lookrepair" value="查看维修信息" onclick="window.location.href='repair-information.jsp'">
		<font>卫生管理</font>
			<input type="button" name="addhygiene" value="记录卫生信息" onclick="window.location.href='hygiene-add.jsp'">
			<input type="button" name="lookhygiene" value="查看卫生信息" onclick="window.location.href='hygiene-information.jsp'">
		<font>费用明细管理</font>
			<input type="button" name="addcost" value="费用充值" onclick="window.location.href='cost-add.jsp'">
			<input type="button" name="lookhygiene" value="查看费用明细" onclick="window.location.href='cost-information.jsp'">
		<font>寝室管理</font>
			<input type="button" name="deleteapart" value="移除寝室">
			<input type="button" name="modifyapart" value="修改寝室基本信息">
	</form>	
	</div>
</body>
</html>
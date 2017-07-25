<%@page import="edu.sas.factory.DAOFactory"%>
<%@page import="edu.sas.vo.Apartment"%>
<%@ page contentType="text/html" pageEncoding="utf-8"%>
<html>
<head>
<title>公寓基本信息</title>
<link rel="stylesheet" href="css/reset.min.css">
<style type="text/css">
	body{
		background: linear-gradient(rgba(38, 172, 217,0.7), rgba(38, 172, 217,0)) no-repeat;
	}
	div{
		text-align:center;
		width:300px;
		height:300px;
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
	#func input{
		background: rgb(38,172,217);
		color: #fff;
	}
</style>
<script type="text/javascript">
	var id = "${sessionScope.userid}"
	if(id == ""){
		alert("你还没有登录，请登录");
		window.location.href="index.jsp";
	}else{
		var permission = '<%=session.getAttribute("permission")%>' ;
		if(permission != '1'){
			//若不是管理员权限，则无法对公寓进行删除操作，即将操作按钮隐藏起来
			document.getElementById("delete_apartment").style.display="none" ; 
			document.getElementById("func").style.display="none" ;
		}
	}
	var info = "${info}";
	if(info != ""){
		alert(info);
	}
</script>
</head>
<body onload="show()">
	<div>
	<font>公寓基本信息</font>
		<table style="display: inline-block;">
			<tr>
				<td>公寓号：</td>
				<td>${apartment.apartno }</td>
			</tr>
			<tr>
				<td>每层寝室数量：</td>
				<td>${apartment.lvdornum }</td>
			</tr>
			<tr>
				<td>公寓层数：</td>
				<td>${apartment.levels }</td>
			</tr>
			<tr>
				<td>公寓容纳总人数：</td>
				<td>${apartment.stutotnum}</td>
			</tr>
			<tr>
				<td>公寓已居住人数：</td>
				<td>${apartment.stulivnum}</td>
			</tr>
			<tr>
				<td>公寓面积：</td>
				<td>${apartment.area}</td>
			</tr>
			<tr id="func">
				<td colspan="2"><input id="delete_apartment" type="button" name="deleteapart" value="移除该公寓" onclick="window.location.href='deleteApartmentServlet?apartno=${apartment.apartno}'"></td>
			</tr>
		</table>
	</div>
</body>
</html>
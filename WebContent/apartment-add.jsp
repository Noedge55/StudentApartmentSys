<%@ page contentType="text/html" pageEncoding="utf-8"%>
<html>
<head>
<title>添加公寓</title>
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
	table{
		margin: 0px auto;
		text-align: center;
	}
	#add{
		background: rgb(38,172,217);
		color: #fff;
	}
</style>
<script type="text/javascript">
	var id = "${sessionScope.userid}"
	if(id == ""){
		alert("你还没有登录，请登录");
		window.location.href="index.jsp";
	}
	var info = "${info}";
	if(info != ""){
		alert(info);
	}
	//验证公寓号的格式是否为："X/D + 数字"
	function validateApartno(value) {
		if(!/(X|D)\d{1,2}$/.test(value)){
			document.getElementById("apartno_msg").innerHTML = "<span style='color:red;'>X</span>"
			return false;
		}else{
			document.getElementById("apartno_msg").innerHTML = "<span style='color:green;'>√</span>"
			return true;
		}
	}
	//验证每层公寓数量是否为数字
	function validateLvdornum(value) {
		if(!/\d+/.test(value)){
			document.getElementById("lvdornum_msg").innerHTML = "<span style='color:red;'>X</span>"
			return false;
		}else{
			document.getElementById("lvdornum_msg").innerHTML = "<span style='color:green;'>√</span>"
			return true;
		}
	}
	//验证楼层数是否为数字
	function validateLevels(value) {
		if(!/\d+/.test(value)){
			document.getElementById("levels_msg").innerHTML = "<span style='color:red;'>X</span>"
			return false;
		}else{
			document.getElementById("levels_msg").innerHTML = "<span style='color:green;'>√</span>"
			return true;
		}
	}
	//验证面积是否为浮点数
	function validateArea(value) {
		if(!/\d+(\.\d+)?$/.test(value)){
			document.getElementById("area_msg").innerHTML = "<span style='color:red;'>X</span>"
			return false;
		}else{
			document.getElementById("area_msg").innerHTML = "<span style='color:green;'>√</span>"
			return true;
		}
	}
	//验证以上操作是否都是true
	function validate(f){
		return validateApartno(f.apartno.value)
			&& validateLvDornum(f.lvdornum.value)
			&& validateArea(f.area.value)
			&& validateLevels(f.levels.value);
	}
</script>
</head>
<body>
	<div>
	<font>添加公寓</font>
	<%--通过onsubmit调用js中 validate方法来判断输入格式是否正确，若正确才能提交 --%>
	<form action="addApartment" method="post" onsubmit="return validate(this)">
	<table>
		<tr>
			<td colspan="3"><span style="font-size: 12px;color: green;">公寓号格式："X/D + 数字" 例如："X1"</span></td>
		</tr>
		<%--通过onblur来调用js函数来验证输入格式是否正确 --%>
		<tr>
			<td>公寓号&nbsp;：</td>
			<td><input type="text" name="apartno" onblur="validateApartno(this.value)"></td>
			<td><span id="apartno_msg">*</span></td>
		</tr>
		<tr>
			<td>每层公寓数量数量：</td>
			<td><input type="text" name="lvdornum" onblur="validateLvdornum(this.value)"></td>
			<td><span id="lvdornum_msg">*</span></td>
		</tr>
		<tr>
			<td>公寓层数：</td>
			<td><input type="text" name="levels" onblur="validateLevels(this.value)"></td>
			<td><span id="levels_msg">*</span></td>
		</tr>
		<tr>
			<td>公寓面积：</td>
			<td><input type="text" name="area" onblur="validateArea(this.value)"></td>
			<td><span id="area_msg">*</span></td>
		</tr>
		<tr>
			<td colspan="3" ><input id="add" type="submit" value="添加公寓"></td>
		</tr>			
	</table>
	</form>	
	</div>
</body>
</html>
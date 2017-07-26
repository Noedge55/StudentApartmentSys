<%@ page contentType="text/html" pageEncoding="utf-8"%>
<html>
<head>
<title>添加学生</title>
<link rel="stylesheet" href="css/reset.min.css">
<style type="text/css">
	body{
		background: linear-gradient(rgba(38, 172, 217,0.7), rgba(38, 172, 217,0)) no-repeat;
	}
	div{
		text-align:center;
		width:400px;
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
		margin:0px auto;
		text-align: center;
		padding: 10px;
	}
	.btn{
		background: rgb(38,172,217);
		color: #fff;
	}
	span{
		display:inline-block;
		width: 120px;
		color: red;
	}
	table tr{
	}
</style>
<script type="text/javascript">
	var id = "<%=session.getAttribute("userid")%>"
	if(id == "null"){
		alert("你还没有登录，请登录");
		window.location.href="index.jsp";
	}
	function validateStuno(value){
		if(!/\d{11}/.test(value)){
			document.getElementById("stuno_msg").innerHTML = "学号为11位数字";
			return false;
		}else{
			document.getElementById("stuno_msg").innerHTML = "";
			return true;
		}
	}
	function validateStuname(value){
		if(value==""){
			document.getElementById("stuname_msg").innerHTML = "姓名不能为空";
			return false;
		}else{
			document.getElementById("stuname_msg").innerHTML = "";
			return true;
		}
	}
	function validateMajor(value){
		if(value==""){
			document.getElementById("major_msg").innerHTML = "专业名不能为空";
			return false;
		}else{
			document.getElementById("major_msg").innerHTML = "";
			return true;
		}
	}
	function validateClassname(value){
		if(value==""){
			document.getElementById("classname_msg").innerHTML = "班级不能为空";
			return false;
		}else{
			document.getElementById("classname_msg").innerHTML = "";
			return true;
		}
	}
	function validatePhonenum(value){
		if(!/^\d*$/.test(value)){
			document.getElementById("phonenum_msg").innerHTML = "手机号必须为数字或者不填";
			return false;
		}else{
			document.getElementById("phonenum_msg").innerHTML = "";
			return true;
		}
	}
	function validate(f){
		return validateStuno(f.stuno.value)     &&
			   validateStuname(f.stuname.value) &&
			   validateMajor(f.major.value)		&&
			   validateClassname(f.classname.value) &&
			   validatePhonenum(f.phonenum.value)	;
	}
</script>
</head>
<body>
	<div>
	<font>添加学生</font>
	<form action="addStudentServlet" method="post" onsubmit="return validate(this)">
	<table>
		<tr>
			<td>学号：</td>
			<td><input type="text" name="stuno" value="<%=request.getParameter("stuno")==null?"":request.getParameter("stuno")%>" onblur="validateStuno(this.value)"></td>
			<td><span id="stuno_msg"></span></td>
		</tr>
		<tr>
			<td>学生姓名：</td>
			<td><input type="text" name="stuname" value="<%=request.getParameter("stuname")==null?"":request.getParameter("stuname")%>" onblur="validateStuname(this.value)"></td>
			<td><span id="stuname_msg"></span></td>
		</tr>
		<tr>
			<td>性别：</td>
			<td><input type="radio" name="sex" value="1" checked="checked">男&nbsp;<input type="radio" name="sex" value="0">女&nbsp;</td>
		</tr>
		<tr>
			<td>专业：</td>
			<td><input type="text" name="major" value="<%=request.getParameter("major")==null?"":request.getParameter("major")%>" onblur="validateMajor(this.value)"></td>
			<td><span id="major_msg"></span></td>
		</tr>
		<tr>
			<td>班级：</td>
			<td><input type="text" name="classname" value="<%=request.getParameter("classname")==null?"":request.getParameter("classname")%>" onblur="validateClassname(this.value)"></td>
			<td><span id="classname_msg"></span></td>
		</tr>
		<tr>
			<td>手机号码：</td>
			<td><input type="text" name="phonenum" value="<%=request.getParameter("phonenum")==null?"":request.getParameter("phonenum")%>" onblur="validatePhonenum(this.value)"></td>	
			<td><span id="phonenum_msg"></span></td>
		</tr>
		<tr>
			<td colspan="3"><input class="btn" type="submit" value="添加学生" ></td>
		</tr>
	</table>
	</form>	
	<form>
		<table>
		<tr>
			<td><input type="file" name="importFromExcel"></td>
			<td><input class="btn" type="submit" value="导入"></td>
		</tr>
		</table>
	</form>
	</div>
</body>
</html>
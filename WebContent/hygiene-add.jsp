<%@ page contentType="text/html" pageEncoding="utf-8"%>
<html>
<head>
<title>添加卫生信息</title>
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
</style>
</head>
<body>
	<div>
	<font>添加卫生信息</font>
	<form action="#" method="post">
		寝室号&nbsp;：<input type="text" name="dorno"><p>
		卫生分数：<input type="text" name="hyscore"><p>
		备&nbsp;注： <input type="text" name="hygienetext"><p>
		检查时间：<input type="date" name="hygienetime"><p>
		<input type="submit" value="添加卫生信息">
	</form>	
	</div>
</body>
</html>
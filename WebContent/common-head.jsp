<%@ page contentType="text/html" pageEncoding="utf-8" %>
<html>
<head>
	<link rel="stylesheet" href="css/head.css">
	<script type="text/javascript">
		function show() {
			var id = "<%=session.getAttribute("userid")%>"
			if(id == "null"){
				document.getElementById("show_login").innerHTML ="<a href=\"login.jsp\">登录</a>";
			}else{
				document.getElementById("show_login").innerHTML = "当前用户为：" + id + " <a href=\"logout.jsp\">注销</a>";
			}
		}
		window.onload=function(){
			show();
		}
		function validateApartment(){
			var id = '<%=session.getAttribute("userid")%>'
			if(id == 'null'){
				alert("还未登录，请登录");
			}else{
				window.location.href='findApartmentServlet';
			}		
		}
		function validateDormitory(){
			var id = '<%=session.getAttribute("userid")%>'
			if(id == 'null'){
				alert("还未登录，请登录");
			}else{
				window.location.href='dormitoryManagerServlet';
			}
		}
		function validateApartStu(){
			var id = '<%=session.getAttribute("userid")%>'
			if(id == 'null'){
				alert("还未登录，请登录");
			}else{
				window.location.href='apartmentStudentServlet';
			}		
		}
		
	</script>
</head>
<body onload="show()">
	<div class="topBar">
			<a href="#" style="margin-left: 10px;">加入收藏</a>
			<div style="display:inline-block; float: right; margin-right: 10px" id="show_login"></div>
	</div>
	<div class="head">
		<div class="headBar">
			<img src="img/logo.png" alt="">
		</div>
		<div>
		<ul class="head-ul">
			<li><input type="button" value="主页" onclick="window.location.href='index.jsp'"></li>
			<li><input type="button" value="公寓管理" onclick="validateApartment()"></li>
			<li><input type="button" value="寝室管理" onclick="validateDormitory()"></li>
			<li><input type="button" value="公寓学生信息表" onclick="validateApartStu()"></li>
		</ul>
		</div>
	</div>
	
</body>
</html>
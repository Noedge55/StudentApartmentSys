<%@ page contentType="text/html" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
<html>
<head>
<title>公寓学生信息表</title>
<link rel="stylesheet" href="css/dormitory-manager.css">
<script type="text/javascript">
	var id = "<%=session.getAttribute("userid")%>"
	if(id == "null"){
		alert("你还没有登录，请登录");
		window.location.href="index.jsp";
	}
	var info = "${info}";
	if(info != ""){
		alert(info);
	}
</script>
<style type="text/css">
table,tr,td{	
	border: solid rgb(0, 172, 230) 1px;
	width:450px;
	margin:0px auto;
	border-radius:6px;
	color: white;
	text-align: center;
}
.function{
	width: 500px;
	margin: 0px auto;
	margin-bottom: 10px;
}
.left_title{
	color:white;
	background: rgb(0,172,230);
	width: 50px;
}
ins{
	text-align: center;
}

</style>
</head>
<body onload="show()">
<div class="container">
	<jsp:include page="common-head.jsp"></jsp:include>
	<div id="show_login" style="text-align: center;"></div>
	<div class="content">
		<div class="left">
			<font class="title">区域</font>
			<ul class="left-ul">
				<li class="left_title">东区</li>
					<ins>
						<ul class="apart_list">
							<c:forEach var="apart" items="${listEast }" varStatus="status">
								<c:if test="${apartno==apart.apartno}">
									<li><a class="actived" href="apartmentStudentServlet?apartno=${apart.apartno }">${apart.apartno }</a></li>									
								</c:if>
								<c:if test="${apartno!=apart.apartno}">
									<li><a class="unactived" href="apartmentStudentServlet?apartno=${apart.apartno }">${apart.apartno }</a></li>									
								</c:if>
							</c:forEach>			
						</ul>	
					</ins>
				<li class="left_title">西区</li>
					<ins>
					<ul>
						<c:forEach var="apart" items="${listWest }" varStatus="status">
								<c:if test="${apartno==apart.apartno}">
									<li><a class="actived" href="apartmentStudentServlet?apartno=${apart.apartno }">${apart.apartno }</a></li>									
								</c:if>
								<c:if test="${apartno!=apart.apartno}">
									<li><a class="unactived" href="apartmentStudentServlet?apartno=${apart.apartno }">${apart.apartno }</a></li>									
								</c:if>
						</c:forEach>
					</ul>
					</ins>
			</ul>
		</div>
		<div class="right">
			<font class="title">西一栋：学生信息</font>
			<div class="function">
				<input type="button" value="添加学生" onclick="window.location.href='student-add.jsp'" id="add_apartment">
				<form action="findApartmentServlet" method="post" style="float: right;">
					<input type="submit" value="查询">
					<input type="text" name="keyword" style="background: #fff;color: #000;" placeholder="输入公寓号">
				</form>
			</div>
			<div style="text-align: center;">
				<table style="display: inline-block;">
					<tr>
						<th>学生学号</th>
						<th>学生名字</th>
						<th>专业班级</th>
						<th>入住寝室</th>
							</tr>
					<tr>
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
					</tr>
				</table>
			</div>
		</div>
	</div>
</div>
</body>
</html>
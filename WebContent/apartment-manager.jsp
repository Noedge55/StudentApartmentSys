<%@page import="edu.sas.vo.Apartment"%>
<%@page import="java.util.List"%>
<%@page import="edu.sas.factory.DAOFactory"%>
<%@ page contentType="text/html" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
<html>
<head>
<title>公寓管理界面</title>
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
</script>
<link rel="stylesheet" href="css/reset.min.css">
<link rel="stylesheet" href="css/apartment-manager.css">
</head>
<body>
<div class="container">
	<jsp:include page="common-head.jsp"></jsp:include>
	<div class="function">
		<input type="button" value="添加公寓" onclick="window.location.href='apartment-add.jsp'" id="add_apartment">
		<form action="findApartmentServlet" method="post" style="float: right;">
			<input type="text" name="keyword" style="background: #fff;color: #000;" placeholder="输入公寓号">
			<input type="submit" value="查询">
		</form>
	</div>
	
	<div class="content">
		<div class="left">
			<font class="title">区域</font>
			<ul class="left-ul">
				<li><a href="findApartmentServlet?keyword=D">东区</a></li>
				<li><a href="findApartmentServlet?keyword=X">西区</a></li>
			</ul>
		</div>
		<div class="right" id="right_apartment">
			<font class="title">公寓号</font>
			<%--通过JSP标签库中的标签，遍历公寓list，将公寓输出出来 --%>
			<table class="list">
				<c:if test="${empty list }">
					<tr><td colspan="4">未查找到公寓</td></tr>
				</c:if>
				<c:if test="${not empty list }">
					<tr>
					<c:forEach items="${list }" var="apartment" varStatus="status">
							<td>
								<img src="img/apartment.png"><p>
								<a href="apartmentInformation?apartno=${apartment.apartno}">${apartment.apartno }</a>
							</td>
							<c:if test="${status.count % 4 == 0 && status.count != fn:length(list)}">
								<tr></tr>
							</c:if>
					</c:forEach>
					</tr>					
				</c:if>
			</table>
		</div>
	</div>
</div>
</body>
</html>
<%@ page contentType="text/html" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
<html>
<head>
<title>寝室管理界面</title>
<link rel="stylesheet" href="css/reset.min.css">
<link rel="stylesheet" href="css/dormitory-manager.css">
<script type="text/javascript">
	var id = "<%=session.getAttribute("userid")%>"
	if(id == "null"){
		alert("你还没有登录，请登录");
		window.location.href="index.jsp";
	}
	function findLevel(){
		var sel = document.getElementById("level_id");
		var selected_val = sel.options[sel.selectedIndex].value;
		window.location.href="DormitoryManagerServlet?pageNow="+selected_val+"&apartno=${apartno}";
	}
</script>
</head>
<body>
<div class="container">
	<jsp:include page="common-head.jsp"></jsp:include>
	<div class="content">
		<div class="left">
			<font class="title">区域</font>
			<ul class="left-ul">
				<li>东区</li>
					<ins>
						<ul class="area_list">
							<c:forEach var="apart" items="${listEast }" varStatus="status">
								<c:if test="${apartno==apart.apartno}">
									<li><a class="actived" href="DormitoryManagerServlet?apartno=${apart.apartno }">${apart.apartno }</a></li>									
								</c:if>
								<c:if test="${apartno!=apart.apartno}">
									<li><a class="unactived" href="DormitoryManagerServlet?apartno=${apart.apartno }">${apart.apartno }</a></li>									
								</c:if>
							</c:forEach>			
						</ul>	
					</ins>
				<li>西区</li>
					<ins>
					<ul class="area_list">
						<c:forEach var="apart" items="${listWest }" varStatus="status">
								<c:if test="${apartno==apart.apartno}">
									<li><a class="actived" href="DormitoryManagerServlet?apartno=${apart.apartno }">${apart.apartno }</a></li>									
								</c:if>
								<c:if test="${apartno!=apart.apartno}">
									<li><a class="unactived" href="DormitoryManagerServlet?apartno=${apart.apartno }">${apart.apartno }</a></li>									
								</c:if>
						</c:forEach>
					</ul>
					</ins>
			</ul>
		</div>
		<div class="right">
			<font class="title">${apartno }栋：寝室号</font>
			<div class="function">
				<div class="level">
						<span style="font-size: 10px;color: red;">选择楼层→</span>
						<select id="level_id" onchange="findLevel()">
							<c:forEach begin="1" end="${pageCount }" varStatus="status">
								<!-- 列表显示楼层 -->
								<option value="${status.count }" <c:if test="${status.count==pageNow }"><c:out value="selected"></c:out></c:if>>${status.count }楼</option>				
							</c:forEach>
						</select>
				</div>
				<form action="DormitoryManagerServlet" style="display: inline-block;float: right;margin-right: 2px;">
					<input type="submit" value="查询" >
					<input type="text" name="keyword" style="background: #fff;color: #000;" placeholder="输入寝室号">
				</form>
			</div>
			
			<table class="list">
				<c:if test="${empty listDormitory }">
					<tr><td colspan="4">未查找到寝室</td></tr>
				</c:if>
				<c:if test="${not empty listDormitory }">
					<tr>
					<c:forEach items="${listDormitory }" var="dormitory" varStatus="status">
							<td>
								<img src="img/dormitory.png"><p>
								<a href="DormitoryInformation?dorno=${dormitory.dorno}">${dormitory.dorno }</a>
							</td>
							<c:if test="${status.count % 4 == 0 && status.count != fn:length(listDormitory)}">
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
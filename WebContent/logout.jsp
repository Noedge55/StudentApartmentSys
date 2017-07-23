<%@ page contentType="text/html" pageEncoding="utf-8"%>
<html>
<body>
	<%
		session.invalidate() ;	// 让session失效
		response.sendRedirect("index.jsp") ;
	%>
</body>
</html>
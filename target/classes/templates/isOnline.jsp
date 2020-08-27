<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
<body>
	<%
		session = request.getSession();
		session.setAttribute("userName", request.getParameter("uName"));
		response.sendRedirect("showOnline.jsp");
	%>
</body>
</html>
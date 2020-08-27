<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
<body>
	<%
		ArrayList showList = (ArrayList) (getServletContext().getAttribute("list"));
		out.print("在线人数 " + showList.size() + "<br>");
		for (int i = 0; i < showList.size(); i++) {
			out.print(showList.get(i) + "在线" + "<br>");
		}
	%>
	<br>
	<a href="index.jsp">退出</a>
</body>
</html>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
<body>
	<%
		session = request.getSession(false);
		if (session != null)
			session.invalidate();
	%>
	<form action="isOnline.jsp" method="post">
		用户名： <input type="text" name="uName" /> <input type="submit"
			value="上线">
</body>
</html>

</body>
</html>
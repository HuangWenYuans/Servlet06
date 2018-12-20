<%@ page contentType="text/html; charset=utf-8" language="java" import="java.io.*,java.util.*" errorPage="" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>request对象的常见方法的应用。</title>
<style>
	@import url('css/style.css');
</style>
</head>
<%
	if (session.getAttribute("username") == null)
		response.sendRedirect("login.jsp?f=2");
%>
<body>

	<div id="main">
		<div id="topDiv">
			<p><b>欢迎使用OA系统</b></p>
			<div id="loginInfo">
				欢迎您，<%=(String)session.getAttribute("username") %>，今天是<%=new Date() %>   
				<a href="logout.jsp" >退出系统</a>
			</div>
		</div>
		<div id="leftDiv">
			<a href="index.jsp">首页</a>
			<ul id="nav">
				<li><a href="page1.jsp">功能页面1</a></li>
				<li><a href="page2.jsp">功能页面2</a></li>
				<li><a href="page3.jsp">功能页面3</a></li>
			</ul>
		</div>
		<div id="rightDiv">
			page1.jsp
		</div>
		<div id="bottomDiv">
			2018 版权所有  
		</div>
	</div>
</body>
</html>
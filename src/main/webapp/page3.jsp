<%--
  Created by IntelliJ IDEA.
  User: name
  Date: 2018/11/25
  Time: 11:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<html>
<head>
    <base href="<%=basePath%>">
    <title>功能页面三</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <a href="index.jsp" class="navbar-brand">首页</a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li><a href="employee/employee_list.jsp">员工管理</a></li>
                <li><a href="/FileList">文件管理</a></li>
                <li class="active"><a href="#">功能页面3</a></li>
            </ul>
        </div>
    </div>
    <a href="logout.jsp " class="btn btn-info btn-md active col-md-offset-11">退出系统</a>
</nav>

<div style="margin-top: 150px">
    <h3>网站正在建设中。。。。</h3>
    <img src="images/build.jpg" style="width: 800px;height: 600px">
</div>

<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="js/bootstrap.js"></script>
</body>
</html>
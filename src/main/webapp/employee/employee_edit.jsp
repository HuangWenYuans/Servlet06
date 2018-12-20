<%@ page contentType="text/html; charset=utf-8" language="java" import="java.io.*,java.sql.*" errorPage="" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>员工信息一览表</title>
    <link rel="stylesheet" href="../css/bootstrap.min.css">

    <style>
        tr {
            line-height: 40px;
        }

        #bottom {
            margin-top: 300px;
            padding: 40px 15px;
            text-align: center;
            position: absolute;
            bottom: 0;
            width: 100%;
            height: 20px;
        }

    </style>


    <script type="text/javascript">
        function ret() {
            history.back(-1);
        }
    </script>
</head>

<body>


<div id="main">
    <div id="topDiv">
        <p><b>欢迎使用OA系统</b></p>
        <div id="loginInfo">
            欢迎您，<%=(String) session.getAttribute("username") %>，今天是<%=new java.util.Date() %>
            第 <%=100 %> 位用户
            <a href="../logout.jsp">退出系统</a>
        </div>
    </div>

    <nav class="navbar navbar-inverse navbar-fixed-top row" role="navigation">
        <div class="container">
            <div class="navbar-header">
                <a href="../index.jsp" class="navbar-brand">首页</a>
            </div>
            <div id="navbar" class="collapse navbar-collapse ">
                <ul class="nav navbar-nav">
                    <li class="active"><a href="/EmployeeList">员工管理</a></li>
                    <li><a href="/FileList">文件管理</a></li>
                    <li><a href="../page3.jsp">功能页面3</a></li>
                </ul>
            </div>
        </div>
        <a href="../logout.jsp " class="btn btn-info btn-md active col-md-offset-11">退出系统</a>
    </nav>

    <div style="margin-top: 85px">
        <h3 style="text-align: center;font-weight: bolder">修改员工信息</h3>
        <form role="form" class="form-group col-md-4 col-md-offset-4" action="/EmployeeEditDo" method="post"
              enctype="multipart/form-data">
            <div class="form-group">
                <label>姓名</label>
                <input type="text" class="form-control" name="name" value="${employee.name}" placeholder="输入姓名">
            </div>

            <div class="form-group">
                <label>请选择您要修改的头像</label>
                <input type="file" name="icon">
                <input type="hidden" name="iconName"value="${employee.icon}" >
            </div>
            <div class="form-group">
                <label>参加工作时间</label>
                <!--显示年月日的日期格式-->
                <input type="date" class="form-control" name="work_date" placeholder="yyyy-mm-dd"
                       value="${employee.work_date}">
                <label>住址</label>
                <input type="text" class="form-control" name="address" value="${employee.address}" placeholder="输入住址">
            </div>

            <div class="form-group">
                <label>所在城市</label>
                <input type="text" class="form-control" name="city" value="${employee.city}" placeholder="输入所在城市">
            </div>
            <input type="hidden" name="id" value="${employee.id}"/>
            <input type="submit" value="  保存 " class="btn btn-info col-md-offset-5"/>
            <input type="button" value=" 返回 " class="btn btn-info col-md-offset-0" onclick="ret()"/>
        </form>
    </div>

    <div id="bottom">&copy2018 版权所有</div>

</div>

<script type="text/javascript" src="../js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="../js/bootstrap.js"></script>
</body>
</html>
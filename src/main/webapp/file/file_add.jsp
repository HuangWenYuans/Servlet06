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


    %>
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
            <a href="logout.jsp">退出系统</a>
        </div>
    </div>

    <nav class="navbar  navbar-inverse navbar-fixed-top row " role="navigation">
        <div class="container">
            <div class="navbar-header">
                <a href="../index.jsp" class="navbar-brand">首页</a>
            </div>
            <div id="navbar" class="collapse navbar-collapse ">
                <ul class="nav navbar-nav">
                    <li><a href="/EmployeeList">员工管理</a></li>
                    <li class="active"><a href="file_list.jsp">文件管理</a></li>
                    <li><a href="../page3.jsp">功能页面3</a></li>
                </ul>
            </div>
        </div>
        <a href="../logout.jsp " class="btn btn-info btn-md active col-md-offset-11">退出系统</a>
    </nav>


    <div style="margin-top: 85px">
        <h3 style="text-align: center;font-weight: bolder">添加文件信息</h3>
        <form role="form" class="form-group col-md-4 col-md-offset-4" action="/FileAddDo" method="post"
              enctype="multipart/form-data">
            <div class="form-group">
                <label>文件标题</label>
                <input type="text" class="form-control" name="title" placeholder="输入文件标题">
            </div>

            <div class="form-group">
                <label>文件内容</label>
                <input type="text" class="form-control" name="content" placeholder="输入文件内容">
            </div>

            <div class="form-group">
                <label>创建时间</label>
                <input type="date" class="form-control" name="create_time" placeholder="yyyy-mm-dd">
            </div>
            <div class="form-group">
                <label>是否置顶</label>
                <br>
                <label class="radio-inline">
                    <input type="radio" name="is_top" value="1"> 是
                </label>
                <label class="radio-inline">
                    <input type="radio" name="is_top" value="0"> 否
                </label>
            </div>
            <div class="form-group">
                <label>附件</label>
                <input type="file" name="attach" >
            </div>
            <div class="form-group">
                <label>发布部门</label>
            </div>
            <select name="source" class="form-control">
                <option value="">请选择</option>
                <option value="党政办">党政办</option>
                <option value="教务处">教务处</option>
                <option value="科技处">科技处</option>
                <option value="组织部">组织部</option>
            </select>

            <input type="submit" value=" 保存 " class="btn btn-info col-md-offset-5"/>
            <input type="button" value=" 返回 " class="btn btn-info col-md-offset-0" onclick="ret()"/>
        </form>
    </div>
    <div id="bottom">&copy;2018 版权所有</div>

</div>

</body>
</html>
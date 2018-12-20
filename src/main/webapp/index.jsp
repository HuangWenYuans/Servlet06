<%@ page contentType="text/html; charset=utf-8" language="java"
         import="java.io.*,java.util.*" errorPage="" %>
<!DOCTYPE html>
<html>
<head>
    <title>首页</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- 引入 Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            padding-top: 50px;
        }

        .starter {
            padding: 40px 15px;
            text-align: center;
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
        function showTime() {
            //创建Date对象
            var today = new Date();
            //分别取出年、月、日、时、分、秒
            var year = today.getFullYear();
            var month = today.getMonth() + 1;
            var day = today.getDate();
            var hours = today.getHours();
            var minutes = today.getMinutes();
            var seconds = today.getSeconds();
            //如果是单个数，则前面补0
            month = month < 10 ? "0" + month : month;
            day = day < 10 ? "0" + day : day;
            hours = hours < 10 ? "0" + hours : hours;
            minutes = minutes < 10 ? "0" + minutes : minutes;
            seconds = seconds < 10 ? "0" + seconds : seconds;

            //构建要输出的字符串
            var str = year + "年" + month + "月" + day + "日 " + hours + ":" + minutes + ":" + seconds;

            //获取id=time的对象
            var obj = document.getElementById("time");
            //将str的内容写入到id=time的<div>中去
            obj.innerHTML = str;
            //延时器,每秒更新
            setTimeout("showTime()", 1000);
        }

    </script>

</head>

<body onload="showTime()">

<nav class="navbar  navbar-inverse navbar-fixed-top row " role="navigation">
    <div class="container">
        <div class="navbar-header">
            <a href="index.jsp" class="navbar-brand">首页</a>
        </div>
        <div id="navbar" class="collapse navbar-collapse ">
            <ul class="nav navbar-nav">
                <li><a href="/EmployeeList">员工管理</a></li>
                <li><a href="/FileList">文件管理</a></li>
                <li><a href="page3.jsp">功能页面3</a></li>
            </ul>
        </div>
    </div>
    <a href="logout.jsp " class="btn btn-info btn-md active col-md-offset-11">退出系统</a>
</nav>


<div class=" container">
    <div class="starter">
        <h1>欢迎使用OA系统</h1>
        <p class="lead">
            欢迎您，<%=(String) session.getAttribute("username")%>
        </p>
        <p class="lead">
            你是今天<span id="time"></span>第<%=100%>位用户
        </p>
    </div>
</div>

<div id="bottom">&copy;2018 版权所有</div>

</body>
</html>
















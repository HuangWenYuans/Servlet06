<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=utf-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>OA登录</title>
    <style type="text/css">
        .select {
            width: 215px;
            height: 30px;
        }

        a {
            text-decoration: none;
        }

        .wangjimima {
            color: lightgrey;
        }

        a:hover {
            color: red;
            text-decoration: underline;
        }

        hr {
            margin-top: 25px;
            margin-bottom: 25px;
        }
    </style>
</head>
<body style="margin:0">

<c:if test="${flag == 1}">
    <script type="text/javascript">
        alert("用户不存在");
    </script>
</c:if>

<c:if test="${flag == 2}">
    <script type="text/javascript">
        alert("密码不正确");
    </script>
</c:if>


<table border="0" width="100%">
    <table width="100%" background="images/header_bg.jpg" style="background-repeat:no-repeat;background-size:100% 100%">
        <tr>
            <td>
                <table width="100%">
                    <tr>
                        <td><img src="images/logo.png"></td>
                        <td width=100>
                            <font size="2">你尚未登录。</font>
                        </td>
                    </tr>
                </table>
            </td>
        </tr>

        <tr>
            <td>
                <table width="65%">
                    <tr height="40">
                        <td width="10" align="center">
                            <font size="4" color="white" face="微软雅黑">首页</font>
                        </td>
                        <td width="10" align="center">
                            <font size="4" color="white" face="微软雅黑">个人资料</font>
                        </td>
                        <td width="10" align="center">
                            <font size="4" color="white" face="微软雅黑">校园网站</font>
                        </td>
                        <td width="10" align="center">
                            <font size="4" color="white" face="微软雅黑">应用系统</font>
                        </td>
                        <td width="10" align="center">
                            <font size="4" color="white" face="微软雅黑">工具软件</font>
                        </td>
                        <td width="10" align="center">
                            <font size="4" color="white" face="微软雅黑">关于</font>
                        </td>
                        <td width="10" align="center">
                            <font size="4" color="white" face="微软雅黑">学校主页</font>
                        </td>
                        <td width="10" align="center">
                            &nbsp;
                        </td>
                    </tr>
                </table>
            </td>
        </tr>
    </table>
    <tr>
        <td>
            <table width="100%" height="450" background="images/oa.jpg"
                   style=" background-repeat:no-repeat;background-size:100% 100%">
                <tr>
                    <td width="60%"></td>
                    <td width="40%">
                        <form method="post" action="login">
                            <table width="400" height="420" background="images/Login.png"
                                   style="background-repeat:no-repeat;background-size:100% 100%">
                                <tr>
                                    <td>
                                        <center><b>用户登录</b></center>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <center>工号:</center>
                                    </td>
                                    <td><input type="text" size="32" name="username" style="height:25px"></td>
                                </tr>
                                <tr>
                                    <td>
                                        <center>密码:</center>
                                    </td>
                                    <td><input type="password" size="32" name="password" style="height:25px"></td>
                                </tr>
                                <tr>
                                    <td>
                                        <center>类型:</center>
                                    </td>
                                    <td><select name="usertype" class="select">
                                        <option>教职工</option>
                                        <option>学生</option>
                                        <option>公共邮箱登陆</option>
                                    </select><img src="images/ask.png"></td>
                                </tr>
                                <tr>
                                    <td></td>
                                    <td><input type="submit" value="登录"
                                               style="background:url(images/login_bg.png);background-size:100% 100%;font-size:larger;color:white;width:120px;height:50px"><a
                                            class="wangjimima"
                                            href="https://passport.nchu.edu.cn/PwdForget/WeChatReset.aspx">&nbsp;&nbsp;忘记密码？</a>
                                    </td>
                                </tr>
                                <tr>
                                    <td><img src="images/lock.png" style="size:100% 100%;width:90px;height:90px"></td>
                                    <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color="grey">如果您输入用户名和密码后，浏览器弹出界面提示"该网站的安全证书有问题"或类似的"安全证书"警告，请点击</font><a
                                            href="http://passport.nchu.edu.cn/cert/"><font
                                            color="red">安装南昌航空大学数字根证书</font></a></td>
                                    <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
                                </tr>
                            </table>
                        </form>
                    </td>
                </tr>
            </table>
        </td>
    </tr>
    <tr>
        <td>
            <hr
            / style="color:lightgrey">
        </td>
    </tr>
    <tr>
        <td>
            <center><font color="darkgrey">© 2017 Powered by 南昌航空大学现代教育技术与信息中心</font></center>
        </td>
    </tr>
</table>
</body>
</html>
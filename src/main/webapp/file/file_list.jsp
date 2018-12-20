<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=utf-8" language="java"
         import="java.io.*,java.sql.*" errorPage="" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>文件信息一览表</title>

    <link rel="stylesheet" href="../css/bootstrap.min.css">
    <script type="text/javascript" src="../js/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="../js/bootstrap.js"></script>
    <style type="text/css">

        #bottom {
            bottom: -20px;
            padding: 20px auto;
            text-align: center;
            position: absolute;
            width: 100%;
            height: 20px;
        }

        body {
            position: relative;
        }

        th {
            text-align: center;
        }

    </style>
    <script type="text/javascript">
        function add() {
            window.location.href = "/FileAdd";
        }

    </script>


</head>

<body>

<%--定义导航栏--%>
<div class="container">
    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
        <div class="container">
            <div class="navbar-header">
                <a href="../index.jsp" class="navbar-brand">首页</a>
            </div>
            <div id="navbar" class="collapse navbar-collapse">
                <ul class="nav navbar-nav">
                    <li><a href="/EmployeeList">员工管理</a></li>
                    <li class="active"><a href="/FileList">文件管理</a></li>
                    <li><a href="../page3.jsp">功能页面3</a></li>
                </ul>
            </div>
        </div>
        <a href="../logout.jsp " class="btn btn-info btn-md active col-md-offset-11">退出系统</a>
    </nav>

    <div id="searchBox" style="margin-top: 85px">
        <form name="frm" role="form" action="/FileList">
            <div class="row col-md-offset-2">
                <div class="input-group input-group-sm col-md-3" style="margin-top: 20px">
                    <span class="input-group-addon">标题:</span>
                    <input type="text" class="form-control" name="title" value="${title}">
                </div>
                <div class="input-group input-group-sm col-md-3" style="margin-top: 20px">
                    <span class="input-group-addon">来源:</span>
                    <input type="text" class="form-control" name="source"
                           value="${source}">
                </div>
                <div class="input-group input-group-sm col-md-3" style="margin-top: 20px">
                    <span class="input-group-addon">起始时间:</span>
                    <input type="text" class="form-control" name="create_time"
                           value="${create_time}">
                </div>
            </div>
            <input type="submit" class="btn btn-mid btn-info col-md-offset-3" style="margin-top: 20px" value="查找 "/>
            <input type="hidden" name="cur_page" value="1">
            <!-- 增加隐藏变量，记录当前页码 -->
        </form>

        <div class="col-md-offset-11">
            <input type="button" class="btn btn-sm btn-info " value=" 添加文件 "
                   onclick="add()"/>
        </div>


        <table width="100%" class="table  table-bordered table-hover" style="text-align: center">
            <tr>
                <th>序号</th>
                <th>文件标题</th>
                <th>文件内容</th>
                <th>创建时间</th>
                <th>是否置顶</th>
                <th>阅读次数</th>
                <th>发布部门</th>
                <th>附件</th>
                <th>操作</th>
            </tr>
            <c:forEach items="${pageInfo.list}" var="file">
            <tr>
                <td>${file.id}</td>
                <td>${file.title}</td>
                <td>${file.content}</td>
                <td>${file.create_time}</td>
                <td>${file.is_top == 1 ? "是" :"否"}</td>
                <td>${file.read_count}</td>
                <td>${file.source}</td>
                <td>
                    <c:choose>
                        <c:when test="${file.attach != null}">
                            <a href="/FileDownload?name=${file.attach}">点击下载</a>
                        </c:when>
                        <c:otherwise>
                            无
                        </c:otherwise>
                    </c:choose>

                </td>
                <td>
                    <a href="/FileEdit?id=${file.id}" class="btn btn-info btn-md active" role="button">修改</a>
                    <a onclick="javascript:var flag = window.confirm('确定要删除吗？') ;if (flag){window.location.href = '/FileDelete?id=${file.id}'} "
                       class="btn btn-info btn-md active" role="button">删除</a>
                </td>
                </c:forEach>
            </tr>
        </table>

        <div align="center">
            <label>共${pageInfo.pageCount}页${pageInfo.recordCount}条数据</label>
            <nav>
                <ul class="pagination pagination ">
                    <c:choose>
                        <c:when test="${pageInfo.pageNumber>1}">
                            <li>
                                <a href="/FileList?pageNumber=${pageInfo.pageNumber-1}&pageSize=${pageInfo.pageSize}"
                                   aria-label="Previous">
                                    <span aria-hidden="true">&laquo;</span>
                                </a>
                            </li>
                        </c:when>
                        <c:otherwise>
                            <li class="disabled">
                                <a aria-label="Previous">
                                    <span aria-hidden="true">&laquo;</span>
                                </a>
                            </li>
                        </c:otherwise>
                    </c:choose>
                    <c:forEach var="currentPage" begin="1" end="${pageInfo.pageCount}">
                        <c:choose>
                            <c:when test="${pageInfo.pageNumber == currentPage}">
                                <li class="active">
                                    <a href="/FileList?pageNumber=${currentPage}&pageSize=${pageInfo.pageSize}">${currentPage}</a>
                                </li>
                            </c:when>
                            <c:otherwise>
                                <li>
                                    <a href="/FileList?pageNumber=${currentPage}&pageSize=${pageInfo.pageSize}">${currentPage}</a>
                                </li>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>

                    <c:choose>
                        <c:when test="${pageInfo.pageNumber < pageInfo.pageCount}">
                            <li>
                                <a href="/FileList?pageNumber=${pageInfo.pageNumber+1}&pageSize=${pageInfo.pageSize}"
                                   aria-label="Next">
                                    <span aria-hidden="true">&raquo;</span>
                                </a>
                            </li>
                        </c:when>
                        <c:otherwise>
                            <li class="disabled">
                                <a aria-label="Next">
                                    <span aria-hidden="true">&raquo;</span>
                                </a>
                            </li>
                        </c:otherwise>
                    </c:choose>
                </ul>
            </nav>
        </div>
    </div>
</div>

<div id="bottom">&copy;2018 版权所有</div>
</div>


</body>
</html>
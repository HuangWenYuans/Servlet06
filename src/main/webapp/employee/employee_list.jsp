<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=utf-8" language="java"
         import="java.io.*,java.sql.*" errorPage="" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>员工信息一览表</title>

    <link rel="stylesheet" href="../css/bootstrap.min.css">

    <style type="text/css">

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
                    <li class="active"><a href="/EmployeeList">员工管理</a></li>
                    <li><a href="/FileList">文件管理</a></li>
                    <li><a href="../page3.jsp">功能页面3</a></li>
                </ul>
            </div>
        </div>
        <a href="../logout.jsp " class="btn btn-info btn-md active col-md-offset-11">退出系统</a>
    </nav>

    <div id="searchBox" style="margin-top: 85px">
        <form name="frm" role="form" action="/EmployeeList">
            <div class="row col-md-offset-2">
                <div class="input-group input-group-sm col-md-3" style="margin-top: 20px">
                    <span class="input-group-addon">姓名:</span>
                    <input type="text" class="form-control" name="name" value="${name}"/>
                </div>
            </div>
            <div class="row col-md-offset-2" style="margin-top: 10px">
                <label class=""> 所在城市：</label>
                <select name="city" class="form-control">
                    <option value="">请选择</option>
                    <%--<option value="南昌" <%=("南昌".equals(city) ? "selected" : "")%>>南昌</option>--%>
                    <option value="南昌" ${city == "南昌" ? "selected" : ''}>南昌</option>
                    <option value="成都" ${city == "成都" ? "selected" : ''}>成都</option>
                    <option value="北京" ${city == "北京" ? "selected" : ''}>北京</option>
                    <option value="杭州" ${city == "杭州" ? "selected" : ''}>杭州</option>
                    <option value="深圳" ${city == "深圳" ? "selected" : ''}>深圳</option>
                    <option value="武汉" ${city == "武汉" ? "selected" : ''}>武汉</option>
                    <option value="长沙" ${city == "长沙" ? "selected" : ''}>长沙</option>
                </select>

                <input type="submit" class="btn btn-mid btn-info col-md-offset-2" value="查找 "/>
            </div>
        </form>


        <div class="col-md-offset-11">
            <input type="button" class="btn btn-sm btn-info " value=" 新增员工 "
                   onclick="add()"/>
        </div>

        <table width="100%" class="table  table-bordered table-hover">
            <tr>
                <th>序号</th>
                <th>头像</th>
                <th>姓名</th>
                <th>参加工作日期</th>
                <th>住址</th>
                <th>所在城市</th>
                <th>操作</th>
            </tr>
            <c:forEach items="${pageInfo.list}" var="employee">
            <tr>
                <td>${employee.id}</td>
                <td>
                    <c:choose>
                        <c:when test="${employee.icon != null}">
                            <img src="/employeeIcon/${employee.icon}" width="60" height="60" alt="用户头像">
                        </c:when>
                        <c:otherwise>
                            未上传
                        </c:otherwise>
                    </c:choose>
                </td>

                <td>${employee.name}</td>
                <td>${employee.work_date}</td>
                <td>${employee.address}</td>
                <td>${employee.city}</td>
                <td>
                    <a href="/EmployeeEdit?id=${employee.id}" class="btn btn-info btn-md active" role="button">修改</a>
                    <a onclick="javascript:var flag = window.confirm('确定要删除吗？') ;if (flag){window.location.href = '/EmployeeDelete?id=${employee.id}'} "
                       class="btn btn-info btn-md active" role="button">删除</a>
                </td>
                </c:forEach>
            </tr>
        </table>
    </div>
</div>


<div align="center">
    <label>共${pageInfo.pageCount}页${pageInfo.recordCount}条数据</label>
    <nav>
        <ul class="pagination pagination ">
            <c:choose>
                <c:when test="${pageInfo.pageNumber>1}">
                    <li>
                        <a href="/EmployeeList?pageNumber=${pageInfo.pageNumber-1}&pageSize=${pageInfo.pageSize}"
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
                            <a href="/EmployeeList?pageNumber=${currentPage}&pageSize=${pageInfo.pageSize}">${currentPage}</a>
                        </li>
                    </c:when>
                    <c:otherwise>
                        <li>
                            <a href="/EmployeeList?pageNumber=${currentPage}&pageSize=${pageInfo.pageSize}">${currentPage}</a>
                        </li>
                    </c:otherwise>
                </c:choose>
            </c:forEach>

            <c:choose>
                <c:when test="${pageInfo.pageNumber < pageInfo.pageCount}">
                    <li>
                        <a href="/EmployeeList?pageNumber=${pageInfo.pageNumber+1}&pageSize=${pageInfo.pageSize}"
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

<div id="bottom">&copy2018 版权所有</div>
<script type="text/javascript">
    function add() {
        window.location.href = '/EmployeeAdd';
    }
</script>
<script type="text/javascript" src="../js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="../js/bootstrap.js"></script>
</body>
</html>
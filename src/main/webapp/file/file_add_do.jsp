<%@ page contentType="text/html; charset=utf-8" language="java" import="java.io.*,java.sql.*" errorPage="" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title></title>
</head>

<body>
<%
    request.setCharacterEncoding("utf-8");
    response.setContentType("text/html;charset=utf-8");

    String title = request.getParameter("title"); // 文件标题
    String content = request.getParameter("content"); // 文件内容
    String create_time = request.getParameter("create_time"); // 创建时间
    int is_top = Integer.parseInt(request.getParameter("is_top"));//是否置顶
    String source = request.getParameter("source"); // 创建部门
    int read_count = 0;

    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
    String url = "jdbc:sqlserver://localhost:1433;DatabaseName=oa";
    Connection conn = DriverManager.getConnection(url, "user", "user");

    if (conn != null) {
        String sql = "insert into TFile(title,content,create_time,is_top,read_count,source) values(?, ?,?, ?,?,?);";
        PreparedStatement pstmt = conn.prepareStatement(sql);

        pstmt.setString(1, title);
        pstmt.setString(2, content);
        pstmt.setString(3, create_time);
        pstmt.setInt(4, is_top);
        pstmt.setInt(5, read_count);
        pstmt.setString(6, source);

        int result = pstmt.executeUpdate();
        System.out.println("result:" + result);
        if (result > 0) {
            //out.println("数据添加成功！");
            //out.println("<a href=''>返回列表</a>");
%>
<script type="text/javascript">
    window.alert("数据添加成功！");
    window.location.href = "file_list.jsp";
</script>

<%
        } else {
            out.println("数据添加失败！！！！！！");
        }
    } else {
        out.println("<font color='red'>数据库连接有问题，请查阅日志</font>");
    }
	/*
	if ( password.equals("666666")
		&& type.equals("教职工")) {
		out.println("登录成功，用户类型：" + type + "，欢迎您 " + id);
		session.setAttribute("username", id);
		response.sendRedirect("index.jsp");
	} else {
		out.println("登录失败！");
		response.sendRedirect("login.jsp?f=1");
	}
	*/
%>
</body>
</html>

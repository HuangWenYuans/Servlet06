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

    int id = Integer.parseInt(request.getParameter("id"));
    String title = request.getParameter("title"); // 文件标题
    String content = request.getParameter("content"); // 文件内容
    String create_time = request.getParameter("create_time"); // 创建时间
    int is_top = Integer.parseInt(request.getParameter("is_top")); //是否置顶
    String read_count = request.getParameter("read_count"); //阅读数量
    String source = request.getParameter("source");//发布部门


    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
    String url = "jdbc:sqlserver://localhost:1433;DatabaseName=oa";
    Connection conn = DriverManager.getConnection(url, "user", "user");

    if (conn != null) {
        String sql = "update TFile set title = ?, content = ?, create_time = ?, is_top = ?,source = ? where id = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, title);
        pstmt.setString(2, content);
        pstmt.setString(3, create_time);
        pstmt.setInt(4, is_top);
        pstmt.setString(5, source);
        pstmt.setInt(6, id);
        int result = pstmt.executeUpdate();
        System.out.println("result:" + result);
        if (result > 0) {
            //out.println("数据添加成功！");
            //out.println("<a href=''>返回列表</a>");
%>
<script type="text/javascript">
    window.alert("数据修改成功！");
    window.location.href = "/FileList";
</script>
<%
        } else {
            out.println("数据修改失败！！！！！！");
        }
    } else {
        out.println("<font color='red'>数据库连接有问题，请查阅日志</font>");
    }
%>
</body>
</html>
<%@ page contentType="text/html; charset=utf-8" language="java" import="java.io.*,java.sql.*" errorPage="" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>request对象的常见方法的应用。</title>
</head>
<body>

<%
    request.setCharacterEncoding("utf-8");
    response.setContentType("text/html;charset=utf-8");

    Integer id = Integer.parseInt(request.getParameter("id"));//获取到要删除的文件的id
    out.print(id);
    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
    String url = "jdbc:sqlserver://localhost:1433;DatabaseName=oa";
    Connection conn = DriverManager.getConnection(url, "user", "user");

    if (conn != null) {
        String sql = "delete from TFile where id = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, id);

        int result = pstmt.executeUpdate();
        System.out.println("result:" + result);
        if (result > 0) {
            //out.println("数据添加成功！");
            //out.println("<a href=''>返回列表</a>");
%>
<script type="text/javascript">
    window.alert("删除成功！");
    window.location.href = "file_list.jsp";
</script>
<%
        } else {
            out.println("删除失败！！！！！！");
        }
    } else {
        out.println("<font color='red'>数据库连接有问题，请查阅日志</font>");
    }
%>
</body>
</html>
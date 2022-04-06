<%--
  Created by IntelliJ IDEA.
  User: yurui
  Date: 2022/4/3
  Time: 16:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Change</title>
</head>
<body>
    <%
        String url = request.getHeader("referer");
        out.println(url);
        if (url.equals("http://localhost:8080/")||url.equals("http://localhost:8080/index.html")) {
            response.sendRedirect("index_c.html");
        }else {
            response.sendRedirect("index.html");
        }
    %>
</body>
</html>

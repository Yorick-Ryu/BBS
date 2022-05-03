<%--
  Created by IntelliJ IDEA.
  User: yurui
  Date: 2022/4/27
  Time: 10:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>BBS_Login_Success</title>
</head>
<body>
<jsp:useBean id="count" class="note.util.ComputerCount" ></jsp:useBean>
<h1>登录成功</h1><br/>
<p>您是第<jsp:getProperty name="count" property="number"></jsp:getProperty>位访问本站的用户</p>
<a href="list_note.jsp">进入留言板</a>

</body>
</html>

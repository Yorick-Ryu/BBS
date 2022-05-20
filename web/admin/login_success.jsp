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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap-5.1.3-dist/css/bootstrap.css">
    <script src="${pageContext.request.contextPath}/bootstrap-5.1.3-dist/js/bootstrap.bundle.js"></script>
    <style>
        #main {
            text-align: center;
            margin: 100px auto;
        }
    </style>
</head>
<body>
<jsp:useBean id="count" class="note.util.ComputerCount"></jsp:useBean>
<div class="container" id="main">
    <h1>登录成功</h1><br/>
    <div class="lead">您是第
        <jsp:getProperty name="count" property="number"></jsp:getProperty>
        位访问本站的管理员</div>
    <br/>
    <a href="admin/userManager.jsp">
        <button class="btn btn-primary" type="button">进入用户管理</button>
    </a>
</div>
<%@ include file="/foot.jsp"%>
</body>
</html>

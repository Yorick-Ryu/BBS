<%@ page import="note.vo.User" %><%--
  Created by IntelliJ IDEA.
  User: yurui
  Date: 2022/5/17
  Time: 22:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>留言板——写留言</title>
    <link rel="stylesheet" href="bootstrap-5.1.3-dist/css/bootstrap.css">
    <script src="bootstrap-5.1.3-dist/js/bootstrap.bundle.js"></script>
</head>
<body>
<%User user = (User) session.getAttribute("user");%>
<nav class="navbar navbar-expand-lg navbar-light bg-light" style="background-color: #e3f2fd;">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">
            <img src="<%=user.getImage()%>" alt="" width="30" height="30" class="d-inline-block align-text-top">
            留言板
        </a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/list_note.jsp">主页</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" href="${pageContext.request.contextPath}/note.jsp">写留言</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/admin/userManager.jsp">用户管理</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/upload.jsp">修改头像</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/index.html">登录&注册</a>
                </li>
            </ul>
        </div>
    </div>
</nav>
<div class="container-sm">
    <br/>
    <h2 align="center">写留言</h2>
    <form name="form2" action="/AddNoteServlet" method='post'>
        <div class="mb-3">
            <label for="exampleFormControlInput1" class="form-label">标题</label>
            <input type="text" name="title" class="form-control" id="exampleFormControlInput1" placeholder="输入标题">
        </div>
        <div class="mb-3">
            <label for="exampleFormControlTextarea1" class="form-label">内容</label>
            <textarea name="note" class="form-control" id="exampleFormControlTextarea1" rows="3"></textarea>
        </div>
        <input class="btn btn-primary" type="submit" value="提交">
    </form>
</div>

</body>
</html>

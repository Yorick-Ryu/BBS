<%@ page import="note.vo.User" %><%--
  Created by IntelliJ IDEA.
  User: yurui
  Date: 2022/5/16
  Time: 19:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>上传图片</title>
    <link rel="stylesheet" href="bootstrap-5.1.3-dist/css/bootstrap.css">
    <script src="bootstrap-5.1.3-dist/js/bootstrap.bundle.js"></script>
    <style>
        main {
            width: 300px;
            text-align: center;
            margin: 100px auto;
        }
    </style>
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
                    <a class="nav-link" href="${pageContext.request.contextPath}/note.jsp">写留言</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/admin/userManager.jsp">用户管理</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" href="${pageContext.request.contextPath}/upload.jsp">修改头像</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/index.html">登录&注册</a>
                </li>
            </ul>
        </div>
    </div>
</nav>
<main>

    <h2>上传头像</h2>

    <br>

    <div class="input-group">
        <form action="UploadServlet" method="post"
              enctype="multipart/form-data">
            <input type="file" name="icon" class="form-control" id="inputGroupFile04"
                   aria-describedby="inputGroupFileAddon04" aria-label="Upload"><br/>
            <button class="btn btn-outline-primary" type="submit" id="inputGroupFileAddon04">上传</button>
        </form>
    </div>

</main>

<%--<form action="UploadServlet" method="post"--%>
<%--      enctype="multipart/form-data">--%>
<%--    <table width="600px">--%>
<%--        <tr>--%>
<%--            <td>上传者</td>--%>
<%--            <td><input type="text" name="name" /></td>--%>
<%--        </tr>--%>
<%--        <tr>--%>
<%--            <td>上传文件</td>--%>
<%--            <td><input type="file" name="icon" /></td>--%>
<%--        </tr>--%>
<%--        <tr>--%>
<%--            <td colspan="2"><input type="submit" value="上传" /></td>--%>
<%--        </tr>--%>
<%--    </table>--%>
<%--</form>--%>
<%@ include file="foot.jsp" %>
</body>
</html>

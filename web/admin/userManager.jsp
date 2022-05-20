<%@ page import="java.util.List" %>
<%@ page import="note.vo.User" %>
<%@ page import="note.service.UserService" %>
<%@ page import="note.service.impl.UserServiceImpl" %>
<%@ page import="java.util.Set" %>
<%@ page import="java.util.HashSet" %><%--
  Created by IntelliJ IDEA.
  User: yurui
  Date: 2022/5/4
  Time: 11:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>UserManager</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap-5.1.3-dist/css/bootstrap.css">
    <script src="${pageContext.request.contextPath}/bootstrap-5.1.3-dist/js/bootstrap.bundle.js"></script>
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
                    <a class="nav-link active" href="#">用户管理</a>
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
<div style="text-align: center;">
    <h2>用户管理</h2>
    <%
        Set<String> onlineUsers = new HashSet<>();
        onlineUsers = (Set<String>) request.getSession().getAttribute("online");
    %>
    <p class="lead">当前在线用户：
        <%
            for (String users : onlineUsers) {
                out.write(users + " ");
            }
        %></p>
    <table class="table align-middle table-striped table-hover table-bordered">
        <tr>
            <th>用户ID</th>
            <th>用户名</th>
            <th>密码</th>
            <th>邮箱</th>
            <th>管理员</th>
            <th>操作</th>
        </tr>

        <%
            List<User> users = null;
            UserService userService = new UserServiceImpl();
            users = userService.queryAll();
            for (User n : users) {
        %>
        <tr>
            <td><%=n.getId()%>
            </td>
            <td><%=n.getName()%>
            </td>
            <td><%=n.getPassword()%>
            </td>
            <td><%=n.getEmail()%>
            </td>
            <td><%=n.getFlag()%>
            </td>
            <td>
                <button class="btn btn-primary btn-sm" data-bs-toggle="modal" data-bs-target="#exampleModal<%=n.getId()%>">
                    删除
                </button>
                <!-- Modal -->
                <div class="modal fade" id="exampleModal<%=n.getId()%>" tabindex="-1" aria-labelledby="exampleModalLabel"
                     aria-hidden="true">
                    <div class="modal-dialog modal-dialog-centered">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="exampleModalLabel">提示</h5>
                                <button type="button" class="btn-close" data-bs-dismiss="modal"
                                        aria-label="Close"></button>
                            </div>
                            <div class="modal-body">
                                确定删除此用户吗？
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">否</button>
                                <button type="button" class="btn btn-primary" onclick="window.location.href='/DeleteServlet?type=user&id=<%=n.getId()%>'">是</button>
                            </div>
                        </div>
                    </div>
                </div>
            </td>
        </tr>
        <%
            }
        %>
    </table>
</div>
<%@ include file="/foot.jsp"%>
</body>
</html>

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
</head>
<body>
<div style="text-align: center;">
    <h3>用户管理</h3>
    <%
        Set<String> onlineUsers = new HashSet<>();
        onlineUsers = (Set<String>) request.getSession().getAttribute("online");
    %>
    当前在线用户：
    <%
        for (String user : onlineUsers) {
            out.write(user+" ");
        }
    %>
    <table width="80%" border=1 cellspacing="0" align="center">
        <tr>
            <td><span style="font-size: x-small; color: #0000FF; ">用户ID</span></td>
            <td><span style="font-size: x-small; color: #0000FF; ">用户名</span></td>
            <td><span style="font-size: x-small; color: #0000FF; ">密码</span></td>
            <td><span style="font-size: x-small; color: #0000FF; ">邮箱</span></td>
            <td><span style="font-size: x-small; color: #0000FF; ">管理员</span></td>
            <td><span style="font-size: x-small; color: #0000FF; ">删除</span></td>
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
                <a href="#"
                   onclick="window.confirm('确定删除吗？')?this.href='/DeleteServlet?type=user&id=<%=n.getId()%>':this.href='javascript:void()';">
                    删除</a>
            </td>
        </tr>
        <%
            }
        %>
    </table>
</div>
</body>
</html>

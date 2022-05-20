<%@ page import="note.service.NoteService" %>
<%@ page import="note.service.impl.NoteServiceImpl" %>
<%@ page import="note.vo.Note" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.List" %>
<%@ page import="note.util.SplitPage" %>
<%@ page import="note.vo.User" %>
<%--
  Created by IntelliJ IDEA.
  User: yurui
  Date: 2022/4/27
  Time: 11:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List_Note</title>
    <link rel="stylesheet" href="bootstrap-5.1.3-dist/css/bootstrap.css">
    <script src="bootstrap-5.1.3-dist/js/bootstrap.bundle.js"></script>
    <script type="text/javascript">
        function go() {
            const goPage = document.all.selectpage.value;
            document.open("list_note.jsp?flag=" + goPage, "_self", "");
        }
    </script>
</head>
<body>
<jsp:useBean id="spage" class="note.util.SplitPage" scope="session"></jsp:useBean>
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
                    <a class="nav-link active" href="${pageContext.request.contextPath}/list_note.jsp">主页</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/note.jsp">写留言</a>
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
            <form class="d-flex" role="search" name="form1" method="post" action="list_note.jsp?flag=first">
                <input class="form-control me-2" type="search" placeholder="" aria-label="Search">
                <button class="btn btn-sm btn-outline-success" type="submit">Search</button>
            </form>
        </div>
    </div>
</nav>
<%--    <form name="form1" method="post" action="list_note.jsp?flag=first">--%>
<%--        <table width="500" border="0" align="center">--%>
<%--            <tr>--%>
<%--                <td>在 <select name="item">--%>
<%--                    <option value="title">标题</option>--%>
<%--                    <option value="author">作者</option>--%>
<%--                    <option value="content">内容</option>--%>
<%--                </select> 中查询:--%>
<%--                    <input type="text" name="content">--%>
<%--                    <input type="submit" name="submit" value="搜索"></td>--%>
<%--            </tr>--%>
<%--        </table>--%>
<%--    </form>--%>


<%
    NoteService note = new NoteServiceImpl();
    String flag = request.getParameter("flag");//翻页时的方向值,即SplitPage中请求标识参数
    //每次刷新页面时都应当重新获得表中的记录数, 因为翻页过程中表的记录可能随时都会更新
    int totalRows = 0;//总的记录数
%>

<div class="table-responsive">
    <table class="table align-middle table-striped table-hover table-bordered">
        <tr>
            <th scope="col">ID</th>
            <th scope="col">标题</th>
            <th scope="col">作者</th>
            <th scope="col">内容</th>
            <th scope="col">操作</th>
        </tr>
        <%
            //翻页查询时需要传递翻页对象,翻页对象保存在session中
            request.setCharacterEncoding("utf-8");
            String strItem = request.getParameter("item");
            String strContent = request.getParameter("content");
            List<Note> list = null;
            HashMap<String, String> tm = new HashMap();
            try {
                //判断是否用了搜索
                if (strContent == null || strContent.equals("") || strContent.equals("null")) {
                    totalRows = note.getRows(strItem, strContent);//总的记录数
                    spage.setTotalRows(totalRows);
                    //重新计算确定当前要显示的页面值,实现翻页
                    spage.confirmPage(flag);
                    list = note.findAll(spage);
                } else {
                    tm.put(strItem, strContent);
                    totalRows = note.getRows(strItem, strContent);//总的记录数
                    spage.setTotalRows(totalRows);
                    //重新计算确定当前要显示的页面值,实现翻页
                    spage.confirmPage(flag);
                    list = note.queryByLike(strItem, strContent, spage);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            for (Note n : list) {
        %>
        <tr>
            <td><%=n.getId()%>
            </td>
            <td><%=n.getTitle()%>
            </td>
            <td><%=n.getAuthor()%>
            </td>
            <td><%=n.getContent()%>
            </td>
            <td>
                <button class="btn btn-primary btn-sm" data-bs-toggle="modal"
                        data-bs-target="#exampleModal<%=n.getId()%>">
                    <%--                            onclick="window.confirm('确定删除吗？')?this.href='/DeleteServlet?type=note&id=<%=n.getId()%>':this.href='javascript:void()';">--%>
                    删除
                </button>
                <!-- Modal -->
                <div class="modal fade" id="exampleModal<%=n.getId()%>" tabindex="-1"
                     aria-labelledby="exampleModalLabel"
                     aria-hidden="true">
                    <div class="modal-dialog modal-dialog-centered">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="exampleModalLabel">删除留言</h5>
                                <button type="button" class="btn-close" data-bs-dismiss="modal"
                                        aria-label="Close"></button>
                            </div>
                            <div class="modal-body">
                                确定删除此留言吗？
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">取消</button>
                                <button type="button" class="btn btn-primary"
                                        onclick="window.location.href='/DeleteServlet?type=note&id=<%=n.getId()%>'">确定
                                </button>
                            </div>
                        </div>
                    </div>
                </div>
                <button class="btn btn-primary btn-sm" data-bs-toggle="modal"
                        data-bs-target="#exampleModalUP<%=n.getId()%>">
                    <%--                            onclick="window.confirm('确定删除吗？')?this.href='/DeleteServlet?type=note&id=<%=n.getId()%>':this.href='javascript:void()';">--%>
                    修改
                </button>
                <!-- Modal -->
                <div class="modal fade" id="exampleModalUP<%=n.getId()%>" tabindex="-1"
                     aria-labelledby="exampleModalLabel"
                     aria-hidden="true">
                    <div class="modal-dialog modal-dialog-centered">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="exampleModalLabelUP">修改留言</h5>
                                <button type="button" class="btn-close" data-bs-dismiss="modal"
                                        aria-label="Close"></button>
                            </div>
                            <form id="form" action="UpdateServlet" method="post">
                                <div class="modal-body">
                                    <div class="mb-3">
                                        <label for="recipient-name" class="col-form-label">标题：</label>
                                        <input type="number" name="id" value="<%=n.getId()%>" style="display: none">
                                        <input type="text" class="form-control" id="recipient-name" name="title"
                                               value="<%=n.getTitle()%>">
                                    </div>
                                    <div class="mb-3">
                                        <label for="message-text" class="col-form-label">内容：</label>
                                        <textarea class="form-control" id="message-text"
                                                  name="content"><%=n.getContent()%></textarea>
                                    </div>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">取消</button>
                                    <button type="submit" class="btn btn-primary">提交</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </td>
        </tr>
        <%
            }
        %>

        <tr>
            <td colspan="5" align="center">
                <a href="list_note.jsp?flag=<%=SplitPage.FIRSTPAGE%>&item=<%=strItem%>&content=<%=strContent%>">
                    <button type="button" class="btn btn-primary btn-sm">首页</button>
                </a>
                <a href="list_note.jsp?flag=<%=SplitPage.PREVIOUSEPAGE%>&item=<%=strItem%>&content=<%=strContent%>">
                    <button type="button" class="btn btn-primary btn-sm">上一页</button>
                </a>
                <a href="list_note.jsp?flag=<%=SplitPage.NEXTPAGE%>&item=<%=strItem%>&content=<%=strContent%>">
                    <button type="button" class="btn btn-primary btn-sm">下一页</button>
                </a>
                <a href="list_note.jsp?flag=<%=SplitPage.LASTPAGE%>&item=<%=strItem%>&content=<%=strContent%>">
                    <button type="button" class="btn btn-primary btn-sm">尾页</button>
                </a>
                <select id="selectpage" name="goPage" onchange="go();"
                        class="btn btn-primary dropdown-toggle btn-sm">
                    <%
                        for (int i = 1; i <= spage.getTotalPages(); i++) {
                    %>
                    <option value="<%=i%>"
                        <%=(spage.getCurrentPage() == +i) ?"selected='selected'": ""%>><%=i%>/<%=spage.getTotalPages()%>
                            <%
                    }
                %>
                </select>
            </td>
        </tr>
    </table>
</div>

<%@ include file="foot.jsp"%>

</body>
</html>
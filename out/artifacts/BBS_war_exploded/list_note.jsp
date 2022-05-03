<%@ page import="note.service.NoteService" %>
<%@ page import="note.service.impl.NoteServiceImpl" %>
<%@ page import="note.vo.Note" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.List" %>
<%@ page import="note.util.SplitPage" %>
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
    <script type="text/javascript">
        function go() {
            const goPage = document.all.selectpage.value;
            alert("我们将去页面:list_note.jsp?flag=" + goPage);
            document.open("list_note.jsp?flag=" + goPage, "_self", "");
        }
    </script>
</head>
<body>
<jsp:useBean id="spage" class="note.util.SplitPage" scope="session"></jsp:useBean>
<div style="text-align: center;">
    <h3>
        <a href="list_note.jsp?flag=first">显示所有留言</a>
    </h3>
    <form name="form1" method="post" action="list_note.jsp?flag=first">
        <table width="500" border="0" align="center">
            <tr>
                <td>在 <select name="item">
                    <option value="title">标题</option>
                    <option value="author">作者</option>
                    <option value="content">内容</option>
                </select> 中查询:
                    <input type="text" name="content">
                    <input type="submit" name="submit" value="搜索"></td>
            </tr>
        </table>
    </form>

    <%
        NoteService note = new NoteServiceImpl();
        String flag = request.getParameter("flag");//翻页时的方向值,即SplitPage中请求标识参数
        //每次刷新页面时都应当重新获得表中的记录数, 因为翻页过程中表的记录可能随时都会更新
        int totalRows = 0;//总的记录数
    %>
    <table width="80%" border=1 cellspacing="0" align="center">
        <tr>
            <td><span style="font-size: x-small; color: #0000FF; ">留言ID</span></td>
            <td><span style="font-size: x-small; color: #0000FF; ">标题</span></td>
            <td><span style="font-size: x-small; color: #0000FF; ">作者</span></td>
            <td><span style="font-size: x-small; color: #0000FF; ">内容</span></td>
            <td><span style="font-size: x-small; color: #0000FF; ">删除</span></td>
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
                <a href="#"
                   onclick="window.confirm('确定删除吗？')?this.href='/DeleteServlet?id=<%=n.getId()%>':this.href='javascript:void()';">
                    删除</a>
            </td>
        </tr>
        <%
            }
        %>
        <tr>
            <td colspan="5" align="right">
                <a href="list_note.jsp?flag=<%=SplitPage.FIRSTPAGE%>&item=<%=strItem%>&content=<%=strContent%>">首页</a>
                <a href="list_note.jsp?flag=<%=SplitPage.PREVIOUSEPAGE%>&item=<%=strItem%>&content=<%=strContent%>">上一页</a>
                <a href="list_note.jsp?flag=<%=SplitPage.NEXTPAGE%>&item=<%=strItem%>&content=<%=strContent%>">下一页</a>
                <a href="list_note.jsp?flag=<%=SplitPage.LASTPAGE%>&item=<%=strItem%>&content=<%=strContent%>">最后页</a>
                <select id="selectpage" name="goPage" onchange="go();">
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
    <br/>
</div>
<div style="margin: 0 auto" align="center">
    <form name="form2" action="/AddNoteServlet" method='post'>
        标题：<br/>
        <input type="text" name="title" style="width: 80%  "><br/>
        内容：<br/>
        <textarea id="edtInputWord" name="note" style="width: 80%  ;height: 100px"></textarea><br/><br/>
        <input type="submit" value="提交">
    </form>
</div>

</body>
</html>
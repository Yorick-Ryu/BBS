package servlet;

import note.service.UserService;
import note.service.impl.UserServiceImpl;
import note.vo.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserService userService = new UserServiceImpl();
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        request.setCharacterEncoding("utf-8");
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        User user = new User(username,password,"true");
        try {
            if (userService.login(user)){
                out.println("登陆成功<br>");
                out.println("用户名：" + username + "<br>");
                out.println("密 码：" + password+"<br>");
            }else {
                out.println("登陆失败<br>");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

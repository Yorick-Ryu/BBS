package note.servlet;

import note.service.UserService;
import note.service.impl.UserServiceImpl;
import note.vo.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "RegisterServlet", value = "/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserService userService = new UserServiceImpl();
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        User user = new User(username,password,email,"false");
        user.setImage("/images/nice.jpg");
        try {
            userService.register(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        out.println("注册成功<br>");
        out.println("用户名：" + username + "<br>");
        out.println("密 码：" + password+"<br>");
        out.println("邮箱：" + email+"<br>");

    }
}

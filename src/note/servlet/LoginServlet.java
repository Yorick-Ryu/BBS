package note.servlet;

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
        User user = new User(username,password);
        HttpSession session = request.getSession();
        String path = "login_success.jsp";
        try {
            if (userService.login(user)){
                if (user.getFlag().equals("true")){
                    path = "admin/login_success.jsp";
                }
                session.setAttribute("user",user);
                session.setAttribute("me",user.getName());
                session.setAttribute("id",user.getId());
                session.setAttribute("image",user.getImage());
                request.getRequestDispatcher(path).forward(request,response);
            }else {
                out.println("登陆失败<br>");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

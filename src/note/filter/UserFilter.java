package note.filter;

import note.vo.User;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

@WebFilter("/admin/userManager.jsp")
public class UserFilter implements Filter {

    public void init(FilterConfig config) throws ServletException {

    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest httpServletRequest = (HttpServletRequest)request;
        User user = (User) httpServletRequest.getSession().getAttribute("user");
        if (user.getFlag().equals("true")){
            chain.doFilter(request,response);
        }else {
            PrintWriter out = response.getWriter();
            out.println("当前用户不是管理员，无法访问");
        }

    }
}

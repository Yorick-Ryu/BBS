package note.filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebFilter(filterName = "CharacterFilter")
public class CharacterFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request1 = (HttpServletRequest) request;
        HttpServletResponse response1 = (HttpServletResponse) response;
        //拦截所有请求 解决全站中文乱码
        //指定request和response的编码
        request1.setCharacterEncoding("utf-8");
        response1.setCharacterEncoding("utf-8");
        response1.setContentType("text/html;charset=utf-8");
        //对request进行包装
        CharacterRequest characterRequest = new CharacterRequest(request1);
        chain.doFilter(request, response);
    }
}

class CharacterRequest extends HttpServletRequestWrapper {
    private HttpServletRequest request;

    public CharacterRequest(HttpServletRequest request) {
        super(request);
        this.request = request;
    }

    @Override
    public String getParameter(String name) {
        String value = super.getParameter(name);
        if (value == null)
            return null;
        //判断请求方式
        String method = super.getMethod();
        if ("get".equalsIgnoreCase(method)) {
            value = new String(value.getBytes(StandardCharsets.UTF_8), StandardCharsets.UTF_8);
        }
        //解决乱码后返回结果
        return value;
    }
}

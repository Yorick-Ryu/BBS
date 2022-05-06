package note.servlet;

import note.service.NoteService;
import note.service.UserService;
import note.service.impl.NoteServiceImpl;
import note.service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DeleteServlet", value = "/DeleteServlet")
public class DeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int deleteID = Integer.parseInt(request.getParameter("id"));
        String type = request.getParameter("type");
        if (type.equals("note")){
            NoteService noteService = new NoteServiceImpl();
            try {
                noteService.delete(deleteID);
            } catch (Exception e) {
                e.printStackTrace();
            }
            response.sendRedirect("/list_note.jsp");
        }else if (type.equals("user")){
            UserService userService = new UserServiceImpl();
            try {
                userService.delete(deleteID);
            } catch (Exception e) {
                e.printStackTrace();
            }
            response.sendRedirect("/userManager.jsp");
        }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

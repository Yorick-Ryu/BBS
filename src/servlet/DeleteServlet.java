package servlet;

import note.service.NoteService;
import note.service.impl.NoteServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DeleteServlet", value = "/DeleteServlet")
public class DeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int deleteID = Integer.parseInt(request.getParameter("id"));
        NoteService noteService = new NoteServiceImpl();
        try {
            noteService.delete(deleteID);
            response.sendRedirect("/list_note.jsp");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

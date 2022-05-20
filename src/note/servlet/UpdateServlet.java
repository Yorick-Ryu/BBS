package note.servlet;

import note.service.NoteService;
import note.service.impl.NoteServiceImpl;
import note.vo.Note;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UpdateServlet", value = "/UpdateServlet")
public class UpdateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        NoteService noteService = new NoteServiceImpl();
        HttpSession session = request.getSession();
        String author = (String) session.getAttribute("me");
        String id = request.getParameter("id");
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        Note note = new Note(title, author, content);
        note.setId(Integer.parseInt(id));
        try {
            noteService.update(note);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            response.sendRedirect("/list_note.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}

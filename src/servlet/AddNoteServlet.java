package servlet;

import note.service.NoteService;
import note.service.impl.NoteServiceImpl;
import note.vo.Note;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "AddNoteServlet", value = "/AddNoteServlet")
public class AddNoteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        String content = request.getParameter("note");
        HttpSession session = request.getSession();
        Note note = new Note(title,(String) session.getAttribute("me"),content);
        NoteService noteService = new NoteServiceImpl();
        try {
            noteService.insert(note);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            response.sendRedirect("/list_note.jsp");
        }
    }
}

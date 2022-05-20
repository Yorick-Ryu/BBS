package note.test;

import note.service.NoteService;
import note.service.impl.NoteServiceImpl;
import note.vo.Note;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NoteServiceImplTest {

    NoteService noteService = new NoteServiceImpl();

    @Test
    void insert() {
        for (int i = 21; i <= 200; i++) {
            Note note = new Note("Note测试" + i, "Yorick", "Note测试" + i);
            try {
                noteService.insert(note);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    void delete() {
        try {
            noteService.delete(2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void update() {

        Note note = new Note("Note","yy","update");
        note.setId(16);
        try {
            noteService.update(note);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
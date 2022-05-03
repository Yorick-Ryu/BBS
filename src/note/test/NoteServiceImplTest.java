package note.test;

import note.service.NoteService;
import note.service.impl.NoteServiceImpl;
import note.vo.Note;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NoteServiceImplTest {

    @Test
    void insert() {
        for (int i = 8;i<=20;i++){
            Note note = new Note("Testing测试"+i,"Yorick","Note测试"+i);
            NoteService noteService = new NoteServiceImpl();
            try {
                noteService.insert(note);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    void delete() {
        NoteService noteService = new NoteServiceImpl();
        try {
            noteService.delete(2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
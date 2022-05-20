package note.test;

import note.service.NoteService;
import note.service.impl.NoteServiceImpl;
import note.util.SplitPage;
import note.vo.Note;
import org.junit.jupiter.api.Test;

import java.util.List;

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

        Note note = new Note("Note", "yy", "update");
        note.setId(16);
        try {
            noteService.update(note);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void queryById() {
    }

    @Test
    void queryAll() {
    }

    @Test
    void queryByLike() {
    }

    @Test
    void findAll() {
    }

    @Test
    void testQueryByLike() {
        try {
            List<Note> notes = noteService.queryByLike("title", "测试", new SplitPage());
            for(Note note:notes){
                System.out.println(note);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void getRows() {
    }
}
package note.service.impl;

import note.dao.NoteDao;
import note.dao.impl.NoteDaoImpl;
import note.service.NoteService;
import note.util.SplitPage;
import note.vo.Note;

import java.util.List;

public class NoteServiceImpl implements NoteService {
    private NoteDao noteDao = new NoteDaoImpl();
    @Override
    public void insert(Note note) throws Exception {
        noteDao.insert(note);
    }

    @Override
    public void update(Note note) throws Exception {
        noteDao.update(note);
    }

    @Override
    public void delete(int id) throws Exception {
        noteDao.delete(id);
    }

    @Override
    public Note queryById(int id) throws Exception {
        return noteDao.queryById(id);
    }

    @Override
    public List<Note> queryAll() throws Exception {
        return noteDao.queryAll();
    }

    @Override
    public List<Note> queryByLike(String key, String value) throws Exception {
        return noteDao.queryByLike(key, value);
    }

    @Override
    public List<Note> findAll(SplitPage sp) throws Exception {
        return noteDao.findAll(sp);
    }

    @Override
    public List<Note> queryByLike(String key, String value, SplitPage sp) throws Exception {
        return noteDao.queryByLike(key, value, sp);
    }

    @Override
    public int getRows(String key, String value) throws Exception {
        List<Note> list = null;
        if (value==null||value.equals("")||value.equals("null"))
            list = queryAll();
        else
            list = queryByLike(key, value);
        int num = list.size();
        return num;
    }
}

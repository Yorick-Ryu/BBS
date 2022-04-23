package note.dao;

import java.util.* ;
import note.util.SplitPage;
import note.vo.* ;

public interface NoteDao {
    void insert(Note note) throws Exception ;
    void update(Note note) throws Exception ;
    void delete(int id) throws Exception ;
    Note queryById(int id) throws Exception ;
    List<Note> queryAll() throws Exception ;
    List<Note> queryByLike(String key, String value) throws Exception;
    List<Note> findAll(SplitPage sp)throws Exception;
    List<Note> queryByLike(String key, String value,SplitPage sp) throws Exception;
}

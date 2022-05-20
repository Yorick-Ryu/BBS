package note.dao.impl;

import note.dao.NoteDao;
import note.util.DataBaseConnection;
import note.util.SplitPage;
import note.vo.Note;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NoteDaoImpl implements NoteDao {
    @Override
    public void insert(Note note) throws Exception {
        String sql = "INSERT INTO note(title,author,content) values(?,?,?)";
        PreparedStatement ps = null;
        DataBaseConnection dbc = new DataBaseConnection();
        try {
            ps = dbc.getConnection().prepareStatement(sql);
            ps.setString(1, note.getTitle());
            ps.setString(2, note.getAuthor());
            ps.setString(3, note.getContent());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException("评论失败");
        } finally {
            dbc.close(null, ps);
        }
    }

    @Override
    public void update(Note note) throws Exception {
        String sql = "UPDATE note SET " +
                "title = ?,content= ? " +
                "WHERE id = ?";
        PreparedStatement ps = null;
        DataBaseConnection dbc = new DataBaseConnection();
        try {
            ps = dbc.getConnection().prepareStatement(sql);
            ps.setString(1, note.getTitle());
            ps.setString(2, note.getContent());
            ps.setInt(3, note.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException("更新失败");
        } finally {
            dbc.close(null, ps);
        }

    }

    @Override
    public void delete(int id) throws Exception {
        String sql = "DELETE FROM note WHERE id = ?";
        PreparedStatement ps = null;
        DataBaseConnection dbc = new DataBaseConnection();
        try {
            ps = dbc.getConnection().prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException("删除失败");
        } finally {
            dbc.close(null, ps);
        }
    }

    @Override
    public Note queryById(int id) throws Exception {
        return null;
    }

    //查询全部
    @Override
    public List<Note> queryAll() throws Exception {
        List<Note> all = new ArrayList<Note>();
        PreparedStatement pstmt = null;
        DataBaseConnection dbc = null;
        dbc = new DataBaseConnection();
        String sql = "SELECT * FROM note";
        ResultSet rs = null;
        try {
            pstmt = dbc.getConnection().prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Note note = new Note();
                note.setId(rs.getInt(1));
                note.setTitle(rs.getString(2));
                note.setAuthor(rs.getString(3));
                note.setContent(rs.getString(4));
                all.add(note);
            }
            rs.close();
            pstmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbc.close(rs, pstmt);
        }
        return all;
    }

    //模糊查询
    @Override
    public List<Note> queryByLike(String key, String value) throws Exception {
        List<Note> all = new ArrayList<Note>();
        PreparedStatement pstmt = null;
        DataBaseConnection dbc = null;
        dbc = new DataBaseConnection();
        String sql = "SELECT * FROM note WHERE " + key + " LIKE " + "'%" + value
                + "%'";
        ResultSet rs = null;
        try {
            pstmt = dbc.getConnection().prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Note note = new Note();
                note.setId(rs.getInt(1));
                note.setTitle(rs.getString(2));
                note.setAuthor(rs.getString(3));
                note.setContent(rs.getString(4));
                all.add(note);
            }
            rs.close();
            pstmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbc.close(rs, pstmt);
        }
        return all;
    }

    // 查询所有记录，数据分页
    @Override
    public List<Note> findAll(SplitPage sp) throws Exception {
        List<Note> all = new ArrayList<Note>();
        PreparedStatement pstmt = null;
        DataBaseConnection dbc = null;
        dbc = new DataBaseConnection();
        String sql = "select * from note limit " + sp.getPageRows() *
                (sp.getCurrentPage() - 1) + ","
                + sp.getPageRows();//显示第二页 第几条记录到第几条 select * from note limit 10,10
        ResultSet rs = null;
        try {
            pstmt = dbc.getConnection().prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Note note = new Note();
                note.setId(rs.getInt(1));
                note.setTitle(rs.getString(2));
                note.setAuthor(rs.getString(3));
                note.setContent(rs.getString(4));
                all.add(note);
            }
            rs.close();
            pstmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbc.close(rs, pstmt);
        }
        return all;
    }

    // 模糊查询，数据分页
    @Override
    public List<Note> queryByLike(String key, String value, SplitPage sp) throws Exception {
        List<Note> all = new ArrayList<Note>();
        PreparedStatement pstmt = null;
        DataBaseConnection dbc = null;
        dbc = new DataBaseConnection();
        String sql = "SELECT * FROM note WHERE " + key + " LIKE " + "'%" +
                value + "%'" + " LIMIT ";
        ResultSet rs = null;
        try {
            pstmt = dbc.getConnection().prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Note note = new Note();
                note.setId(rs.getInt(1));
                note.setTitle(rs.getString(2));
                note.setAuthor(rs.getString(3));
                note.setContent(rs.getString(4));
                all.add(note);
            }
            rs.close();
            pstmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbc.close(rs, pstmt);
        }
        return all;
    }
}

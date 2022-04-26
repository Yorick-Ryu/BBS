package note.dao.impl;

import note.dao.UserDao;
import note.util.DataBaseConnection;
import note.vo.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserDaoImpl implements UserDao {


    @Override
    public boolean login(User user) throws Exception {
        boolean flag = false;
        String sql = "SELECT id,email FROM user "
                + "WHERE name=? and password=? and flag=?";
        PreparedStatement pstmt = null;
        DataBaseConnection dbc = null;
        ResultSet rs =null;
        dbc = new DataBaseConnection();
        try {
            pstmt = dbc.getConnection().prepareStatement(sql);
            pstmt.setString(1,user.getName());
            pstmt.setString(2,user.getPassword());
            pstmt.setString(3,user.getFlag());
            rs = pstmt.executeQuery();
            if (rs.next()){
                flag = true;
                user.setId(rs.getString(1));
                user.setEmail(rs.getString(2));
            }
        }catch (SQLException e){
            e.printStackTrace();
            throw new SQLException("登录失败");
        }finally {
            dbc.close(rs,pstmt);
        }

        return flag;
    }

    @Override
    public void register(User user) throws Exception {
        String sql = "INSERT INTO user(name,email,password,flag) values(?,?,?,?)";
        PreparedStatement pstmt = null;
        DataBaseConnection dbc = new DataBaseConnection();
        try{
            pstmt = dbc.getConnection().prepareStatement(sql);
            pstmt.setString(1,user.getName());
            pstmt.setString(2,user.getEmail());
            pstmt.setString(3,user.getPassword());
            pstmt.setString(4,user.getFlag());
            pstmt.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
            throw new SQLException("注册失败");
        }finally {
            dbc.close(null,pstmt);
        }
    }

    @Override
    public boolean checkUser(User user) throws Exception {
        return false;
    }

    @Override
    public String queryById(User user) throws Exception {
        return null;
    }

    @Override
    public List<User> queryAll() throws Exception {
        return null;
    }

    @Override
    public void delete(int id) throws Exception {

    }

    @Override
    public void update(String id) throws Exception {

    }

    @Override
    public void update(User user) throws Exception {

    }
}
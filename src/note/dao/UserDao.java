package note.dao;
import java.util.List;
import note.vo.* ;
public interface UserDao {
    //登录验证
    public boolean login(User user) throws Exception ;
    //用户注册，注册信息存入数据库
    public void register(User user) throws Exception ;
    //检查注册用户是否存在
    public boolean checkUser(User user) throws Exception ;
    //查询用户id
    public String queryById(User user) throws Exception ;
    //查询全部用户
    public List<User> queryAll() throws Exception;
    //根据id删除用户
    public void delete(int id) throws Exception;
    //修改已通过邮件进行激活的用户
    public void update(String id) throws Exception;
    //修改用户信息
    public void update(User user ) throws Exception;

}

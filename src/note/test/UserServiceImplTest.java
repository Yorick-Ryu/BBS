package note.test;

import note.service.UserService;
import note.service.impl.UserServiceImpl;
import note.vo.User;
import org.junit.jupiter.api.Test;

import java.util.List;

class UserServiceImplTest {

    UserService userService = new UserServiceImpl();

    @Test
    void login() {
        User user = new User("Yorick", "964538");
        try {
            if (userService.login(user)) {
                System.out.println("登录成功");
            } else {
                System.out.println("登录失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void register() {
        User user = new User("test", "23333", "23333333@qq.com", "false");
        try {
            userService.register(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void queryAll() {
        try {
            List<User> users = userService.queryAll();
            for (User user : users) {
                System.out.println(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void checkUser() {
    }

    @Test
    void queryById() {
    }

    @Test
    void delete() {
        try {
            userService.delete(3);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void update() {
        User user =new User(5,"marry","123456","2524@qq.com","false","/images/611f2b73-a047-42fe-b3d5-8b6e6053cfc2_ae2fb999a9014c08f9f834f21d7b02087af4f4b5.gif");
        try {
            userService.update(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void testUpdate() {
    }
}
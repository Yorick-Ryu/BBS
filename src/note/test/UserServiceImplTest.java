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
    }

    @Test
    void testUpdate() {
    }
}
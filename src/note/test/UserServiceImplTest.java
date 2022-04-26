package note.test;

import note.service.UserService;
import note.service.impl.UserServiceImpl;
import note.vo.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceImplTest {

    @Test
    void login() {
        User user = new User("Yorick","964538","true");
        UserService userService = new UserServiceImpl();
        try {
            if(userService.login(user)){
                System.out.println("登录成功");
            }else {
                System.out.println("登录失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void register() {
        User user = new User("Yorick","964538","2524964538@qq.com","true");
        UserService userService = new UserServiceImpl();
        try {
            userService.register(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
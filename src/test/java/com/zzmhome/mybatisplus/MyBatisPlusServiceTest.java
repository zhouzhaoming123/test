package com.zzmhome.mybatisplus;

import com.zzmhome.mybatisplus.bean.User;
import com.zzmhome.mybatisplus.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

/**
 * Data:
 * Author: zhouzm
 * ---------------------------
 */
@SpringBootTest
public class MyBatisPlusServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void testGetCount(){
        long count = userService.count();
        System.out.println(count);
    }

    @Test
    public void testInsertMore(){
        //批量添加
        List<User> userList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setName("zzm" + i);
            user.setUserAge(20 + i);
            user.setEmail(user.getName() + "@qq.com");
            userList.add(user);
        }
        boolean b = userService.saveBatch(userList);
        System.out.println(b);
    }
}


















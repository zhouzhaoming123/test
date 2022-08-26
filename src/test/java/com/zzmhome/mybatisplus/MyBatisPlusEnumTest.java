package com.zzmhome.mybatisplus;

import com.zzmhome.mybatisplus.bean.User;
import com.zzmhome.mybatisplus.enums.SexEnum;
import com.zzmhome.mybatisplus.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Data:
 * Author: zhouzm
 * ---------------------------
 */
@SpringBootTest
public class MyBatisPlusEnumTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void test(){
        User user = new User();
        user.setName("admin");
        user.setUserAge(30);
        user.setSex(SexEnum.MALE);
        userMapper.insert(user);
    }

}

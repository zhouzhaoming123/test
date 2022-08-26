package com.zzmhome.mybatisplus;

import com.zzmhome.mybatisplus.bean.User;
import com.zzmhome.mybatisplus.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Data:
 * Author: zhouzm
 * ---------------------------
 */
@SpringBootTest
public class MyBatisPlusTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelectUserList(){
        //通过条件构造器查询list集合，若没有条件，可以设置参数为null
        List<User> userList = userMapper.selectList(null);
        userList.forEach(System.out::println);
    }

    @Test
    public void testInsert(){
        User user = new User();
        user.setName("张三1");
        user.setUserAge(12);
        user.setEmail("zhangsan@qq.com");
        int insert = userMapper.insert(user);
        System.out.println("insert: " + insert);
        System.out.println("id: " + user.getUid());
    }

    @Test
    public void testDelete(){
        int result = userMapper.deleteById(8L);
        System.out.println(result);
//        Map<String, Object> map = new HashMap<>();
//        map.put("name", "张三");
//        userMapper.deleteByMap(map);
//        List<Long> list = new ArrayList<>();
//        list.add(1557301045704003585L);
//        userMapper.deleteBatchIds(list);
    }

    @Test
    public void testUpdate(){
        User user = new User();
        user.setUid(6L);
        user.setName("小明");
        user.setUserAge(16);
        user.setEmail("小明@qq.com");
        userMapper.updateById(user);
    }

    @Test
    public void testSelect(){
        User user = userMapper.selectById(8L);
        System.out.println(user);

//        userMapper.selectBatchIds(new ArrayList<>());
//        userMapper.selectByMap(new HashMap<>());
    }

    @Test
    public void testSelectMapById(){
        Map<String, Object> map = userMapper.selectMapById(6L);
        System.out.println(map);
    }
}




















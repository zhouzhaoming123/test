package com.zzmhome.mybatisplus;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.zzmhome.mybatisplus.bean.User;
import com.zzmhome.mybatisplus.mapper.UserMapper;
import com.zzmhome.mybatisplus.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

/**
 * Data:
 * Author: zhouzm
 * ---------------------------
 */
@SpringBootTest
public class MyBatisPlusWrapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void test01(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("user_name","张").between("user_age",11,12)
                .isNotNull("email");
        List<User> users = userMapper.selectList(queryWrapper);
        System.out.println(users);
    }

    @Test
    public void test02(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("user_age").orderByAsc("user_id");
        List<User> users = userMapper.selectList(queryWrapper);
        System.out.println(users);
    }

    @Test
    public void test03(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_name","张三1");
        userMapper.delete(queryWrapper);
    }

    @Test
    public void test04(){
        User user = new User();
        user.setName("大明");
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.gt("user_age", 22)
                .or()
                .eq("email", "Tom@qq.com");
        userMapper.update(user, queryWrapper);
    }

    @Test
    public void test05(){
        //将用户名中包含有明 并且（年龄大于18或邮箱为null）的用户信息修改
        //lambda中的条件优先执行
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("user_name", "明")
                .and(userQueryWrapper -> userQueryWrapper.gt("user_age", 18)
                        .or().isNull("email"));
        User user = new User();
        user.setName("小红");
        userMapper.update(user, queryWrapper);
    }

    @Test
    public void test06(){
        //查询名称，年龄，邮箱
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("user_name","user_age", "email");
        List<Map<String, Object>> maps = userMapper.selectMaps(queryWrapper);
        System.out.println(maps);
    }

    @Test
    public void test07(){
        //子查询
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.inSql("user_id", "select user_id from t_user where user_id > 6");
        List<User> users = userMapper.selectList(queryWrapper);
        System.out.println(users);
    }

    @Test
    public void test08(){
        //将用户名中包含有明 并且（年龄大于18或邮箱为null）的用户信息修改
        //lambda中的条件优先执行
        UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
        updateWrapper.like("user_name", "红")
                .and(userQueryWrapper -> userQueryWrapper.gt("user_age", 18)
                        .or().isNull("email"));

        updateWrapper.set("user_name", "小黑").set("email", "xiaohei@qqo.com");
        int update = userMapper.update(null, updateWrapper);

    }

    @Test
    public void test10(){
        String userName = "";
        Integer beginAge = 10;
        Integer endAge = 20;
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.like(StringUtils.isNotBlank(userName), "user_name",userName)
                .ge(beginAge != null, "user_age", beginAge)
                .le(endAge != null, "user_age", endAge);

        userMapper.selectList(queryWrapper);
    }

    @Test
    public void test11(){
        String userName = "";
        Integer beginAge = 10;
        Integer endAge = 20;
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.like(StringUtils.isNotBlank(userName), User::getName,userName)
                .ge(beginAge != null, User::getUserAge, beginAge)
                .le(endAge != null, User::getUserAge, endAge);

        userMapper.selectList(queryWrapper);
    }

    @Test
    public void test12(){
        //将用户名中包含有明 并且（年龄大于18或邮箱为null）的用户信息修改
        //lambda中的条件优先执行
        LambdaUpdateWrapper<User> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.like(User::getName, "红")
                .and(userQueryWrapper -> userQueryWrapper.gt(User::getUserAge, 18)
                        .or().isNull(User::getEmail));

        updateWrapper.set(User::getName, "小黑").set(User::getEmail, "xiaohei@qqo.com");
        int update = userMapper.update(null, updateWrapper);

    }

}


















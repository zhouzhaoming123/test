package com.zzmhome.mybatisplus;

import com.zzmhome.mybatisplus.service.ProductService;
import com.zzmhome.mybatisplus.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

/**
 * Data:
 * Author: zhouzm
 * ---------------------------
 */
@SpringBootTest
public class MybatisPlusDataSourcesTest {

    @Autowired
    private UserService userService;
    @Autowired
    private ProductService productService;

    @Test
    public void test01(){
        Map<String, Object> map = userService.getMap(null);
        System.out.println(map);

        Map<String, Object> map1 = productService.getMap(null);
        System.out.println(map1);
    }

}

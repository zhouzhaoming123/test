package com.zzmhome.mybatisplus;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zzmhome.mybatisplus.bean.Product;
import com.zzmhome.mybatisplus.bean.User;
import com.zzmhome.mybatisplus.mapper.ProductMapper;
import com.zzmhome.mybatisplus.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootVersion;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.SpringVersion;

import java.util.List;

/**
 * Data:
 * Author: zhouzm
 * ---------------------------
 */
@SpringBootTest
public class MyBatisPlusPluginsTest {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private ProductMapper productMapper;

    @Test
    public void TestspringVersionAndspringBootVersion (){
        String springVersion = SpringVersion.getVersion();
        System.out.println(springVersion);
        String springBootVersion = SpringBootVersion.getVersion();
        System.out.println(springBootVersion);
    }

    @Test
    public void testPage(){
        Page<User> page = new Page<>(2,3);
        userMapper.selectPage(page,null);
        System.out.println(page.getRecords());
    }

    @Test
    public void testPageByAge(){
        Page<User> page = new Page<>(2,3);
        userMapper.selectPageBuyAge(page,18);
        List<User> records = page.getRecords();
        long total = page.getTotal();
        System.out.println(total);
        System.out.println(records);
    }

    @Test
    public void testProduct01(){
        //小李查询价格
        Product productLi = productMapper.selectById(1);
        System.out.println("小李查询价格" + productLi.getPrice());
        //小王查询价格
        Product productWan = productMapper.selectById(1);
        System.out.println("小王查询价格" + productWan.getPrice());
        //小李商品价格加1000
        productLi.setPrice(productLi.getPrice() + 1000);
        productMapper.updateById(productLi);
        //小王价格减500
        productWan.setPrice(productWan.getPrice() - 500);
        int result = productMapper.updateById(productWan);
        if (result == 0){
            //操作失败，重试
            Product productWanNew = productMapper.selectById(1);
            productWanNew.setPrice(productWanNew.getPrice() - 500);
            productMapper.updateById(productWanNew);
        }

        //老板来查询价格
        Product productLaoBan = productMapper.selectById(1);
        System.out.println("老板来查询价格" + productLaoBan.getPrice());
    }

}

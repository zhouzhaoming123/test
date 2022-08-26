package com.zzmhome.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zzmhome.mybatisplus.bean.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * Data:
 * Author: zhouzm
 * ---------------------------
 */
@Repository
public interface UserMapper extends BaseMapper<User> {

    Map<String, Object> selectMapById(Long id);

    /**
     * 通过年龄查询用户信息并分页
     * @param page MyBatis-plus所提供的分页对象，必须位于参数的第一个位置
     * @param userAge
     * @return
     */
    Page<User> selectPageBuyAge(@Param("Page") Page<User> page, @Param("age") Integer age);

}

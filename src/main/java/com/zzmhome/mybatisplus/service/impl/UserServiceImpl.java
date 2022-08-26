package com.zzmhome.mybatisplus.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zzmhome.mybatisplus.bean.User;
import com.zzmhome.mybatisplus.mapper.UserMapper;
import com.zzmhome.mybatisplus.service.UserService;
import org.springframework.stereotype.Service;

/**
 * Data: 2022-8-11
 * Author: zhouzm
 * ---------------------------
 */
@Service
@DS("master")
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}























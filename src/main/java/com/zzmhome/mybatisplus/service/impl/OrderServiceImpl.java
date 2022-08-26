package com.zzmhome.mybatisplus.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zzmhome.mybatisplus.bean.Order;
import com.zzmhome.mybatisplus.service.OrderService;
import com.zzmhome.mybatisplus.mapper.OrderMapper;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order>
    implements OrderService{

}





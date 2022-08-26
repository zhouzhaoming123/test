package com.zzmhome.mybatisplus.mapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.zzmhome.mybatisplus.bean.Order;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * @Entity com.zzmhome.mybatisplus.bean.Order
 */
public interface OrderMapper extends BaseMapper<Order> {

    int insertSelective(Order order);

    int deleteByOrderId(@Param("orderId") Long orderId);

    int updatePriceAndPayByOrderId(@Param("price") Integer price, @Param("pay") Integer pay, @Param("orderId") Long orderId);

    List<Order> selectAllByOrderId(@Param("orderId") Long orderId);

    List<Order> selectProductIdByOrderIdOrderByPrice(@Param("orderId") Long orderId);
}





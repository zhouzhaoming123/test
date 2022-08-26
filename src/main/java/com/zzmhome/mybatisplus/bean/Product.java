package com.zzmhome.mybatisplus.bean;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

@Data
public class Product {

    //将属性所对应的字段指定为主键
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private String name;

    private Integer price;

    @Version//标识乐观锁版本字段
    private Integer version;

}

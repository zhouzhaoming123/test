package com.zzmhome.mybatisplus.bean;

import com.baomidou.mybatisplus.annotation.*;
import com.zzmhome.mybatisplus.enums.SexEnum;
import lombok.Data;

@Data
//设置实体类所对应的表名
//@TableName("user")
public class User {

    //将属性所对应的字段指定为主键
    @TableId(value = "user_id", type = IdType.AUTO)
    private Long uid;

    @TableField("user_name")
    private String name;

    private Integer userAge;

    private String email;

    private SexEnum sex;

    @TableLogic
    private Integer isDeleted;

}

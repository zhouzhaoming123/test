package com.zzmhome.mybatisplus.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zzmhome.mybatisplus.bean.Product;
import com.zzmhome.mybatisplus.mapper.ProductMapper;
import com.zzmhome.mybatisplus.service.ProductService;
import org.springframework.stereotype.Service;

/**
 * Data:
 * Author: zhouzm
 * ---------------------------
 */
@Service
@DS("slave")
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {



}

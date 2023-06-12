package com.springboot.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.springboot.entity.Goods;
import com.baomidou.mybatisplus.extension.service.IService;
import com.springboot.entity.Goodstype;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wxr
 * @since 2023-05-28
 */
public interface GoodsService extends IService<Goods> {
    IPage pageCC(Page<Goods> page, Wrapper wrapper);
}

package com.springboot.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.springboot.entity.Goodstype;
import com.baomidou.mybatisplus.extension.service.IService;
import com.springboot.entity.Storage;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wxr
 * @since 2023-05-28
 */
public interface GoodstypeService extends IService<Goodstype> {

    IPage pageCC(Page<Goodstype> page, Wrapper wrapper);
}

package com.springboot.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.springboot.entity.Storage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.springboot.entity.User;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wxr
 * @since 2023-05-22
 */
public interface StorageService extends IService<Storage> {

    IPage pageCC(Page<Storage> page, Wrapper wrapper);
}

package com.springboot.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.springboot.entity.Goods;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.springboot.entity.Goodstype;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author wxr
 * @since 2023-05-28
 */
@Mapper
public interface GoodsMapper extends BaseMapper<Goods> {

    IPage pageCC(Page<Goods> page, @Param(Constants.WRAPPER) Wrapper wrapper);
}

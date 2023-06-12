package com.springboot.mapper;

import com.springboot.entity.Menu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author wxr
 * @since 2023-05-21
 */
@Mapper
public interface MenuMapper extends BaseMapper<Menu> {

}

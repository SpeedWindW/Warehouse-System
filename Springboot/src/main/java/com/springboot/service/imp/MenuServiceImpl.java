package com.springboot.service.imp;

import com.springboot.entity.Menu;
import com.springboot.mapper.MenuMapper;
import com.springboot.service.MenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wxr
 * @since 2023-05-21
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements MenuService {

}

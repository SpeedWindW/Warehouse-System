package com.springboot.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.springboot.common.QueryPageParam;
import com.springboot.common.Result;
import com.springboot.entity.Menu;
import com.springboot.entity.User;
import com.springboot.service.MenuService;
import com.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wxr
 * @since 2023-04-26
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private MenuService menuService;


    @GetMapping("/findByNo")
    public Result findByNo(@RequestParam String no){
     List list = userService.lambdaQuery().eq(User::getNo,no).list();
     return list.size()>0?Result.suc(list):Result.fail();
    }

    //查询全部
    @GetMapping("/list")
    public List<User> userList(){
        return userService.list();
    }

    //新增
    @PostMapping("/save")
    public Result usersave(@RequestBody User user){
        return userService.save(user)?Result.suc():Result.fail();
    }

    //修改
    @PostMapping("/update")
    public Result update(@RequestBody User user){
        return userService.updateById(user)?Result.suc():Result.fail();
    }

    //删除
    @GetMapping("/del")
    public Result del(@RequestParam String id){
        return userService.removeById(id)?Result.suc():Result.fail();
    }

    //修改
    @PostMapping("/login")
    public Result login(@RequestBody User user){
        List list = userService.lambdaQuery()
                .eq(User::getNo,user.getNo())
                .eq(User::getPassword,user.getPassword()).list();

        if(list.size()>0){
            User user1 = (User)list.get(0);
            List menuList = menuService.lambdaQuery().like(Menu::getMenuright,user1.getRoleId()).list();
            HashMap res = new HashMap();
            res.put("user",user1);
            res.put("menu",menuList);
            return Result.suc(res);
        }
        return Result.fail();

    }

    //新增或修改
    @PostMapping("/saveorupdate")
    public boolean usersaveorupdate(@RequestBody User user){
        return userService.saveOrUpdate(user);
    }



    //查询（模糊、精确）
    @PostMapping("/listp")
    public Result userlistp(@RequestBody User user){
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper();
        if(StringUtils.isNotBlank(user.getName())){
            //姓名模糊查询
            lambdaQueryWrapper.like(User::getName,user.getName());
        }

        //姓名精确查询
//        lambdaQueryWrapper.eq(User::getName,user.getName());

        return Result.suc(userService.list(lambdaQueryWrapper));
    }

    @PostMapping("/listpage")
    public List<User> listpage(@RequestBody QueryPageParam queryPageParam){
        System.out.println("num=="+queryPageParam.getPageNum());
        System.out.println("size=="+queryPageParam.getPageSize());

        HashMap param = queryPageParam.getParam();
        String name = (String) param.get("name");
        System.out.println("name=="+param.get("name"));
//        System.out.println("no=="+param.get("no"));

        Page<User> page = new Page();
        page.setCurrent(queryPageParam.getPageNum());
        page.setSize(queryPageParam.getPageSize());

        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper();
        lambdaQueryWrapper.like(User::getName,name);

        IPage result = userService.page(page,lambdaQueryWrapper);
        System.out.println("total=="+result.getTotal());

        return result.getRecords();
    }

    @PostMapping("/listpagec")
    public List<User> listpageC(@RequestBody QueryPageParam queryPageParam){
        System.out.println("num=="+queryPageParam.getPageNum());
        System.out.println("size=="+queryPageParam.getPageSize());

        HashMap param = queryPageParam.getParam();
        String name = (String) param.get("name");
        System.out.println("name=="+param.get("name"));
//        System.out.println("no=="+param.get("no"));

        Page<User> page = new Page();
        page.setCurrent(queryPageParam.getPageNum());
        page.setSize(queryPageParam.getPageSize());

        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper();
        lambdaQueryWrapper.like(User::getName,name);

//        IPage result = userService.pageC(page);
        IPage result = userService.pageCC(page,lambdaQueryWrapper);
        System.out.println("total=="+result.getTotal());

        return result.getRecords();
    }

    @PostMapping("/listpagec1")
    public Result listpageC1(@RequestBody QueryPageParam queryPageParam){


        HashMap param = queryPageParam.getParam();
        String name = (String) param.get("name");
        String sex = (String) param.get("sex");
        String roleId = (String) param.get("roleId");

        Page<User> page = new Page();
        page.setCurrent(queryPageParam.getPageNum());
        page.setSize(queryPageParam.getPageSize());

        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper();
        if(StringUtils.isNotBlank(name) && !"null".equals(name)){
            lambdaQueryWrapper.like(User::getName,name);
        }
        if(StringUtils.isNotBlank(sex)){
            lambdaQueryWrapper.like(User::getSex,sex);
        }
        if(StringUtils.isNotBlank(roleId)){
            lambdaQueryWrapper.like(User::getRoleId,roleId);
        }


//        IPage result = userService.pageC(page);
        IPage result = userService.pageCC(page,lambdaQueryWrapper);


        return Result.suc(result.getRecords(),result.getTotal());
    }
}

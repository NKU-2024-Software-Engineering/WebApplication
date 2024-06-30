package com.fourteen.wms.controller;

import java.util.HashMap;
import java.util.List;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fourteen.wms.common.QueryPageParam;
import com.fourteen.wms.common.Result;
import com.fourteen.wms.entity.User;
import com.fourteen.wms.service.UserService;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author akaziki
 * @since 2024-05-27
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/list")
    public List<User> list() {
        return userService.list();
    }

    // 新增
    @PostMapping("/save")
    public Result save(@RequestBody User user) {

        return userService.save(user)?Result.suc():Result.fail();
    }

    // 修改
    @PostMapping("/mod")
    public Result mod(@RequestBody User user) {

        return userService.updateById(user)?Result.suc():Result.fail();
    }

    // 新增或修改
    @PostMapping("/saveOrMod")
    public Result saveOrMod(@RequestBody User user) {
        return userService.saveOrUpdate(user)?Result.suc():Result.fail();
    }

    // 删除
    @PostMapping("/delete")
    public Result del(@RequestBody User user) {
        return userService.removeById(user.getId())?Result.suc():Result.fail();
    }

    // 查询（模糊或匹配）
    @PostMapping("/listP")
    public Result listP(@RequestBody User user) {
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        // like 模糊查询
        // eq 完全匹配
        // lambdaQueryWrapper.eq(User::getName, user.getName());


        return Result.suc(userService.list(lambdaQueryWrapper));
    }


    @PostMapping("/listPageC")
    public Result listPageC(@RequestBody QueryPageParam qParam) {
        HashMap map = qParam.getParam();
        String name = (String)map.get("name");
        Integer iLevel = (Integer)map.get("level");

        Page<User> page = new Page<>();
        page.setCurrent(qParam.getPageNum());
        page.setSize(qParam.getPageSize());

        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();

        if(iLevel!=null)
        {
            int level = iLevel;
            lambdaQueryWrapper.eq(User::getLevel, level);
        }
        IPage<User> result = userService.page(page, lambdaQueryWrapper);

        return Result.suc(result.getTotal(), result.getRecords());
    }

    @PostMapping("/login")
    public Result login(@RequestBody User user){
        System.out.println(user.getAccount());
        System.out.println(user.getPassword());
        List list = userService.lambdaQuery().eq(User::getAccount,user.getAccount())
                .eq(User::getPassword,user.getPassword())
                .list();
        return list.size()>0 ? Result.suc(list.get(0)) :Result.fail();
    }
}

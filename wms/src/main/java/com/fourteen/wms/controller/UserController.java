package com.fourteen.wms.controller;

import java.util.HashMap;
import java.util.List;

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
    public boolean save(@RequestBody User user) {
        return userService.save(user);
    }

    // 修改
    @PostMapping("/mod")
    public boolean mod(@RequestBody User user) {
        return userService.updateById(user);
    }

    // 新增或修改
    @PostMapping("/saveOrMod")
    public boolean saveOrMod(@RequestBody User user) {
        return userService.saveOrUpdate(user);
    }

    // 删除
    @GetMapping("/delete")
    public boolean saveOrMod(Integer id) {
        return userService.removeById(id);
    }

    // 查询（模糊或匹配）
    @PostMapping("/listP")
    public Result listP(@RequestBody User user) {
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        // like 模糊查询
        lambdaQueryWrapper.like(User::getName, user.getName());
        // eq 完全匹配
        // lambdaQueryWrapper.eq(User::getName, user.getName());


        return Result.suc(userService.list(lambdaQueryWrapper));
    }

    @PostMapping("/listPage")
    public List<User> listPage(@RequestBody QueryPageParam qParam) {
        HashMap map = qParam.getParam();
        System.out.println(qParam);
        System.out.println(qParam.getParam().get("name"));

        Page<User> page = new Page<>();
        page.setCurrent(qParam.getPageNum());
        page.setSize(qParam.getPageSize());

        String name = (String)map.get("name");

        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        // like 模糊查询
        lambdaQueryWrapper.like(User::getName, name);
        IPage<User> result = userService.page(page, lambdaQueryWrapper);
        return result.getRecords();
    }

    @PostMapping("/listPageC")
    public Result listPageC(@RequestBody QueryPageParam qParam) {
        HashMap map = qParam.getParam();

        Page<User> page = new Page<>();
        page.setCurrent(qParam.getPageNum());
        page.setSize(qParam.getPageSize());

        String name = (String)map.get("name");

        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        // like 模糊查询
        lambdaQueryWrapper.like(User::getName, name);
        IPage<User> result = userService.page(page, lambdaQueryWrapper);

        return Result.suc(result.getTotal(), result.getRecords());
    }
}

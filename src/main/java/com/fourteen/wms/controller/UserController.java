package com.fourteen.wms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}

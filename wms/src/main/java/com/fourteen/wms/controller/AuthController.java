package com.fourteen.wms.controller;

import com.fourteen.wms.common.Result;
import com.fourteen.wms.entity.Auth;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author user
 * @className AuthController
 * @description 用于反映token
 * @date 2024/06/28 22:56
 */

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {
    @RequestMapping("/token")
    public Result getToken(){
        Auth auth = new Auth();
        auth.setToken("admin");
        return Result.suc(auth);
    }
}


package com.fourteen.wms.controller;

import com.fourteen.wms.common.Result;
import com.fourteen.wms.entity.Hrs;
import com.fourteen.wms.entity.Jseekers;
import com.fourteen.wms.entity.User;
import com.fourteen.wms.service.JseekersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author akaziki
 * @since 2024-06-30
 */
@RestController
@RequestMapping("/jseekers")
public class JseekersController {

    @Autowired
    private JseekersService jseekersService;
    @PostMapping("/saveOrMod")
    public Result saveOrMod(@RequestBody Jseekers jseekers) {
        return jseekersService.saveOrUpdate(jseekers)?Result.suc():Result.fail();
    }

}

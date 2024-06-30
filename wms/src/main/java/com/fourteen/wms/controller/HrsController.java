package com.fourteen.wms.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fourteen.wms.common.QueryPageParam;
import com.fourteen.wms.common.Result;
import com.fourteen.wms.entity.Hrs;
import com.fourteen.wms.entity.Hrs;
import com.fourteen.wms.entity.User;
import com.fourteen.wms.service.HrsService;
import com.fourteen.wms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author akaziki
 * @since 2024-06-27
 */
@RestController
@RequestMapping("/hrs")
public class HrsController {
    @Autowired
    private HrsService hrsService;

    @PostMapping("/listPageC")
    public Result listPageC(@RequestBody QueryPageParam qParam) {
        HashMap map = qParam.getParam();
        String name = (String)map.get("name");

        Page<Hrs> page = new Page<>();
        page.setCurrent(qParam.getPageNum());
        page.setSize(qParam.getPageSize());

        LambdaQueryWrapper<Hrs> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        if(StringUtils.isNotBlank(name) && !"null".equals(name))
        {
            // like 模糊查询
            lambdaQueryWrapper.like(Hrs::getName, name);
        }
        IPage<Hrs> result = hrsService.page(page, lambdaQueryWrapper);

        return Result.suc(result.getTotal(), result.getRecords());
    }

    @PostMapping("/search")
    public Result search(@RequestBody HashMap hashMap) {
        int id = (Integer) hashMap.get("id");
        System.out.println(id);
        Hrs hrs = hrsService.getById(id);
        return hrs!=null?Result.suc(hrs):Result.fail();
    }

    @PostMapping("/saveOrMod")
    public Result saveOrMod(@RequestBody Hrs hrs) {
        return hrsService.saveOrUpdate(hrs)?Result.suc():Result.fail();
    }

    @PostMapping("/delete")
    public Result del(@RequestBody Hrs hrs) {
        return hrsService.removeById(hrs.getHRid())?Result.suc():Result.fail();
    }
}

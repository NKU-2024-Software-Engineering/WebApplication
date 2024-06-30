package com.fourteen.wms.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fourteen.wms.common.QueryPageParam;
import com.fourteen.wms.common.Result;
import com.fourteen.wms.entity.Cvs;
import com.fourteen.wms.entity.Cvs;
import com.fourteen.wms.entity.User;
import com.fourteen.wms.service.CvsService;

import org.apache.logging.log4j.message.ReusableMessage;
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
 * @since 2024-06-26
 */
@RestController
@RequestMapping("/cvs")
public class CvsController {
    @Autowired
    private CvsService cvsService;

    @PostMapping("/listPageC")
    public Result listPageC(@RequestBody QueryPageParam qParam) {

        HashMap map = qParam.getParam();
        String name = (String)map.get("name");

        Page<Cvs> page = new Page<>();
        page.setCurrent(qParam.getPageNum());
        page.setSize(qParam.getPageSize());

        LambdaQueryWrapper<Cvs> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        if(StringUtils.isNotBlank(name) && !"null".equals(name))
        {
            // like 模糊查询
            lambdaQueryWrapper.like(Cvs::getUid, name);
        }
        IPage<Cvs> result = cvsService.page(page, lambdaQueryWrapper);

        return Result.suc(result.getTotal(), result.getRecords());
    }

    @PostMapping("/search")
    public Result search(@RequestBody HashMap hashMap) {
        int id = (Integer) hashMap.get("id");
        System.out.println(id);
        Cvs cvs = cvsService.getById(id);
        return cvs!=null?Result.suc(cvs):Result.fail();
    }

    @PostMapping("/saveOrMod")
    public Result saveOrMod(@RequestBody Cvs cvs) {
        return cvsService.saveOrUpdate(cvs)?Result.suc():Result.fail();
    }

    @PostMapping("/delete")
    public Result del(@RequestBody Cvs cvs) {
        return cvsService.removeById(cvs.getCid())?Result.suc():Result.fail();
    }
}

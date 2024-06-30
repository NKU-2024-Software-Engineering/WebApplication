package com.fourteen.wms.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fourteen.wms.common.QueryPageParam;
import com.fourteen.wms.common.Result;
import com.fourteen.wms.entity.Companys;
import com.fourteen.wms.entity.Hrs;
import com.fourteen.wms.entity.Jseekers;
import com.fourteen.wms.service.CompanysService;
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
 * @since 2024-06-30
 */
@RestController
@RequestMapping("/companys")
public class CompanysController {

    @Autowired
    private CompanysService companysService;

    /**
     * 将所有公司进行列出
     * @param qParam
     * @return
     */
    @PostMapping("/listPageC")
    public Result listPageC(@RequestBody QueryPageParam qParam) {
        HashMap map = qParam.getParam();
        String name = (String)map.get("name");

        Page<Companys> page = new Page<>();
        page.setCurrent(qParam.getPageNum());
        page.setSize(qParam.getPageSize());

        LambdaQueryWrapper<Companys> lambdaQueryWrapper = new LambdaQueryWrapper<>();

        if(StringUtils.isNotBlank(name) && !"null".equals(name))
        {
            // like 模糊查询
            lambdaQueryWrapper.like(Companys::getCname, name);
        }

        IPage<Companys> result = companysService.page(page, lambdaQueryWrapper);

        return Result.suc(result.getTotal(), result.getRecords());
    }

    @PostMapping("/saveOrMod")
    public Result saveOrMod(@RequestBody Companys companys) {
        return companysService.saveOrUpdate(companys)?Result.suc():Result.fail();
    }
}

package com.fourteen.wms.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.fourteen.wms.common.Result;
import com.fourteen.wms.entity.Jobs;
import com.fourteen.wms.entity.User;
import com.fourteen.wms.service.JobsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author akaziki
 * @since 2024-06-30
 */
@RestController
@RequestMapping("/jobs")
public class JobsController {

    @Autowired
    private JobsService jobsService;

    @PostMapping("/saveOrMod")
    public Result saveOrMod(@RequestBody Jobs jobs) {
        return jobsService.saveOrUpdate(jobs)?Result.suc():Result.fail();
    }

    @PostMapping("/delete")
    public Result del(@RequestBody Jobs jobs) {
        return jobsService.removeById(jobs.getJobid())?Result.suc():Result.fail();
    }

    /**
     * 列出某个HR发出的岗位
     * @param jobs
     * @return
     */
    @PostMapping("/listjobs")
    public Result listjobs(@RequestBody Jobs jobs) {
        LambdaQueryWrapper<Jobs> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(Jobs::getHr, jobs.getHr());
        List list = jobsService.list(lambdaQueryWrapper);
        return list.size() > 0 ? Result.suc(list) : Result.fail();
    }

    /**
     * 列出某个公司的岗位
     * @param jobs
     * @return
     */
    @PostMapping("/listcjobs")
    public Result listcjobs(@RequestBody Jobs jobs) {
        LambdaQueryWrapper<Jobs> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(Jobs::getCompany, jobs.getCompany());
        List list = jobsService.list(lambdaQueryWrapper);
        return list.size() > 0 ? Result.suc(list) : Result.fail();
    }

    /**
     * 列出某个岗位
     * @param jobs
     * @return
     */
    @PostMapping("/listjob")
    public Result listjob(@RequestBody Jobs jobs) {
        LambdaQueryWrapper<Jobs> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(Jobs::getJob, jobs.getJob());
        List list = jobsService.list(lambdaQueryWrapper);
        return list.size() > 0 ? Result.suc(list) : Result.fail();
    }

}

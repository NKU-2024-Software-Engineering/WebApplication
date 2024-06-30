package com.fourteen.wms.controller;

import com.fourteen.wms.common.Result;
import com.fourteen.wms.entity.Seeks;
import com.fourteen.wms.entity.User;
import com.fourteen.wms.service.SeeksService;
import com.fourteen.wms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.ResultSet;
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
@RequestMapping("/seeks")
public class SeeksController {

    @Autowired
    private SeeksService seeksService;

    /**
     * 新建一个投递简历的日志
     * @param seeks 某人对某个岗位投递
     * @return 若未存在则成功，已存在则失败
     */
    @PostMapping("/new")
    public Result register(@RequestBody Seeks seeks){

        List list = seeksService.lambdaQuery().eq(Seeks::getJid,seeks.getJid())
                .eq(Seeks::getJseeker,seeks.getJseeker())
                .list();


        return list.size() == 0?Result.suc():Result.fail();

    }

    /**
     * 查看某个岗位有哪些人投递
     * @param seeks
     * @return
     */
    @PostMapping("/listseeker")
    public Result listseeker(@RequestBody Seeks seeks){

        List list = seeksService.lambdaQuery().eq(Seeks::getJid,seeks.getJid())
                .list();

        return list.size() > 0?Result.suc(list):Result.fail();

    }

    /**
     * 查看某个人投递了哪些岗位
     * @param seeks
     * @return
     */
    @PostMapping("/listjobs")
    public Result listjobs(@RequestBody Seeks seeks){

        List list = seeksService.lambdaQuery().eq(Seeks::getJseeker,seeks.getJseeker())
                .list();

        return list.size() > 0?Result.suc(list):Result.fail();

    }
}

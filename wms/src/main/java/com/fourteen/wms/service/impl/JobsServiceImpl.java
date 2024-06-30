package com.fourteen.wms.service.impl;

import com.fourteen.wms.entity.Jobs;
import com.fourteen.wms.mapper.JobsMapper;
import com.fourteen.wms.service.JobsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author akaziki
 * @since 2024-06-30
 */
@Service
public class JobsServiceImpl extends ServiceImpl<JobsMapper, Jobs> implements JobsService {

}

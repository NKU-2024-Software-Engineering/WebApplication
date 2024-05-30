package com.fourteen.wms.service.impl;

import com.fourteen.wms.entity.User;
import com.fourteen.wms.mapper.UserMapper;
import com.fourteen.wms.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author akaziki
 * @since 2024-05-30
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}

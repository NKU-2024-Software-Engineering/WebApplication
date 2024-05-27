package com.fourteen.wms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.fourteen.wms.entity.User;

import java.util.List;

public interface UserService extends IService<User> {
    List<User> listAll();
}

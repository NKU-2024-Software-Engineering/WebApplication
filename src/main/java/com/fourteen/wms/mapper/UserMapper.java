package com.fourteen.wms.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fourteen.wms.entity.User;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author akaziki
 * @since 2024-05-27
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}

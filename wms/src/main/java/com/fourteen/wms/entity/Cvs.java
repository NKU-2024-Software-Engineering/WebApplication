package com.fourteen.wms.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author akaziki
 * @since 2024-06-26
 */
@Getter
@Setter
@Accessors(chain = true)
@ApiModel(value = "Cvs对象", description = "")
public class Cvs implements Serializable {

    private static final long serialVersionUID = 1L;

    private String 姓名;

    private String 手机号;

    private String 紧急联系人;

    private String 紧急联系人电话;

    private String 意向岗位;

    private String 自我评价;

    private String 技能特长;

    private String 经历;

    @TableId(value = "简历id", type = IdType.AUTO)
    private Integer 简历id;

    private Integer 用户id;
}

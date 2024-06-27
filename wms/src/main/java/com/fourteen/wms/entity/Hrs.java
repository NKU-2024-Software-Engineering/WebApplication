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
 * @since 2024-06-27
 */
@Getter
@Setter
@Accessors(chain = true)
@ApiModel(value = "Hrs对象", description = "")
public class Hrs implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer 用户id;

    @TableId(value = "HRid", type = IdType.AUTO)
    private Integer hRid;

    private String 公司;

    private String 姓名;

    private String 联系方式;
}

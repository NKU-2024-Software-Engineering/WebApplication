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
 * @since 2024-06-30
 */
@Getter
@Setter
@Accessors(chain = true)
@ApiModel(value = "Hrs对象", description = "")
public class Hrs implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("对应的用户表中的ID")
    private Integer uid;

    @ApiModelProperty("HR表的序列")
    @TableId(value = "HRid", type = IdType.AUTO)
    private Integer hRid;

    @ApiModelProperty("公司名")
    private String companyid;

    @ApiModelProperty("HR的姓名")
    private String name;

    @ApiModelProperty("HR的联系方式	")
    private String telephone;
}

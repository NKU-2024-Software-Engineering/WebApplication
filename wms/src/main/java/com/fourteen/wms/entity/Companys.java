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
@ApiModel(value = "Companys对象", description = "")
public class Companys implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("公司名")
    private String cname;

    @ApiModelProperty("公司地址")
    private String caddress;

    @ApiModelProperty("公司表的序列")
    @TableId(value = "companyid", type = IdType.AUTO)
    private Integer companyid;

    @ApiModelProperty("公司的介绍")
    private String cintroduction;
}

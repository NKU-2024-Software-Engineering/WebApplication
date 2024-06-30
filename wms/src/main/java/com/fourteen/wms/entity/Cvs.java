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
@ApiModel(value = "Cvs对象", description = "")
public class Cvs implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("个人姓名")
    private String name;

    @ApiModelProperty("联系方式")
    private String telephone;

    @ApiModelProperty("紧急联系人")
    private String econtact;

    @ApiModelProperty("紧急联系人的联系方式")
    private String ectelephone;

    @ApiModelProperty("意向岗位")
    private String iposition;

    @ApiModelProperty("自我评价")
    private String sevaluation;

    @ApiModelProperty("技能特长")
    private String skills;

    @ApiModelProperty("个人经历")
    private String exp;

    @ApiModelProperty("简历表的序列")
    @TableId(value = "cid", type = IdType.AUTO)
    private Integer cid;

    @ApiModelProperty("对应的用户的id 用于在用户表查询")
    private Integer uid;
}

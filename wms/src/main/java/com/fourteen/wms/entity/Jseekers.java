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
@ApiModel(value = "Jseekers对象", description = "")
public class Jseekers implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("求职者的ID 唯一")
    @TableId(value = "Jid", type = IdType.AUTO)
    private Integer jid;

    @ApiModelProperty("求职者对应的简历")
    private Integer cid;

    @ApiModelProperty("求职者对应的用户ID")
    private Integer uid;
}

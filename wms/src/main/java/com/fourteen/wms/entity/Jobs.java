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
@ApiModel(value = "Jobs对象", description = "")
public class Jobs implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("岗位要求")
    private String requirement;

    private String job;

    private String company;

    private Integer hr;

    @TableId(value = "jobid", type = IdType.AUTO)
    private Integer jobid;
}

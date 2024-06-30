package com.fourteen.wms.entity;

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
@ApiModel(value = "Seeks对象", description = "")
public class Seeks implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("投递简历的求职者id")
    private String jseeker;

    @ApiModelProperty("投递的工作岗位id")
    private Integer jid;
}

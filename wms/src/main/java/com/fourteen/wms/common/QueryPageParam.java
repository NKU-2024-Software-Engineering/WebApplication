package com.fourteen.wms.common;

import java.util.HashMap;

import lombok.Data;

/**
 * @author user
 * @className QueryPageParam
 * @description 查询参数
 * @date 2024/05/27 15:57
 */
@Data
public class QueryPageParam {
    // 设置默认值
    private static int PAGE_SIZE = 20;
    private static int PAGE_NUM = 1;
    private int pageSize = PAGE_SIZE;
    private int pageNum = PAGE_NUM;
    private HashMap param ;
}

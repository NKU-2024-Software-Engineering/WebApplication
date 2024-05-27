package com.fourteen.wms.common;

import lombok.Data;

/**
 * @author user
 * @className Result
 * @description 返回给前端的信息封装
 * @date 2024/05/27 16:58
 */
@Data
public class Result {
    private int code;// 200 / 400
    private String msg;// 成功/失败
    private Long total;// 总记录数
    private Object data; // 数据

    public static Result result(int code, String msg, Long total, Object data) {
        Result res = new Result();
        res.setCode(code);
        res.setMsg(msg);
        res.setTotal(total);
        res.setData(data);
        return res;
    }

    public static Result fail() {
        return result(400, "失败", 0L, null);
    }

    public static Result suc() {
        return result(200, "成功", 0L, null);
    }

    public static Result suc(Object data) {
        return result(200, "成功", 0L, data);
    }

    public static Result suc(Long total, Object data) {
        return result(200, "成功", total, data);
    }
}

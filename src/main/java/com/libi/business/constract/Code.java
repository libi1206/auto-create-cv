package com.libi.business.constract;

import lombok.Data;
import lombok.Getter;

/**
 * @author :Libi
 * @version :1.0
 * @date :2019-08-03 19:45
 * 返回码和返回信息
 */
@Getter
public enum Code {
    /**
     * 请求成功
     */
    SUCCESS(0, "成功"),
    NO_PARAM(1000, "缺少参数"),
    CV_NOT_FIND(2000, "相关pdf已失效"),
    MAKE_PDF_ERROR(3000, "PDF生成失败，检查网址填写是否正确"),

    /**
     * 服务器异常,大概率时出现bug
     */
    UNKNOWN_ERROR(9000,"服务器异常");

    private int code;
    private String  msg;

    Code(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}

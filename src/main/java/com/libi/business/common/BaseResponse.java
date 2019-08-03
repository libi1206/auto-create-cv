package com.libi.business.common;

import com.libi.business.constract.Code;
import lombok.Data;

/**
 * @author :Libi
 * @version :1.0
 * @date :2019-08-03 16:39
 * 一个基础的请求模板
 */
@Data
public class BaseResponse<T> {
    private int code;
    private String msg;
    private T data;

    BaseResponse() {

    }

    BaseResponse(Code code) {
        this.code = code.getCode();
        this.msg = code.getMsg();
    }
}

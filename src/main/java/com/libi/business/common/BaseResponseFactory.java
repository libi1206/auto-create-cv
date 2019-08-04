package com.libi.business.common;

import com.libi.business.constract.Code;

/**
 * @author :Libi
 * @version :1.0
 * @date :2019-08-03 16:42
 * 响应模板的工厂类
 */
public class BaseResponseFactory {
    public static BaseResponse getSuccessResponse(Object data) {
        return getResponse(Code.SUCCESS,data);
    }

    public static BaseResponse getSuccessResponse() {
        return getSuccessResponse(null);
    }

    public static BaseResponse getResponse(Code code) {
        BaseResponse baseResponse = new BaseResponse(code);
        baseResponse.setData(null);
        return baseResponse;
    }

    public static BaseResponse getResponse(Code code, Object data) {
        BaseResponse baseResponse = new BaseResponse(code);
        baseResponse.setData(data);
        return baseResponse;
    }

    public static BaseResponse getResponse(int code, String msg, Object data) {
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setData(data);
        baseResponse.setCode(code);
        baseResponse.setMsg(msg);
        return baseResponse;
    }

}

package com.libi.business.exception;

import com.libi.business.common.BaseResponse;
import com.libi.business.common.BaseResponseFactory;
import com.libi.business.constract.Code;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author :Libi
 * @version :1.0
 * @date :2019-08-03 21:09
 */
@org.springframework.web.bind.annotation.ControllerAdvice
public class GlobalExceptionControllerAdvice {
    private static Logger logger = LoggerFactory.getLogger(GlobalExceptionControllerAdvice.class);

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public BaseResponse handleNoParamException(Exception e) {
        logger.warn(e.getMessage());
        e.printStackTrace();
        return BaseResponseFactory.getResponse(Code.NO_PAARAM, null);
    }

}

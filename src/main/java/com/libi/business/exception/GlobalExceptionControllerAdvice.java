package com.libi.business.exception;

import com.github.jhonnymertz.wkhtmltopdf.wrapper.exceptions.PDFExportException;
import com.libi.business.common.BaseResponse;
import com.libi.business.common.BaseResponseFactory;
import com.libi.business.constract.Code;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.FileNotFoundException;

/**
 * @author :Libi
 * @version :1.0
 * @date :2019-08-03 21:09
 */
@ControllerAdvice
public class GlobalExceptionControllerAdvice {
    private static Logger logger = LoggerFactory.getLogger(GlobalExceptionControllerAdvice.class);

    @ExceptionHandler(FileNotFoundException.class)
    @ResponseBody
    public BaseResponse handleFileNotFindException(FileNotFoundException e) {
        logger.warn(e.getMessage());
        e.printStackTrace();
        return BaseResponseFactory.getResponse(Code.CV_NOT_FIND, null);
    }

    @ExceptionHandler(PDFExportException.class)
    @ResponseBody
    public BaseResponse handlePdfExportException(PDFExportException e) {
        logger.warn(e.getMessage());
        e.printStackTrace();
        return BaseResponseFactory.getResponse(Code.MAKE_PDF_ERROR, null);
    }


    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseBody
    public BaseResponse handleHttpMessageNotReadableException(HttpMessageNotReadableException e) {
        logger.warn(e.getMessage());
        e.printStackTrace();
        return BaseResponseFactory.getResponse(Code.NO_PARAM, e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public BaseResponse handleUnknownException(Exception e) {
        logger.warn(e.getMessage());
        e.printStackTrace();
        return BaseResponseFactory.getResponse(Code.UNKNOWN_ERROR, null);
    }

}

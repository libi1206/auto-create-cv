package com.libi.controller;

import com.libi.business.common.BaseResponse;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author :Libi
 * @version :1.0
 * @date :2019-08-03 16:36
 * 用于根据网页生成PDF的controller
 */
@RestController
public class CvController {
    //TODO swagger相关注解没写
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String homePage() {
        return "Welcome SuperCV!";
    }

    @RequestMapping(value = "/getCV", method = RequestMethod.POST)
    public BaseResponse getCV(@RequestBody String pdfUrl) {
        return null;
    }
}

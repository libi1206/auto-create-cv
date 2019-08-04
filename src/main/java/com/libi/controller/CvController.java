package com.libi.controller;

import com.libi.business.common.BaseResponse;
import com.libi.servise.CvService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * @author :Libi
 * @version :1.0
 * @date :2019-08-03 16:36
 * 用于根据网页生成PDF的controller
 */
@Api("用于制作简历pdf")
@RestController
@RequestMapping("/cv")
public class CvController {
    @Autowired
    private CvService cvService;

    @ApiOperation("主页，用于测试项目启动")
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String homePage() {
        return "Welcome to SuperCV!";
    }

    @ApiOperation("获得简历PDF所在的wrl")
    @RequestMapping(value = "/getCv", method = RequestMethod.POST)
    public BaseResponse getCv(@ApiParam("简历网址") @RequestBody String cvUrl) throws IOException, InterruptedException {
        return cvService.createPdf(cvUrl);
    }
}

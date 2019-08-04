package com.libi.controller;

import com.libi.business.common.BaseResponse;
import com.libi.business.common.BaseResponseFactory;
import com.libi.servise.DownloadService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author :Libi
 * @version :1.0
 * @date :2019-08-04 14:17
 */
@Api("下载简历模块")
@RestController()
@RequestMapping("/download")
public class DownloadController {
    @Autowired
    private DownloadService downloadService;

    @ApiOperation("下载文件的接口")
    @RequestMapping(value = "/{uuid}", method = RequestMethod.GET)
    public BaseResponse downloadCv(@PathVariable("uuid") String uuid, HttpServletResponse response) throws IOException {
        return downloadService.downloadCv(response,uuid);
    }
}

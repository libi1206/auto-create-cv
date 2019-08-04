package com.libi.servise.impl;

import com.github.jhonnymertz.wkhtmltopdf.wrapper.Pdf;
import com.github.jhonnymertz.wkhtmltopdf.wrapper.params.Param;
import com.libi.business.common.BaseResponse;
import com.libi.business.common.BaseResponseFactory;
import com.libi.servise.CvService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @author :Libi
 * @version :1.0
 * @date :2019-08-03 21:41
 */
@Service
public class CvServiceImpl implements CvService {
    @Value("${cv-file-path}")
    private static String FILE_PATH;
    @Value("${cv-url-path}")
    private static String URL_PATH;

    @Override
    public BaseResponse<String> createPdf(String pdfUrl) throws IOException, InterruptedException {
        //创建pdf
        Pdf pdf = new Pdf();
        //生成pdf的文件名
        String pdfName = UUID.randomUUID().toString();

        //从url生成url
        pdf.addPageFromUrl(pdfUrl);

        //Add a Table of Contents
        pdf.addToc();

        //下面的操作是使用他们都各种参数
        pdf.addParam(new Param("--enable-javascript"));
        pdf.addParam(new Param("--no-stop-slow-scripts"));

        // 生成pdf的位置
        File file = ResourceUtils.getFile(FILE_PATH + pdfName + ".pdf");
        pdf.saveAs(file.getPath());
        return BaseResponseFactory.getSuccessResponse(URL_PATH + pdfName);
    }
}

package com.libi.servise.impl;

import com.github.jhonnymertz.wkhtmltopdf.wrapper.Pdf;
import com.github.jhonnymertz.wkhtmltopdf.wrapper.params.Param;
import com.libi.business.common.BaseResponse;
import com.libi.business.common.BaseResponseFactory;
import com.libi.business.model.vo.CvNameVo;
import com.libi.servise.CvService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.UUID;

/**
 * @author :Libi
 * @version :1.0
 * @date :2019-08-03 21:41
 */
@Slf4j
@Service
public class CvServiceImpl implements CvService {
    @Value("${cv-file-path-key}")
    private String FILE_PATH_KEY;
    @Value("${cv-url-path}")
    private String URL_PATH;

    @Override
    public BaseResponse<CvNameVo> createPdf(String pdfUrl) throws IOException, InterruptedException {
        //创建pdf
        Pdf pdf = new Pdf();
        //生成pdf的文件名
        String pdfName = UUID.randomUUID().toString()+".pdf";

        //从url生成url
        pdf.addPageFromUrl(pdfUrl);

        //Add a Table of Contents
        pdf.addToc();

        //下面的操作是使用他们都各种参数
        pdf.addParam(new Param("--enable-javascript"));
        pdf.addParam(new Param("--no-stop-slow-scripts"));

        // 生成pdf的位置
        String path = System.getProperty(FILE_PATH_KEY);
        pdf.saveAs(path+"/"+pdfName);
        CvNameVo cvNameVo = new CvNameVo();
        cvNameVo.setUuid(pdfName);
        return BaseResponseFactory.getSuccessResponse(cvNameVo);
    }
}

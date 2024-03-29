package com.libi.servise;

import com.libi.business.common.BaseResponse;
import com.libi.business.model.vo.CvNameVo;

import java.io.IOException;

/**
 * @author :Libi
 * @version :1.0
 * @date :2019-08-03 21:37
 * 生成简历PDF的业务接口
 */
public interface CvService {
    /**
     * 创建
     * @param pdfUrl
     * @return
     */
    BaseResponse<CvNameVo> createPdf(String pdfUrl) throws IOException, InterruptedException;
}

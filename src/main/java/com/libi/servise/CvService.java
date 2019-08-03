package com.libi.servise;

import com.libi.business.common.BaseResponse;

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
    BaseResponse<String> createPdf(String pdfUrl);
}

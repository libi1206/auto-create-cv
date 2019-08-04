package com.libi.servise;

import com.libi.business.common.BaseResponse;
import lombok.SneakyThrows;

import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author :Libi
 * @version :1.0
 * @date :2019-08-04 14:18
 */
public interface DownloadService {
    /**
     * 下载简历的业务逻辑
     * @param response
     * @return
     */
    BaseResponse downloadCv(HttpServletResponse response, String uuid) throws IOException;
}

package com.libi.servise.impl;

import com.libi.business.common.BaseResponse;
import com.libi.business.common.BaseResponseFactory;
import com.libi.servise.DownloadService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * @author :Libi
 * @version :1.0
 * @date :2019-08-04 14:21
 */
@Service
public class DownloadServiceImpl implements DownloadService {
    @Value("${cv-file-path-key}")
    private String FILE_PATH;
    @Value("${cv-url-path}")
    private String URL_PATH;

    @Override
    public BaseResponse downloadCv(HttpServletResponse response, String uuid) throws IOException {
        String fileName = FILE_PATH + uuid;
        //设置文件路径
        File file = ResourceUtils.getFile(fileName);
        //File file = new File(realPath , fileName);
        if (file.exists()) {
            // 设置强制下载不打开
            response.setContentType("application/force-download");
            // 设置文件名
            response.addHeader("Content-Disposition", "attachment;fileName=" + uuid+".pdf");
            byte[] buffer = new byte[1024];
            FileInputStream fis = null;
            BufferedInputStream bis = null;
            try {
                fis = new FileInputStream(file);
                bis = new BufferedInputStream(fis);
                OutputStream os = response.getOutputStream();
                int i = bis.read(buffer);
                while (i != -1) {
                    os.write(buffer, 0, i);
                    i = bis.read(buffer);
                }
                return BaseResponseFactory.getSuccessResponse();
            } finally {
                bis.close();
                fis.close();
            }
        }
        throw new FileNotFoundException("uuid是"+uuid+"的相关简历找不到");
    }
}

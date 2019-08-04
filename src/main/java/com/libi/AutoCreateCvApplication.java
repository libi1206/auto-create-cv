package com.libi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author :Libi
 * @version :1.0
 * @date :2019-08-03 16:19
 */

@EnableSwagger2
@SpringBootApplication
public class AutoCreateCvApplication {

    public static void main(String[] args) {
        SpringApplication.run(AutoCreateCvApplication.class, args);
    }

}

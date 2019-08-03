package com.libi.business.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @author :Libi
 * @version :1.0
 * @date :2019-08-03 16:19
 */
@Configuration
public class SwaggerConfig {

    @Bean
    public Docket docket(ApiInfo apiInfo) {

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo)
                .select()
                //扫描的包
                .apis(RequestHandlerSelectors.basePackage("com.libi.controller"))
                .paths(PathSelectors.any())
                .build()
                ;
    }

    /**
     * 创建一个api信息
     * @return
     */
    @Bean
    public ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                //api的标题
                .title("swagger测试")
                //描述
                .description("这是一个测试swagger，jwt和jpa的Demo")
                .version("0.1")
                .build();
    }

}

package com.libi.business.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author :Libi
 * @version :1.0
 * @date :2019-08-03 21:45
 */
@WebFilter(urlPatterns = {"/"},filterName = "defaultFilter")
@Component
public class ControllerFilter implements Filter {
    Logger logger = LoggerFactory.getLogger(ControllerFilter.class);
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        //记录当前时间
        logger.info("===>开始访问：url:{}, method:{}",request.getRequestURI(),request.getMethod());
        long start = System.currentTimeMillis();

        //把这个请求交给下一个拦截器
        filterChain.doFilter(servletRequest, servletResponse);

        //记录执行完的时间
        long time = System.currentTimeMillis() - start;
        logger.info("<===结束访问：url:{}, method:{}, time:{}ms",request.getRequestURI(),request.getMethod(),time);
    }

    @Override
    public void destroy() {

    }
}

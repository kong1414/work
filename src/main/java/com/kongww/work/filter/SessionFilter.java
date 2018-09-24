package com.kongww.work.filter;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @Author: QiuGuanLin
 * @Description: 过滤器测试
 * @Date: 0:28 2018/9/25
 */
@WebFilter(filterName = "myFilter", urlPatterns = "/*")
public class SessionFilter implements Filter {
    /**
     * 执行过滤操作
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        chain.doFilter(request, response);
        System.out.println("执行过滤操作。。。");
    }

    /**
     * 过滤器初始化
     */
    @Override
    public void init(FilterConfig config) throws ServletException {
        System.out.println("过滤器初始化。。。");
    }

    /**
     * 过滤器销毁
     */
    @Override
    public void destroy() {
        System.out.println("过滤器销毁。。。");
    }

}
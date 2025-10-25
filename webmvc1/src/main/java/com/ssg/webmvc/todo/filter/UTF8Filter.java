package com.ssg.webmvc.todo.filter;

import lombok.extern.log4j.Log4j2;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(urlPatterns = {"/*"})
@Log4j2
public class UTF8Filter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("UTF8Filter........");

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        // 모든 요청에 대해서 한글 필터 적용
        request.setCharacterEncoding("UTF-8");
        filterChain.doFilter(servletRequest,servletResponse);

    }
}

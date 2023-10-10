package com.example.zuulservice.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@Component
public class ZuulLoggingFilter extends ZuulFilter {

    // 실제 동작
    @Override
    public Object run() throws ZuulException {
        log.info("=============================================" + "printing logs ");

        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        log.info("=============================================" + request.getRequestURI());

        return null;
    }

    // 사전 - pre, 사후 - post
    @Override
    public String filterType() {
        return "pre";
    }

    // 여러 filter 가 있을 경우, 순서
    @Override
    public int filterOrder() {
        return 1;
    }

    // filter 로 쓸꺼다!
    @Override
    public boolean shouldFilter() {
        return true;
    }
}

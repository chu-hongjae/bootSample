package com.chu.web.common.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
@Slf4j
public class ReqBodyLogFIlter implements Filter {

  @Override
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
      FilterChain filterChain) throws IOException, ServletException {

    ReadableRequestBodyWrapper wrapper = new ReadableRequestBodyWrapper(
        (HttpServletRequest) servletRequest);

    servletRequest.setAttribute("reqBody", wrapper.getRequestBody());

    filterChain.doFilter(wrapper, servletResponse);
  }

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {

  }

  @Override
  public void destroy() {

  }
}

package com.chu.web.common.interceptor;

import com.chu.web.dao.SysAuthMatchUrlRepository;
import com.chu.web.vo.sys.SysAuthMatchUrlVO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
public class TokenCheckInterceptor implements HandlerInterceptor {



  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
      throws Exception {
      log.debug("#########################################################################");
      log.info("req url : {}", request.getRequestURI());
      log.info("reqbody : {}", request.getAttribute("reqBody"));
    log.debug("#########################################################################");
    return true;
  }

  @Override
  public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
      ModelAndView modelAndView) throws Exception {

  }
}

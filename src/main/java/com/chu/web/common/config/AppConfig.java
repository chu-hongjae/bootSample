package com.chu.web.common.config;

import com.chu.web.common.filter.ReqBodyLogFIlter;
import com.chu.web.common.interceptor.RequestParamInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Slf4j
@Configuration
public class AppConfig implements WebMvcConfigurer {


  @Bean
  public ReqBodyLogFIlter reqBodyLogFIlter(){
    return new ReqBodyLogFIlter();
  }

  @Bean
  public RequestParamInterceptor requestParamInterceptor(){
    return new RequestParamInterceptor();
  }

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(requestParamInterceptor())
        .addPathPatterns("/**");
  }



}

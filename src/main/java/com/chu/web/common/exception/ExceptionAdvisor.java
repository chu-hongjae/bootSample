package com.chu.web.common.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@ControllerAdvice
public class ExceptionAdvisor {

  @ExceptionHandler(CommonException.class)
  public ResponseEntity<ErrorResponse> commonExceptionHandler(CommonException e) {
    ErrorResponse response = new ErrorResponse();
    response.setCode(e.getCode());
    response.setMessage(e.getMessage());
    return new ResponseEntity<>(response, HttpStatus.valueOf(e.getStatus()));
  }
}

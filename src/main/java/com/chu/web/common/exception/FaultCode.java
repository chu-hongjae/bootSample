package com.chu.web.common.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum FaultCode {
    INVALID_USER_INFO(HttpStatus.UNAUTHORIZED.value(),"FAT-401","INVALID USER INFO")
  , INTERAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR.value(),"FAT-500" ,"INTERNAL_SERVER_ERROR");

  private final String code;
  private final String message;
  private int status;

  FaultCode(final int status, final String code, final String message) {
    this.status = status;
    this.message = message;
    this.code = code;
  }
}

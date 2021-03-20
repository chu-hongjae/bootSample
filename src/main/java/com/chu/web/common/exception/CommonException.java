package com.chu.web.common.exception;

import java.util.List;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.validation.FieldError;

@Getter
public class CommonException extends RuntimeException{
  private String code;
  private String message;
  private int status;

  public CommonException(FaultCode faultCode){
    this.status = faultCode.getStatus();
    this.message = faultCode.getMessage();
    this.code = faultCode.getCode();
  }

}

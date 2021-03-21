package com.chu.web.vo.sys;

import javax.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SysGetTokenVO {
  @NotEmpty
  private String userId;
  @NotEmpty
  private String userPwd;
}

package com.chu.web.vo.sys;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import lombok.Data;

@Data
@Entity(name = "TB_USER_MST")
public class SysUserVO {

  @Id
  @Column(length = 200)
  @NotEmpty
  private String userId;

  private String userName;

  @NotEmpty
  private String userPwd;
  @NotEmpty

  private String userTelNo;
  private int passwordNotMatchCnt;


}

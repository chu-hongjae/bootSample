package com.chu.web.vo.sys;

import com.chu.web.common.utils.PasswordConvertor;
import com.chu.web.vo.common.CommonVO;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Converter;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import lombok.Data;

@Data
@Entity(name = "TB_USER_MST")
public class SysUserVO{

  @Id
  @Column(name = "user_id" ,length = 200)
  @NotEmpty
  private String userId;
  @Column(name = "user_name" )

  private String userName;

  @Column(name = "user_pwd")
  @NotEmpty
  private String userPwd;
  @Column(name = "user_tel_no")
  private String userTelNo;
  @Column(name = "pwd_not_match_cnt")
  private int passwordNotMatchCnt;


}

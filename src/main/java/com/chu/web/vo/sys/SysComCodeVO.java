package com.chu.web.vo.sys;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity(name = "TB_COMM_CODE_MST")
public class SysComCodeVO implements Serializable {


  @Column(name = "com_grp_cd")
  private String comGrpCd;
  @Id
  @Column(name = "com_cd" ,length = 200)
  private String comCd;

  private String comCdNm;
  private String ref01;
  private String ref02;
  private String ref03;
  private String ref04;
  private String ref05;
  private String useYn;
  private int order_no;
  @Column(name = "reg_id")
  private String regId;
  @Column(name = "reg_date")
  private Date regDate;

  @Column(name = "mod_id")
  private String modId;
  @Column(name = "mod_date")
  private Date modDate;


}

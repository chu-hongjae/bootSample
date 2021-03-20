package com.chu.web.vo.sys;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Data;

@Data
@Entity(name = "TB_COMM_CODE_GRP_MST")
public class SysComGrpCodeVO {


  @Id
  @Column(length = 200)
  private String comGrpCd;

  private String comGrpCdNm;
  private String ref01;
  private String ref02;
  private String ref03;
  private String ref04;
  private String ref05;
  private String useYn;
  private int orderNo;
  private String regId;
  private Date regDate;
  private String modId;
  private Date modDate;


}

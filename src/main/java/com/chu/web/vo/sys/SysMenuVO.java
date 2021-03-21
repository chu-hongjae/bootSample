package com.chu.web.vo.sys;

import com.chu.web.vo.common.CommonVO;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "TB_MENU_MST")
public class SysMenuVO {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long menuId;
  private String menuName;

  private String menuUrl;

  private int sortNum;
  private String regId;
  private Date regDate;

  private String modId;
  private Date modDate;

}

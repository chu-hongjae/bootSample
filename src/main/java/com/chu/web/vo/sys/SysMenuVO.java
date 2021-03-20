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
  @Column(name = "menu_id")
  private long menuId;
  @Column(name = "menu_name")
  private String menuName;

  @Column(name = "menu_url")
  private String menuUrl;

  @Column(name = "sort_num")
  private int sortNum;
  @Column(name = "reg_id")
  private String regId;
  @Column(name = "reg_date")
  private Date regDate;

  @Column(name = "mod_id")
  private String modId;
  @Column(name = "mod_date")
  private Date modDate;

}

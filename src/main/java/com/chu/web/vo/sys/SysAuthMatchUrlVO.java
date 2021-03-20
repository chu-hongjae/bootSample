package com.chu.web.vo.sys;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity(name = "TB_AUTH_MATCH_MST")
public class SysAuthMatchUrlVO {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  private String authCd;

  private String matchUrl;

  private String useYn;

}

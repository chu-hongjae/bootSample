package com.chu.web.controller;


import com.chu.web.common.exception.CommonException;
import com.chu.web.common.exception.FaultCode;
import com.chu.web.common.utils.JwtUtils;
import com.chu.web.service.sys.SysUserService;
import com.chu.web.vo.sys.SysUserVO;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
@RequestMapping("/auth")
public class SysAuthController {

  @Autowired
  SysUserService service;


  @PostMapping(path = "/getToken")
  @ResponseBody
  public String getToken(@RequestBody @Valid SysUserVO sysUserVO) {

    SysUserVO rtnUserVO = service.getUserById(sysUserVO);

    log.debug("rtnUserVO : {}", rtnUserVO);

    if (rtnUserVO == null) {
      throw new CommonException(FaultCode.INVALID_USER_INFO);
    }

    return JwtUtils.createToken(rtnUserVO.getUserId(), rtnUserVO.getUserPwd());
  }
}

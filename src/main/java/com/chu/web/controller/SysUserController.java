package com.chu.web.controller;

import com.chu.web.service.sys.SysUserService;
import com.chu.web.vo.sys.SysUserVO;
import java.util.List;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/sys/user")
@Controller
@Slf4j
public class SysUserController {

  @Autowired
  SysUserService userService;

  @PostMapping(path = "/getUserList")
  @ResponseBody
  public List<SysUserVO> getUserList() {
    log.debug("call~~~~~~~~~~~~~~~");
    return userService.getUserList().stream().peek(s -> s.setUserPwd(null))
        .collect(Collectors.toList());
  }

  @PostMapping(path = "/addUser")
  @ResponseBody
  public boolean addUser(@RequestBody SysUserVO userVO) {
    userService.add(userVO);
    return true;
  }

  @PostMapping(path = "/hello")
  @ResponseBody
  public String hello() {
    return "hello";
  }

}

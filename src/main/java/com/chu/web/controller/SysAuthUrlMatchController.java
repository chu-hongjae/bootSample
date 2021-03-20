package com.chu.web.controller;

import com.chu.web.service.sys.SysAuthMatchUrlService;
import com.chu.web.service.sys.SysUserService;
import com.chu.web.vo.sys.SysUserVO;
import java.util.List;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/sys/auth")
@Controller
@Slf4j
public class SysAuthUrlMatchController {

  @Autowired
  SysAuthMatchUrlService userService;

}

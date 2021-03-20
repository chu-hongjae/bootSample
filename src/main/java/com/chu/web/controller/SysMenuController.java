package com.chu.web.controller;

import com.chu.web.service.sys.SysMenuService;
import com.chu.web.vo.sys.SysMenuVO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/sys/menu")
@Controller
public class SysMenuController {

  @Autowired
  SysMenuService service;

  @PostMapping(path = "/getList")
  public List<SysMenuVO> getList() {
    return service.getMenuList();
  }

}

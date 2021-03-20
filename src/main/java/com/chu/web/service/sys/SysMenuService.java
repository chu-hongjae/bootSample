package com.chu.web.service.sys;

import com.chu.web.dao.SysMenuRepository;
import com.chu.web.vo.sys.SysMenuVO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysMenuService {

  @Autowired
  SysMenuRepository repository;

  public List<SysMenuVO> getMenuList() {
    return repository.findAll();
  }

  public void add(SysMenuVO menuVO){
     repository.save(menuVO);
  }

}

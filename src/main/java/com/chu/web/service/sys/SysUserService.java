package com.chu.web.service.sys;

import com.chu.web.dao.SysComCodeRepository;
import com.chu.web.dao.SysUserRepository;
import com.chu.web.vo.sys.SysMenuVO;
import com.chu.web.vo.sys.SysUserVO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysUserService {

  @Autowired
  private SysUserRepository repository;

  @Autowired
  private SysComCodeRepository codeRepository;

  public List<SysUserVO> getUserList() {
    return repository.findAll();
  }


  public void add(SysUserVO menuVO){
     repository.save(menuVO);
  }


}

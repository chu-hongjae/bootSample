package com.chu.web.service.sys;

import com.chu.web.dao.SysComCodeRepository;
import com.chu.web.dao.SysUserRepository;
import com.chu.web.vo.sys.SysUserVO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SysUserService {

  @Autowired
  private SysUserRepository repository;

  @Autowired
  private SysComCodeRepository codeRepository;

  @Transactional(readOnly = true)
  public SysUserVO getUserById(SysUserVO sysUserVO){
    return repository.findByUserIdAndUserPwd(sysUserVO.getUserId() , sysUserVO.getUserPwd());
  }

  public List<SysUserVO> getUserList() {
    return repository.findAll();
  }


  @Transactional
  public void add(SysUserVO menuVO){
     repository.save(menuVO);
  }


}

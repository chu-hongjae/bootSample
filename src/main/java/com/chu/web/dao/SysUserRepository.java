package com.chu.web.dao;

import com.chu.web.vo.sys.SysMenuVO;
import com.chu.web.vo.sys.SysUserVO;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SysUserRepository extends JpaRepository<SysUserVO, Long> {

  public SysUserVO findByUserIdAndUserPwd(String userId,String userPwd);


}

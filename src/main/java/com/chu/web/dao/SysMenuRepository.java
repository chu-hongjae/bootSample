package com.chu.web.dao;

import com.chu.web.vo.sys.SysMenuVO;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SysMenuRepository extends JpaRepository<SysMenuVO, Long> {

  public List<SysMenuVO> findAll();

  public List<SysMenuVO> findByMenuId(String menuId);



}

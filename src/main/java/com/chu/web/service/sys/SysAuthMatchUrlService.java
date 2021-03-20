package com.chu.web.service.sys;

import com.chu.web.dao.SysAuthMatchUrlRepository;
import com.chu.web.dao.SysMenuRepository;
import com.chu.web.vo.common.ComAuthVO;
import com.chu.web.vo.sys.SysAuthMatchUrlVO;
import com.chu.web.vo.sys.SysMenuVO;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysAuthMatchUrlService {

  @Autowired
  SysAuthMatchUrlRepository repository;

  @PostConstruct
  public void initAuth() {
    repository.deleteAll();
    repository.save(
        SysAuthMatchUrlVO.builder().matchUrl("/sys/**").authCd(ComAuthVO.ADMIN.toString()).useYn("Y").build());
    repository.save(
        SysAuthMatchUrlVO.builder().matchUrl("/login/**").authCd(ComAuthVO.ADMIN.toString()).useYn("Y")
            .build());
  }


  public List<SysAuthMatchUrlVO> getAll() {
    return repository.findAll();
  }

  public void add(SysAuthMatchUrlVO paramVO) {
    repository.save(paramVO);
  }

  public void delete(SysAuthMatchUrlVO param) {
    repository.delete(param);
  }

}

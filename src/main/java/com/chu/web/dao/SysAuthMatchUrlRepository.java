package com.chu.web.dao;

import com.chu.web.vo.sys.SysAuthMatchUrlVO;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SysAuthMatchUrlRepository extends JpaRepository<SysAuthMatchUrlVO, Long> {
   List<SysAuthMatchUrlVO> findAllByUseYnEquals( String useYn );
}

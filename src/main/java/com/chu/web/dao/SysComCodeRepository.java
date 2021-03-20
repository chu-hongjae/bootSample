package com.chu.web.dao;

import com.chu.web.vo.sys.SysComCodeVO;
import com.chu.web.vo.sys.SysUserVO;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SysComCodeRepository extends JpaRepository<SysComCodeVO, Long> {

  @Query(value = "SELECT *                     "
      + "           FROM TB_COMM_CODE_GRP_MST  "
      + "         WHERE USE_YN ='Y'            "
      + "           AND COM_GRP_CD = ?1        " , nativeQuery = true)
  public List<SysComCodeVO> getGrpCode(String com_grp_cd);


}

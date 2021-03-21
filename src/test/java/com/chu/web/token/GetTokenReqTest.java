package com.chu.web.token;

import com.chu.web.dao.SysUserRepository;
import com.chu.web.vo.sys.SysGetTokenVO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@Slf4j
public class GetTokenReqTest {

  @Autowired
  MockMvc mockMvc;

  @Test
  public void getToken() throws Exception {

    SysGetTokenVO getTokenVO = new SysGetTokenVO();
    getTokenVO.setUserId("chuhongjae");
    getTokenVO.setUserPwd("chu12314");

    MvcResult result = mockMvc.perform(
        post("/auth/getToken")
            .content(new Gson().toJson(getTokenVO))
            .contentType(MediaType.APPLICATION_JSON)
    ).andExpect(
        status().isOk()
    ).andReturn();


  }
}

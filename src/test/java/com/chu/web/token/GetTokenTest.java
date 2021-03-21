package com.chu.web.token;

import com.chu.web.dao.SysUserRepository;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@Slf4j
public class GetTokenTest {

  @Autowired
  SysUserRepository repository;

  @Test
  public void getToken()throws Exception{
    Gson gson =new GsonBuilder().setPrettyPrinting().create();
    log.debug("users : {}" , gson.toJson(repository.findAll()) );

  }
}

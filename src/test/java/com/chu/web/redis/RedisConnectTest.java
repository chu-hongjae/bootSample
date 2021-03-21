package com.chu.web.redis;

import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;

@SpringBootTest
@Slf4j
public class RedisConnectTest {



  @Autowired
  RedisTemplate<String,String> redisTemplate;

  @Test
  public void redisConnectTest(){
    log.debug("redis test========================================================================");
    if(redisTemplate == null){
      log.debug("redis is disconnected");
    }

    redisTemplate.opsForValue().set("hello" , "world");
    log.debug(redisTemplate.opsForValue().get("hello"));



  }
}

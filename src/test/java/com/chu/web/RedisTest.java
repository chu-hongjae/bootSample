package com.chu.web;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;
import java.util.UUID;
import java.util.stream.IntStream;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@SpringBootTest
@Configuration
@Slf4j
public class RedisTest {


  private static Jedis jedis;
  private static JedisPool jedisPool;

  @Before
  public void init() {
    JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
    jedisPool = new JedisPool(jedisPoolConfig, "localhost", 6379);
    jedis = jedisPool.getResource();
  }

  @After
  public void destory() {
    jedis.close();
    jedisPool.close();
  }

  @Test
  public void testSet() {

    jedis.set("hello", "world");
    log.debug(jedis.get("hello"));
    log.debug(jedis.set("hello", "1213123"));
    log.debug(jedis.get("hello"));
    jedis.expire("hello", 1);
    try {
      Thread.sleep(3000);
    } catch (Exception e) {
      e.printStackTrace();
    }

    log.debug(jedis.get("hello"));


  }

  @Test
  public void testList() {

    jedis.del("idx");
    log.debug("init start test");
     IntStream.range(1, 1000).forEach(i -> jedis.sadd("idx", UUID.randomUUID().toString()));
    log.debug("init success test");

      Set<String> tel = jedis.smembers("idx");

    for(Iterator<String> itr = tel.iterator(); itr.hasNext();){
        System.out.println(itr.next());
      }



  }
}

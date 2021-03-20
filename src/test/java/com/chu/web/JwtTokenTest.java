package com.chu.web;

import com.chu.web.vo.sys.SysUserVO;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.security.Key;
import java.util.Date;
import java.util.UUID;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class JwtTokenTest {

  private static final String SECRET_KEY = UUID.randomUUID().toString();
  private static long ttlMills = 10 * 1000 * 60;

  @Test
  public void makeToken() {

    log.debug("SECRET_KEY : {}" , SECRET_KEY);

    String jwt = createToken("chuhongjae@gmail.com", "chu");
    log.debug("token : {}" , jwt);

    log.debug("token data : {}" , getTokenData(jwt));
  }

  public static String createToken(String userId , String userName) {
    SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
    byte[] seckeyBytes = DatatypeConverter.parseBase64Binary(SECRET_KEY);
    Key signingKey = new SecretKeySpec(seckeyBytes, signatureAlgorithm.getJcaName());

    JwtBuilder builder = Jwts.builder()
        .setSubject("hello")
        .setIssuer("localhost.com")
        .setHeaderParam("typ", "JWT")
        .claim("hasPermission", true)
        .signWith(signatureAlgorithm, signingKey);
    builder.claim("userId", userId);
    builder.claim("userName",userName);
    builder.setExpiration(new Date(System.currentTimeMillis() + ttlMills));

    return builder.compact();

  }

  public static Claims getTokenData(String token) {
    Claims claims = Jwts.parser()
        .setSigningKey(DatatypeConverter.parseBase64Binary(SECRET_KEY))
        .parseClaimsJws(token).getBody();
    return claims;
  }


}

package com.chu.web.common.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.security.Key;
import java.security.KeyStore;
import java.util.Date;
import java.util.UUID;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

/**
 * JWT TOKEN 생성유틸
 * @author chu
 * @version 1.0.0
 * @since 2021-03-21 오전 6:40
 * JWT (json web token )
*/
public class JwtUtils {
  private static final String SECRET_KEY = UUID.randomUUID().toString();
  private static long ttlMills = 10 * 1000 * 60;

  public static String createToken(String userId , String userName) {
    SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS512;
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

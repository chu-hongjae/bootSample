package com.chu.web;

import java.security.MessageDigest;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class EncryptTest {

  @Test
  public void encryptTest(){
    log.debug(encryptSHA256("password01##!@"));
  }


  public String encryptSHA256(String s) {
    return encrypt(s, "SHA-256");
  }

  private  String encryptMD5(String s) {
    return encrypt(s, "MD5");
  }

  private static String encrypt(String s, String messageDigest) {
    try {
      MessageDigest md = MessageDigest.getInstance(messageDigest);
      byte[] passBytes = s.getBytes();
      md.reset();
      byte[] digested = md.digest(passBytes);
      StringBuffer sb = new StringBuffer();
      for (int i = 0; i < digested.length; i++) sb.append(Integer.toString((digested[i]&0xff) + 0x100, 16).substring(1));
      return sb.toString();
    } catch (Exception e) {
      return s;
    }
  }
}

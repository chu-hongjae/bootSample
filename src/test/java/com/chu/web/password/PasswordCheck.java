package com.chu.web.password;

import static org.junit.Assert.*;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class PasswordCheck {

  @Test
  public void passwordLength(){

    assertFalse(passwordCheck("1234566789"));
    log.debug("pwd number check : pass");
    assertFalse(passwordCheck("aA123$d"));
    log.debug("pwd length check : pass");
    assertFalse(passwordCheck("1q2w3e4r%"));
    log.debug("pwd length check : pass");
    assertTrue(passwordCheck("1q2w3e4r%R"));
    log.debug("pwd All check : pass");

  }

  public static boolean passwordCheck(String password){
    String pwdPattern = "^(?=.*\\d)(?=.*[~`!@#$%\\^&*()-])(?=.*[a-z])(?=.*[A-Z]).{9,12}$";
    return password.matches(pwdPattern);
  }
}

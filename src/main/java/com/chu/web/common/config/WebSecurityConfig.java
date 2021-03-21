package com.chu.web.common.config;


import com.chu.web.dao.SysAuthMatchUrlRepository;
import com.chu.web.vo.sys.SysAuthMatchUrlVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Slf4j
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

  @Autowired
  SysAuthMatchUrlRepository repository;

  @Override
  public void configure(WebSecurity web) throws Exception {
    super.configure(web);
    // web.ignoring().requestMatchers(PathRequest.toStaticResources().atCommonLocations());
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    addMatch(http);
    http.csrf().disable()
         .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        .and()
        .authorizeRequests()
        .antMatchers("/auth/**").permitAll()
        .antMatchers("/**").authenticated()
        .anyRequest().permitAll()
        .and()
        .formLogin().disable();

  }

  public void addMatch(HttpSecurity http) throws Exception {
    for (SysAuthMatchUrlVO matchUrlVO : repository.findAll()) {
      log.debug("add match : {}", matchUrlVO);
           http.authorizeRequests()
          .antMatchers(matchUrlVO.getMatchUrl())
          .hasAnyRole(matchUrlVO.getAuthCd());


    }
  }

}

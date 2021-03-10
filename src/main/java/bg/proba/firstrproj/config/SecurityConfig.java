package bg.proba.firstrproj.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http
        .formLogin()
//        /**/.permitAll()
        /**/.and()
        .logout()
        /**/.and()
        .authorizeRequests()
        /**/.antMatchers("/h2-console/**").anonymous()
        /**/.antMatchers("/explorer/**").authenticated()
        /**/.antMatchers("/users/**").authenticated()
        /**/.antMatchers("/books/**").authenticated();
  }

  @Bean
  PasswordEncoder passwordEncoder(){
    return new BCryptPasswordEncoder();
  }
}

package com.bezkoder.springjwt.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.bezkoder.springjwt.config.jwt.AuthEntryPointJwt;
import com.bezkoder.springjwt.config.jwt.AuthTokenFilter;
import com.bezkoder.springjwt.Service.Impl.UserDetailsServiceImpl;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(
        prePostEnabled = true,
        securedEnabled = true,
        jsr250Enabled = true)
public class WebSecurityConfiguration {

  private final AuthEntryPointJwt authenticationEntryPointJwt;

  private final CustomAccessDeniedHandler customAccessDeniedHandler;

  private final UserDetailsServiceImpl userDetailsService;

  public WebSecurityConfiguration(
          AuthEntryPointJwt authenticationEntryPointJwt,
          CustomAccessDeniedHandler customAccessDeniedHandler,
          UserDetailsServiceImpl userDetailsService) {
    this.authenticationEntryPointJwt = authenticationEntryPointJwt;
    this.customAccessDeniedHandler = customAccessDeniedHandler;
    this.userDetailsService = userDetailsService;
  }

  @Bean
  public AuthenticationManager authenticationManager(
          AuthenticationConfiguration authConfig) throws Exception {
    return authConfig.getAuthenticationManager();
  }

  @Bean
  public AuthTokenFilter authenticationJwtTokenFilter() {
    return new AuthTokenFilter();
  }
  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

    @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http.httpBasic().disable().cors()
            .and().formLogin().disable()
            .csrf().disable()
            .exceptionHandling()
            .authenticationEntryPoint(authenticationEntryPointJwt)
            .accessDeniedHandler(customAccessDeniedHandler)
            .and()
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and()
            .authorizeRequests()
            .antMatchers("/api/auth/**").permitAll()
            .antMatchers("/ProjectSJ/Product/**").permitAll()
            .antMatchers("/ProjectSJ/Category/**").permitAll()
            .antMatchers("/ProjectSJ/Bill/**").permitAll()
            .anyRequest().authenticated()
            .and()
            .addFilterAfter(authenticationJwtTokenFilter(),
                    UsernamePasswordAuthenticationFilter.class);

    return http.build();
  }

}
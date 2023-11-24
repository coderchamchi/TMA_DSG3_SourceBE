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

@Configuration // Class được đánh dấu annotaiton này được Spring Container sử dụng làm nguồn định nghĩa bean.
@EnableWebSecurity //annotation cơ bản của Spring Security để kích hoạt tính năng bảo mật trên ứng dụng web.
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
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {//Phương thức filterChain cấu hình các quy tắc bảo mật cho ứng dụng.
      http.httpBasic().disable().cors()
            .and().formLogin().disable()
            .csrf().disable()
            .exceptionHandling() //Cấu hình xử lý ngoại lệ cho các trường hợp xác thực thất bại hoặc quyền truy cập bị từ chối.
            .authenticationEntryPoint(authenticationEntryPointJwt)
              //xử lý và trả về thông điệp lỗi khi một yêu cầu yêu cầu xác thực và người dùng chưa được xác thực.
            .accessDeniedHandler(customAccessDeniedHandler)
              // xử lí, ghi log khi user cố gắng truy cấp vào nguồn tài nguyên mà không đủ quyền
            .and()
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
              //chỗ này là cấu hình quản lí phiên nhưng mà mình không muốn sử dụng session và sẽ không lưu trữ thông tin xác thực ở phía máy chủ
              //nên để là SessionCreationPolicy.stateless
            .and()
            .authorizeRequests()
            .antMatchers("/api/auth/**").permitAll()
            .antMatchers("/ProjectSJ/Product/**").permitAll()
            .antMatchers("/ProjectSJ/Category/**").permitAll()
            .antMatchers("/ProjectSJ/Bill/**").permitAll()
            .anyRequest().authenticated()
            .and()
            .addFilterAfter(authenticationJwtTokenFilter(), //có nhiệm vụ kiểm tra và xác thực token JWT trong các yêu cầu.
                    UsernamePasswordAuthenticationFilter.class);

    return http.build();
  }

}
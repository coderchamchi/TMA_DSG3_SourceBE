package com.bezkoder.springjwt.config.jwt;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class AuthEntryPointJwt implements AuthenticationEntryPoint {

  private static final Logger logger = LoggerFactory.getLogger(AuthEntryPointJwt.class);

  @Override
  public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException)
      throws IOException, ServletException {
    logger.error("Unauthorized error: {}", authException.getMessage());

    response.setContentType(MediaType.APPLICATION_JSON_VALUE);
    //Đặt kiểu nội dung của phản hồi thành JSON để trả về thông điệp lỗi dưới dạng JSON.
    response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
    //Đặt mã trạng thái của phản hồi thành 401 (UNAUTHORIZED) để báo cho client biết rằng họ chưa được xác thực.

    final Map<String, Object> body = new HashMap<>(); //tạo đối tượng body chứa thông tin cụ thể lỗi như status, message, error,..
    body.put("status", HttpServletResponse.SC_UNAUTHORIZED);
    body.put("error", "Unauthorized");
    body.put("message", authException.getMessage());
    body.put("path", request.getServletPath());

    final ObjectMapper mapper = new ObjectMapper();//cuối cùng dùng mappper để chuyển body về json để gửi về client thông qua getoutputstream
    mapper.writeValue(response.getOutputStream(), body);
  }

}

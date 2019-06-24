package com.group.almighty.slidebackend.Configurations;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.oauth2.provider.error.OAuth2AuthenticationEntryPoint;
import org.springframework.security.oauth2.provider.error.OAuth2ExceptionRenderer;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@Component
public class AuthenticationExceptionHandler extends OAuth2AuthenticationEntryPoint implements OAuth2ExceptionRenderer, Serializable {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        ObjectMapper mapper = new ObjectMapper();

        final Map<String, Object> responseObject = new HashMap<>() ;

        responseObject.put("responseMessage"  , authException.getMessage());
        responseObject.put("responseCode"    , "03");

        String responseMsg = mapper.writeValueAsString(responseObject);
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.getWriter().write(responseMsg);
    }

    @Override
    public void handleHttpEntityResponse(HttpEntity<?> responseEntity, ServletWebRequest webRequest) throws Exception {
        System.out.println("I got in here!");
    }
}

package com.group.almighty.slidebackend.Configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

@Order(1)
@Configuration
@EnableResourceServer
public class ResourceServerOAuth2Config extends ResourceServerConfigurerAdapter {


    @Autowired
    AuthenticationExceptionHandler authenticationExceptionHandler;

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources.resourceId("resourceId");
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
            .requestMatchers()
            .antMatchers("/api/v3/**").and()
            .exceptionHandling()
            .authenticationEntryPoint(authenticationExceptionHandler).and()
            .authorizeRequests()
            .antMatchers("/api/v3/activation/**").permitAll()
            .antMatchers("/api/v3/auth/login").permitAll()
            .anyRequest().authenticated();
    }

}

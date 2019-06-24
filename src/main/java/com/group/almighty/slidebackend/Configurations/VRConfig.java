package com.group.almighty.slidebackend.Configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@Order(4)
public class VRConfig extends WebSecurityConfigurerAdapter {


    @Bean
    public MyAuthenticationEntryPoint myEntryPoint(){
        return new MyAuthenticationEntryPoint();
    }


    @Override
    public void configure(HttpSecurity http) throws Exception {

        http
                .cors().and()
                .antMatcher("/vr/**")
                .authorizeRequests()
                .antMatchers("/vr/**").permitAll().and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.NEVER).and()
                .httpBasic().and()
                .exceptionHandling().authenticationEntryPoint(myEntryPoint()).and()
                .csrf().disable();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
                .antMatchers("/vr/**");
    }

    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/vr/**", new CorsConfiguration().applyPermitDefaultValues());
        return source;
    }

}


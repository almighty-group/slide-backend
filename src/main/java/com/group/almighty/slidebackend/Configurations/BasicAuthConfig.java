//package com.group.almighty.slidebackend.Configurations;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.annotation.Order;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.web.cors.CorsConfiguration;
//import org.springframework.web.cors.CorsConfigurationSource;
//import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
//
//@Configuration
//@Order(2)
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
//public class BasicAuthConfig extends WebSecurityConfigurerAdapter {
//
////    @Autowired
////    AgentService agentService;
//
//    @Bean
//    public MyAuthenticationEntryPoint myEntryPoint(){
//        return new MyAuthenticationEntryPoint();
//    }
//
//
//    @Override
//    public void configure(HttpSecurity http) throws Exception {
//
//        http
//                .cors().and()
//                .antMatcher("/api/v3/**")
//                .authorizeRequests()
//                .antMatchers("/api/v3/agent/add").permitAll()
//                .antMatchers("/api/v3/changepassword").permitAll()
//                .antMatchers("/api/v3/terminal/activate", "/api/v3/auth", "/api/v3/time").permitAll().and()
//                .sessionManagement()
//                .sessionCreationPolicy(SessionCreationPolicy.NEVER).and()
//                .httpBasic().and()
//                .exceptionHandling().authenticationEntryPoint(myEntryPoint()).and()
//                .csrf().disable();
//    }
//
//    @Override
//    public void configure(WebSecurity web) throws Exception {
//        web.ignoring()
//                .antMatchers("/resources/**")
//                .antMatchers("api/agent/add");
//    }
//
//    @Bean
//    CorsConfigurationSource corsConfigurationSource() {
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        source.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());
//        return source;
//    }
//
////    @Bean
////    public FilterRegistrationBean<PhoneUUIDFilter> phoneUUIDFilter() {
////        FilterRegistrationBean<PhoneUUIDFilter> filterRegBean = new FilterRegistrationBean<>();
////        filterRegBean.setFilter(new PhoneUUIDFilter(agentService));
////        filterRegBean.addUrlPatterns("/api/v3/*");
////        filterRegBean.setOrder(Ordered.LOWEST_PRECEDENCE -1);
////        return filterRegBean;
////    }
//
//}
//

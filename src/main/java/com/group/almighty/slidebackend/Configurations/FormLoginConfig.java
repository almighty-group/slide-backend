package com.group.almighty.slidebackend.Configurations;

import com.group.almighty.slidebackend.Services.MyUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@Order(5)
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class FormLoginConfig extends WebSecurityConfigurerAdapter {


    @Autowired
    private MyUserDetailService userDetailService;


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userDetailService)
                .passwordEncoder(bCryptPasswordEncoder());
    }


    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }


    @Autowired
    public void globalUserDetails(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailService)
                .passwordEncoder(bCryptPasswordEncoder());
    }


    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.
                authorizeRequests()
                .antMatchers("/resources/**", "/assets/**",  "/css/**", "/js/**", "/fonts/**", "/images/**", "/plugins/**", "/pages/**", "/setpassword/**", "/password/**", "/static/**","**/favicon.ico", "/public/**").permitAll()
                .antMatchers("/").permitAll()
                .antMatchers("/login").permitAll()
                .antMatchers("/tc/**").permitAll()
                .antMatchers("/forgot-password").permitAll()
                .antMatchers("/api/v3/terminal/activate").permitAll()
                .antMatchers("/api/v3/state/**").permitAll()
                .antMatchers("/reset-password").permitAll()
                .antMatchers("/registration").permitAll()
                .antMatchers("/agent/authenticate/**").permitAll()
                .antMatchers("/oauth/token").permitAll()

                .antMatchers("/transaction/test").permitAll()

                .antMatchers("/ambassador/profile").hasAnyAuthority("ESL_ADMIN","AMBASSADOR")
                .antMatchers("/ambassador/edit").hasAnyAuthority("ESL_ADMIN","AMBASSADOR")

                .antMatchers("/agent/create").hasAnyAuthority("ESL_ADMIN", "AMBASSADOR","THIRD PARTY USERS")
                .antMatchers("/agent/view").hasAnyAuthority("ESL_ADMIN","THIRD PARTY USERS","AGENT")
                .antMatchers("/agent/transaction").hasAnyAuthority("ESL_ADMIN","AGENT","AMBASSADOR","THIRD PARTY USERS")
                .antMatchers("/agent/profile").hasAnyAuthority("ESL_ADMIN","AMBASSADOR", "AGENT","THIRD PARTY USERS","LOAN AGENCY")
                .antMatchers("/agent/edit").hasAnyAuthority("ESL_ADMIN","THIRD PARTY USERS")
                .antMatchers("agent/api/getagentbybankstatelga/").hasAuthority("ESL_ADMIN")
                .antMatchers("agent/api/getAgentListByGender").hasAuthority("ESL_ADMIN")

                .antMatchers("/error404").permitAll()
                .antMatchers("/error500").permitAll()

                .antMatchers("/transaction/view").hasAnyAuthority("ESL_ADMIN","THIRD PARTY USERS")
                .antMatchers("/registration").permitAll()
                .antMatchers("/dashboard").hasAuthority("ESL_ADMIN")

                .antMatchers("/agentDashboard").hasAuthority("AGENT")
                .antMatchers("/ambassadorDashboard").hasAuthority("AMBASSADOR")
                .anyRequest()
                .authenticated().and().formLogin()
                .loginPage("/login")
                .failureUrl("/login?error=true")
                .defaultSuccessUrl("/success", true)
                .usernameParameter("phone")
                .passwordParameter("password")
                .and().logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/").and().exceptionHandling()
                .accessDeniedPage("/403.html")
                .and()
                .csrf().disable();

    }


    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
                .antMatchers("/resources/**")
        ;
    }

}


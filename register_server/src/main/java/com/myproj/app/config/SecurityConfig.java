package com.myproj.app.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

/**
 * 利用springSecurity进行鉴权
 * @Author LittleCadet
 * @Date 2020/2/1
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter
{
    @Value("${spring.userA.name}")
    private String nameA;
    @Value("${spring.userA.password}")
    private String passwordA;
    @Value("${spring.userA.role}")
    private String roleA;
    @Value("${spring.userB.name}")
    private String nameB;
    @Value("${spring.userB.password}")
    private String passwordB;
    @Value("${spring.userB.role}")
    private String roleB;


    //去掉spring5一定要密码加密的限制
    @Bean
    PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }

    //在代码中配置用户名和密码
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception
    {
        auth.inMemoryAuthentication()
            .withUser(nameA).password(passwordA).roles(roleA)
            .and()
            .withUser(nameB).password(passwordB).roles(roleB);
    }

    /**
     * 2.1版本的security默认加上了 csrf 拦截, 所以需要通过重写方法, 把csrf拦截禁用不写，客户端无法注册服务
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        super.configure(http);
    }
}


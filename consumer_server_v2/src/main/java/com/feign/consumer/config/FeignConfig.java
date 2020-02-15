package com.feign.consumer.config;

import feign.Contract;
import feign.Logger;
import feign.auth.BasicAuthRequestInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;

/**
 * @Author LittleCadet
 * @Date 2020/2/11
 */
@Slf4j
public class FeignConfig
{

    @Bean
    public BasicAuthRequestInterceptor basicAuthRequestInterceptor(){
        log.info("初始化Feign的拦截器");
        return new BasicAuthRequestInterceptor("admin","admin123");
    }

    /**
     * 初始化feign的合约 ： 将契约改为feign的原生的默认契约，这样可以使用feign的原生注解：例如：@RequestLine("GET /consumer")
     * @return
     */
    @Bean
    public Contract feignContract(){
        log.info("初始化feign的合约，默认契约是SpringMvcContract");
        return new feign.Contract.Default();
    }

    /*@Bean
    public Logger.Level feignLogLevel(){
        log.info("初始化feign的日志级别");
        return Logger.Level.HEADERS;
    }*/

}

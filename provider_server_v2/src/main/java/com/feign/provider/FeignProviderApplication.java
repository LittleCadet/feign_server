package com.feign.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author LittleCadet
 * @Date 2020/2/4
 */
@EnableFeignClients
@SpringBootApplication
public class FeignProviderApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(FeignProviderApplication.class,args);
    }
}
